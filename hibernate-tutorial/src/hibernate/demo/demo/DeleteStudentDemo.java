package hibernate.demo.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		// create a session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		// create a session		
		Session session = factory.getCurrentSession();
		
		try {
			int studentId = 7;
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the id: primary key
			System.out.println("\nGetting student with id: " + studentId);
			
			Student myStudent = session.get(Student.class, studentId);
			
			// delete the student
			//System.out.println("Deleting student: " + myStudent);
			//session.delete(myStudent);
			
			// delete the student id=3
			System.out.println("Deleting student id=3");
			
			session.createQuery("delete from Student where id=3").executeUpdate();
			
			// commit the transaction
			session.getTransaction().commit();	
			
		} finally {
			factory.close();
		}

	}

}
