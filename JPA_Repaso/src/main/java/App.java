import model.HiloInsertar;

public class App {
    public static void main(String[] args) throws Exception {
        HiloInsertar tarea1 = new HiloInsertar(50);
        HiloInsertar tarea2 = new HiloInsertar(50);
        HiloInsertar tarea3 = new HiloInsertar(50);

        new Thread(() -> tarea1.Guardar()).start();
        new Thread(() -> tarea2.Guardar()).start();
        new Thread(() -> tarea3.Guardar()).start();
    }
}