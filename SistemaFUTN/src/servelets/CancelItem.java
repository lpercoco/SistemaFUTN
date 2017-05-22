package servelets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.OrderDetail;
import negocio.CtrlOrders;

/**
 * Servlet implementation class CancelItem
 */
@WebServlet("/CancelItem")
public class CancelItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelItem() {
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

		CtrlOrders ctrl=new CtrlOrders();
		
		ArrayList<OrderDetail> orderDetails=(ArrayList<OrderDetail>) request.getSession().getAttribute("orderDetails");
		int odNumber= Integer.parseInt(request.getParameter("orderDetailToDelate"));
		
		orderDetails=ctrl.cancelItem(orderDetails,odNumber);

		request.getSession().setAttribute("orderDetails",orderDetails);

		request.getRequestDispatcher("Cart.jsp").forward(request, response); 
	}

}
