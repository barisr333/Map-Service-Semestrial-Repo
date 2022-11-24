package serverFunctionality;

import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import javafx.scene.image.Image;
import java.io.Serializable;
//import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.WritableImage;
import java.awt.image.BufferedImage;
import java.io.*;
import serverFunctionality.mysqlConnection;
//import java.awt.Image;
import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;
import javafx.embed.swing.SwingFXUtils;
import serverFunctionality.mysqlConnection;


// TODO: Auto-generated Javadoc
/**
 * The Class mysqlQuery.
 * This class receives a query in String format from the client and contains all the methods responsible for executing the required query
 * server-side on the DB and returning the result.
 * All methods return either a simple String, in the case of an Update\Insert\Delete query where information does not need to return to the client,
 *  or a List of Strings for Select queries with the entire query result. 
 */
public class mysqlQuery implements Serializable {

	/** The my sql. */
	private mysqlConnection mySql;

	/**
	 * Login function execute the query and return all the information about the
	 * user.
	 *
	 * @param query - This string include the query to login.
	 * @return - ArrayList<String> userArr ,this arrayList include the query result.
	 *         In this case this arrayList hold all the information about the user.
	 */
	public ArrayList<String> Login(String query) {
		Statement stmt;
		ArrayList<String> userArr = new ArrayList<String>();
		String[] splitQuery = query.split("#");
		userArr.add("Login");

		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (userArr.contains("customers")) {
			try {
				stmt = mySql.connection.createStatement();
				ResultSet rs = stmt.executeQuery(splitQuery[0]);
				while (rs.next()) {
					// Put result to string
					for (int i = 1; i < 13; i++)
						userArr.add(rs.getString(i));
				}
				rs.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		} else {
			try {
				stmt = mySql.connection.createStatement();
				ResultSet rs = stmt.executeQuery(splitQuery[0]);
				while (rs.next()) {
					// Put result to string
					for (int i = 1; i < 14; i++)
						userArr.add(rs.getString(i));
				}
				rs.close();
			} catch (Exception e) {
				// TODO: handle exception
			}

		}

		// check if the "userArr" list is the one with the results from the
		// query to avoid exception array out of bounds.
		if (userArr.size() > 2) {
			ServerLogger.writeNewLine("Query execution result: User name: " + userArr.get(1) + ", Password: "
					+ userArr.get(4) + ", Permission: " + userArr.get(7) + ".");
			if (Integer.parseInt(userArr.get(7)) == 0) // If user is a customer,
														// log login activity
			{
				/*
				 * try { stmt = mySql.connection.createStatement(); stmt.
				 * executeUpdate("INSERT INTO customerloginhistory (username, time) VALUES ('" +
				 * userArr.get(1) + "', NOW());");
				 *
				 * } catch (Exception e) { // TODO: handle exception
				 *
				 * }
				 */
			}

			try {
				stmt = mySql.connection.createStatement();
				stmt.executeUpdate(splitQuery[1]);
			} catch (SQLException e) {
				userArr.clear();
				userArr.add("Login");
				userArr.add(Integer.toString(e.getErrorCode()));
				ServerLogger.writeNewLine("Login request handled: user already logged in.");
			}

		} else {
			ServerLogger.writeNewLine("Query execution result: There are no results for this query at this moment.");
		}

		return userArr;
	}

	/**
	 * RegisterClient function execute the client register query .
	 *
	 * @param query - This string include the query to Register a Client.
	 * @return only a key word for the recognition of the query.
	 */
	public String RegisterClient(String query) {
		Statement stmt;
		String loginInfro = new String();

		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			stmt = mySql.connection.createStatement();
			stmt.executeUpdate(query);
			ServerLogger.writeNewLine("Query execution result: the new customer added to the DB");
			loginInfro = "RegisterNewClient, ";

		} catch (Exception e) {
			if (e instanceof SQLException) {
				loginInfro = "RegisterNewClient, ";
				loginInfro += Integer.toString(((SQLException) e).getErrorCode());
				return loginInfro;
			}
		}
		return loginInfro;
	}

