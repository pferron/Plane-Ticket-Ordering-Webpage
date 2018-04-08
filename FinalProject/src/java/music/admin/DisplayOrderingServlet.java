package music.admin;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import music.data.*;
import java.util.*;


public class DisplayOrderingServlet extends HttpServlet 
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String message = null;
        String url     = null;
        
        // get parameters from the request
        String orderingNumber = request.getParameter("orderingNumber");
        String emailAddress = request.getParameter("emailAddress");
        
        if(OrderingDB.exists(orderingNumber, emailAddress))
        {
            message = "Existing Ordering";
            url = "/order.jsp";
        }
        else
        {
            message = "No Existing Ordering, Please, re-enter your information";
            url = "/book_home_page.jsp";
        }
        
        request.setAttribute("message", message);
        
        RequestDispatcher dispatcher =
             getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);              
    }    
}