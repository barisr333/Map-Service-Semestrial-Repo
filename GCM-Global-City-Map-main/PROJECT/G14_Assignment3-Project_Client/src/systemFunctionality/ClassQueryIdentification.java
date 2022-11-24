package systemFunctionality;

import java.util.ArrayList;
import client.MainClient;
import entities.Map;
import javafx.scene.image.Image;
import java.io.InputStream;
import java.sql.Blob;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.sql.rowset.serial.SerialBlob;

// TODO: Auto-generated Javadoc
/**
 * The Class ClassQueryIdentification.
 * This class is responsible for identifying the "answers" returned from the server to the client following a Client->Server request, typically a query.
 * We need to know Client-side what we need to do with the information\query result returned to us, for example - load a combo box or print to a table,
 * and which combo box or in which page. This identification is done using special String identifiers returned from server.
 */
public class ClassQueryIdentification {

	/** The main client. */
	private MainClient mainClient;
	
	/** The class query identification. */
	private static ClassQueryIdentification classQueryIdentification;
	
	/** The client member controller. */
	private ClientMemberController clientMemberController;



	/**
	 * Instantiates a new class query identification.
	 */
	public ClassQueryIdentification() {
		classQueryIdentification = this;
		mainClient = MainClient.GetClient();
		mainClient.SetClassQueryIdentification(this);

	}

	/**
	 * Sets the client member controller.
	 *
	 * @param clientMemberController the new client member controller
	 */
	public void setClientMemberController(ClientMemberController clientMemberController) {
		this.clientMemberController = clientMemberController;
	}

	/**
	 * Gets the class query identification.
	 *
	 * @return the class query identification
	 */
	public static ClassQueryIdentification GetClassQueryIdentification() {
		if(classQueryIdentification == null)
			classQueryIdentification = new ClassQueryIdentification();
		return classQueryIdentification;
	}