	/**
	 * RegisterCreditCard function execute the clients credit card registration
	 * query .
	 *
	 * @param query - This string include the query to Register a clients credit
	 *              card.
	 * @return only a key word for the recognition of the query.
	 */
	public String RegisterCreditCard(String query) {
		Statement stmt;
		String loginInfro = new String();
		loginInfro = "RegisterNewClientCreditCard, ";

		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			stmt = mySql.connection.createStatement();
			stmt.executeUpdate(query);
			ServerLogger.writeNewLine("Query execution result: the new credit card added to the DB");

		} catch (Exception e) {

		}
		return loginInfro;
	}

	/**
	 * GetRegisterClient function execute the query and return all the information
	 * about the registered client.
	 *
	 * @param query - This string include the query to show information about the
	 *              new client.
	 * @return - ArrayList<String> userArr ,this arrayList include the query result.
	 *         In this case this arrayList hold all the information about the user.
	 */
	public ArrayList<String> GetRegisterClient(String query) {
		Statement stmt;
		ArrayList<String> userArr = new ArrayList<String>();
		userArr.add("GetCustomerByUsername");

		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			stmt = mySql.connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				// Put result to string
				for (int i = 1; i < 13; i++)
					userArr.add(rs.getString(i));
			}
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

		// check if the "words" array is the one with the results from the query
		// to avoid exception array out of bounds.
		if (userArr.size() > 2) {
			ServerLogger.writeNewLine("Query execution result: User name: " + userArr.get(1) + ", Password: "
					+ userArr.get(4) + ", Permission: " + userArr.get(7) + ".");
		} else {
			ServerLogger.writeNewLine("Query execution result: There are no results for this query at this moment.");
		}
		return userArr;
	}

	/**
	 * Sets the update customer info.
	 *
	 * @param query the query
	 * @return the string
	 */
	public String setUpdateCustomerInfo(String query) {
		Statement stmt;
		String cusomerInfo = new String();
		cusomerInfo = "UpdateCustomerInfo, ";

		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			stmt = mySql.connection.createStatement();
			stmt.executeUpdate(query);
			ServerLogger.writeNewLine("Query execution result: the customer profile was updated");

		} catch (Exception e) {
			// TODO: handle exception

		}
		return cusomerInfo;
	}

	/**
	 * Sets the update employee info.
	 *
	 * @param query the query
	 * @return the string
	 */
	public String setUpdateEmployeeInfo(String query) {
		Statement stmt;
		String employeeInfro = new String();
		employeeInfro = "UpdateEmployeeInfo, ";

		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			stmt = mySql.connection.createStatement();
			stmt.executeUpdate(query);
			ServerLogger.writeNewLine("Query execution result: the employee profile was updatedd");

		} catch (Exception e) {
			// TODO: handle exception

		}
		return employeeInfro;
	}

	/**
	 * Sets the update CC info.
	 *
	 * @param query the query
	 * @return the string
	 */
	public String setUpdateCCInfo(String query) {
		Statement stmt;
		String CCInfro = new String();
		CCInfro = "UpdateCCInfo, ";

		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			stmt = mySql.connection.createStatement();
			stmt.executeUpdate(query);
			ServerLogger.writeNewLine("Query execution result: the employee profile was updatedd");

		} catch (Exception e) {
			// TODO: handle exception

		}
		return CCInfro;
	}

	/**
	 * Gets the customer info.
	 *
	 * @param query the query
	 * @return the string
	 */
	public String GetCustomerInfo(String query) {
		Statement stmt;
		String loginInfro = new String();
		loginInfro = "UserInfo, ";

		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			stmt = mySql.connection.createStatement();
			stmt.executeUpdate(query);
			ServerLogger.writeNewLine("Query execution result: the customer info was returned");

		} catch (Exception e) {
			// TODO: handle exception

		}
		return loginInfro;
	}

	/**
	 * City combo box.
	 *
	 * @param query the query
	 * @return the array list
	 */
	public ArrayList<String> cityComboBox(String query) {
		ArrayList<String> arr = new ArrayList<String>();
		Statement stmt;
		arr.add("selectCountry");
		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			stmt = mySql.connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				// Put result to string
				arr.add(rs.getString(1));
			}
			ServerLogger.writeNewLine("Query execution result: countries list returned");

		} catch (Exception e) {
			// TODO: handle exception

		}
		return arr;

	}

	/**
	 * Insert city.
	 *
	 * @param query the query
	 * @return the string
	 */
	public String InsertCity(String query) {
		Statement stmt;
		String loginInfro = new String();
		loginInfro = "insertCity, ";

		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			stmt = mySql.connection.createStatement();
			stmt.executeUpdate(query);
			ServerLogger.writeNewLine("Query execution result: the new city  added to the DB");

		} catch (Exception e) {
			// TODO: handle exception

		}
		return loginInfro;
	}

	/**
	 * Insert interested.
	 *
	 * @param query the query
	 * @return the string
	 */
	public String InsertInterested(String query) {
		Statement stmt;
		String loginInfro = new String();
		loginInfro = "insertInterestedPlace, ";
		String[] splitQuery=query.split("#");

		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			stmt = mySql.connection.createStatement();
			stmt.executeUpdate(splitQuery[0]);
			ServerLogger.writeNewLine("Query execution result: POI added to the Waiting DB");
			
			stmt = mySql.connection.createStatement();
			stmt.executeUpdate(splitQuery[1]);
			ServerLogger.writeNewLine("Query execution result: Map added to the Waiting DB");

		} catch (Exception e) {
			System.out.println(e);

		}
		return loginInfro;
	}

	/**
	 * Selectcity combo box.
	 *
	 * @param query the query
	 * @return the array list
	 */
	public ArrayList<String> selectcityComboBox(String query) {
		ArrayList<String> arr = new ArrayList<String>();
		Statement stmt;
		arr.add("selectCity");
		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			stmt = mySql.connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				// Put result to string
				arr.add(rs.getString(1));
			}
			ServerLogger.writeNewLine("Query execution result: city list returned");

		} catch (Exception e) {
			// TODO: handle exception

		}
		return arr;

	}

	/**
	 * Insert map to city.
	 *
	 * @param query the query
	 * @return the string
	 */
	////////////////////////////////////////////////////////////////////////////////////////////////////
	public String InsertMapToCity(String query) {

		Statement stmt = null;
		String[] identification;
		String execQuery;
		String execQuery1;

		identification = query.split("#", 2);
		execQuery = identification[0];
		execQuery1 = identification[1];

		String loginInfro = new String();
		loginInfro = "insertmap, ";

		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			stmt = mySql.connection.createStatement();
			stmt.executeUpdate(execQuery);
			ServerLogger.writeNewLine("Query execution result: the new map to city added to the DB.\n");
			ServerLogger.writeNewLine(execQuery);

			stmt = mySql.connection.createStatement();
			stmt.executeUpdate(execQuery1);
			ServerLogger.writeNewLine("Query execution result: City image was update.\n");
			ServerLogger.writeNewLine(execQuery1);

		} catch (Exception e) {
			System.out.println("SQLException: - " + e);
		}

		return loginInfro;
	}

	/**
	 * Map combo box.
	 *
	 * @param query the query
	 * @return the array list
	 */
	public ArrayList<String> mapComboBox(String query) {
		ArrayList<String> arr = new ArrayList<String>();
		Statement stmt;
		arr.add("selectMap");
		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			stmt = mySql.connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				// Put result to string
				arr.add(rs.getString(1));
			}
			ServerLogger.writeNewLine("Query execution result: maps list returned");

		} catch (Exception e) {
			// TODO: handle exception

		}
		return arr;
	}

	/**
	 * Select map image.
	 *
	 * @param query the query
	 * @return the object
	 */
	public Object selectMapImage(String query) {
		Statement stmt;
		InputStream input = null;
		byte id[] = { 1 };
		byte sqlResult[] = null;

		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {

			stmt = mySql.connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				input = rs.getBinaryStream("image");
			}

			ByteArrayOutputStream os = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int len;

			while ((len = input.read(buffer)) != -1) {
				os.write(buffer, 0, len);
			}

			sqlResult = os.toByteArray();

			// sqlResult = input.readAllBytes();
			ServerLogger.writeNewLine("Query execution result: Map image returned from DB");

		} catch (Exception e) {
			// TODO: handle exception

		}

		byte imageWithId[] = new byte[id.length + sqlResult.length];

		// copy elements into start of destination (from pos 0, copy
		// ciphertext.length bytes)
		System.arraycopy(id, 0, imageWithId, 0, id.length);
		System.arraycopy(sqlResult, 0, imageWithId, id.length, sqlResult.length);

		return imageWithId;
	}

	/**
	 * Select map id.
	 *
	 * @param query the query
	 * @return the string
	 */
	public String selectMapId(String query) {
		Statement stmt;
		String loginInfro = new String();
		loginInfro = "getMapId, ";

		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			stmt = mySql.connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				// Put result to string
				loginInfro += rs.getString(1);
			}
			ServerLogger.writeNewLine("Query execution result: Return mapid by description");

		} catch (Exception e) {
			System.out.println(e);

		}
		return loginInfro;
	}

	/**
	 * Masp rates.
	 *
	 * @param query the query
	 * @return the array list
	 */
	public ArrayList<String> MaspRates(String query) {
		ArrayList<String> arr = new ArrayList<String>();
		Statement stmt;
		arr.add("selectMapRates");
		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			stmt = mySql.connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				// Put result to string
				for (int i = 1; i < 3; i++)
					arr.add(rs.getString(i));
			}
			ServerLogger.writeNewLine("Query execution result: maps rates returned");

		} catch (Exception e) {
			// TODO: handle exception

		}
		return arr;
	}

	/**
	 * Updat map rates.
	 *
	 * @param query the query
	 * @return the string
	 */
	public String UpdatMapRates(String query) {
		Statement stmt;
		String CCInfro = new String();
		CCInfro = "updateRates, ";
		String[] splitQuery = query.split("#");

		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {

			stmt = mySql.connection.createStatement();
			stmt.executeUpdate(splitQuery[0]);

			stmt = mySql.connection.createStatement();
			stmt.executeUpdate(splitQuery[1]);
			ServerLogger.writeNewLine("Query execution result: the rates map were updated waiting for approvement");

		} catch (Exception e) {
			// TODO: handle exception

		}
		return CCInfro;
	}

	/**
	 * Select place name.
	 *
	 * @param query the query
	 * @return the array list
	 */
	public ArrayList<String> SelectPlaceName(String query) {
		ArrayList<String> arr = new ArrayList<String>();
		Statement stmt;
		arr.add("selectPOI");
		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			stmt = mySql.connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				// Put result to string
				arr.add(rs.getString(1));
			}
			ServerLogger.writeNewLine("Query execution result: palce name list returned");

		} catch (Exception e) {
			// TODO: handle exception

		}
		return arr;
	}

	/**
	 * Delete place name.
	 *
	 * @param query the query
	 * @return the string
	 */
	public String DeletePlaceName(String query) {
		Statement stmt;
		String loginInfro = new String();
		loginInfro = "deletePOI, ";
		String[] splitQuery = query.split("#");

		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			stmt = mySql.connection.createStatement();
			stmt.executeUpdate(splitQuery[0]);
			ServerLogger.writeNewLine("Query execution result: place removed from map.");

		} catch (Exception e) {
			// TODO: handle exception

		}

		try {
			stmt = mySql.connection.createStatement();
			stmt.executeUpdate(splitQuery[1]);
			ServerLogger.writeNewLine("Query execution result: POI count in map decremented.");

		} catch (Exception e) {
			// TODO: handle exception

		}
		
		
		try {
			stmt = mySql.connection.createStatement();
			stmt.executeUpdate(splitQuery[2]);
			ServerLogger.writeNewLine("Query execution result: POI count in city decremented.");

		} catch (Exception e) {
			// TODO: handle exception

		}
		return loginInfro;
	}

	/**
	 * Select guest catalog.
	 *
	 * @param query the query
	 * @return the array list
	 */
	public ArrayList<String> selectGuestCatalog(String query) {
		ArrayList<String> arr = new ArrayList<String>();
		Statement stmt;
		arr.add("guestCatalog");
		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			stmt = mySql.connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				// Put result to string
				for (int i = 1; i < 4; i++)
					arr.add(rs.getString(i));
			}
			ServerLogger.writeNewLine("Query execution result: map information returned");

		} catch (Exception e) {
			// TODO: handle exception

		}
		return arr;

	}

	/**
	 * Select name place by poi.
	 *
	 * @param query the query
	 * @return the array list
	 */
	public ArrayList<String> SelectNamePlaceByPoi(String query) {
		ArrayList<String> arr = new ArrayList<String>();
		Statement stmt;
		arr.add("getPoiByCity");
		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			stmt = mySql.connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				// Put result to string

				arr.add(rs.getString(1));
			}
			ServerLogger.writeNewLine("Query execution result: map information returned");

		} catch (Exception e) {
			// TODO: handle exception

		}
		return arr;

	}

	/**
	 * Select catalog bycity.
	 *
	 * @param query the query
	 * @return the array list
	 */
	public ArrayList<String> selectCatalogBycity(String query) {
		ArrayList<String> arr = new ArrayList<String>();
		Statement stmt;
		arr.add("getDataByCityName");
		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			stmt = mySql.connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				// Put result to string
				for (int i = 1; i < 5; i++)
					arr.add(rs.getString(i));
			}
			ServerLogger.writeNewLine("Query execution result: city information returned");

		} catch (Exception e) {
			// TODO: handle exception

		}
		return arr;
	}

	/**
	 * Select PO icoordinate.
	 *
	 * @param query the query
	 * @return the array list
	 */
	public ArrayList<String> selectPOIcoordinate(String query) {
		ArrayList<String> arr = new ArrayList<String>();
		Statement stmt;
		arr.add("selectPOIcoordinate");
		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			stmt = mySql.connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				// Put result to string
				for (int i = 1; i < 3; i++)
					arr.add(rs.getString(i));
			}

			ServerLogger.writeNewLine("Query execution result: map POI coordinate returned");

		} catch (Exception e) {
			// TODO: handle exception
		}
		return arr;
	}

	/**
	 * Select specific PO icoordinate.
	 *
	 * @param query the query
	 * @return the array list
	 */
	public ArrayList<String> selectSpecificPOIcoordinate(String query) {
		ArrayList<String> arr = new ArrayList<String>();
		Statement stmt;
		arr.add("selectSpecificPOIcoordinate");
		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			stmt = mySql.connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				// Put result to string
				for (int i = 1; i < 3; i++)
					arr.add(rs.getString(i));
			}

			ServerLogger.writeNewLine("Query execution result: map POI of specific map coordinate returned");

		} catch (Exception e) {
			// TODO: handle exception
		}
		return arr;
	}

	/**
	 * Select map by free text.
	 *
	 * @param query the query
	 * @return the array list
	 */
	public ArrayList<String> selectMapByFreeText(String query) {
		ArrayList<String> arr = new ArrayList<String>();
		Statement stmt;
		arr.add("SearchByFreeText");
		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			stmt = mySql.connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				// Put result to string
				for (int i = 1; i < 4; i++)
					arr.add(rs.getString(i));
			}
			ServerLogger.writeNewLine("Query execution result: map information returned");

		} catch (Exception e) {
			// TODO: handle exception

		}
		return arr;

	}

	/**
	 * Select map by purchase.
	 *
	 * @param query the query
	 * @return the array list
	 */
	public ArrayList<String> selectMapByPurchase(String query) {
		ArrayList<String> arr = new ArrayList<String>();
		Statement stmt;
		arr.add("getpurchase");
		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			stmt = mySql.connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				// Put result to string
				for (int i = 1; i < 4; i++)
					arr.add(rs.getString(i));
			}
			ServerLogger.writeNewLine("Query execution result: map information by purchase returned");

		} catch (Exception e) {
			// TODO: handle exception

		}
		return arr;

	}

	/**
	 * Select user info.
	 *
	 * @param query the query
	 * @return the array list
	 */
	public ArrayList<String> selectUserInfo(String query) {
		ArrayList<String> arr = new ArrayList<String>();
		Statement stmt;
		arr.add("getUserInfo");
		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			stmt = mySql.connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				// Put result to string
				for (int i = 1; i < 13; i++)
					arr.add(rs.getString(i));
			}
			ServerLogger.writeNewLine("Query execution result: Full user info returned");

		} catch (Exception e) {
			// TODO: handle exception

		}
		return arr;

	}

	/**
	 * Select history.
	 *
	 * @param query the query
	 * @return the array list
	 */
	public ArrayList<String> selectHistory(String query) {
		ArrayList<String> arr = new ArrayList<String>();
		Statement stmt;
		arr.add("getHistory");
		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			stmt = mySql.connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				// Put result to string
				for (int i = 1; i < 6; i++)
					arr.add(rs.getString(i));
			}
			ServerLogger.writeNewLine("Query execution result: History Purchases returned");

		} catch (Exception e) {
			// TODO: handle exception

		}
		return arr;

	}

	/**
	 * Select report.
	 *
	 * @param query the query
	 * @return the array list
	 */
	public ArrayList<String> selectReport(String query) {
		ArrayList<String> arr = new ArrayList<String>();
		String firstQuery = new String();
		String secondQuery = new String();
		firstQuery = query.split("#")[0];
		secondQuery = query.split("#")[1];
		Statement stmt;
		arr.add("getReport");
		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			stmt = mySql.connection.createStatement();

			ResultSet rs1 = stmt.executeQuery(secondQuery);
			while (rs1.next()) {
				arr.add(rs1.getString(1));
			}

		} catch (Exception e) {
			// TODO: handle exception

		}

		try {
			stmt = mySql.connection.createStatement();
			ResultSet rs = stmt.executeQuery(firstQuery);
			while (rs.next()) {
				// Put result to string
				for (int i = 1; i < 6; i++)
					arr.add(rs.getString(i));
			}
			ServerLogger.writeNewLine("Query execution result: History Purchases returned");

		} catch (Exception e) {
			// TODO: handle exception

		}
		return arr;

	}

	////////////////////////////////// NEW METHODS FOR TOUR
	/**
	 * Insert tour.
	 *
	 * @param query the query
	 * @return the string
	 */
	////////////////////////////////// ADD\EDIT/////////////////////////////////////////////////////
	public String insertTour(String query) {
		Statement stmt;
		String tourInfo = new String();
		tourInfo = "insertTour, ";
		String[] splitQuery = query.split(";");
		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			stmt = mySql.connection.createStatement();
			stmt.executeUpdate(splitQuery[0]);
			ServerLogger.writeNewLine("Query execution result: the new tour added to the DB");

		} catch (Exception e) {
			// TODO: handle exception

		}

		try {
			stmt = mySql.connection.createStatement();
			stmt.executeUpdate(splitQuery[1]);
			ServerLogger.writeNewLine("Query execution result: Tour count in city incremented.");

		} catch (Exception e) {
			// TODO: handle exception

		}
		return tourInfo;
	}

	/**
	 * Gets the tour ID.
	 *
	 * @param query the query
	 * @return the tour ID
	 */
	public ArrayList<String> getTourID(String query) {
		Statement stmt;
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("getTourID");

		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			stmt = mySql.connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				// Put result to string

				arr.add(rs.getString(1));
			}
			ServerLogger.writeNewLine("Query execution result: tour ID returned");

		} catch (Exception e) {
			// TODO: handle exception

		}
		return arr;
	}

	/**
	 * Select pid.
	 *
	 * @param query the query
	 * @return the array list
	 */
	public ArrayList<String> selectPid(String query) {
		Statement stmt;
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("selectPid");

		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			stmt = mySql.connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				// Put result to string
				for (int i = 1; i < 8; i++)
					arr.add(rs.getString(i));
			}
			// [0]=identifier, [1]=poiID, [2]=name, [3]=type, [4]=desc,
			// [5]=accessible, [6]=time, [7]=address
			ServerLogger.writeNewLine("Query execution result: Point of Interest full info returned");

		} catch (Exception e) {
			// TODO: handle exception

		}
		return arr;
	}

	/**
	 * Insert PO ito tour.
	 *
	 * @param query the query
	 * @return the string
	 */
	public String insertPOItoTour(String query) {
		Statement stmt;
		String tourInfo = new String();
		tourInfo = "insertPOIToTour, ";
		String[] splitQuery = query.split("#");

		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			stmt = mySql.connection.createStatement();
			stmt.executeUpdate(splitQuery[0]);
			ServerLogger.writeNewLine("Query execution result: POI linked to tour in DB");

		} catch (Exception e) {
			// TODO: handle exception

		}

		try {
			stmt = mySql.connection.createStatement();
			stmt.executeUpdate(splitQuery[1]);
			ServerLogger.writeNewLine("Query execution result: Tour POI count incremented.");

		} catch (Exception e) {
			// TODO: handle exception

		}
		return tourInfo;
	}

	/**
	 * Gets the tour by city.
	 *
	 * @param query the query
	 * @return the tour by city
	 */
	public ArrayList<String> getTourByCity(String query) {
		Statement stmt;
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("getTourByCity");

		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			stmt = mySql.connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				// Put result to string
				arr.add(rs.getString(1));
			}
			ServerLogger.writeNewLine("Query execution result: Tour names returned");

		} catch (Exception e) {
			// TODO: handle exception

		}
		return arr;
	}

	/**
	 * Gets the tour info.
	 *
	 * @param query the query
	 * @return the tour info
	 */
	public ArrayList<String> getTourInfo(String query) {
		Statement stmt;
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("getTourInfo");

		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			stmt = mySql.connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				// Put result to string
				for (int i = 1; i < 5; i++)
					arr.add(rs.getString(i));
			}
			ServerLogger.writeNewLine("Query execution result: Full tour information returned");

		} catch (Exception e) {
			// TODO: handle exception

		}
		return arr;
	}

	/**
	 * Gets the PO iby tour.
	 *
	 * @param query the query
	 * @return the PO iby tour
	 */
	public ArrayList<String> getPOIbyTour(String query) {
		Statement stmt;
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("getPOIbyTour");

		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			stmt = mySql.connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				// Put result to string
				for (int i = 1; i < 4; i++)
					arr.add(rs.getString(i));
			}
			ServerLogger.writeNewLine("Query execution result: Place information by tour returned");

		} catch (Exception e) {
			// TODO: handle exception

		}
		return arr;
	}

	/**
	 * Update index.
	 *
	 * @param query the query
	 * @return the string
	 */
	public String updateIndex(String query) {
		Statement stmt;
		String identifier = new String();
		identifier = "updateIndex, ";

		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			stmt = mySql.connection.createStatement();
			stmt.executeUpdate(query);
			ServerLogger.writeNewLine("Query execution result: POI index in tour updated");

		} catch (Exception e) {
			// TODO: handle exception

		}
		return identifier;
	}

	/**
	 * Delete poi from tour.
	 *
	 * @param query the query
	 * @return the string
	 */
	public String deletePoiFromTour(String query) {
		Statement stmt;
		String identifier = new String();
		identifier = "deletePOITour, ";
		String[] splitQuery = query.split("#");

		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			stmt = mySql.connection.createStatement();
			stmt.executeUpdate(splitQuery[0]);
			ServerLogger.writeNewLine("Query execution result: POI removed from tour");

		} catch (Exception e) {
			// TODO: handle exception

		}

		try {
			stmt = mySql.connection.createStatement();
			stmt.executeUpdate(splitQuery[1]);
			ServerLogger.writeNewLine("Query execution result: Tour POI count decremented.");

		} catch (Exception e) {
			// TODO: handle exception

		}
		return identifier;
	}

	/**
	 * Gets the other poi.
	 *
	 * @param query the query
	 * @return the other poi
	 */
	public ArrayList<String> getOtherPoi(String query) {
		Statement stmt;
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("getOtherPoi");

		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			stmt = mySql.connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				// Put result to string
				for (int i = 1; i < 3; i++)
					arr.add(rs.getString(i));
			}
			ServerLogger.writeNewLine("Query execution result: POI's not in tour returned");

		} catch (Exception e) {
			// TODO: handle exception

		}
		return arr;
	}

	/**
	 * Delete tour.
	 *
	 * @param query the query
	 * @return the string
	 */
	public String deleteTour(String query) {
		Statement stmt;
		String tourInfo = new String();
		tourInfo = "deleteTour, ";
		String[] splitQuery = query.split("#");

		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			stmt = mySql.connection.createStatement();
			stmt.executeUpdate(splitQuery[0]);
			ServerLogger.writeNewLine("Query execution result: Tour deleted from DB");

		} catch (Exception e) {
			// TODO: handle exception

		}
		try {
			stmt = mySql.connection.createStatement();
			stmt.executeUpdate(splitQuery[1]);
			ServerLogger.writeNewLine("Query execution result: Tour POI count decremented.");

		} catch (Exception e) {
			// TODO: handle exception

		}
		return tourInfo;
	}

	/**
	 * Update tour.
	 *
	 * @param query the query
	 * @return the string
	 */
	public String updateTour(String query) {
		Statement stmt;
		String tourInfo = new String();
		tourInfo = "updateTour, ";

		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			stmt = mySql.connection.createStatement();
			stmt.executeUpdate(query);
			ServerLogger.writeNewLine("Query execution result: Tour info updated");

		} catch (Exception e) {
			// TODO: handle exception

		}
		return tourInfo;
	}

	/**
	 * Select all POI by map.
	 *
	 * @param query the query
	 * @return the array list
	 */
	public ArrayList<String> selectAllPOIByMap(String query) {
		ArrayList<String> arr = new ArrayList<String>();
		Statement stmt;
		arr.add("selectAllPOIByCity");
		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			stmt = mySql.connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				// Put result to string
				for (int i = 1; i < 8; i++)
					arr.add(rs.getString(i));
			}

			ServerLogger.writeNewLine("Query execution result: map all POI of specific map returned");

		} catch (Exception e) {
			// TODO: handle exception
		}
		return arr;
	}

	/**
	 * Select all city info.
	 *
	 * @param query the query
	 * @return the array list
	 */
	//////////////////////////////////////////////////////////////////////
	public ArrayList<String> selectAllCityInfo(String query) {
		ArrayList<String> arr = new ArrayList<String>();
		Statement stmt;
		arr.add("selectAllCityInfo");
		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			stmt = mySql.connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				for (int i = 1; i < 8; i++)
					arr.add(rs.getString(i));
			}
			ServerLogger.writeNewLine("Query execution result: city list returned");

		} catch (Exception e) {
			// TODO: handle exception

		}
		return arr;

	}

	/**
	 * Select map image with ID.
	 *
	 * @param query the query
	 * @return the object
	 */
	public Object selectMapImageWithID(String query) {

		Statement stmt;
		InputStream input = null;
		byte id[] = { 2 };
		byte sqlResult[] = null;
		ArrayList<byte[]> array = new ArrayList<byte[]>();
		ArrayList<InputStream> inarry = new ArrayList<InputStream>();
		ArrayList<Image> imarry = new ArrayList<Image>();
		ArrayList<Object> ObjArray = new ArrayList<Object>();
		int i = 0;
		int j = 0;

		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {

			stmt = mySql.connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM map");
			while (rs.next()) {
				ObjArray.add(rs.getInt(1));
				ObjArray.add(rs.getDouble(2));
				ObjArray.add(rs.getDouble(3));
				ObjArray.add(rs.getString(4));
				ObjArray.add(rs.getString(5));
				ObjArray.add(rs.getString(6));
				ObjArray.add(rs.getInt(7));
				inarry.add(rs.getBinaryStream(8));
				sqlResult = readAllBytes(inarry.get(j));
				ObjArray.add(sqlResult);
				j++;
			
			}

			ByteArrayOutputStream os = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int len;

		
			ServerLogger.writeNewLine("Query execution result: MapImageID returned from DB");

		} catch (Exception e) {
			System.out.println(e);

		}


		return ObjArray;
	}

	/**
	 * Select all POI.
	 *
	 * @param query the query
	 * @return the array list
	 */
	public ArrayList<String> selectAllPOI(String query) {
		ArrayList<String> arr = new ArrayList<String>();
		Statement stmt;
		arr.add("selectAllPOI");
		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			stmt = mySql.connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				for (int i = 1; i < 11; i++)
					arr.add(rs.getString(i));
			}
			ServerLogger.writeNewLine("Query execution result: POI list returned");
		} catch (Exception e) {
			System.out.println(e);
		}
		return arr;
	}

	/**
	 * Insert customer purchase.
	 *
	 * @param query the query
	 * @return the string
	 */
	public String InsertCustomerPurchase(String query) {
		Statement stmt;
		String loginInfro = new String();
		loginInfro = "InsertCustomerPurchase, ";

		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			stmt = mySql.connection.createStatement();
			stmt.executeUpdate(query);
			ServerLogger.writeNewLine("Query execution result: customer purchase inserted to DB");

		} catch (Exception e) {
			// TODO: handle exception

		}
		return loginInfro;
	}

	/**
	 * Insert customer download.
	 *
	 * @param query the query
	 * @return the string
	 */
	public String InsertCustomerDownload(String query) {
		Statement stmt;
		String loginInfro = new String();
		loginInfro = "InsertCustomerDownload, ";
		ArrayList<String> arr=new ArrayList<String>();
		String[] splitQuery=query.split("#");

		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			stmt = mySql.connection.createStatement();
			ResultSet rs=stmt.executeQuery(splitQuery[0]);
			while(rs.next())
			{
				arr.add(rs.getString(1));
				arr.add(rs.getString(2));
			}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		try {
			stmt = mySql.connection.createStatement();
			stmt.executeUpdate(splitQuery[1]);
			ServerLogger.writeNewLine("Query execution result: customer download inserted to DB");

		} catch (Exception e) {
			// TODO: handle exception

		}
		
		try {
			stmt = mySql.connection.createStatement();
			stmt.executeUpdate("UPDATE purchase SET subVersion="+Double.parseDouble(arr.get(1))+" WHERE type='Subscription' AND cityname='"+arr.get(0)+"' AND customerUsername='"+splitQuery[2]+"';");
			ServerLogger.writeNewLine("Query execution result: User's subscription version updated");

		} catch (Exception e) {
			// TODO: handle exception

		}
		
		
		return loginInfro;
	}

	/**
	 * Select all purchase.
	 *
	 * @param query the query
	 * @return the array list
	 */
	public ArrayList<String> selectAllPurchase(String query) {
		ArrayList<String> arr = new ArrayList<String>();
		Statement stmt;
		arr.add("selectAllPurchase");
		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			stmt = mySql.connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				for (int i = 1; i < 8; i++)
					arr.add(rs.getString(i));
			}
			ServerLogger.writeNewLine("Query execution result: Purchase of maps list returned");
		} catch (Exception e) {
			System.out.println(e);
		}
		return arr;
	}

	/**
	 * Log out user.
	 *
	 * @param query the query
	 * @return the string
	 */
	public String logOutUser(String query) {
		Statement stmt;
		String loginInfro = new String();
		loginInfro = "DeleteUserName, ";

		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			stmt = mySql.connection.createStatement();
			stmt.executeUpdate(query);
			ServerLogger.writeNewLine("Query execution result: User logged out of system");

		} catch (Exception e) {
			// TODO: handle exception

		}
		return loginInfro;
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Update purchase table.
	 *
	 * @param query the query
	 * @return the string
	 */
	public String updatePurchaseTable(String query) {
		Statement stmt;
		String loginInfro = new String();
		loginInfro = "updatePurchaseTable, ";

		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			stmt = mySql.connection.createStatement();
			stmt.executeUpdate(query);
			ServerLogger.writeNewLine("Query execution result: customer download inserted to DB");

		} catch (Exception e) {
			// TODO: handle exception

		}
		return loginInfro;
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Insert sub renew.
	 *
	 * @param query the query
	 * @return the string
	 */
	public String insertSubRenew(String query) {
		Statement stmt;
		String loginInfro = new String();
		loginInfro = "insertSubRenew, ";

		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			stmt = mySql.connection.createStatement();
			stmt.executeUpdate(query);
			ServerLogger.writeNewLine("Query execution result: customer download inserted to DB");

		} catch (Exception e) {
			// TODO: handle exception

		}
		return loginInfro;
	}

	/**
	 * Read all bytes.
	 *
	 * @param inputStream the input stream
	 * @return the byte[]
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static byte[] readAllBytes(InputStream inputStream) throws IOException {
		final int bufLen = 4 * 0x400; // 4KB
		byte[] buf = new byte[bufLen];
		int readLen;
		IOException exception = null;

		try {
			try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
				while ((readLen = inputStream.read(buf, 0, bufLen)) != -1)
					outputStream.write(buf, 0, readLen);

				return outputStream.toByteArray();
			}
		} catch (IOException e) {
			exception = e;
			throw e;
		} finally {
			if (exception == null)
				inputStream.close();
			else
				try {
					inputStream.close();
				} catch (IOException e) {
					exception.addSuppressed(e);
				}
		}
	}

	//////////////////////////////////////////////// Publish new
	/**
	 * Select publish.
	 *
	 * @param query the query
	 * @return the array list
	 */
	//////////////////////////////////////////////// version//////////////////////////////////////////////////////////////////////////////
	public ArrayList<String> SelectPublish(String query) {
		ArrayList<String> arr = new ArrayList<String>();
		Statement stmt;
		arr.add("SelectPublish, ");
		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			stmt = mySql.connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				for (int i = 1; i < 6; i++)
					arr.add(rs.getString(i));
			}
			ServerLogger.writeNewLine("Query execution result: SelectPublish of maps list returned");
		} catch (Exception e) {
			System.out.println(e);
		}

		return arr;
	}

	/**
	 * Select publishall.
	 *
	 * @param query the query
	 * @return the array list
	 */
	public ArrayList<String> SelectPublishall(String query) {
		ArrayList<String> arr = new ArrayList<String>();
		Statement stmt;
		int i;
		arr.add("SelectPublishall");
		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			stmt = mySql.connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				for (i = 1; i < 9; i++)
					arr.add(rs.getString(i));
			}
			
			stmt = mySql.connection.createStatement();
		    rs = stmt.executeQuery("SELECT idmap, countryName, waitingrates.cityname, rate, rate, subrate, subrate, waitingrates.description FROM waitingrates INNER JOIN city ON waitingrates.cityname=city.cityname;");
			while (rs.next()) {
				for (i = 1; i < 9; i++)
					arr.add(rs.getString(i));
			}
			
			
			stmt = mySql.connection.createStatement();
			rs = stmt.executeQuery("SELECT idmap, countryName, waitingmaps.cityname, rate, rate, subrate, subrate, waitingmaps.description FROM waitingmaps INNER JOIN city WHERE waitingmaps.cityname=city.cityname;");
			while (rs.next()) {

				for (i = 1; i < 9; i++)
					arr.add(rs.getString(i));
			}
			
			

		} catch (Exception e) {
			System.out.println(e);
		}

		ServerLogger.writeNewLine("Query execution result: SelectPublishall of maps list returned");

		return arr;
	}

	/**
	 * Updateversion.
	 *
	 * @param query the query
	 * @return the string
	 */
	public String Updateversion(String query) {
		Statement stmt;
		String loginInfro = new String();
		loginInfro = "Updateversion, ";

		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			stmt = mySql.connection.createStatement();
			stmt.executeUpdate(query);
			ServerLogger.writeNewLine("Query execution result: The version of the city was updated");

		} catch (Exception e) {
			// TODO: handle exception

		}
		return loginInfro;
	}

	/**
	 * Getnewoldpoi.
	 *
	 * @param query the query
	 * @return the array list
	 */
	public ArrayList<String> Getnewoldpoi(String query) {
		ArrayList<String> arr = new ArrayList<String>();
		Statement stmt;
		arr.add("Listofnewoldpoi");
		String nquery;
		String oquery;
		int index = query.indexOf("SecondQuery");
		int lastindex = query.length();
		nquery = query.substring(0, index);
		index = index + 11;
		oquery = query.substring(index, lastindex);

		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			stmt = mySql.connection.createStatement();
			ResultSet rs = stmt.executeQuery(nquery);
			while (rs.next()) {
				for (int i = 1; i < 7; i++)
					arr.add(rs.getString(i));
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		arr.add("SecondResult");

		try {
			stmt = mySql.connection.createStatement();
			ResultSet rs = stmt.executeQuery(oquery);
			while (rs.next()) {
				for (int i = 1; i < 7; i++)
					arr.add(rs.getString(i));
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		ServerLogger.writeNewLine("Query execution result: Select old and new Poi lists returned");
		return arr;
	}

	/**
	 * Approverate.
	 *
	 * @param query the query
	 * @return the string
	 */
	public String Approverate(String query) {
		Statement stmt;
		String msg = new String();
		int count = 0;
		msg = "Approverate, Approverate";
		String mapid = query;
		query = "SELECT COUNT(*) FROM map where idmap=" + Integer.parseInt(mapid) + ";";
		ArrayList<String> arr = new ArrayList<String>();

		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			stmt = mySql.connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				count = rs.getInt(1);
			}

			query = "SELECT rate, subrate FROM waitingrates where idmap=" + Integer.parseInt(mapid) + ";";
			stmt = mySql.connection.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				for (int i = 1; i < 8; i++) {
					arr.add(rs.getString(1));
					arr.add(rs.getString(2));
				}
			}

			if (count == 0) {
				query = "INSERT INTO map (idmap, cityname, rate, subrate, status, description, numPOI, image) SELECT * FROM waitingrates WHERE idmap="
						+ Integer.parseInt(mapid) + ";";
				stmt = mySql.connection.createStatement();
				stmt.executeUpdate(query);
				
				query = "SELECT cityname FROM map WHERE idmap="+ Integer.parseInt(mapid) + ";";
				stmt = mySql.connection.createStatement();
			    rs=stmt.executeQuery(query);
			    String cityname =new String();
			    while (rs.next()) {
					cityname = rs.getString(1);
				}
			    
			    query = "UPDATE city SET NumOfMaps=NumOfMaps+1 WHERE cityname='"+cityname+"';";
			    stmt = mySql.connection.createStatement();
			    stmt.executeUpdate(query);
			     
				
			}

			else {
				query = "UPDATE map SET rate=" + Double.parseDouble(arr.get(1)) + ", subrate="
						+ Double.parseDouble(arr.get(2)) + " WHERE idmap=" + Integer.parseInt(mapid) + ";";
				stmt = mySql.connection.createStatement();
				stmt.executeUpdate(query);
			}

			query = "DELETE FROM waitingrates where idmap=" + Integer.parseInt(mapid) + ";";
			stmt = mySql.connection.createStatement();
			stmt.executeUpdate(query);

		} catch (Exception e) {
			// TODO: handle exception

		}

		try {
			stmt = mySql.connection.createStatement();
			stmt.executeUpdate(
					"UPDATE city SET VersionNum=VersionNum+0.1 WHERE cityname IN (SELECT cityname FROM map WHERE map.idmap="
							+ Integer.parseInt(mapid) + ");");
			ServerLogger.writeNewLine("Query execution result: Map Version updated.");

		} catch (Exception e) {
			// TODO: handle exception

		}

		ServerLogger.writeNewLine("Query execution result: The Map rate was updated");
		return msg;
	}

	/**
	 * Approvepoi.
	 *
	 * @param query the query
	 * @return the string
	 */

