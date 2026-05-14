package model;

public class Contador {
    private int contador;

    public synchronized void incrementar() {
        contador++;
    }

    public int getTotal() {
        return contador;
    }
}
