package in.ps.studentapp.servlets;

import java.io.IOException;

import in.ps.studentapp.dao.StudentDAO;
import in.ps.studentapp.dao.StudentDAOImpl;
import in.ps.studentapp.dto.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/resetPassword")
public class ResetPin extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession(false);
		StudentDAO sdao=new StudentDAOImpl();
		Student s=(Student)session.getAttribute("student");

		if(s.getPhone()==Long.parseLong(req.getParameter("phone"))&&s.getMail().equals(req.getParameter("mail"))) {
			if(req.getParameter("password").equals(req.getParameter("confirm"))) {
				s.setPassword(req.getParameter("password"));
				boolean res=sdao.updateStudent(s);
				if(res) {
					req.setAttribute("success","Password changed!");
					RequestDispatcher rd=req.getRequestDispatcher("login.jsp");//creating ref object of RequestDispatcher
					rd.forward(req, resp);
				}
				else {
					req.setAttribute("error","Failed to update password!");
					RequestDispatcher rd=req.getRequestDispatcher("resetPassword.jsp");//creating ref object of RequestDispatcher
					rd.forward(req, resp);
				}
			}
			else {
				req.setAttribute("error","Password mismatch!");
				RequestDispatcher rd=req.getRequestDispatcher("resetPassword.jsp");//creating ref object of RequestDispatcher
				rd.forward(req, resp);
			}
		}
		else {
			req.setAttribute("error","Error occured!");
			RequestDispatcher rd=req.getRequestDispatcher("resetPassword.jsp");//creating ref object of RequestDispatcher
			rd.forward(req, resp);
		}
	}
}
