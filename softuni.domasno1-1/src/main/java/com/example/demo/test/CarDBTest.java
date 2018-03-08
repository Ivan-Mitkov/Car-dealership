package com.example.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Cars;
import com.example.demo.entity.Customers;
import com.example.demo.entity.Parts;
import com.example.demo.entity.Sales;
import com.example.demo.entity.Suppliers;


public class CarDBTest {
	public static void main(String[] args) {
	// create session factory
			SessionFactory factory= new Configuration()
					.configure()
//					.addAnnotatedClass(Cars.class)
					.addAnnotatedClass(Customers.class)
//					.addAnnotatedClass(Sales.class)
//					.addAnnotatedClass(Parts.class)
					.addAnnotatedClass(Suppliers.class)
					.buildSessionFactory();
			//create session
	       
			  Session session=factory.getCurrentSession();
			try {
			 
				//start a transaction
				session.beginTransaction();
				//get student
				long id=10;
//				Cars temp = session.get(Cars.class, id);
//				System.out.println("Cars: "+temp.getMake());
				Customers temp2 = session.get(Customers.class, id);
				System.out.println("Customers: "+temp2.getName());//working
//				Sales temp3 = session.get(Sales.class, id);
//				System.out.println("Sales: "+temp3.getCarId());
//				Parts temp4 = session.get(Parts.class, id);
//				System.out.println("Parts: "+temp4.getName());
				Suppliers temp5 = session.get(Suppliers.class, id);
				System.out.println("Suppliers: "+temp5.getName());
//				
//				System.out.println(temp.getParts());

				//commit the transaction
				session.getTransaction().commit();
				System.out.println("Done!");
			}
			finally {
				session.close();
				factory.close();
			}

		}

}
