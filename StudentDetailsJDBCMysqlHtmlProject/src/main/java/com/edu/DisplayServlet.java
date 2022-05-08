package com.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisplayServlet
 */
@WebServlet("/DisplayServlet")
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		try {
		Connection conn=DbConnect.getConnection();
		
		String s="select * from student";
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery(s);
		
		out.println("<!DOCTYPE html>");
		out.println("<head><title>Student Records</title></head>");
		out.println("<body >");
		out.println("<table border='1'>");
		out.println("<tr><th>SID</th><th>SNAME</th><th>SPASS</th><th>SAGE</th><th>SFEES</th></tr>");
		
		while(rs.next()) {
			out.println("<tr>");
			out.println("<td>"+rs.getInt("sid")+"</td>");
			out.println("<td>"+rs.getString("sname")+"</td>");
			out.println("<td>"+rs.getString("spass")+"</td>");
			out.println("<td>"+rs.getInt("sage")+"</td>");					
			out.println("<td>"+rs.getFloat("sfees")+"</td>");
			out.println("</tr>");
			
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