public String Approvepoi(String query) {
		Statement stmt;
		String msg = new String();
		String cityname = new String();
		int count = 0;
		msg = "Approvepoi, Approvepoi";
		String mapid = query;
		query = "SELECT COUNT(*) FROM map where idmap=" + Integer.parseInt(mapid) + ";";
		ArrayList<Integer> oldpoi = new ArrayList<Integer>();
		ArrayList<Integer> newpoi = new ArrayList<Integer>();

		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			stmt = mySql.connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				count = rs.getInt(1);
			}

			if (count == 0) {

				query = "INSERT INTO map (idmap, rate, subrate, status, cityname, description, image) "
						+ "SELECT idmap, rate, subrate, status, cityname, description, image " + "FROM waitingmaps "
						+ "WHERE idmap=" + Integer.parseInt(mapid) + ";";
				stmt = mySql.connection.createStatement();
				stmt.executeUpdate(query);

				query = "SELECT cityname FROM map WHERE idmap=" + Integer.parseInt(mapid) + ";";
				stmt = mySql.connection.createStatement();
				rs = stmt.executeQuery(query);
				
				while (rs.next()) {
					cityname = rs.getString(1);
				}

				query = "UPDATE city SET NumOfMaps=NumOfMaps+1 WHERE cityname='" + cityname + "';";
				stmt = mySql.connection.createStatement();
				stmt.executeUpdate(query);

				query = "SELECT idpoi FROM waitingpoi where idmap=" + Integer.parseInt(mapid) + ";";
				stmt = mySql.connection.createStatement();
				rs = stmt.executeQuery(query);
				while (rs.next()) {
					newpoi.add(rs.getInt(1));
				}

				query = "SELECT idpoi FROM poi where idmap=" + Integer.parseInt(mapid) + ";";
				stmt = mySql.connection.createStatement();
				rs = stmt.executeQuery(query);
				while (rs.next()) {
					oldpoi.add(rs.getInt(1));
				}

				for (int i = 0; i < newpoi.size(); i++) {

					if (oldpoi.contains(newpoi.get(i))) {

					} else {

						query = "UPDATE city SET NumOfPOI=NumOfPOI+1 WHERE cityname='" + cityname + "';";
						stmt = mySql.connection.createStatement();
						stmt.executeUpdate(query);

					}

				}

				query = "INSERT INTO poi"
						+ "(idpoi, name, type, description, isACC, time, address, idmap, locationX, locationY) "
						+ "SELECT idpoi, name, type, description, isACC, time, address, idmap, locationX, locationY "
						+ "FROM waitingpoi " + "WHERE idmap=" + Integer.parseInt(mapid) + ";";
				stmt = mySql.connection.createStatement();
				stmt.executeUpdate(query);

			}

			else {
				query = "SELECT idpoi FROM waitingpoi where idmap=" + Integer.parseInt(mapid) + ";";
				stmt = mySql.connection.createStatement();
				rs = stmt.executeQuery(query);
				while (rs.next()) {
					newpoi.add(rs.getInt(1));
				}

				query = "SELECT idpoi FROM poi where idmap=" + Integer.parseInt(mapid) + ";";
				stmt = mySql.connection.createStatement();
				rs = stmt.executeQuery(query);
				while (rs.next()) {
					oldpoi.add(rs.getInt(1));
				}

				for (int i = 0; i < newpoi.size(); i++) {

					if (oldpoi.contains(newpoi.get(i))) {

						query = "UPDATE poi AS dest," + "(" + " SELECT * FROM waitingpoi" + " WHERE idmap="
								+ Integer.parseInt(mapid) + " and idpoi=" + newpoi.get(i) + "" + " ) AS src"
								+ " SET  dest.idpoi = src.idpoi," + "dest.name = src.name," + "dest.type = src.type,"
								+ "dest.description = src.description," + "dest.isAcc = src.isAcc,"
								+ "dest.time = src.time," + "dest.address = src.address," + "dest.idmap = src.idmap,"
								+ "dest.locationX = src.locationX," + "dest.locationY = src.locationY"
								+ " WHERE dest.idmap=" + Integer.parseInt(mapid) + " and dest.idpoi=" + newpoi.get(i)
								+ ";";

						stmt = mySql.connection.createStatement();
						stmt.executeUpdate(query);

					} else {
						query = "INSERT INTO poi"
								+ "(idpoi, name, type, description, isACC, time, address, idmap, locationX, locationY)"
								+ " SELECT idpoi, name, type, description, isACC, time, address, idmap, locationX, locationY"
								+ " FROM waitingpoi" + " WHERE idmap=" + mapid + " AND idpoi=" + newpoi.get(i) + ";";
						stmt = mySql.connection.createStatement();
						stmt.executeUpdate(query);

						query = "SELECT cityname FROM map WHERE idmap=" + Integer.parseInt(mapid) + ";";
						stmt = mySql.connection.createStatement();
						rs = stmt.executeQuery(query);
						
						while (rs.next()) {
							cityname = rs.getString(1);
						}

						query = "UPDATE city SET NumOfPOI=NumOfPOI+1 WHERE cityname='" + cityname + "';";
						stmt = mySql.connection.createStatement();
						stmt.executeUpdate(query);

					}

				}

			}
			
			
			query = "SELECT COUNT(*) FROM poi WHERE idmap=" + Integer.parseInt(mapid) + ";";
			stmt = mySql.connection.createStatement();
			stmt.executeQuery(query);
			String NUMPOI = new String();
			while (rs.next()) {
				NUMPOI = rs.getString(1);
			}
			
			query = "UPDATE map SET numPOI="+ Integer.parseInt(NUMPOI) +" WHERE idmap="+ Integer.parseInt(mapid) + ";";
			stmt = mySql.connection.createStatement();
			stmt.executeUpdate(query);
			
			query = "DELETE FROM waitingpoi where idmap=" + Integer.parseInt(mapid) + ";";
			stmt = mySql.connection.createStatement();
			stmt.executeUpdate(query);

			query = "DELETE FROM waitingmaps where idmap=" + Integer.parseInt(mapid) + ";";
			stmt = mySql.connection.createStatement();
			stmt.executeUpdate(query);
			
		} catch (Exception e) {
			// TODO: handle exception

		}

		try {
			stmt = mySql.connection.createStatement();
			stmt.executeUpdate(
					"UPDATE city SET VersionNum=VersionNum+0.1 WHERE cityname IN (SELECT cityname FROM map WHERE map.idmap="
							+ Integer.parseInt(mapid) + ");");
			ServerLogger.writeNewLine("Query execution result: customer purchase inserted to DB");

		} catch (Exception e) {
			// TODO: handle exception

		}

		ServerLogger.writeNewLine("Query execution result: The Map Poi was updated");
		return msg;
	}


	/**
	 * Gets the exp sub.
	 *
	 * @param query the query
	 * @return the exp sub
	 */
	public ArrayList<String> getExpSub(String query) {
		ArrayList<String> arr = new ArrayList<String>();
		Statement stmt;
		arr.add("getExp");
		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			stmt = mySql.connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				arr.add(rs.getString(1));
			}
			ServerLogger.writeNewLine("Query execution result: Expiring subs returned");
		} catch (Exception e) {
		}
		return arr;
	}

	/**
	 * Gets the updates.
	 *
	 * @param query the query
	 * @return the updates
	 */
	public String getUpdates(String query) {
		Statement stmt;
		String loginInfro = new String();
		loginInfro = "getVerUpdate, ";

		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			stmt = mySql.connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				loginInfro += rs.getString(1);
			}
			ServerLogger.writeNewLine("Query execution result: Notifications returned");

		} catch (Exception e) {
			// TODO: handle exception

		}
		return loginInfro;
	}

	/**
	 * Insert new POI.
	 *
	 * @param query the query
	 * @return the string
	 */
	public String insertNewPOI(String query) {
		Statement stmt;
		String loginInfro = new String();
		ArrayList<String> arr = new ArrayList<String>();
		loginInfro = "insertNewPOI, ";

		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			stmt = mySql.connection.createStatement();
			stmt.executeUpdate(query);
			ServerLogger.writeNewLine("Query execution result: the new POI added to the DB");

		} catch (Exception e) {
			System.out.println(e);

		}
		return loginInfro;
	}

	/**
	 * Update POI.
	 *
	 * @param query the query
	 * @return the string
	 */
	public String updatePOI(String query) {
		Statement stmt;
		String loginInfro = new String();
		ArrayList<String> arr = new ArrayList<String>();
		loginInfro = "UpdatedPOI, ";

		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			stmt = mySql.connection.createStatement();
			stmt.executeUpdate(query);
			ServerLogger.writeNewLine("Query execution result: the POI was updated Successfully");

		} catch (Exception e) {
			System.out.println(e);

		}
		return loginInfro;

	}

	/**
	 * Gets the POI in maps.
	 *
	 * @param query the query
	 * @return the POI in maps
	 */
	public ArrayList<String> getPOIInMaps(String query) {
		ArrayList<String> arr = new ArrayList<String>();
		Statement stmt;
		arr.add("getPOINotInMap");
		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			stmt = mySql.connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				// Put result to string
				for (int i = 1; i < 3; i++)
					arr.add(rs.getString(i));
			}
			ServerLogger.writeNewLine("Query execution result: POI's in current map returned");

		} catch (Exception e) {
			// TODO: handle exception

		}
		return arr;
	}

	/**
	 * Adds the view.
	 *
	 * @param query the query
	 * @return the string
	 */
	public String addView(String query) {
		Statement stmt;
		String loginInfro = new String();
		loginInfro = "addView, ";

		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			stmt = mySql.connection.createStatement();
			stmt.executeUpdate(query);
			ServerLogger.writeNewLine("Query execution result: Views added");

		} catch (Exception e) {

		}
		return loginInfro;
	}

	/**
	 * Check req.
	 *
	 * @param query the query
	 * @return the string
	 */
	public String checkReq(String query) {
		Statement stmt;
		String loginInfro = new String();
		loginInfro = "getReq, ";
		String[] arr = new String[2];
		arr = query.split("#");
		try {
			mySql = mysqlConnection.GetConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			stmt = mySql.connection.createStatement();
			ResultSet rs = stmt.executeQuery(arr[1]);
			while (rs.next()) {
				loginInfro += rs.getString(1);
			}
			ServerLogger.writeNewLine("Query execution result: Approval requests returned");

		} catch (Exception e) {
			// TODO: handle exception

		}
		loginInfro += "#" + arr[0];
		return loginInfro;
	}

}
