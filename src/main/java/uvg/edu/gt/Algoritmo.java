package uvg.edu.gt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class Algoritmo {

    ArrayList<String> ciudades = new ArrayList<>();
    ArrayList<String> rutas = new ArrayList<>();
    Grafo grafo = null;

    public Algoritmo(String rutaArchivoTxt) {
        generarGrafo( rutaArchivoTxt );
    }

    public String printCiudades() {
        String ciudadesStr = "";
        for (String ciudad : ciudades) {
            ciudadesStr += ciudad + "\t";
        }
        return ciudadesStr;
    }

    private void generarGrafo(String rutaArchivoTxt) {
        // Lee el archivo
        File archivo;
        FileReader fr;
        BufferedReader br = null;
        try {
            archivo = new File(rutaArchivoTxt);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
        } catch (Exception e) {
            System.out.println("El archivo no se ha encontrado :( ");
        }

        // Recorrer archivo
        try {

            // Guardar cada ciudad en una lista
            ciudades = new ArrayList<>();
            rutas = new ArrayList<>();
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] temp = linea.split(" ");
                // Agregar cada ciudad a una lista
                if (!ciudades.contains(temp[0])) {
                    ciudades.add(temp[0]);
                }
                if (!ciudades.contains(temp[1])) {
                    ciudades.add(temp[1]);
                }
                // Guarda cada ruta en una lista
                rutas.add(linea);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        // Crear nodos
        grafo = new Grafo(ciudades.size());
        // Agregar ciudades al grafo
        for (int i = 0; i < ciudades.size(); i++) {
            grafo.ingresarNombre(i, ciudades.get(i));
        }
        for (int i = 0; i < ciudades.size(); i++) {
            for (int j = 0; j < ciudades.size(); j++) {
                if (i < j) {
                    // Recorrer las ciudades y ver si tienen una ruta
                    Boolean tieneRuta = false;
                    for (int j2 = 0; j2 < rutas.size(); j2++) {
                        String[] datos = rutas.get(j2).split(" ");
                        if ((datos[0].equals(ciudades.get(i)) && datos[1].equals(ciudades.get(j)))
                                || (datos[1].equals(ciudades.get(i)) && datos[0].equals(ciudades.get(j)))) {

                            grafo.ingresarArco(i, j, Integer.parseInt(datos[2]));
                            tieneRuta = true;
                        }
                    }
                    if (!tieneRuta) {
                        grafo.ingresarArco(i, j, 10000);
                    }
                }
            }
        }
        grafo.calcular();

    }

    public String encontrarRutaMasCorta(String origen, String destino) {
        int contadorSalida = 0;
        // Compara cada ciudad con las demas ciudades
        for (int i = 0; i < ciudades.size(); i++) {
            for (int j = 0; j < ciudades.size(); j++) {
                if (i > j) {

                    // Mira si el origen y el destino son iguales a los indicados
                    if ((origen.equals(grafo.getNombre(i).toLowerCase())
                            && destino.equals(grafo.getNombre(j).toLowerCase()))
                            || (destino.equals(grafo.getNombre(i).toLowerCase())
                            && origen.equals(grafo.getNombre(j).toLowerCase()))) {

                        // Muestra el camino más corto
                        return (grafo.caminocorto(i, j) + "\nCon una distancia total de: " + grafo.pesominimo(i, j) + " Kilometros \n");
                    }else {
                        contadorSalida++;
                    }

                }
            }
        }
        if(contadorSalida != 0) {
            return "Las ciudades ingresadas no existen D: \n";
        }
        return ":o";
    }

    public String mostrarCentro() {
        return grafo.centro();
    }

    public String rutasExistentes() {
        String msj = "";
        for (int i = 0; i < rutas.size(); i++) {
            msj += ("    " + (i + 1) + " - " + rutas.get(i) + "\n");
        }
        return msj;
    }

    public String generarInterrupcion(int ruta, String rutaTxt) throws IOException {

        Writer output2 = new BufferedWriter(new FileWriter(rutaTxt));
        // Reescribir el archivo con las rutas correctas
        int contador = 0;
        for (int i = 0; i < rutas.size(); i++) {
            //Agregar todas menos la ruta indicada
            if (i != (ruta - 1)) {
                output2.write(rutas.get(i));
            }
            // Validaciones para los saltos de linea
            if (i != (ruta - 1)) {
                if (ruta == rutas.size()) {
                    if (contador < rutas.size() - 2) {
                        output2.write("\n");
                    }
                } else {
                    if (contador < rutas.size() - 1) {
                        output2.write("\n");
                    }
                }
            }
            contador++;
        }
        output2.close();
        // Se genera de nuevo el grafo con los cambios hechos
        generarGrafo(rutaTxt);
        return ("\nRuta reportada exitosamente :) .\n");
    }

    public String agregarRuta(String origen, String destino, String distancia, String rutaTxt) throws IOException {
        Writer output = new BufferedWriter(new FileWriter(rutaTxt, true));

        // Agregar la ruta al arhivo de rutas
        output.append("\n" + origen + " " + destino + " " + distancia);
        output.close();
        // Se genera de nuevo el grafo con los cambios hechos
        generarGrafo(rutaTxt);
        return "Ruta agregada exitosamente :).";
    }
}