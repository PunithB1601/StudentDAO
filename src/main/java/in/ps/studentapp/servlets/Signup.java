package in.ps.studentapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import in.ps.studentapp.dao.StudentDAO;
import in.ps.studentapp.dao.StudentDAOImpl;
import in.ps.studentapp.dto.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/signup")
public class Signup extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Student s=new Student();//creation of pojo class object
		StudentDAO sdao=new StudentDAOImpl();
		//PrintWriter out=resp.getWriter();
		//String name=req.getParameter("name");
		//s.setName(name);
		s.setName(req.getParameter("name"));
		//String s_phone=req.getParameter("phone");
		//long l_phone=Long.parseLong(s_phone);
		//s.setPhone(l_phone);
		s.setPhone(Long.parseLong(req.getParameter("phone")));
		s.setMail(req.getParameter("mail"));
		s.setBranch(req.getParameter("branch"));
		s.setLoc(req.getParameter("loc"));
		if(req.getParameter("password").equals(req.getParameter("confirm")))
		{
			s.setPassword(req.getParameter("password"));
			boolean res=sdao.insertStudent(s);
			if(res) {
				//out.println("<h1>Data added successfully</h1>");
				req.setAttribute("success","Data added successfully!");
				RequestDispatcher rd=req.getRequestDispatcher("login.jsp");//creating ref object of RequestDispatcher
				rd.forward(req, resp);
				//RequestDispatcher -> Interface
		
				
			}
			else {
				req.setAttribute("error", "Failed to create the account!");
				RequestDispatcher rd=req.getRequestDispatcher("signup.jsp");
				rd.forward(req, resp);
				//out.println("<h1>Failed to create the account</h1>");
			}
		}
		else {
			req.setAttribute("error", "Password mismatch!");
			RequestDispatcher rd=req.getRequestDispatcher("signup.jsp");
			rd.forward(req, resp);
			//out.println("<h1>Failed to create the account</h1>");
		}
		
		
		
		
		
		
		
		
		
		
	}
}
