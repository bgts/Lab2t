
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

public class RefreshAction {
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
		return "success";
	}

}
