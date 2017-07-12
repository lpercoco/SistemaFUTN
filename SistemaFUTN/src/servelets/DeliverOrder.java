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

/**
 * Servlet implementation class DeliverOrder
 */
@WebServlet("/DeliverOrder")
public class DeliverOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeliverOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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
