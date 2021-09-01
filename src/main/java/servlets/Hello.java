package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import travelagency.dao.UserDao;
import travelagency.dao.impl.DefaultUserDao;
import travelagency.models.UserData;;

@WebServlet("/Hello")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao userDao = DefaultUserDao.getInstance(); 
//		response.getWriter().append("User id =" + request.getParameter("id"));
        PrintWriter writer = response.getWriter();
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            writer.println(userDao.getUserById(id));
        } finally {
            writer.close();  
        }
	}

}
