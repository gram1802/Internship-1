import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	
	private final static String query = "delete from user where id=?";
	
	protected void doGet(HttpServletRequest req , HttpServletResponse res) {
		doPost(req,res);
	}
	protected void doPost(HttpServletRequest req , HttpServletResponse res) {
		
		Connection con = null;
        PreparedStatement ps = null;
        PrintWriter pw = null;

        try {
            pw = res.getWriter();
            res.setContentType("text/html");
            
            Integer id = Integer.parseInt(req.getParameter("id"));

            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/usermanagement";
            String usr = "root";
            String pass = "root123";

            con = DriverManager.getConnection(url, usr, pass);

            ps = con.prepareStatement(query);
            ps.setInt(1, id);
           
            int count = ps.executeUpdate();
            if (count == 1) {
                pw.println("<h2 style='color:green;'>Record Deleted Successfully</h2>");
            }
            else {
                pw.println("<h2 style='color:red;'>Record Not Deleted</h2>");
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        pw.println("<a href='index.html'><button>Home</button></a>");
        pw.println("<a href='showdata'><button>Show Users</button></a>");
    }		
}


