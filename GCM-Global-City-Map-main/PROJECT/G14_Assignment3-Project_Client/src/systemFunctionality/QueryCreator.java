package systemFunctionality;


import java.util.ArrayList;
import java.util.List;

import entities.Customer;
import entities.Employee;
import entities.PointOfInterest;
import entities.User;
import guiControllers.gcmMainController;
import java.sql.*;
import java.io.*;

// TODO: Auto-generated Javadoc
/**
 * The Class QueryCreator.
 * This class contains methods that receive input from the user on the Client side and constructs the desired queries
 * which are then sent to the Server for execution on the DB.
 * The first thing appended to each Query string is the unique identifier in order for the Server to know which query it has received.
 */
/* TODO - ViewCatalog - keyword?? Language??
          Register - comments??
          Purchasemap.fxml??
          ManagementClientInfo - PK is username not ID
          Language col - no
          Search by keyword - no
          Comments - no*/
public class QueryCreator
{
	
	/**
	 * Checks if is numeric.
	 *
	 * @param strNum the str num
	 * @return true, if is numeric
	 */
	public static boolean isNumeric(String strNum) {
		for(int i=0;i<strNum.length();i++)
			if(strNum.charAt(i) <'0' || strNum.charAt(i)>'9')
				return false;
	    return true;
	}


	/**
	 * Log in customer by user name.
	 *
	 * @param userName the user name
	 * @param password the password
	 * @return the string
	 */
	public static String logInCustomerByUserName(String userName,String password) //Customer login.
	  {
		  String query=new String();
		  query=query+"Login, SELECT customers.*, creditcard.cardid,creditcard.cardcompanyname,creditcard.cardvaliddate,creditcard.cardcvv FROM creditcard INNER JOIN customers ON customers.userName=creditcard.userName WHERE customers.userName='"+userName+"' AND customers.password='"+password+"';";
		  query=query+"# INSERT INTO loggedusers (userName) VALUES ('"+userName+"');";
		  return query;
	  }

	/**
	 * Log in employees by user name.
	 *
	 * @param userName the user name
	 * @param password the password
	 * @return the string
	 */
	public static String logInEmployeesByUserName(String userName,String password) //Employee login.
	  {
		  String query=new String();
		  query=query+"Login, SELECT employees.*, creditcard.cardid,creditcard.cardcompanyname,creditcard.cardvaliddate,creditcard.cardcvv FROM creditcard INNER JOIN employees ON employees.userName=creditcard.userName WHERE employees.userName='"+userName+"' AND employees.password='"+password+"';";
		  query=query+"# INSERT INTO loggedusers (userName) VALUES ('"+userName+"');";
		  return query;
	  }

	/**
	 * Gets the customer by username.
	 *
	 * @param input the input
	 * @return the string
	 */
	public static String GetCustomerByUsername(String input) //Customer login.
	  {
		  String query=new String();
		  query=query+"GetCustomerByUsername, SELECT customers.*, creditcard.cardid,creditcard.cardcompanyname,creditcard.cardvaliddate,creditcard.cardcvv FROM creditcard INNER JOIN customers ON customers.userName=creditcard.userName WHERE customers.userName='"+input+"';";
		  return query;
	  }

	 /**
 	 * Update customer info.
 	 *
 	 * @param input the input
 	 * @return the string
 	 */
 	public static String updateCustomerInfo(String[] input) //EditProfile
	  {
		 /**
		  * input[0] =  userNameTxt.getText();
    		input[1] =  firstNameTxt.getText();
    		input[2] =  lastNameTxt.getText();
    		input[3] =  passwordTxt.getText();
    		input[4] =  emailTxt.getText();
    		input[5] =  addressTxt.getText();
    		input[6] =  cardCompanyCbx.getValue().toString();
    		input[7] =  cardNumberTxt.getText();
    		input[8] =  dateCardTxt.getValue().toString();
    		input[9] =  cardCvvTxt.getText();
    		input[10] =  phonenumber.getText();
		  */

		  //last string arr[6] needs to be current username
		  String query=new String();
		  query=query+"UpdateCustomerInfo, UPDATE customers SET phoneNumber='"+input[10]+"',firstName='"+input[1]+"', lastName='"+input[2]+"', userName='"+input[0]+"', password='"+input[3]+"', email='"+input[4]+"', address='"+input[5]+"'"
		  		+ "WHERE userName='"+gcmMainController.user.getUserName()+"';";
		  return query;
	  }

	 /**
 	 * Update employee info.
 	 *
 	 * @param input the input
 	 * @return the string
 	 */
 	public static String updateEmployeeInfo(String[] input) //EditProfile
	  {
		 /**
		  * input[0] =  userNameTxt.getText();
    		input[1] =  firstNameTxt.getText();
    		input[2] =  lastNameTxt.getText();
    		input[3] =  passwordTxt.getText();
    		input[4] =  emailTxt.getText();
    		input[5] =  addressTxt.getText();
    		input[6] =  cardCompanyCbx.getValue().toString();
    		input[7] =  cardNumberTxt.getText();
    		input[8] =  dateCardTxt.getValue().toString();
    		input[9] =  cardCvvTxt.getText();
		  */

		  //last string arr[6] needs to be current username
		 String query=new String();
		  query=query+"UpdateEmployeeInfo, UPDATE employees SET phoneNumber='"+input[10]+"',firstName='"+input[1]+"', lastName='"+input[2]+"', userName='"+input[0]+"', password='"+input[3]+"', email='"+input[4]+"', address='"+input[5]+"'"
		  		+ "WHERE userName='"+gcmMainController.user.getUserName()+"';";
		  return query;
	  }

