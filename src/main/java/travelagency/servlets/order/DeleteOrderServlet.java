package travelagency.servlets.order;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import travelagency.dao.OrderDao;
import travelagency.dao.impl.DefaultOrderDao;


@WebServlet(urlPatterns="/deleteorder", name="DeleteOrderServlet")
public class DeleteOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private OrderDao orderDao;

	{
		orderDao = DefaultOrderDao.getInstance();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		orderDao.deleteOrder(orderId);
		response.sendRedirect(getServletContext().getContextPath() + "/allorders");
	}
}
