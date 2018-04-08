package music.admin;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import music.data.ProductDB;
import java.util.*;
import music.business.Product;


public class DisplayProductsServlet extends HttpServlet 
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        
        List<Product> products = ProductDB.selectProducts();
        
        // store the products object in the session
        HttpSession session = request.getSession();
        session.setAttribute("products", products);
        
        // forward request and response objects to JSP page
        String url = "/products.jsp";
        RequestDispatcher dispatcher =
             getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);              
    }    
}