	  /**
  	 * Update CC info.
  	 *
  	 * @param input the input
  	 * @return the string
  	 */
  	public static String updateCCInfo(String[] input) //EditProfile
	  {
		  /**
			  * input[0] =  userNameTxt.getText();
	    		input[1] =  firstNameTxt.getText();
	    		input[2] =  lastNameTxt.getText();
	    		input[3] =  passwordTxt.getText();
	    		input[4] =  emailTxt.getText();
	    		input[5] =  addressTxt.getText();
	    		input[6] =  cardCompanyCbx.getValue().toString();
	    		input[7] =  cardNumberTxt.getText();
	    		input[8] =  dateCardTxt.getValue().toString();
	    		input[9] =  cardCvvTxt.getText();
	    		input[10] =  PhoneNuber.getText();
			  */

		  //arr[4] is current username
		  String query=new String();
		  query=query+"UpdateCCInfo, UPDATE creditcard SET cardid='"+input[7]+"', cardcompanyname='"+input[6]+"', cardvaliddate='"+input[8]+"', cardcvv='"+input[9]+"', userName='"+input[0]+"' WHERE userName='"+gcmMainController.user.getUserName()+"';";
		  return query;
	  }
	

	/**
	 * Select city table.
	 *
	 * @param input the input
	 * @return the string
	 */
	public static String selectCityTable(String input) // receives cityname, shows full table
	  {
		  String query=new String();
		  query=query+"SELECT * FROM city WHERE cityname='"+input+"';";
		  return query;
	  }

	  /**
  	 * Update version.
  	 *
  	 * @param input the input
  	 * @return the string
  	 */
  	public static String UpdateVersion(String input) // receives cityname, sets new versionNum
	  {
		  String query=new String();
		  String[] arr=new String[2];
		  int i=input.indexOf(' ');
		  arr[0]=input.substring(0,i); // arr[0]=city name, arr[1]=new version number
		  arr[1]=input.substring(i);
		  query=query+"UPDATE city SET VersionNum='"+arr[1]+"' WHERE cityname='"+arr[0]+"';";
		  return query;
	  }

	  /**
  	 * Select all countries.
  	 *
  	 * @return the string
  	 */
  	public static String selectAllCountries() // select all countries
	  {
		  String query=new String();
		  query=query+"selectCountry, SELECT * FROM countries;";
		  return query;
	  }

	  /**
  	 * Select map by ID.
  	 *
  	 * @param input the input
  	 * @return the string
  	 */
  	public static String selectMapByID(String input) // select map from ID
	  {
		  String query=new String();
		  query=query+"SELECT * FROM map WHERE idmap='"+input+"';";
		  return query;
	  }

	  /**
  	 * Filter city by country.
  	 *
  	 * @param input the input
  	 * @return the string
  	 */
  	public static String filterCityByCountry(String input) // select country from combobox
	  {
		  String query=new String();
		  if(input=="Select All")
			  query=query+"selectAllCityInfo, SELECT * FROM city;";
		  else
			  query=query+"selectCity, SELECT * FROM city WHERE countryName='"+input+"';";
		  return query;
	  }

	  /**
  	 * Filter map by city.
  	 *
  	 * @param input the input
  	 * @return the string
  	 */
  	public static String filterMapByCity(String input) // select city from combobox
	  {
		  String query=new String();
		  if(input=="Select All")
			  query=query+"SELECT * FROM map;";
		  query=query+"SELECT * FROM map WHERE cityname='"+input+"';";
		  return query;
	  }

	  /**
  	 * Select map by city.
  	 *
  	 * @param input the input
  	 * @return the string
  	 */
  	public static String SelectMapByCity(String input) // select map from combobox
	  {
		  String query=new String();
		  if(input=="Select All")
			  query=query+"SELECT * FROM map;";
		  query=query+"selectMap, SELECT description FROM map WHERE cityname='"+input+"';";
		  return query;
	  }




	  /**
  	 * Update map rate.
  	 *
  	 * @param input the input
  	 * @return the string
  	 */
  	public static String updateMapRate(String[] input) // UpdateMapRates.fxml
	  {

		  String query=new String();      // input[0]=mapRate, input[1]=mapsubRate, input[2]=description/////
		  query=query+"updateRates, INSERT INTO waitingrates (idmap, cityname, rate, subrate, status, description, numPOI, image) SELECT * FROM map WHERE description='"+input[2]+"';"
		  +"#UPDATE waitingrates SET rate="+Double.parseDouble(input[0])+", subrate="+Double.parseDouble(input[1])+" WHERE description='"+input[2]+"';";
		  return query;
	  }

	  /**
  	 * Select map rate.
  	 *
  	 * @param mapDescription the map description
  	 * @return the string
  	 */
  	//////////=====/**//***
	  public static String selectMapRate(String mapDescription) // select city from combobox
	  {
		  String query=new String();
		  query=query+"selectMapRates, SELECT rate,subrate FROM map WHERE description='"+mapDescription+"';";
		  return query;
	  }



	  /**
  	 * Insert customer.
  	 *
  	 * @param RegisterInfo the register info
  	 * @return the string
  	 */
  	public static String insertCustomer(String[] RegisterInfo) // registerFXML.fxml
	  {
		  // Array order - First Name Last Name Username  ....
		  String query=new String();
		  query =query+"RegisterNewClient, INSERT INTO customers (firstName,lastName,userName,password,email,address,permission,phoneNumber) VALUES ('"+RegisterInfo[1]+"','"+RegisterInfo[2]+"','"+RegisterInfo[0]+"','"+RegisterInfo[3]+"','"+RegisterInfo[4]+"','"+RegisterInfo[5]+"', 0 ,'"+RegisterInfo[10]+"');";
		  return query;
	  }

