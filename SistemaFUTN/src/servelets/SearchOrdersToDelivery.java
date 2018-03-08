package servelets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Order;
import entidades.User;
import negocio.CtrlOrders;
import negocio.CtrlUsers;
import utils.ApplicationException;

@WebServlet("/SearchOrdersToDelivery")
public class SearchOrdersToDelivery extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchOrdersToDelivery() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getSession().setAttribute("ordersToDeliver",null);
		
		CtrlUsers ctrlUsers=new CtrlUsers();
		CtrlOrders ctrlOrders=new CtrlOrders();

		ArrayList<Order> ordersToDeliver;
		User student=new User();

		int legajo=(Integer.parseInt(request.getParameter("legajo")));

		try {
			student=ctrlUsers.getByLegajo(legajo);

			ordersToDeliver = ctrlOrders.getOrdersToDeliver(student);
			

			request.getSession().setAttribute("ordersToDeliver",ordersToDeliver);

		} catch (ApplicationException e) {

			request.getSession().setAttribute("exceptionMessage",e.getMessage());	

		}finally {
			request.getRequestDispatcher("DeliverOrder.jsp").forward(request, response); 
		}	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
