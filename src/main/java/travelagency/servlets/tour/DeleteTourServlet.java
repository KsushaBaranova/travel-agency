package travelagency.servlets.tour;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import travelagency.dao.TourDao;
import travelagency.dao.impl.DefaultTourDao;


@WebServlet(urlPatterns="/deletetour", name="DeleteTourServlet")
public class DeleteTourServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

	private TourDao tourDao;

	{
		tourDao = DefaultTourDao.getInstance();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int tourId = Integer.parseInt(request.getParameter("tourId"));
		tourDao.deleteTour(tourId);	
		response.sendRedirect(getServletContext().getContextPath() + "/alltours");
	}

}
