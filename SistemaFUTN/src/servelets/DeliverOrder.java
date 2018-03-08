package servelets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Order;
import negocio.CtrlOrders;
import utils.ApplicationException;

@WebServlet("/DeliverOrder")
public class DeliverOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeliverOrder() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getSession().setAttribute("exceptionMessage",null);
		request.getSession().setAttribute("message",null);

		CtrlOrders ctrlOrders = new CtrlOrders();
		
		ArrayList<Order> ordersToDeliver;
		
		int orderNumberToDeliver=Integer.parseInt(request.getParameter("orderNumber"));
		
		ordersToDeliver=(ArrayList<Order>) request.getSession().getAttribute("ordersToDeliver");
		
		try {
			ordersToDeliver=ctrlOrders.deliverOrder(ordersToDeliver,orderNumberToDeliver);
			
			request.getSession().setAttribute("message","Order delivered");
		} catch (ApplicationException e) {

			request.getSession().setAttribute("exceptionMessage",e.getMessage());
			
		}finally{
			request.getSession().setAttribute("ordersToDeliver",ordersToDeliver);
			request.getRequestDispatcher("DeliverOrder.jsp").forward(request, response); 
		}
	}
}
