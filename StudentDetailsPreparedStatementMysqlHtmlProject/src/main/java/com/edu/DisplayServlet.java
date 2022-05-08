package com.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
		
		Connection conn=null;
		PreparedStatement pst;
		ResultSet rst;
		try
		{
			conn=DbConnect.getConnection();
			String sel="select * from student";
			pst=conn.prepareStatement(sel);
			rst=pst.executeQuery();

			out.println("<!DOCTYPE html>");
			out.println("<head><title>Student Details</title></head>");
			out.println("<body>");
			out.println("<table border='1'>");
			out.println("<tr><th>SID</th><th>SNAME</th><th>SPASS</th><th>SAGE</th><th>SFEES</th></tr>");
			while(rst.next())
			{
				out.println("<tr><td>"+rst.getInt(1)+"</td>");
				out.println("<td>"+rst.getString(2)+"</td>");
				out.println("<td>"+rst.getString(3)+"</td>");
				out.println("<td>"+rst.getInt(4)+"</td>");
				out.println("<td>"+rst.getFloat(5)+"</td></tr>");
			}//while
			out.println("</table>");
			out.println("</body>");
			out.println("</html>");

			}//try
			
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	}


