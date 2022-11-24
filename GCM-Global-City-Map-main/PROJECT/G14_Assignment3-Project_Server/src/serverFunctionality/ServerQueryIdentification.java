package serverFunctionality;


import ocsf.server.ConnectionToClient;
import serverFunctionality.mysqlQuery;

// TODO: Auto-generated Javadoc
/**
 * The Class ServerQueryIdentification.
 * This class is responsible for identifying the query requests arriving from the Client, processing them and "sending" them to a different class
 * for execution. Unique String identifiers are used to know which query we received and how to execute it.
 */
public class ServerQueryIdentification {

	/** The mysql. */
	private mysqlQuery mysql;

	/**
	 * Instantiates a new server query identification.
	 */
	public ServerQueryIdentification() {
		mysql = new mysqlQuery();
	}

	/**
	 * Choose query.
	 *
	 * @param msg the msg
	 * @param client the client
	 * @return the object
	 */
	public Object ChooseQuery(Object msg, ConnectionToClient client)
	{
		if (msg instanceof String) {

			String TypeWithQuery = (String)msg;
			String[] identification;
			String type;
			String query;

			identification = TypeWithQuery.split(", ", 2);
			type = identification[0];
			query= identification[1];

				switch(type)
				{
				case "Login":
					ServerLogger.writeNewLine("Login query has been requred by: "+ client);
					return mysql.Login(query);

				case "Logout":
					ServerLogger.writeNewLine("Login query has been ended by: "+ client);
					break;

				case"RegisterNewClient":
					ServerLogger.writeNewLine("Register new customer query has been requred by: "+ client);
					return mysql.RegisterClient(query);

				case"RegisterNewClientCreditCard":
					ServerLogger.writeNewLine("Register new creditcard query has been requred by: "+ client);
					return mysql.RegisterCreditCard(query);

				case"GetCustomerByUsername":
					ServerLogger.writeNewLine("Register new creditcard query has been requred by: "+ client);
					return mysql.GetRegisterClient(query);

				case"UpdateCustomerInfo":
					ServerLogger.writeNewLine("Update customer profile query has been requred by: "+ client);
					return mysql.setUpdateCustomerInfo(query);

				case"UpdateEmployeeInfo":
					ServerLogger.writeNewLine("Update employee profile query has been requred by: "+ client);
					return mysql.setUpdateEmployeeInfo(query);

				case"UpdateCCInfo":
					ServerLogger.writeNewLine("Update credit card query has been requred by: "+ client);
					return mysql.setUpdateCCInfo(query);

				case"UserInfo":
					ServerLogger.writeNewLine("Select customer query has been requred by: "+ client);
					return mysql.GetCustomerInfo(query);

				case"selectCountry":
					ServerLogger.writeNewLine("Select country query has been requred by: "+ client);
					return mysql.cityComboBox(query);

				case"insertCity":
					ServerLogger.writeNewLine("Select city query has been requred by: "+ client);
					return mysql.InsertCity(query);

				case"insertInterestedPlace":
					ServerLogger.writeNewLine("Insert interested query has been requred by: "+ client);
					return mysql.InsertInterested(query);

				case"selectCity":
					ServerLogger.writeNewLine("Select city query has been requred by: "+ client);
					return mysql.selectcityComboBox(query);

				case"insertmap":
					ServerLogger.writeNewLine("Insert map query has been requred by: "+ client);
					return mysql.InsertMapToCity(query);

				case"selectMap":
					ServerLogger.writeNewLine("Select map query has been requred by: "+ client);
					return mysql.mapComboBox(query);

				case"selectMapRates":
					ServerLogger.writeNewLine("Select map rates query has been requred by: "+ client);
					return mysql.MaspRates(query);

				case"updateRates":
					ServerLogger.writeNewLine("Select map rates query has been requred by: "+ client);
					return mysql.UpdatMapRates(query);

				case"selectPOI":
					ServerLogger.writeNewLine("Select place name query has been requred by: "+ client);
					return mysql.SelectPlaceName(query);

				case"deletePOI":
					ServerLogger.writeNewLine("Delet place name query has been requred by: "+ client);
					return mysql.DeletePlaceName(query);

				case"guestCatalog":
					ServerLogger.writeNewLine("Guest catalog query has been requred by: "+ client);
					return mysql.selectGuestCatalog(query);

				case"getMapImage":
					ServerLogger.writeNewLine("Get map image has been requred by: "+ client);
					return mysql.selectMapImage(query);

				case"getMapId":
					ServerLogger.writeNewLine("Select mapID query has been requred by: "+ client);
					return mysql.selectMapId(query);

				case"getPoiByCity":
					ServerLogger.writeNewLine("Select place of interest query has been requred by: "+ client);
					return mysql.SelectNamePlaceByPoi(query);

				case"insertTour":
					ServerLogger.writeNewLine("Insert tour query has been requred by: "+ client);
					return mysql.insertTour(query);

				case"getDataByCityName":
					ServerLogger.writeNewLine("Select city query has been requred by: "+ client);
					return mysql.selectCatalogBycity(query);

				case"selectPOIcoordinate":
					ServerLogger.writeNewLine("Select map query has been requred by: "+ client);
					return mysql.selectPOIcoordinate(query);

				case"selectSpecificPOIcoordinate":
					ServerLogger.writeNewLine("Select map query has been requred by: "+ client);
					return mysql.selectSpecificPOIcoordinate(query);

				case"SearchByFreeText":
					ServerLogger.writeNewLine("Select map query has been requred by: "+ client);
					return mysql.selectMapByFreeText(query);

				 case"getpurchase":
			        ServerLogger.writeNewLine("Select map query has been requred by: "+ client);
		        	return mysql.selectMapByPurchase(query);

				 case"getUserInfo":
			        ServerLogger.writeNewLine("Select user info query has been requred by: "+ client);
		        	return mysql.selectUserInfo(query);

				 case"getHistory":
			        ServerLogger.writeNewLine("Select History Purchases query has been requred by: "+ client);
		        	return mysql.selectHistory(query);

				 case"getReport":
				        ServerLogger.writeNewLine("Select  report data query has been requred by: "+ client);
			        	return mysql.selectReport(query);

				 case"getTourID":
						ServerLogger.writeNewLine("Tour ID query has been requested by: "+ client);
						return mysql.getTourID(query);

					case"selectPid":
						ServerLogger.writeNewLine("Point of Interest ID query has been requested by: "+ client);
						return mysql.selectPid(query);

					case"insertPOIToTour":
						ServerLogger.writeNewLine("Insert POI to tour query has been requested by: "+ client);
						return mysql.insertPOItoTour(query);

					case"getTourByCity":
						ServerLogger.writeNewLine("Tour name by city query has been requested by: "+ client);
						return mysql.getTourByCity(query);

					case"getTourInfo":
						ServerLogger.writeNewLine("Get full tour info query has been requested by: "+ client);
						return mysql.getTourInfo(query);

					case"getPOIbyTour":
						ServerLogger.writeNewLine("Get POIs in Tour query has been requested by: "+ client);
						return mysql.getPOIbyTour(query);

					case"updateIndex":
						ServerLogger.writeNewLine("Update POI Index in Tour query has been requested by: "+ client);
						return mysql.updateIndex(query);

					case"deletePOITour":
						ServerLogger.writeNewLine("Remove POI from Tour query has been requested by: "+ client);
						return mysql.deletePoiFromTour(query);

					case"getOtherPoi":
						ServerLogger.writeNewLine("Get POI's NOT in tour query has been requested by: "+ client);
						return mysql.getOtherPoi(query);

					case"deleteTour":
						ServerLogger.writeNewLine("Delete tour query has been requested by: "+ client);
						return mysql.deleteTour(query);

					case"updateTour":
						ServerLogger.writeNewLine("Update tour info query has been requested by: "+ client);
						return mysql.updateTour(query);
					case"selectAllPOIByCity":
						ServerLogger.writeNewLine("Select all poi of city query has been requred by: "+ client);
						return mysql.selectAllPOIByMap(query);

					case"selectAllCityInfo":
						ServerLogger.writeNewLine("Select all city query has been requred by: "+ client);
						return mysql.selectAllCityInfo(query);

					case"SelectOnlyMapImageWithId":
						ServerLogger.writeNewLine("Select all maps query has been requred by: "+ client);
						return mysql.selectMapImageWithID(query);

					case"selectAllPOI":
						ServerLogger.writeNewLine("Select all poi query has been requred by: "+ client);
						return mysql.selectAllPOI(query);

					case"InsertCustomerPurchase":
						ServerLogger.writeNewLine("Insert customer purchase query has been requred by: "+ client);
						return mysql.InsertCustomerPurchase(query);

					case"InsertCustomerDownload":
						ServerLogger.writeNewLine("Insert customer download query has been requred by: "+ client);
						return mysql.InsertCustomerDownload(query);

					case"selectAllPurchase":
						ServerLogger.writeNewLine("Insert customer purchase query has been requred by: "+ client);
						return mysql.selectAllPurchase(query);

					case"DeleteUserName":
						ServerLogger.writeNewLine("User log out requested: "+ client);
						return mysql.logOutUser(query);
					case"updatePurchaseTable":
						ServerLogger.writeNewLine("Update Purchase Table query has been requred by: "+ client);
						return mysql.updatePurchaseTable(query);
					case"insertSubRenew":
						ServerLogger.writeNewLine("insert Sub Renew query has been requred by: "+ client);
						return mysql.insertSubRenew(query);

					case"SelectPublish":
						ServerLogger.writeNewLine("Select all waiting maps Manager query has been requred by: "+ client);
						return mysql.SelectPublish(query);

					case"SelectPublishall":
						ServerLogger.writeNewLine("Select all waiting maps CEO query has been requred by: "+ client);
						return mysql.SelectPublishall(query);

					case"Updateversion":
						ServerLogger.writeNewLine("Update version query has been requred by: "+ client);
						return mysql.Updateversion(query);

					case"Getnewoldpoi":
						ServerLogger.writeNewLine("Select All new and old POI has been requred by: "+ client);
						return mysql.Getnewoldpoi(query);

					case"Approverate":
						ServerLogger.writeNewLine("Approve map rate has been requred by: "+ client);
						return mysql.Approverate(query);

					case"Approvepoi":
						ServerLogger.writeNewLine("Approve map poi has been requred by: "+ client);
						return mysql.Approvepoi(query);

					case"getExp":
						ServerLogger.writeNewLine("Get expiring subscriptions query has been requred by: "+ client);
						return mysql.getExpSub(query);

					case"getVerUpdate":
						ServerLogger.writeNewLine("Get update notifications query has been requred by: "+ client);
						return mysql.getUpdates(query);

					case"insertNewPOI":
						ServerLogger.writeNewLine("Insert POI query has been requred by: "+ client);
						return mysql.insertNewPOI(query);

					case"getPOIInMap":
						ServerLogger.writeNewLine("Get POI in map query has been requred by: "+ client);
						return mysql.getPOIInMaps(query);

					case"addView":
						ServerLogger.writeNewLine("Add view query has been requred by: "+ client);
						return mysql.addView(query);

					case"getReq":
						ServerLogger.writeNewLine("Pending requests query has been requred by: "+ client);
						return mysql.checkReq(query);
						
					case"updatePOI":
						ServerLogger.writeNewLine("Update POI query has been requred by: "+ client);
						return mysql.updatePOI(query);










				}
		}
		return null;
	}

}
