package com.example.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Car;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Part;
import com.example.demo.entity.Sale;
import com.example.demo.entity.Supplier;


public class CarDBTest {
	public static void main(String[] args) {
	// create session factory
			SessionFactory factory= new Configuration()
					.configure()
					.addAnnotatedClass(Car.class)
					.addAnnotatedClass(Customer.class)
					.addAnnotatedClass(Sale.class)
					.addAnnotatedClass(Part.class)
					.addAnnotatedClass(Supplier.class)
					.buildSessionFactory();
			//create session
	       
			  Session session=factory.getCurrentSession();
			try {
			 
				//start a transaction
				session.beginTransaction();
				
				long id=10;
				Car temp = session.get(Car.class, id);//working
				System.out.println("Cars: "+temp.getMake());
				System.out.println();
				Customer temp2 = session.get(Customer.class, id);//working
				System.out.println();
				System.out.println("Customers: "+temp2.getName());
				System.out.println();
				Sale temp3 = session.get(Sale.class, id);//working
				System.out.println();
				System.out.println("Sales: "+temp3.getDiscount());
				System.out.println();
				Part temp4 = session.get(Part.class, id);// WORKING
				System.out.println();
				System.out.println("Parts: "+temp4.getName());
				System.out.println();
				Supplier temp5 = session.get(Supplier.class, id);//working
				System.out.println();
				System.out.println("Suppliers: "+temp5.getName());
//				System.out.println();				
				System.out.println(temp.getParts());

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