	  /**
  	 * Insert CC.
  	 *
  	 * @param RegisterInfo the register info
  	 * @return the string
  	 */
  	public static String insertCC(String[] RegisterInfo) // registerFXML.fxml
	  {
		  // Also need to pass username last
		  String query=new String();
		  query=query+"RegisterNewClientCreditCard, INSERT INTO creditcard (cardid,cardcompanyname,cardvaliddate,cardcvv,username) VALUES ('"+RegisterInfo[7]+"','"+RegisterInfo[6]+"','"+RegisterInfo[8]+"','"+RegisterInfo[9]+"','"+RegisterInfo[0]+"');";
		  return query;
	  }

	  /**
  	 * Insert interested place.
  	 *
  	 * @param details the details
  	 * @param POI the poi
  	 * @param status the status
  	 * @return the string
  	 */
  	public static String insertInterestedPlace(String[] details, PointOfInterest POI,String status) // Insert Interested Place
	  {
		  String query=new String();
		  if(status.equals("No"))
		  {
			  query =query+"insertInterestedPlace, INSERT INTO waitingpoi (isAcc,type,description,time, address, locationX, locationY, idmap, name) VALUES ('"+details[8]+"','"+details[2]+"','"+details[4]+"','"+details[3]+"','"+details[0]+"','"+details[5]+"','"+details[6]+"', "+Integer.parseInt(details[7])+",'"+details[1]+"');";
			  query = query+"#INSERT INTO waitingmaps (idmap, rate, subrate, cityname, description, numPOI, image)\r\n" + 
			  		"SELECT idmap, rate, subrate, cityname, description, numPOI, image\r\n" + 
			  		"FROM map\r\n" + 
			  		"WHERE EXISTS (Select idmap WHERE "+Integer.parseInt(details[7])+" = map.idmap);";
			  return query;
		  }
		  else if(status.equals("Yes"))
		  {
			  query =query+"insertInterestedPlace, INSERT INTO waitingpoi (idpoi ,isAcc,type,description,time, address, locationX, locationY, idmap, name) VALUES ("+Integer.parseInt(POI.getIdPOI())+",'"+POI.getAccessible()+"','"+POI.getType()+"','"+POI.getDescription()+"','"+POI.getTime()+"','"+POI.getAddress()+"','"+details[5]+"','"+details[6]+"', "+Integer.parseInt(details[7])+", '"+POI.getName()+"');";
			  query = query+"#INSERT INTO waitingmaps (idmap, rate, subrate, cityname, description, numPOI, image)\r\n" + 
				  		"SELECT idmap, rate, subrate, cityname, description, numPOI, image\r\n" + 
				  		"FROM map\r\n" + 
				  		"WHERE EXISTS (Select idmap WHERE "+Integer.parseInt(details[7])+" = map.idmap);";
			  
		  }
		  return query;

	  }



	  /**
  	 * Insert new POI.
  	 *
  	 * @param arr the arr
  	 * @return the string
  	 */
  	public static String insertNewPOI(String[] arr)
	  {
		  String query=new String();
		  query=query+"insertNewPOI, INSERT INTO waitingpoi (isAcc,type,description,time, address, locationX, locationY, idmap, name) VALUES ('"
		  		+arr[0]+"','"+arr[1]+"','"+arr[2]+"','"+arr[3]+"','"+arr[4]+"','"+arr[5]+"','"+arr[6]+"', "+Integer.parseInt(arr[7])+",'"+arr[8]+"');";
		  return query;
	  }

	  /**
  	 * Select employees by user name.
  	 *
  	 * @param input the input
  	 * @return the string
  	 */
  	public static String selectEmployeesByUserName(String input) // ManagementClientInfo.fxml - mistake here, no clientID
	  {
		  String query=new String();
		  query=query+"UserInfo, SELECT * FROM employees WHERE userName='"+input+"';";
		  return query;
	  }

	  /**
  	 * Gets the map by map description.
  	 *
  	 * @param mapDescription the map description
  	 * @return the map by map description
  	 */
  	public static String getMapByMapDescription(String mapDescription) // select city from combobox
	  {
		  String query=new String();
		  query=query+"getMapImage, SELECT image FROM map WHERE description='"+mapDescription+"';";
		  return query;
	  }


	  /**
  	 * Gets the map id by map description.
  	 *
  	 * @param mapDescription the map description
  	 * @return the map id by map description
  	 */
  	public static String getMapIdByMapDescription(String mapDescription) // select city from combobox
	  {
		  String query=new String();
		  query=query+"getMapId, SELECT idmap FROM map WHERE description='"+mapDescription+"';";
		  return query;
	  }

	  /**
  	 * Gets the POI in map.
  	 *
  	 * @param arr the arr
  	 * @return the POI in map
  	 */
  	public static String getPOIInMap(String[] arr)
	  {
		  String query=new String();
		  query=query+"getPOIInMap, SELECT idpoi, name FROM poi WHERE idmap="+arr[0]+";";
		  return query;
	  }


	  /**
  	 * String select col.
  	 *
  	 * @param input the input
  	 * @return the string
  	 */
  	public static String stringSelectCol(String input) // generic select one column and one row
	  {
		  // arr[0]=table name, arr[1]=WHERE field, arr[2]=SELECT field, arr[3]=key
		  String query=new String();
		  String[] arr=input.split(" ");
		  query=query+"SELECT "+arr[2]+"FROM "+arr[0]+"WHERE "+arr[1]+"='"+arr[3]+"';";
		  return query;
	  }

