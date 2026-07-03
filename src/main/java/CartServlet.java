import java.io.IOException;

import com.tap.Model.Cart;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CartServlet extends HttpServlet {
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		Cart cart = new Cart();
		
		if(action.equals("add"))
		{
			addItemToCart(req,cart);
		}
		else if(action.equals("update")) {
			updateItemToCart(req,cart);
	    }
	   else if(action.equals("delete")) {
		   deleteItemFromCart(req,cart);
		
	}
}

	private void deleteItemFromCart(HttpServletRequest req, Cart cart) {
		
	}

	private void updateItemToCart(HttpServletRequest req, Cart cart) {
		
		
	}

	private void addItemToCart(HttpServletRequest req, Cart cart) {
		
		
	}

}
