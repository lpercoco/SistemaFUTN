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


@WebServlet("/refreshOrdersToPrint")
public class refreshOrdersToPrint extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public refreshOrdersToPrint() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CtrlOrders ctrlOrders = new CtrlOrders();
		ArrayList<Order> orders = new ArrayList<Order>();
		
		orders=ctrlOrders.getUnprintedOrders();
		
		request.getSession().setAttribute("orders",orders);

		if(orders.size()==0){
			request.getSession().setAttribute("exceptionMessage","There are no orders to print");	
		}
		
		request.getRequestDispatcher("OrdersGrid.jsp").forward(request, response); 
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
