package com.example.demo.testDB;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//set connection variable
		String user ="root";
		String pass ="Moiata parola za Mysql";
		String jdbcUrl="jdbc:mysql://localhost:3306/cardb?useSSLL=false";
		String driver = "com.mysql.jdbc.Driver";//name for jdbc java class for mySQL
		
		//get a connection
		try {
			PrintWriter out= response.getWriter();
			out.println("Connecting to database: "+ jdbcUrl);
			//load driver
			Class.forName(driver);
			
			Connection connection= DriverManager.getConnection(jdbcUrl,user,pass);
			
			out.println("Connection successful");
			
			connection.close();
		}
		catch(Exception e){
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

}
