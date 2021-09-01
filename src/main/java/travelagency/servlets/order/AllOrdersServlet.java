package travelagency.servlets.order;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import travelagency.dao.OrderDao;
import travelagency.dao.impl.DefaultOrderDao;
import travelagency.models.OrderData;


@WebServlet(urlPatterns="/allorders", name="AllOrdersServlet")
public class AllOrdersServlet extends HttpServlet {

	private OrderDao orderDao;

	{
		orderDao = DefaultOrderDao.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		List<OrderData> orders = orderDao.getAllOrders();
		request.setAttribute("orders", orders);
		request.getRequestDispatcher("WEB-INF/views/allOrders.jsp").forward(request, response);
	}

}
