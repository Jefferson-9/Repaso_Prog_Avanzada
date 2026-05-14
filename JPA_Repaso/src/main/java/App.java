import model.HiloInsertar;

public class App {
    public static void main(String[] args) throws Exception {
        HiloInsertar tarea1 = new HiloInsertar(50);
        HiloInsertar tarea2 = new HiloInsertar(50);
        HiloInsertar tarea3 = new HiloInsertar(50);

        Thread t1 = new Thread(tarea1);
        Thread t2 = new Thread(tarea2);
        Thread t3 = new Thread(tarea3);

        t1.start();
        t2.start();
        t3.start();
    }
}