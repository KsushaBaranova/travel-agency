package travelagency.servlets.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import travelagency.dao.UserDao;
import travelagency.dao.impl.DefaultUserDao;
import travelagency.models.UserData;

@WebServlet(urlPatterns="/userById", name="ShowUserByIdServlet")
public class ShowUserByIdServlet extends HttpServlet {

	private UserDao userDao;
	
	{
		userDao = DefaultUserDao.getInstance();
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserData user = userDao.getUserById(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("user", user);
		request.getRequestDispatcher("WEB-INF/views/showUser.jsp").forward(request, response);
	}
}