	  /**
  	 * Update POI.
  	 *
  	 * @param arr the arr
  	 * @return the string
  	 */
  	public static String updatePOI(String[] arr) //editPlaceOfInterest - but location
	  {
		  //arr[0]=name , arr[1]=type, arr[2]=address, arr[3]=time, arr[4]=description, arr[5]=cordx,arr[6]=cordy
		  String query=new String();
		  query=query+"updatePOI, UPDATE poi SET type='"+arr[1]+"',address='"+arr[2]+"',time='"+arr[3]+"',description='"+arr[4];
		  query=query+"' WHERE name='"+arr[0]+"' AND locationX='"+arr[5]+"' AND locationY='"+arr[6]+"';";
		  return query;
	  }
	  
	  /**
  	 * Delete row.
  	 *
  	 * @param input the input
  	 * @return the string
  	 */
  	public static String deleteRow(String input) // generic delete entire row
	  {
		  // arr[0]=table, arr[1]=key of row to delete, arr[2]=value of key
		  String query=new String();
		  String[] arr=input.split(" ");
		  if(!QueryCreator.isNumeric(arr[2]))
			  query=query+"DELETE FROM "+arr[0]+" WHERE "+arr[1]+"='"+arr[2]+"';";
		  else
			  query=query+"DELETE FROM "+arr[0]+" WHERE "+arr[1]+"="+Integer.parseInt(arr[2])+";";
		  return query;
	  }


	  /**
  	 * Insert city.
  	 *
  	 * @param input the input
  	 * @return the string
  	 */
  	public static String insertCity(String[] input) // createNewCity
	  {
		  String query=new String();
		  query=query+"insertCity, INSERT INTO city (cityname, countryName, description) VALUES ('"+input[0]+"','"+input[1]+"', '"+input[2]+"');";
		  return query;
	  }


	  /**
  	 * Insert tour.
  	 *
  	 * @param arr the arr
  	 * @return the string
  	 */
  	public static String insertTour(String[] arr)// addTourToCity
	  {
		  String query=new String();
		  query=query+"insertTour, INSERT INTO tour (name, description, rectime, cityname) VALUES ('"+arr[2]+"', '"+arr[4]+"', '"+arr[3]+"', '"+arr[1]+"');";
		  return query;
	  }


	  /**
  	 * Select POI by map desc.
  	 *
  	 * @param input the input
  	 * @return the string
  	 */
  	public static String selectPOIByMapDesc(String input)
	  {
		  //
		  String query=new String();
		  query=query+"selectPOI, SELECT name FROM poi WHERE idmap in (SELECT idmap FROM map WHERE description='"
		  		+input+"') ORDER BY name ASC;";
		  return query;
	  }
	  
	  /**
  	 * Insert map.
  	 *
  	 * @param input the input
  	 * @return the string
  	 */
  	public static String insertMap(String[] input) //AddMapToCity
	  {
	   String query=new String();
		  query=query+"insertmap, ";
		
			  query=query+"INSERT INTO waitingrates (rate, subrate, status, cityname, description) VALUES ("+Double.parseDouble(input[3])+", "+
						Double.parseDouble(input[4])+", 'Waiting' , '"+input[1]+"', '"+input[6]+"');"+
						"#UPDATE waitingrates JOIN pics ON waitingrates.cityname = pics.cityname"+
						" SET waitingrates.image = pics.image;";
			
			  return query;
		   
	  }


	  /**
  	 * Delete PO iby map.
  	 *
  	 * @param input the input
  	 * @return the string
  	 */
  	public static String deletePOIbyMap(String[] input)
	  {
		  // input[0] = map description, input[1]=POI name
		  String query=new String();
		  query=query+"deletePOI, DELETE FROM poi WHERE idmap in (SELECT idmap FROM map WHERE description='"
		  		+input[0]+"') AND name='"+input[1]+"';"
		  				+ "# UPDATE map SET numPOI=numPOI-1 WHERE description='"+input[0]+"';"
		                +"# UPDATE city SET numOfPOI=numOfPOI-1 WHERE city.cityname=(SELECT cityname FROM map WHERE description='"+input[0]+"');";
		  
		  return query;
	  }

	  /**
  	 * Select map by POI name.
  	 *
  	 * @param input the input
  	 * @return the string
  	 */
  	public static String selectMapByPOIName(String input)
	  {

		  String query=new String();
		  query=query+"guestCatalog, SELECT description, rate, subrate FROM map WHERE map.idmap IN"
		  		+ " (SELECT poi.idmap FROM poi WHERE poi.name='"+input+"');";
		  return query;
	  }


	  /**
  	 * Gets the poibycity.
  	 *
  	 * @param input the input
  	 * @return the poibycity
  	 */
  	public static String getpoibycity(String input)
	  {
		  String query=new String();
		  query=query+"getPoiByCity, SELECT DISTINCT name FROM poi where idmap in (SELECT idmap FROM map WHERE cityname='"+input+"') ORDER BY name ASC;";
		  return query;
	  }

	  /**
  	 * Gets the poi by name.
  	 *
  	 * @param name the name
  	 * @return the poi by name
  	 */
  	public static String getPoiByName(String name)
	  {
		  String query=new String();
		  query=query+"getPoiByName, SELECT name, type, description, isAcc, time, address FROM poi WHERE name='"+name+"';";
		  return query;
	  }


	  /**
  	 * View map catalog guest by city name.
  	 *
  	 * @param name the name
  	 * @return the string
  	 */
  	public static String viewMapCatalogGuestByCityName(String name)
	  {
		  String query=new String();
		  query=query+"getDataByCityName, SELECT NumOfMaps, NumOfPOI, NumOfTours, description FROM city WHERE cityname='"+name+"';";
		  return query;
	  }


