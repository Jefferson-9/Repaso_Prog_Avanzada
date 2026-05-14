import model.*;
import jakarta.persistence.*;
import util.JPAUtil;

import java.time.LocalDateTime;

public class App {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();

        TypedQuery<Cliente> queryCliente = em.createNamedQuery("Cliente.getById", Cliente.class);
        queryCliente.setParameter("id_cliente", 1);
        var cliente = queryCliente.getSingleResult();

        TypedQuery<Barbero> queryBarbero = em.createNamedQuery("Barbero.getById", Barbero.class);
        queryBarbero.setParameter("id_barbero", 1);
        var barbero = queryBarbero.getSingleResult();

        TypedQuery<Servicio> queryServicio = em.createNamedQuery("Servicio.getById", Servicio.class);
        queryServicio.setParameter("id_servicio", 1);
        var servicio = queryServicio.getSingleResult();

        try (em) {
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Cita newCita = new Cita(LocalDateTime.now(), cliente, barbero, servicio, "Reserva", "No usar alcohol");
            em.persist(newCita);
            tx.commit();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            JPAUtil.close();
        }
    }
}
