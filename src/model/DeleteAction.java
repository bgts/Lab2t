package model;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

public class DeleteAction {
	String name="";
	public String getName()
	{
		return name;
	}
	public void setName(String name) throws UnsupportedEncodingException
	{
		this.name = new String(name.getBytes("iso-8859-1"),"UTF-8");
	}
	public String execute() {
		search.Title.clear();
		search.Publisher.clear();
		search.PublishDate.clear();
		search.Price.clear();
		search.ISBN.clear();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("allbooks", search.Title);
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/bookdb", "root", "hjhj1994");
			Statement stmt = con.createStatement();
			ResultSet rst = stmt.executeQuery("select * from book;");
			while (rst.next()) {
				if (name.equals(rst.getString("Title"))) {
					stmt.executeUpdate("delete from book where Title='"+name+"';");
					break;
				}
			}
			
			stmt.close();
			rst.close();
			con.close();
		} catch (Exception e) {
			return "failed";
		}
		return "success";
	}
}