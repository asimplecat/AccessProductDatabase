package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetProductServlet
 */
@WebServlet("/GetProductServlet")
public class GetProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productName = "[]";
		int price = 0;
		
		String pid = request.getParameter("pid");
		ConnectionManager con = new ConnectionManager();
		ResultSet rs= con.productInfo(pid);
		System.out.println(rs.toString());
		
		try {
			rs.next();
	        productName = rs.getString("productName");
	        price = rs.getInt("price");
		}
		catch(Exception e) {}
		
		PrintWriter out = response.getWriter();
		out.print("Product " + pid + " has the product name " + productName + " and its price is $" + price);
		
		
		con.close();
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//PrintWriter out = con.get

	}
	
	
}


