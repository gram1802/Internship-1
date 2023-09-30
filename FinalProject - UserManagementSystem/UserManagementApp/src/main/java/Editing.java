import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/edited")
public class Editing extends HttpServlet {
	
	private final static String query = "update user set name=?,email=?,mobile=?,date=?,city=?,gender=? where id=?";
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) {
		doPost(req,res);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) {

		PrintWriter pw = null;
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			
			pw = res.getWriter();
			res.setContentType("text/html");
			
			Integer id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("name");
            String email = req.getParameter("email");
            String mobile = req.getParameter("mobile");
            String date = req.getParameter("date");
            String city = req.getParameter("city");
            String gender = req.getParameter("gender");
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/usermanagement";
			String usr = "root";
			String pass = "root123";
			con = DriverManager.getConnection(url,usr,pass);
			
			ps = con.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, mobile);
			ps.setString(4, date);
			ps.setString(5, city);
			ps.setString(6, gender);
			ps.setInt(7, id);
			
			int row = ps.executeUpdate();
			if(row == 1) {
				pw.println("<h2 style='color:green'>Record Updated Successfully</h2>");
			}
			else {
				pw.println("<h2 style='red'>Record Did Not Get Updated</h2>");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		pw.println("<a href='index.html'>");
		pw.println("<button>Home</button></a>");
		pw.println("<a href='showdata'>");
		pw.println("<button>Show Users</button></a>");
		
	}
	
}