	  /**
  	 * Select POI coor by map ID.
  	 *
  	 * @param input the input
  	 * @return the string
  	 */
  	public static String selectPOICoorByMapID(String input)
	  {
		  String query=new String();
		  query=query+"selectPOIcoordinate, SELECT locationX,locationY FROM poi WHERE idmap='"+Integer.parseInt(input)+"';";
		  return query;
	  }


	  /**
  	 * Select map coord by place name.
  	 *
  	 * @param input the input
  	 * @return the string
  	 */
  	public static String selectMapCoordByPlaceName(String input)
	  {
		  String query=new String();
		  query=query+"selectSpecificPOIcoordinate, SELECT locationX,locationY FROM poi WHERE name='"+input+"';";
		  return query;
	  }


	  /**
  	 * Select map from text.
  	 *
  	 * @param input the input
  	 * @return the string
  	 */
  	public static String selectMapFromText(String input)
	  {
	  	String query=new String();
	  	query=query+"SearchByFreeText, SELECT description, rate, subrate FROM map WHERE description LIKE '%"+input+"%';";
	  	return query;
	  }


	  /**
  	 * Gets the purchase info.
  	 *
  	 * @param arr the arr
  	 * @return the purchase info
  	 */
  	public static String getPurchaseInfo(String[] arr)
	  {
		  //[0]=username, [1]=type
	  	String query=new String();
	  	query=query+"getpurchase, SELECT map.description, map.cityname, map.numPOI FROM map WHERE map.cityname"
	  			+ " IN (SELECT purchase.cityname FROM purchase WHERE customerUsername='"+arr[0]+"' AND type='"+arr[1]+"');";
	  	return query;
	  }

	  /**
  	 * Gets the user info.
  	 *
  	 * @param arr the arr
  	 * @return the user info
  	 */
  	public static String getUserInfo(String[] arr)
	  {
		  //[0]=username, [1]=permission
	  	String query=new String();
	  	if(Integer.parseInt(arr[1])==0)
	  	{
	  		query=query+"getUserInfo, SELECT customers.userName, firstName, lastName, password, email, address, permission, cardid, cardcompanyname, cardvaliddate, cardcvv, phoneNumber "
	  				+ "FROM customers "
	  				+ "INNER JOIN creditcard ON customers.userName=creditcard.userName "
	  				+ "WHERE customers.userName='"+arr[0]+"';";
	  	}
	  	else
	  	{
	  		query=query+"getUserInfo, SELECT employees.userName, firstName, lastName, password, email, address, permission, cardid, cardcompanyname, cardvaliddate, cardcvv, phoneNumber "
	  				+ "FROM employees "
	  				+ "INNER JOIN creditcard ON employees.userName=creditcard.userName "
	  				+ "WHERE employees.userName='"+arr[0]+"';";
	  	}
	  	System.out.println(query);
	  	return query;

	  }

	  /**
  	 * Gets the purchase history.
  	 *
  	 * @param arr the arr
  	 * @return the purchase history
  	 */
  	public static String getPurchaseHistory(String[] arr)
	  {
		  	String query=new String();
		  	if(Integer.parseInt(arr[1])==0)
		  	{
			  	query=query+"getHistory, SELECT type, cityname, date, price, subTime FROM purchase "
			  			+ "WHERE customerUsername='"+arr[0]+"';";

		  	}
		  	else
		  	{
		  		query=query+"getHistory, SELECT type, cityname, date, price, subTime FROM purchase "
			  			+ "WHERE employeeUsername='"+arr[0]+"';";
		  	}
		  	return query;
	  }

	  /**
  	 * Gets the report.
  	 *
  	 * @param arr the arr
  	 * @return the report
  	 */
  	public static String getReport(String[] arr)
	  {
		  // arr[0]= city name, arr[1]= from date, arr[2]= to date
		  String query=new String();
		  if(!(arr[0]=="allcity")) {
		       query=query+"getReport, "
		  		+ "SELECT  (\r\n" +
		  		"SELECT COUNT(*)\r\n" +
		  		"        FROM   purchase\r\n" +
		  		"        WHERE cityname='"+arr[0]+"' AND type='One time purchase' AND date BETWEEN '"+arr[1]+"' AND '"+arr[2]+"'\r\n" +
		  		"        ) AS OneTimePurchases,\r\n" +
		  		"        (\r\n" +
		  		"        SELECT COUNT(*)\r\n" +
		  		"        FROM   purchase\r\n" +
		  		"        WHERE cityname='"+arr[0]+"' AND type='Subscription' AND date BETWEEN '"+arr[1]+"' AND '"+arr[2]+"'\r\n" +
		  		"        ) AS Subscriptions,\r\n" +
		  		"        (\r\n" +
		  		"        SELECT COUNT(*)\r\n" +
		  		"        FROM   subscriptionrenewals\r\n" +
		  		"        WHERE cityname='"+arr[0]+"' AND date BETWEEN '"+arr[1]+"' AND '"+arr[2]+"'\r\n" +
		  		"        ) AS SubscriptionRenewals,\r\n" +
		  		"        (\r\n" +
		  		"        SELECT COUNT(*)\r\n" +
		  		"        FROM   views\r\n" +
		  		"        WHERE cityname='"+arr[0]+"' AND date BETWEEN '"+arr[1]+"' AND '"+arr[2]+"'\r\n" +
		  		"        ) AS Views,\r\n" +
		  		"        (\r\n" +
		  		"         SELECT COUNT(*)\r\n" +
		  		"        FROM   subscribeddownloads\r\n" +
		  		"        WHERE cityname='"+arr[0]+"' AND date BETWEEN '"+arr[1]+"' AND '"+arr[2]+"'\r\n" +
		  		"        ) AS Downloads\r\n" +
		  		"        \r\n" +
		  		"        # SELECT NumOfMaps FROM city where cityname='"+arr[0]+"';";
		  		return query;
	      }

		  else {
			  query=query+"getReport, "
				  		+ "SELECT  (\r\n" +
				  		"SELECT COUNT(*)\r\n" +
				  		"        FROM   purchase\r\n" +
				  		"        WHERE type='One time purchase' AND date BETWEEN '"+arr[1]+"' AND '"+arr[2]+"'\r\n" +
				  		"        ) AS OneTimePurchases,\r\n" +
				  		"        (\r\n" +
				  		"        SELECT COUNT(*)\r\n" +
				  		"        FROM   purchase\r\n" +
				  		"        WHERE type='Subscription' AND date BETWEEN '"+arr[1]+"' AND '"+arr[2]+"'\r\n" +
				  		"        ) AS Subscriptions,\r\n" +
				  		"        (\r\n" +
				  		"        SELECT COUNT(*)\r\n" +
				  		"        FROM   subscriptionrenewals\r\n" +
				  		"        WHERE date BETWEEN '"+arr[1]+"' AND '"+arr[2]+"'\r\n" +
				  		"        ) AS SubscriptionRenewals,\r\n" +
				  		"        (\r\n" +
				  		"        SELECT COUNT(*)\r\n" +
				  		"        FROM   views\r\n" +
				  		"        WHERE date BETWEEN '"+arr[1]+"' AND '"+arr[2]+"'\r\n" +
				  		"        ) AS Views,\r\n" +
				  		"        (\r\n" +
				  		"         SELECT COUNT(*)\r\n" +
				  		"        FROM   subscribeddownloads\r\n" +
				  		"        WHERE date BETWEEN '"+arr[1]+"' AND '"+arr[2]+"'\r\n" +
				  		"        ) AS Downloads\r\n" +
				  		"        \r\n" +
				  		"        # SELECT SUM(NumOfMaps) FROM city;";
		  }
		  return query;
	  }

