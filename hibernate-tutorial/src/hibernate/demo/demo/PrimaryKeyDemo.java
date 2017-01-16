package hibernate.demo.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		// create a session factory
				SessionFactory factory = new Configuration()
											.configure("hibernate.cfg.xml")
											.addAnnotatedClass(Student.class)
											.buildSessionFactory();
				
				// create a session		
				Session session = factory.getCurrentSession();
				
				try {

					// create 3 student object
					System.out.println("Creating 3 student Object...");
					Student tempStudent1 = new Student("Malwin", "Zacny", "mzacny@gmail.com");
					Student tempStudent2 = new Student("Krzysztof", "Garus", "kgarus@gmail.com");
					Student tempStudent3 = new Student("Jan", "Kowalski", "jkowalski@gmail.com");
					
					// start a transaction
					session.beginTransaction();
					
					// save the student object
					System.out.println("Saving the student...");
					session.save(tempStudent1);
					session.save(tempStudent2);
					session.save(tempStudent3);
					
					// commit transaction
					session.getTransaction().commit();
					
					System.out.println("Done!");
					
					
				} finally {
					factory.close();
				}

	}

}
