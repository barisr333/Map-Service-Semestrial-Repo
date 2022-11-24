package serverFunctionality;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


// TODO: Auto-generated Javadoc
/**
 * The Class mysqlConnection.
 */
public class mysqlConnection {

	/** The connection. */
	public Connection connection = null;
	
	/** The data base. */
	private static mysqlConnection dataBase;


	/**
	 * Instantiates a new mysql connection.
	 *
	 * @throws SQLException the SQL exception
	 */
	public mysqlConnection() throws SQLException
    {
		try
		{
           Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (Exception ex) {/* handle the error*/}

        try
          {
        	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gcm?serverTimezone=IST","root","123456");
            //Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.3.68/test","root","Root");
            System.out.println("SQL connection succeed");
            ServerLogger.writeNewLine("SQL connection succeed");
     	    } catch (SQLException ex)
     	    {/* handle any errors*/
            ServerLogger.writeNewLine("SQLException: " + ex.getMessage());
            ServerLogger.writeNewLine("SQLState: " + ex.getSQLState());
            ServerLogger.writeNewLine("VendorError: " + ex.getErrorCode());
            }
          }

	   /**
   	 * Gets the connection.
   	 *
   	 * @return the mysql connection
   	 * @throws SQLException the SQL exception
   	 */
   	public static mysqlConnection GetConnection() throws SQLException {
			if (dataBase == null) {
			    dataBase = new mysqlConnection();
			}
			return dataBase;
		    }
}


