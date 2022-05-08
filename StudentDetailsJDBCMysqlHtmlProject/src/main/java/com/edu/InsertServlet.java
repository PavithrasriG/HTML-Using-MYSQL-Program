package com.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		
		String sn=request.getParameter("sname");
		int id=Integer.parseInt(request.getParameter("sid"));
		String sp=request.getParameter("spass");
		int sa=Integer.parseInt(request.getParameter("sage"));
		float sf=Float.parseFloat(request.getParameter("sfees"));
		
		try {
			Connection conn=DbConnect.getConnection();
			Statement st=conn.createStatement();
			String ins="insert into student values("+id+",'"+sn+"','"+sp+"',"+sa+","+sf+")";
		    
			int i=st.executeUpdate(ins);
			
			if(i>0) {
				out.println("Registered successfully");
			}
			else {
				out.println("Not Registered");
			}
		
		
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
