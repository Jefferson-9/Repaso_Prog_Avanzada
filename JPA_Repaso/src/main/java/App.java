import model.*;

public class App {
    public static void main(String[] args) throws Exception {

        Contador miContador = new Contador();

        HiloInsertar tarea1 = new HiloInsertar(50, miContador);
        HiloInsertar tarea2 = new HiloInsertar(50, miContador);
        HiloInsertar tarea3 = new HiloInsertar(50, miContador);

        tarea1.start();
        tarea2.start();
        tarea3.start();

        try {
            tarea1.join();
            tarea2.join();
            tarea3.join();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Todas las inserciones finalizaron con éxito");
        System.out.println("Proceso finalizado. Total de usuarios insertados: " + miContador.getTotal());
    }
}