	/**
	 * Choose query.
	 *
	 * @param msg the msg
	 */
	public void ChooseQuery(Object msg)
		{
			if (msg instanceof String)
			{

				String TypeWithQuery = (String)msg;
				String[] identification;
				String type;
				String queryResult;

				identification = TypeWithQuery.split(", ", 2);
				type = identification[0];
				queryResult= identification[1];

					switch(type)
					{
					case "RegisterNewClient":
							clientMemberController.RegistrationResult(queryResult);
					break;

					case "RegisterNewClientCreditCard":
							clientMemberController.RegistrationCreditCard();
					break;
					case "UpdateCustomerInfo":
						clientMemberController.reciveUpdateCustomertInfo();
					break;
					case "UpdateEmployeeInfo":
						clientMemberController.reciveUpdateEmployeeInfo();
					break;
					case "UpdateCCInfo":
						//clientMemberController.RegistrationCreditCard();
					break;
					case "insertCity":
						  clientMemberController.city();
					break;
					case "insertInterestedPlace":
						  clientMemberController.InsertInterested();
					break;
					case "insertmap":
						  clientMemberController.aftermapadded();
					break;
					case "updateRates":
						  clientMemberController.rates();
					break;
					case "deletePOI":
						  clientMemberController.placename();
					break;
					case "getMapId":
						 clientMemberController.setMapIdByDesc(queryResult);
					break;

					case "insertTour":
						 clientMemberController.tour();
					break;
					case "insertPOIToTour":
						 clientMemberController.poiConnected();
					break;

					case "updateIndex":
						 clientMemberController.indexUpdated();
					break;

					case "deletePOITour":
						 clientMemberController.poiRemoved();
					break;

					case "deleteTour":
						 clientMemberController.tourDeleted();
					break;

					case "updateTour":
						 clientMemberController.tourUpdated();
					break;
					case "InsertCustomerPurchase":
						 clientMemberController.msgBackFromServerCusPurInfo(queryResult);
					break;
					case "InsertCustomerDownload":
						 clientMemberController.msgBackFromServerCusDownInfo(queryResult);
					break;
					case "DeleteUserName":
						 clientMemberController.userLoggedOut();
					break;
					case "Approvepoi":
						 clientMemberController.msgBackFromServerApprovepoi(queryResult);
					break;
					case "Approverate":
						 clientMemberController.msgBackFromServerApproverate(queryResult);
					break;
					case "getVerUpdate":
						 clientMemberController.notificationsReceived(queryResult);
					break;
					case "insertNewPOI":
						 clientMemberController.insertNewPOI();
					break;

					case "addView":
						 clientMemberController.addView();
					break;

					case "getReq":
						 clientMemberController.reqReturned(queryResult);
					break;
					
					case "UpdatedPOI":
						 clientMemberController.UpdatedPOI();
                    break;








					default:
	    				break;
					}
			}




			if (msg instanceof ArrayList<?>)
			{
				if(((ArrayList<?>)msg).get(0) instanceof String)
				{
				String type = new String();
				type = (String) ((ArrayList<?>) msg).get(0);
				ArrayList<String> queryResult = (ArrayList<String>) msg;
				switch(type)
				{
				case "Login":
						queryResult.remove(0);
						clientMemberController.getLogin(queryResult);
				break;
				case "GetCustomerByUsername":
						queryResult.remove(0);
						clientMemberController.getCustomer(queryResult);
				break;
				case"selectCountry":
					queryResult.remove(0);
					clientMemberController.loadCountryBox(queryResult);
				break;
				case"selectCity":
					queryResult.remove(0);
					clientMemberController.loadCityBox(queryResult);
				break;
				case"selectMap":
					queryResult.remove(0);
					clientMemberController.loadMapsBox(queryResult);
				break;
				case"selectMapRates":
					queryResult.remove(0);
					clientMemberController.loadRates(queryResult);
				break;
				case"selectPOI":
					queryResult.remove(0);
					clientMemberController.loadPlaceName(queryResult);
				break;
				case"guestCatalog":
					queryResult.remove(0);
					clientMemberController.printToTable(queryResult);
				break;
				case"getPoiByCity":
					queryResult.remove(0);
					clientMemberController.loadPlaceNameToCombox(queryResult);
				break;

				case "getDataByCityName":
					 queryResult.remove(0);
					 clientMemberController.loadTable(queryResult);
				break;
				case"selectPOIcoordinate":
					queryResult.remove(0);
					clientMemberController.setMapPlacesByMapID(queryResult);
				break;
				case"selectSpecificPOIcoordinate":
					queryResult.remove(0);
					clientMemberController.setMapCoord(queryResult);
				break;
				case"SearchByFreeText":
					queryResult.remove(0);
					clientMemberController.showTableByFreeText(queryResult);
				break;
				case"getpurchase":
					queryResult.remove(0);
					clientMemberController.showTableBypurchase(queryResult);
				break;
				case"getUserInfo":
					queryResult.remove(0);
					clientMemberController.userInfoReturned(queryResult);
				break;
				case"getHistory":
					queryResult.remove(0);
					clientMemberController.purchaseHistoryReturned(queryResult);
				break;
				case"getReport":
					queryResult.remove(0);
					clientMemberController.PrintDetailsOfMapsBetweenDates(queryResult);
				break;
				case"getTourID":
					queryResult.remove(0);
					clientMemberController.tourIDreceived(queryResult);
				break;
				case"selectPid":
					queryResult.remove(0);
					clientMemberController.POIIDreceived(queryResult);
				case"getTourByCity":
					queryResult.remove(0);
					clientMemberController.TourNamesReceived(queryResult);
				break;
				case"getTourInfo":
					queryResult.remove(0);
					clientMemberController.TourInfoReceived(queryResult);
				break;
				case"getPOIbyTour":
					queryResult.remove(0);
					clientMemberController.loadPOIByTourBox(queryResult);
				break;

				case"getOtherPoi":
					queryResult.remove(0);
					clientMemberController.loadOtherPOIs(queryResult);
				break;
				case"selectAllPOIByCity":
					queryResult.remove(0);
					clientMemberController.setAllPOIByCity(queryResult);
				break;
				case"selectAllCityInfo":
					queryResult.remove(0);
					clientMemberController.setCityEntity(queryResult);
				break;
				case"selectAllPOI":
					queryResult.remove(0);
					clientMemberController.setPOIEntity(queryResult);
					break;
				case"selectAllPurchase":
					queryResult.remove(0);
					clientMemberController.setPurchaseEntity(queryResult);
					break;
				case "SelectPublish":
					queryResult.remove(0);
					clientMemberController.Listwaitingmaps(queryResult);
					break;
				case "SelectPublishall":
					queryResult.remove(0);
					clientMemberController.Listwaitingrates(queryResult);
					break;
				case "Listofoldpoi":
					queryResult.remove(0);
					clientMemberController.Listofoldpoi(queryResult);
					break;
				case "Listofnewpoi":
					queryResult.remove(0);
					clientMemberController.Listofnewpoi(queryResult);
				case "Listofnewoldpoi":
					queryResult.remove(0);
					clientMemberController.Listofnewoldpoi(queryResult);
					break;

				case "getExp":
					queryResult.remove(0);
					clientMemberController.expSubsReceived(queryResult);
					break;

				case "getPOIInMap":
					queryResult.remove(0);
					clientMemberController.POIInMapRet(queryResult);
					break;


				default:
    			break;
				}
				}
				else{
					ArrayList<Object> queryResult1 = (ArrayList<Object>) msg;
					clientMemberController.setMapEntity(queryResult1);

				}

			}

			if(msg instanceof byte[])
			{
				byte[] original = (byte[])msg;
				byte[] type = Arrays.copyOfRange(original, 0, 1);
				byte[] image = Arrays.copyOfRange(original, type.length, original.length);

				switch(type[0])
				{
				case 1:
					try {
						clientMemberController.setImageFromDB(image);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				default:
    				break;
				}


			}

		}
}
