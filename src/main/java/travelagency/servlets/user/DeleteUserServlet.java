package travelagency.servlets.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import travelagency.dao.UserDao;
import travelagency.dao.impl.DefaultUserDao;


@WebServlet(urlPatterns="/deleteuser", name="DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
	
	private UserDao userDao;

	{
		userDao = DefaultUserDao.getInstance();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("userId"));
		userDao.deleteUser(userId);	
		response.sendRedirect(getServletContext().getContextPath() + "/login");
	}
}
