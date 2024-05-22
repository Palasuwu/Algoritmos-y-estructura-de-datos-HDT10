package uvg.edu.gt;

import java.util.Scanner;

//Jorge Palacios - 231385
// Hoja de trabajo 10
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //String ruta = ("C:\\Users\\gabri\\IdeaProjects\\HDT10\\src\\main\\java\\uvg\\edu\\gt\\guategrafo.txt") ; // Colocar la ruta del archivo entre los parentecis
        String ruta = ("/Users/pala./Desktop/Algoritmos-EstructurasDTS/HDT10/src/main/java/uvg/edu/gt/guategrafo.txt") ;
        String root = ruta;

        Algoritmo floyd = new Algoritmo(root);

        boolean salir = false;
        int option;

        while(!salir){
            System.out.println("---------------------------------------------");
            System.out.println("Estas son las siguinetes opciones");
            System.out.println("---------------------------------------------");
            System.out.println("1. Encontrar ruta mas corta entre dos ciudades.");
            System.out.println("2. Mostrar ciudad en el centro.");
            System.out.println("3.Modificar grafo.");
            System.out.println("4. Finalizar programa.");
            try {
                System.out.println("Opcion -> ");
                option = input.nextInt();
                input.nextLine();
                switch (option) {
                    case 1:
                        System.out.println("Las ciudades que tiene este programa son las siguientes: \n" + floyd.printCiudades() + "\n");
                        System.out.println("Ciudad de origen ->> ");
                        String origen = input.nextLine();
                        System.out.println("Ciudad de destino ->> ");
                        String destino = input.nextLine();
                        System.out.println("\nEl camino mas corto de " + origen + " a " + destino + " es:\n" + floyd.encontrarRutaMasCorta(origen.toLowerCase(), destino.toLowerCase()) );
                        break;
                    case 2:
                        System.out.println("\nLa ciudad ubicada en el centro es: \n" + floyd.mostrarCentro() +"\n");
                        break;
                    case 3:
                        System.out.println("1. Hay interrupcion de trafico entre un par de ciudades :0 ");
                        System.out.println("2. Establecer nueva conexion entre ciudades.");
                        System.out.println("Opcion -> ");
                        int option2 = input.nextInt();
                        input.nextLine();
                        switch (option2) {
                            case 1:
                                System.out.println( floyd.rutasExistentes() );
                                System.out.println("Opcion -> ");
                                int option3 = input.nextInt();
                                System.out.println( floyd.generarInterrupcion(option3, root) );
                                break;
                            case 2:
                                System.out.println("Ciudad de origen ->> ");
                                String origen2 = input.nextLine();
                                System.out.println("Ciudad de destino ->> ");
                                String destino2 = input.nextLine();
                                System.out.println("Ingrese la distancia entre las ciudades ->> ");
                                String distancia = input.nextLine();
                                System.out.println( floyd.agregarRuta(origen2, destino2, distancia, root) );
                                break;
                            default:
                                System.out.println("\nIngresa una opcion valida 1 o 2.\n");
                                break;
                        }
                        break;
                    case 4:
                        System.out.println("**********************************\n");
                        System.out.println("\tGracias por usar el programa :)\n");
                        System.out.println("**********************************\n");
                        salir = true;
                        break;
                    default:
                        System.out.println("\nIngresa una opcion valida 1 a 4 .\n");
                        break;
                }
            }catch(Exception e) {
                System.out.println("\nIngresa una opcion valida\n");
                input.nextLine();
            }
        }
        input.close();
    }
}
