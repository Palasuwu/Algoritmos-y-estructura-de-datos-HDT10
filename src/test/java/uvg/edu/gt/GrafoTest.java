package uvg.edu.gt;

import junit.framework.TestCase;

public class GrafoTest extends TestCase {
    Grafo grafoTest;
    String ruta = ("/Users/pala./Desktop/Algoritmos-EstructurasDTS/HDT10/src/main/java/uvg/edu/gt/guategrafo.txt") ;
    protected void setUp() throws Exception {
        super.setUp();
        grafoTest = new Grafo(5);
    }

    public void testIngresarArco() {
        grafoTest.ingresarArco(0, 0, 5);
        assertEquals(null, grafoTest.getNombre(0));
    }

    public void testIngresarNombreT() {
        grafoTest.ingresarNombre(1, "test");
        assertEquals("test", grafoTest.getNombre(1));
    }

    public void testIngresarNombreF() {
        grafoTest.ingresarNombre(1, "test");
        assertEquals(null, grafoTest.getNombre(2));
    }

    public void testCentro() {
        Algoritmo test = new Algoritmo(ruta);
        assertEquals("Mixco", test.mostrarCentro());
    }

    public void testCaminocortoF() {
        Algoritmo test = new Algoritmo(ruta);
        assertEquals("Las ciudades ingresadas no existen D: \n", test.encontrarRutaMasCorta("VENUS", "PLUTON"));
    }

    public void testCaminocortoT() {
        Algoritmo test = new Algoritmo(ruta);
        assertEquals("->Guatemala->Antigua->Escuintla\nCon una distancia total de: 65 Kilometros \n", test.encontrarRutaMasCorta("guatemala", "escuintla"));
    }
}