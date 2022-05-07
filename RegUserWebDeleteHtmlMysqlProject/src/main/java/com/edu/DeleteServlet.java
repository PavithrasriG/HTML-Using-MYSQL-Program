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
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		
		int id=Integer.parseInt(request.getParameter("sid"));
		
		try {
			Connection conn=DbConnect.getConnection();
			Statement st=conn.createStatement();
			 String sql="select * from student where sid="+id; //get only one row
			  //check id exists
			 ResultSet  rs=st.executeQuery(sql);
			  if(rs.next()) { //if true record exists
				//delete operation when record exists
				  
			String del = "delete from student where sid="+id;
			int  i=st.executeUpdate(del);
					
			if(i>0) {
				out.println("Record is deleted");
					}//if(i>0)
					}//if(rs.next)
				  else {
					  out.println("Record not exists");
				  }//else
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
