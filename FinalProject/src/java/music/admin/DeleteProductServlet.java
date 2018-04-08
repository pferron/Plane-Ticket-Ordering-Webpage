package music.admin;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import music.business.*;
import music.data.*;


public class DeleteProductServlet extends HttpServlet {

       
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String url = null;
        Product product;
        String button = "";
                
        // get parameters from the request
        String productCode = request.getParameter("productCode");
        
        // store the product object in the session
        HttpSession session = request.getSession();
        
        if (productCode != null)
        {
            product =  ProductDB.selectProduct(productCode);
            session.setAttribute("product", product);
        }

    button = request.getParameter("Yes_button"); 

    if ( button == null)
        {        
             url = "/confirm_product_delete.jsp"; 
        }
        else
        {
             synchronized(session)
             {
                product = (Product) session.getAttribute("product");
                ProductDB.delete(product);
             }
             url = "/displayProducts";
                     
        }

    // forward request and response objects to JSP page
    RequestDispatcher dispatcher =
         getServletContext().getRequestDispatcher(url);
    dispatcher.forward(request, response);

    }

         
   

}
