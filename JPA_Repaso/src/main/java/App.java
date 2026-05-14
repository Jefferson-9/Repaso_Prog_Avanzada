import model.HiloInsertar;

public class App {
    public static void main(String[] args) throws Exception {
        HiloInsertar tarea1 = new HiloInsertar(50);
        HiloInsertar tarea2 = new HiloInsertar(50);
        HiloInsertar tarea3 = new HiloInsertar(50);

        tarea1.start();
        tarea2.start();
        tarea3.start();
    }
}