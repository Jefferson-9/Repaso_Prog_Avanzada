package model;

import java.sql.*;
import java.util.Random;

public class HiloInsertar implements Runnable {
    private int cantidad;

    public HiloInsertar(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public void run() {
        Random random = new Random();

        String url = "jdbc:mysql://localhost:3306/Empresa";
        String usuario = "root";
        String password = "1150441341";
        String sql = "INSERT INTO usuarios (nombre, edad) VALUES(?, ?)";

         try (Connection conexion = DriverManager.getConnection(url, usuario, password);
         PreparedStatement ps = conexion.prepareStatement(sql)) {
             for (int i = 0; i < this.cantidad; i++) {
                 String nombre = "Usuario" + random.nextInt(1000);
                 int edad = random.nextInt(60) + 18;

                 ps.setString(1, nombre);
                 ps.setInt(2, edad);

                 ps.executeUpdate();

                 System.out.println(Thread.currentThread().getName() + " inserto: " + nombre);
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }

    }
}
