package music.admin;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import music.data.*;
import music.business.*;

public class UpdateProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        // get parameters from the request
        Product product;
        String message;
        String url;
        Double price;
        String productCode = request.getParameter("productCode");
        String productDescription = request.getParameter("productDescription");
        String productPrice = request.getParameter("productPrice");
        
              
        try
        {
           if (!productPrice.equals(""))
                price = Double.parseDouble(productPrice);
           else price = 0.0;
        
            
        
            if (productCode.equals("") || productDescription.equals("") || productPrice.equals("") || price < 0)
            {
                product = new Product();
                
                if (productCode.equals(""))
                {
                    message = "Please, enter a product Code";
                }
                else if (productDescription.equals(""))
                {
                    message = "Please, enter a descriptiion";
                }
                else if (productPrice.equals(""))
                {
                    message = "Please, enter a price";
                }
                else 
                {
                    message = "Please, enter a positive value for the price";
                }

                // store the message object in the request object
                request.setAttribute("message", message);
                
                // forward request and response objects to JSP page
                url = "/product.jsp";
                RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
                dispatcher.forward(request, response);
            }
            else
            {

                if (ProductDB.exists(productCode))
                {
                    product = ProductDB.selectProduct(productCode);
                    product.setDescription(productDescription);
                    product.setPrice(price);
                    ProductDB.update(product);
                }
                else
                {
                    product = new Product();
                    product.setCode(productCode);
                    product.setDescription(productDescription);
                    product.setPrice(price);
                    ProductDB.insert(product);
                }

                // forward request and response objects to JSP page
                url = "/displayProducts";
                RequestDispatcher dispatcher =
                     getServletContext().getRequestDispatcher(url);
                dispatcher.forward(request, response);
            }
        }
        catch (NumberFormatException e) 
        {
                product = new Product();
                
                message = "Please, enter a valid numeric value for the price";
            
                // store the message object in the request object
                request.setAttribute("message", message);
                
                // forward request and response objects to JSP page
                url = "/product.jsp";
                RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
                dispatcher.forward(request, response);
        }
        
    }
}
