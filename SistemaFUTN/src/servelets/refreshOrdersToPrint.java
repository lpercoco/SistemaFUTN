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

/**
 * Servlet implementation class refreshOrdersToPrint
 */
@WebServlet("/refreshOrdersToPrint")
public class refreshOrdersToPrint extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public refreshOrdersToPrint() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.getSession().setAttribute("exceptionMessage",null);	
		request.getSession().setAttribute("message",null);
		
		CtrlOrders ctrlOrders = new CtrlOrders();
		ArrayList<Order> orders = new ArrayList<Order>();
		int  numberOfOrdersToPrint;
		
		orders=ctrlOrders.getUnreadyAndUndeliveryOrders();

		numberOfOrdersToPrint=ctrlOrders.getNumberOfOrdersToPrint(orders);
		
		request.getSession().setAttribute("orders",orders);
		request.getSession().setAttribute("numberOfOrdersToPrint",numberOfOrdersToPrint);

		if(numberOfOrdersToPrint==0){
			request.getSession().setAttribute("exceptionMessage","There are no orders to print");	
		}
		
		request.getRequestDispatcher("OrdersGrid.jsp").forward(request, response); 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
