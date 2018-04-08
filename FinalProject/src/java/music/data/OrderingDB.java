
package music.data;

import java.sql.*;
import java.util.*;

public class OrderingDB
{
public static boolean exists(String orderingNumber, String emailAddress)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT OrderingNumber FROM Orders " +
                "WHERE OrderingNumber = ? and EmailAddress = ?";
        try
        {
            ps = connection.prepareStatement(query);
            ps.setString(1, orderingNumber);
            ps.setString(2, emailAddress);
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
}