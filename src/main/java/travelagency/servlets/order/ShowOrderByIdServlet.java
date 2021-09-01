package travelagency.servlets.order;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import travelagency.dao.OrderDao;
import travelagency.dao.impl.DefaultOrderDao;
import travelagency.models.OrderData;
import travelagency.models.TourData;


@WebServlet(urlPatterns="/orderById", name="ShowTourByIdServlet")
public class ShowOrderByIdServlet extends HttpServlet {

	private OrderDao orderDao;

	{
		orderDao = DefaultOrderDao.getInstance();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderData order = orderDao.getOrderById(Integer.parseInt(request.getParameter("orderId")));
		request.setAttribute("order", order);
		request.getRequestDispatcher("WEB-INF/views/showOrder.jsp").forward(request, response);
	}

}
