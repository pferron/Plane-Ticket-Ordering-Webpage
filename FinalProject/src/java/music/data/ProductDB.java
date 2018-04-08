package music.data;

import java.sql.*;
import java.util.*;

import music.business.Product;

public class ProductDB
{
    public static int insert(Product product)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = 
                "INSERT INTO Product (ProductCode, ProductDescription, ProductPrice) " +
                "VALUES (?, ?, ?)";
        try
        {        
            ps = connection.prepareStatement(query);
            ps.setString(1, product.getCode());
            ps.setString(2, product.getDescription());
            ps.setDouble(3, product.getPrice());
            return ps.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return 0;
        }
        finally
        {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static int update(Product product)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "UPDATE Product SET " +
                "ProductDescription = ?, " +
                "ProductPrice = ? " +
                "WHERE ProductCode = ?";
        try
        {
            ps = connection.prepareStatement(query);
            ps.setString(1, product.getDescription());
            ps.setDouble(2, product.getPrice());
            ps.setString(3, product.getCode());

            return ps.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return 0;
        }
        finally
        {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static int delete(Product product)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "DELETE FROM Product " +
                "WHERE ProductCode = ?";
        try
        {
            ps = connection.prepareStatement(query);
            ps.setString(1, product.getCode());

            return ps.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return 0;
        }
        finally
        {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static boolean exists(String productCode)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT ProductCode FROM Product " +
                "WHERE ProductCode = ?";
        try
        {
            ps = connection.prepareStatement(query);
            ps.setString(1, productCode);
            rs = ps.executeQuery();
            return rs.next();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return false;
        }
        finally
        {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static Product selectProduct(String productCode)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM Product " +
                       "WHERE ProductCode = ?";
        try
        {
            ps = connection.prepareStatement(query);
            ps.setString(1, productCode);
            rs = ps.executeQuery();
            Product product = null;
            if (rs.next())
            {
                product = new Product();
                product.setCode(rs.getString("ProductCode"));
                product.setDescription(rs.getString("ProductDescription"));
                product.setPrice(rs.getDouble("ProductPrice"));
            }
            return product;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }        
        finally
        {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static List<Product> selectProducts()
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Product> products = new ArrayList<Product>();
        
        String query = "SELECT * FROM Product ";
        
        try
        {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            Product product = null;
            while (rs.next())
            {
                product = new Product();
                product.setCode(rs.getString("ProductCode"));
                product.setDescription(rs.getString("ProductDescription"));
                product.setPrice(rs.getDouble("ProductPrice"));
                
                products.add(product);
                
            }
            
            return products;
            
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }        
        finally
        {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        
    }
   
}