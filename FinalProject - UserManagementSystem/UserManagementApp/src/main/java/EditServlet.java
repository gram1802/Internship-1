import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/edit")
public class EditServlet extends HttpServlet {
	
	private final static String query = "select name,email,mobile,date,city,gender from user where id=?";
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) {
		doPost(req,res);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) {
		
		Connection con = null;
        PreparedStatement ps = null;
        PrintWriter pw = null;
		
		try {
			pw = res.getWriter();
			res.setContentType("text/html");
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/usermanagement";
			String usr = "root";
			String pass = "root123";
			con = DriverManager.getConnection(url,usr,pass);
			
			Integer id= Integer.parseInt(req.getParameter("id"));
			
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			rs.next();
			pw.println("<form action='edited?id=" + id + "' method='post'>");
			pw.println("<table>");
			pw.println("<tr>");
			pw.println("<td>Name</td>");
			pw.println("<td><input type='text' name='name' value='" + rs.getString(1) + "'></td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td>Email</td>");
			pw.println("<td><input type='email' name='email' value='" + rs.getString(2) + "'</td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td>Mobile</td>");
			pw.println("<td><input type='text' name='mobile' value='" + rs.getString(3) + "'</td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td>DOB</td>");
			pw.println("<td><input type='date' name='date' value='" + rs.getString(4) + "'</td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td>City</td>");
			pw.println("<td><input type='text' name='city' value='" + rs.getString(5) + "'</td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td>Gender</td>");
			pw.println("<td><input type='text' name='gender' value='" + rs.getString(6) + "'</td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td><button type='submit'>Edit</button>");
			pw.println("</tr>");
			pw.println("</table>");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	

}