	  /**
  	 * Gets the tour ID by name.
  	 *
  	 * @param name the name
  	 * @return the tour ID by name
  	 */
  	public static String getTourIDByName(String name)
	  {
		  String query=new String();
		  query=query+"getTourID, SELECT idtour FROM tour WHERE name='"+name+"';";
		  return query;
	  }

	  /**
  	 * Select pid by name.
  	 *
  	 * @param input the input
  	 * @return the string
  	 */
  	public static String selectPidByName(String[] input)
	  {
		  //[0]=poiName, [1]=cityname, [2]=tourID, [3]=index
		  String query=new String();
		  query=query+"selectPid, SELECT idpoi,name,type,description,isAcc,time,address FROM poi WHERE name='"+input[0]+"' AND idmap IN (SELECT idmap FROM map WHERE cityname='"+input[1]+"');";
		  return query;
	  }

	  /**
  	 * Insert POI to tour.
  	 *
  	 * @param input the input
  	 * @return the string
  	 */
  	public static String insertPOIToTour(String[] input)
	  {
		  //[2]=tourID, [4]=poiID
		  String query=new String();
		  query=query+"insertPOIToTour, INSERT INTO tourpois (idpoi, idtour, pIndex) VALUES ("+Integer.parseInt(input[4])+", "+Integer.parseInt(input[2])+", "+Integer.parseInt(input[3])+");";
		  query+="# UPDATE tour SET numPOI=numPOI+1 WHERE idtour="+Integer.parseInt(input[2])+";";
		  return query;
	  }

	  /**
  	 * Select map by POI name.
  	 *
  	 * @param input the input
  	 * @return the string
  	 */
  	public static String selectMapByPOIName(String[] input)
	  {

		  String query=new String();
		  query=query+"SELECT description, rate, subrate FROM map WHERE map.idmap IN"
		  		+ " (SELECT poi.idmap FROM poi WHERE poi.name='"+input+"');";
		  return query;
	  }

	  /**
  	 * Gets the tour by city.
  	 *
  	 * @param city the city
  	 * @return the tour by city
  	 */
  	public static String getTourByCity(String city)
	  {
		  String query=new String();
		  query=query+"getTourByCity, SELECT name FROM tour WHERE cityname='"+city+"' ORDER BY name ASC;";
		  return query;
	  }

	  /**
  	 * Select PO iby tour.
  	 *
  	 * @param id the id
  	 * @return the string
  	 */
  	public static String selectPOIbyTour(String id)
	  {
		  String query=new String();
		  query=query+"getPOIbyTour, SELECT DISTINCT name, pIndex, poi.idpoi FROM poi"
		  		+ " INNER JOIN tourpois ON poi.idpoi=tourpois.idpoi WHERE idtour="+Integer.parseInt(id)+""
		  		+ " ORDER BY name ASC;";
		  return query;
	  }

	  /**
  	 * Select tour info by name.
  	 *
  	 * @param name the name
  	 * @return the string
  	 */
  	public static String selectTourInfoByName(String name)
	  {
		  String query=new String();
		  query=query+"getTourInfo, SELECT idtour, name, description, rectime FROM tour WHERE name='"+name+"';";
		  return query;
	  }

	  /**
  	 * Update tour index.
  	 *
  	 * @param arr the arr
  	 * @return the string
  	 */
  	public static String updateTourIndex(String[] arr)
	  {
		  // arr[0]=index, arr[1]=idpoi, arr[2]=idtour
		  String query=new String();
		  query=query+"updateIndex, UPDATE tourpois SET pIndex="+Integer.parseInt(arr[0])+" WHERE idpoi="+Integer.parseInt(arr[1])+" AND idtour="+Integer.parseInt(arr[2])+";";
		  return query;
	  }

