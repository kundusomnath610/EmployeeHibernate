package empCompany;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunApp {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure();
        SessionFactory factory = cfg.buildSessionFactory();
        Session sess = factory.openSession();
        Transaction tx = sess.beginTransaction();

        Company c = new Company();

        Employee e1 = new Employee(100, "Priya", "dev", 32000, c);
        Employee e2 = new Employee(200, "Anjali", "Testing", 34000, c);

        List<Employee> empList = new ArrayList<Employee>();
        empList.add(e1);
        empList.add(e2);

        c.setcId(1);
        c.setEmpList(empList);

        sess.persist(c);
        sess.persist(e1);
        sess.persist(e2);

        tx.commit();
    }
}