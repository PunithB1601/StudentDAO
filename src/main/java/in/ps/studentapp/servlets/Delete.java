package in.ps.studentapp.servlets;

import java.io.IOException;

import in.ps.studentapp.dao.StudentDAO;
import in.ps.studentapp.dao.StudentDAOImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/deleteUsers")
public class Delete extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentDAO sdao=new StudentDAOImpl();
		boolean res=sdao.deleteStudent(Integer.parseInt(req.getParameter("id")));
		if(res) {
			req.setAttribute("success","Account deleted!");
			RequestDispatcher rd=req.getRequestDispatcher("viewUsers.jsp");//creating ref object of RequestDispatcher
			rd.forward(req, resp);
		}
		else {
			req.setAttribute("error","Failed to delete the account!");
			RequestDispatcher rd=req.getRequestDispatcher("viewUsers.jsp");//creating ref object of RequestDispatcher
			rd.forward(req, resp);
		}
	}
}