	  /**
  	 * Delete POI from tour.
  	 *
  	 * @param arr the arr
  	 * @return the string
  	 */
  	public static String deletePOIFromTour(String[] arr)
	  {
		  //arr[0]=idpoi, arr[1]=idtour
		  String query=new String();
		  query=query+"deletePOITour, DELETE FROM tourpois WHERE idpoi="+Integer.parseInt(arr[0])+" AND idtour="+Integer.parseInt(arr[1])+";";
		  query=query+"# UPDATE tour SET numPOI=numPOI-1 WHERE idtour="+Integer.parseInt(arr[1])+";";
		  return query;
	  }

	  /**
  	 * Gets the poi not in tour.
  	 *
  	 * @param arr the arr
  	 * @return the poi not in tour
  	 */
  	public static String getPoiNotInTour(String[] arr)
	  {
		  String query=new String();
		  query=query+"getOtherPoi, SELECT DISTINCT name, idpoi "
		  		+ "FROM poi WHERE idpoi NOT IN (SELECT idpoi FROM tourpois WHERE idtour="+Integer.parseInt(arr[0])+") "
		  		+ "AND idmap IN (SELECT idmap FROM map WHERE cityname='"+arr[1]+"') ORDER BY name ASC;";
		  return query;
	  }


	  /**
  	 * Delete tour.
  	 *
  	 * @param arr the arr
  	 * @return the string
  	 */
  	public static String deleteTour(String[] arr)
	  {
		  String query=new String();
		  query=query+"deleteTour, DELETE FROM tour WHERE idtour="+Integer.parseInt(arr[0])+";";
		  query=query+"# UPDATE city SET NumOfTours=NumOfTours-1 WHERE cityname='"+arr[1]+"';";
		  return query;
	  }

	  /**
  	 * Update tour info.
  	 *
  	 * @param arr the arr
  	 * @return the string
  	 */
  	public static String updateTourInfo(String [] arr)
	  {
		  String query=new String();
		  query=query+"updateTour, UPDATE tour SET name='"+arr[0]+"', description='"+arr[1]+"',"
		  		+ " rectime='"+arr[2]+"' WHERE idtour="+Integer.parseInt(arr[3])+";";
		  return query;
	  }

	  /**
  	 * Select all POI by city.
  	 *
  	 * @param cityName the city name
  	 * @return the string
  	 */
  	public static String selectAllPOIByCity(String cityName)
	  {
		  String query=new String();
		  query=query+"selectAllPOIByCity,  SELECT idpoi,name,type,description,isAcc,time,address FROM poi where idmap in (SELECT idmap FROM map WHERE cityname='"+cityName+"');";
		  return query;
	  }

	  /**
  	 * Gets the all POI.
  	 *
  	 * @return the all POI
  	 */
  	public static String getAllPOI()
	  {
		  String query=new String();
		  query=query+"selectAllPOI, SELECT * FROM poi;";
		  return query;
	  }

	  /**
  	 * Insert customer purchase.
  	 *
  	 * @param purcInfo the purc info
  	 * @return the string
  	 */
  	public static String InsertCustomerPurchase(ArrayList<String> purcInfo)
	  {
		  String query=new String();
		  query=query+"InsertCustomerPurchase, INSERT INTO purchase (type, price, date, cityname,subTime,customerUsername) VALUES ('"+purcInfo.get(0)+"', "+Double.parseDouble(purcInfo.get(1))+", CURDATE(), '"+purcInfo.get(2)+"', "+Integer.parseInt(purcInfo.get(3))+", '"+purcInfo.get(4)+"');";
		  return query;
	  }

	  /**
  	 * Insert customer download.
  	 *
  	 * @param cusDownInfo the cus down info
  	 * @return the string
  	 */
  	public static String InsertCustomerDownload(ArrayList<String> cusDownInfo)
	  {
		  String query=new String();
		  query=query+"InsertCustomerDownload, INSERT INTO subscribeddownloads (username, date, cityname) VALUES ('"+cusDownInfo.get(4)+"', CURDATE(),'"+cusDownInfo.get(2)+"');";
		  return query;
	  }

	  /**
  	 * Insert download.
  	 *
  	 * @param cusDownInfo the cus down info
  	 * @return the string
  	 */
  	public static String InsertDownload(ArrayList<String> cusDownInfo)
	  {
		  String query=new String();
		  query=query+"InsertCustomerDownload, SELECT cityname, VersionNum FROM city WHERE cityname='"+cusDownInfo.get(1)+"';";
		  query=query+"#INSERT INTO subscribeddownloads (username, date, cityname, subVersion) VALUES ('"+cusDownInfo.get(0)+"', CURDATE(),'"+cusDownInfo.get(1)+"');";
		  query=query+"#"+cusDownInfo.get(0);
		  return query;
	  }

	  /**
  	 * Gets the all purchase.
  	 *
  	 * @return the all purchase
  	 */
  	public static String getAllPurchase()
	  {
		  String query=new String();
		  query=query+"selectAllPurchase, SELECT idpurchase,type,price,date,cityname,subTime,customerUsername FROM purchase;";
		  return query;
	  }

	  /**
  	 * Gets the map image.
  	 *
  	 * @return the map image
  	 */
  	public static String getMapImage() // select map from ID
	  {
		  String query=new String();
		  query=query+"SelectOnlyMapImageWithId, SELECT idmap,rate,subrate,status,cityname,description FROM map;";
		  return query;
	  }

	  /**
  	 * Delete user name.
  	 *
  	 * @return the string
  	 */
  	public static String DeleteUserName() // select map from ID
	  {
		  String UserName=gcmMainController.user.getUserName();
		  String query=new String();
		  query=query+"DeleteUserName, DELETE FROM loggedusers WHERE userName='"+UserName+""
		  		+ "';";
		  return query;
	  }

