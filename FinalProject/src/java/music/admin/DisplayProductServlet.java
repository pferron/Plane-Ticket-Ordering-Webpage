package music.admin;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import music.business.Product;
import music.data.ProductDB;


public class DisplayProductServlet extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        // get parameters from the request
        String productCode = request.getParameter("productCode");
        
        Product product =  ProductDB.selectProduct(productCode);
        String message = null;
            
        if (product == null)
        {
            product = new Product();
            message = "Enter code, description, and price to add a new product.";
        }
        else
        {
            message = "Make the necessary changes to update this product.";
        }
        
        // store the message object in the request object
        request.setAttribute("message", message);
        
        // store the product object in the session
        HttpSession session = request.getSession();
        session.setAttribute("product", product);
        
        String url = "/product.jsp";
        RequestDispatcher dispatcher =
             getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response); 
    }
   
}
