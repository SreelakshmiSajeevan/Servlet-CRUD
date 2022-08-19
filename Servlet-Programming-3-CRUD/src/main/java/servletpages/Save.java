package servletpages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Employee;
import dao.EmployeeDao;

/**
 * Servlet implementation class Save
 */
@WebServlet("/Save")
public class Save extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Save() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { // TODO Auto-generated
	 * method stub
	 * response.getWriter().append("Served at: ").append(request.getContextPath());
	 * }
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		 response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	          
	        String name=request.getParameter("name");  
	        String password=request.getParameter("password");  
	        String email=request.getParameter("email");  
	        String country=request.getParameter("country");
	        
	        Employee emp=new Employee();
	        emp.setName(name);
	        emp.setPassword(password);
	        emp.setEmail(email);
	        emp.setCountry(country);
	        int status=EmployeeDao.saveEmployee(emp);
	        if(status>0)
	        {
	        	out.print("Saved");
	        
	        	request.getRequestDispatcher("index.html").include(request, response);
	        }
	        else {
				out.print("Error found");
			}
	        
	}

}
