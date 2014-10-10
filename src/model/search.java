package model;

import java.sql.*;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

public class search extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static String author;
	static String AuthorID = "";
	static ArrayList<String> ISBN = new ArrayList<String>();
	static ArrayList<String> Title = new ArrayList<String>();
	static ArrayList<String> Publisher = new ArrayList<String>();
	static ArrayList<String> PublishDate = new ArrayList<String>();
	static ArrayList<String> Price = new ArrayList<String>();
	static String country;
	static String age;
	HttpServletResponse response;

	public String execute() {
		Title.clear();
		Publisher.clear();
		PublishDate.clear();
		Price.clear();
		ISBN.clear();
		author="";
		AuthorID="";
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("allbooks", Title);
		search.author = request.getParameter("author");
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/bookdb", "root", "hjhj1994");
			Statement stmt = con.createStatement();
			ResultSet rst = stmt.executeQuery("select * from author;");
			while (rst.next()) {
				if (author.equals(rst.getString("Name"))) {
					search.AuthorID = rst.getString("AuthorID");
					search.age = rst.getString("Age");
					search.country = rst.getString("Country");
				}
			}
			rst.close();

			rst = stmt.executeQuery("select * from book;");
			while (rst.next()) {
				if (search.AuthorID.equals(rst.getString("AuthorID"))) {
					search.ISBN.add(rst.getString("ISBN"));
					search.Title.add(rst.getString("Title"));
					search.Publisher.add(rst.getString("Publisher"));
					search.PublishDate.add(rst.getString("PublishDate"));
					search.Price.add(rst.getString("Price"));
				}
			}
			stmt.close();
			rst.close();
			con.close();
		} catch (Exception e) {
			return "failed";
		}
		if (AuthorID == "")
			return "failed";
		else
			return "success";
	}

}