	  /**
  	 * Update purchase table.
  	 *
  	 * @param subTimeToRenew the sub time to renew
  	 * @param purchaseId the purchase id
  	 * @return the string
  	 */
  	public static String updatePurchaseTable(String subTimeToRenew,int purchaseId)
	  {
		  int subTime = Integer.parseInt(subTimeToRenew) ;
		  subTime ++;
		  String query=new String();
		  query=query+"updatePurchaseTable,  UPDATE purchase SET date = CURDATE() ,subTime=" +subTime+ " WHERE idpurchase='"+purchaseId+"';";
		  return query;
	  }


	  /**
  	 * Insert sub renew.
  	 *
  	 * @param userName the user name
  	 * @param cityName the city name
  	 * @return the string
  	 */
  	public static String insertSubRenew(String userName,String cityName)
	  {
		  String query=new String();
		  query=query+"insertSubRenew,  INSERT INTO subscriptionrenewals (username, date, cityname) VALUES ('"+userName+"', CURDATE(),'"+cityName+"');";
		  return query;
	  }

	  /**
  	 * Specialrequestforpublishnewversionalltb.
  	 *
  	 * @return the string
  	 */
  	public static String specialrequestforpublishnewversionalltb()
	  {

		String query=new String();
		query=query+"SelectPublishall, SELECT map.idmap, countryName, map.cityname, map.rate, waitingrates.rate, map.subrate, waitingrates.subrate, waitingrates.description FROM map INNER JOIN city ON map.cityname=city.cityname INNER JOIN waitingrates ON map.idmap=waitingrates.idmap;";
		return query;
	  }


	  /**
  	 * Specialrequestforpublishnewversiontb.
  	 *
  	 * @return the string
  	 */
  	public static String specialrequestforpublishnewversiontb()
	  {

		String query=new String();
		query=query+"SelectPublish, SELECT idmap, countryName, waitingmaps.cityname, rate, subrate, waitingmaps.description FROM waitingmaps;";
		return query;
	  }

	  /**
  	 * Updateversion.
  	 *
  	 * @param input the input
  	 * @return the string
  	 */
  	public static String updateversion(String input)
	  {
		  String query=new String();
		  query=query+"Updateversion,  UPDATE city SET VersionNum=VersionNum+0.1 cityname='"+input+"';";
		  return query;
	  }

	  /**
  	 * Gets the newoldpoi.
  	 *
  	 * @param input the input
  	 * @return the newoldpoi
  	 */
  	public static String getnewoldpoi(String input)
	  {
		  String query=new String();
		  query=query+"Getnewoldpoi, SELECT name,type,description,isAcc,time,address FROM waitingpoi where idmap="+input+";";
		  query=query+"SecondQuerySELECT name,type,description,isAcc,time,address FROM poi where idmap="+input+";";
		  return query;
	  }

	  /**
  	 * Approvepoi.
  	 *
  	 * @param input the input
  	 * @return the string
  	 */
  	public static String approvepoi(String input)
	  {
		  String query=new String();
		  query=query+"Approvepoi, "+input;
		  return query;
	  }

	  /**
  	 * Approverate.
  	 *
  	 * @param input the input
  	 * @return the string
  	 */
  	public static String approverate(String input)
	  {
		  String query=new String();
		  query=query+"Approverate, "+input;
		  return query;
	  }


	  /**
  	 * Gets the expired subs.
  	 *
  	 * @return the expired subs
  	 */
  	public static String getExpiredSubs()
	  {
		  String query=new String();
		  query=query+"getExp, "
		  		+ "SELECT cityname "
		  		+ "FROM purchase "
		  		+ "WHERE customerUsername='"+gcmMainController.user.getUserName()+"'"
		  				+ " AND type='Subscription' "
		  				+ "AND DATE_ADD((DATE_ADD(purchase.date, INTERVAL subTime MONTH)), INTERVAL -3 DAY)=CURDATE();";
		  return query;
	  }

	  /**
  	 * Gets the version updates.
  	 *
  	 * @return the version updates
  	 */
  	public static String getVersionUpdates()
	  {
		  String query=new String();
		  query=query+"getVerUpdate, "
		  		+ " SELECT COUNT(*) FROM purchase"
		  		+ " INNER JOIN city ON city.cityname=purchase.cityname"
		  		+ " WHERE purchase.customerUsername='"+gcmMainController.user.getUserName()+"'"
		  				+ " AND purchase.subVersion+0.1 < city.VersionNum"
		  				+ " AND purchase.type='Subscription'"
		  				+ " AND DATE_ADD(purchase.date, INTERVAL subTime MONTH) > CURDATE();";
		  return query;
	  }

	  /**
  	 * Adds the view.
  	 *
  	 * @param arr the arr
  	 * @return the string
  	 */
  	public static String addView(String[] arr)
	  {
		  String query=new String();
		  query=query+"addView, INSERT INTO views (username, date, cityname) VALUES ('"+arr[0]+"', CURDATE(), '"
		  		+ arr[1]+"');";
		  return query;
	  }

	  /**
  	 * Gets the requests num.
  	 *
  	 * @param permission the permission
  	 * @return the requests num
  	 */
  	public static String getRequestsNum(int permission)
	  {
		  String query=new String();
		  if(permission==3)
		  {
			  query=query+"getReq, 3#SELECT COUNT(*) FROM waitingmaps;";
			  }
		  else
		  {
			  query=query+"getReq, 1#SELECT SUM(x) FROM (SELECT COUNT(*) AS x FROM waitingmaps UNION SELECT COUNT(*) AS x FROM waitingrates) AS y;";

		  }
		  return query;
	  }

}
