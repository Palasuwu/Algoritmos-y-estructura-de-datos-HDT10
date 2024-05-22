package uvg.edu.gt;



public class Grafo {

    private int cantNodos;
    private int nodos[][][];
    private String nombres[];

    public Grafo(int cant) {
        this.cantNodos = cant;
        this.nodos = new int[cantNodos][cantNodos][2];
        this.nombres = new String[cantNodos];
    }

    public void ingresarArco(int n1, int n2, int peso) {
        this.nodos[n1][n2][0] = peso;
        this.nodos[n2][n1][0] = peso;
        this.nodos[n1][n2][1] = n1;
        this.nodos[n2][n1][1] = n2;
    }

    public String getNombre(int nodo) {
        return this.nombres[nodo];
    }

    public String centro() {
        return getNombre(0);
    }

    public void ingresarNombre(int nodo, String nombre) {
        this.nombres[nodo] = nombre;
    }

    public void calcular() {
        int i, j, k;
        for (i = 0; i < this.cantNodos; i++) {
            for (j = 0; j < this.cantNodos; j++) {
                for (k = 0; k < this.cantNodos; k++) {
                    if (this.nodos[i][k][0] + this.nodos[k][j][0] < this.nodos[i][j][0]) {
                        this.nodos[i][j][0] = this.nodos[i][k][0] + this.nodos[k][j][0];
                        this.nodos[i][j][1] = k;
                    }
                }
            }
        }
    }

    public String caminocorto(int org, int des) {
        String cam;
        if (org == des) {
            cam = "->" + nombres[org];
        } else {
            cam = caminocorto(org, this.nodos[org][des][1]) + "->" + nombres[des];
        }
        return cam;
    }

    public int pesominimo(int org, int des) {
        return this.nodos[org][des][0];
    }

}