import entities.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        Employee empl = new Employee();
        empl.setFirstName("Yara");
        empl.setLastName("Cham");
        empl.setEmail("yara.cham@gmail.com");
        empl.setHireDate(LocalDate.now());

        em.getTransaction().begin();
        em.persist(empl);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
