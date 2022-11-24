package systemFunctionality;

import java.time.LocalDate;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;

// TODO: Auto-generated Javadoc
/**
 * The Class ValidationTests.
 * Contains pre-existing input validation tests that are necessary to perform repeatedly throughout the system, such as checking names, checking that any
 * text field is not empty, etc.
 * The static methods provide an easy way to perform the checks and prevent code duplication throughout the system.
 * Also contains dynamic methods that receive header and message strings and print the required pop-up notification window to the UI.
 */
public class ValidationTests {

	/**
	 * Instantiates a new validation tests.
	 */
	public ValidationTests() {
	}

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
	 * Checks if is email valid.
	 *
	 * @param email the email
	 * @return true, if is email valid
	 */
	public static boolean isEmailValid(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        if(!email.matches(regex)) {
        	Alert alert = new Alert(AlertType.ERROR);
    		 alert.setTitle("Email invalid");
    		 alert.setHeaderText("Email address is not valid");
    		 alert.showAndWait();
    		 return false;
        }
        return email.matches(regex);
     }


    /**
     * Checks if is CC valid.
     *
     * @param num the num
     * @param cvv the cvv
     * @return true, if is CC valid
     */
    public static boolean isCCValid(String num, String cvv)
    {
    	if(!(QueryCreator.isNumeric(num) && num.length()>=13 && num.length()<=16))
    	{
    		Alert alert = new Alert(AlertType.ERROR);
     		 alert.setTitle("Payment invalid");
     		 alert.setHeaderText("Credit Card number must be between 13 and 16 digits");
     		 alert.showAndWait();
    		  return false;
    	}
       if(!(QueryCreator.isNumeric(cvv) && cvv.length()==3))
       {
    	   Alert alert = new Alert(AlertType.ERROR);
   		 alert.setTitle("Payment Invalid");
   		 alert.setHeaderText("CVV must be 3 digits");
   		 alert.showAndWait();
  		  return false;
       }
    return true;
    }



    /**
     * Checks if is username valid.
     *
     * @param username the username
     * @return true, if is username valid
     */
    public static boolean isUsernameValid(String username)
    {
 	   if(username.length()>12)
 	   {
      	 Alert alert = new Alert(AlertType.ERROR);
  		 alert.setTitle("Invalid Username");
  		 alert.setHeaderText("Username length cannot be more than 12");
  		 alert.showAndWait();
 		  return false;
 	   }

 	   for(int i=0;i<username.length();i++)
 		  if(!Character.isLetter(username.charAt(i)) && !Character.isDigit(username.charAt(i) ) && !Character.isWhitespace(username.charAt(i))) {

 			 Alert alert = new Alert(AlertType.ERROR);
 	  		 alert.setTitle("Invalid Username");
 	  		 alert.setHeaderText("Username can only contain letters and digits");
 	  		 alert.showAndWait();
 			 return false;
 		   }

 	   // TODO - check if Username exists

 	   return true;
    }


    /**
     * Checks if is valid password.
     *
     * @param password the password
     * @return true, if is valid password
     */
    public static boolean isValidPassword(String password) {

        if (password.length() < 6 || password.length() > 12)
        {
        	 Alert alert = new Alert(AlertType.ERROR);
    		 alert.setTitle("Invalid Password");
    		 alert.setHeaderText("Password length must be between 6 and 12");
    		 alert.showAndWait();
    		 return false;
        }
        for(int i=0;i<password.length();i++)
        	  if(!Character.isLetter(password.charAt(i)) && !Character.isDigit(password.charAt(i)))
        	  {
        	 Alert alert = new Alert(AlertType.ERROR);
    		 alert.setTitle("Invalid Password");
    		 alert.setHeaderText("Password can only contain letters and digits");
    		 alert.showAndWait();
        	 return false;

        	  }

        return true;
        }



    /**
     * Checks if is address valid.
     *
     * @param address the address
     * @return true, if is address valid
     */
    public static boolean isAddressValid(String address)
    {
 	   if(address.length()>20) {
 		  Alert alert = new Alert(AlertType.ERROR);
		 alert.setTitle("Invalid Address");
		 alert.setHeaderText("Address length cannot be more than 20");
		 alert.showAndWait();
	     return false;
 	   }
 		 for(int i=0;i<address.length();i++)
 			 if(!Character.isLetter(address.charAt(i)) && !Character.isDigit(address.charAt(i)) && !Character.isWhitespace(address.charAt(i))) {
 			  Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Invalid Address");
				alert.setHeaderText("Address can only contain letters and digits");
				alert.showAndWait();
				return false;
 		   }

 	   return true;
    }



    /**
     * Checks if is first name valid.
     *
     * @param firstname the firstname
     * @return true, if is first name valid
     */
    public static boolean isFirstNameValid(String firstname)
    {
 	   if(firstname.length()>20)
 	   {
 		  Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Invalid name");
			alert.setHeaderText("First Name length cannot be more than 20");
			alert.showAndWait();
 		   return false;
 	   }
 	   for(int i=0;i<firstname.length();i++)
 		   if (!Character.isLetter(firstname.charAt(i)) && !Character.isWhitespace(firstname.charAt(i)))
 		   {
 			  Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Invalid name");
				alert.setHeaderText("First Name can only contain letters");
				alert.showAndWait();
 			   return false;
 		   }
 	   return true;
    }


    /**
     * Checks if is last name valid.
     *
     * @param lastname the lastname
     * @return true, if is last name valid
     */
    public static boolean isLastNameValid(String lastname)
    {
 	   if(lastname.length()>20)
 	   {
 		  Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Invalid name");
			alert.setHeaderText(" Last Name length cannot be more than 20");
			alert.showAndWait();
 		   return false;
 	   }
 	   for(int i=0;i<lastname.length();i++)
 		  if (!Character.isLetter(lastname.charAt(i)) && !Character.isWhitespace(lastname.charAt(i)))
 		   {
 			  Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Invalid name");
				alert.setHeaderText(" Last Name can only contain letters");
				alert.showAndWait();
 			   return false;
 		   }
 	   return true;
    }

    /**
     * Checks if is city name valid.
     *
     * @param cityname the cityname
     * @return true, if is city name valid
     */
    public static boolean isCityNameValid(String cityname)
    {


 	   for(int i=0;i<cityname.length();i++)
 		   if (!Character.isLetter(cityname.charAt(i)) && !Character.isWhitespace(cityname.charAt(i)))
 		   {
 			    Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Invalid city name");
				alert.setHeaderText("City Name can only contain letters and spaces");
				alert.showAndWait();
 			   return false;
 		   }

 	   return true;
    }

    /**
     * Checks if is field empty.
     *
     * @param input the input
     * @return true, if is field empty
     */
    public static boolean isFieldEmpty(String input)
    {
    		if (input.isEmpty())
    		{
    			Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Empty field");
				alert.setHeaderText("Please fill all fields");
				alert.showAndWait();
 			    return true;
    		}
    		return false;
    }

    /**
     * Checks if is rate double.
     *
     * @param input the input
     * @return true, if is rate double
     */
    public static boolean isRateDouble(String input)
    {
    	try
    	{
    		Double.parseDouble(input);
    	}
    	catch(Exception e)
    	{
    		Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Invalid input");
			alert.setHeaderText("Rates must be numbers!");
			alert.showAndWait();
    		return false;
    	}
    	return true;
    }

    /**
     * Checks if is phone num valid.
     *
     * @param input the input
     * @return true, if is phone num valid
     */
    public static boolean isPhoneNumValid(String input)
    {
    	if(input.length()<9 || input.length()>10 || !isNumeric(input))
    	{
    		printErrorMsg("Error", "Phone number must be 9-10 DIGITS!");
    		return false;
    	}
    	return true;

    }

    /**
     * Checks if is CC date valid.
     *
     * @param date the date
     * @return true, if is CC date valid
     */
    public static boolean isCCDateValid(LocalDate date)
    {
    	if(LocalDate.now().isAfter(date))
    	{
    		printErrorMsg("Error", "Credit card has expired!");
    		return false;
    	}
    	return true;
    }

    /*Message methods*/

    /**
     * Prints the info msg.
     *
     * @param header the header
     * @param msg the msg
     */
    public static void printInfoMsg(String header, String msg)
    {
    	 Alert alert = new Alert(AlertType.INFORMATION);
 		 alert.setTitle(header);
 		 alert.setHeaderText(msg);
 		 alert.showAndWait();
    }

    /**
     * Prints the error msg.
     *
     * @param header the header
     * @param msg the msg
     */
    public static void printErrorMsg(String header, String msg)
    {
    	Alert alert = new Alert(AlertType.ERROR);
		 alert.setTitle(header);
		 alert.setHeaderText(msg);
		 alert.showAndWait();
    }

    /**
     * Prints the confirm msg.
     *
     * @param header the header
     * @param msg the msg
     * @return true, if successful
     */
    public static boolean printConfirmMsg(String header, String msg)
    {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
		 alert.setTitle(header);
		 alert.setHeaderText(msg);
		 alert.showAndWait();
		 if(alert.getResult()==ButtonType.OK)
			 return true;
		 return false;
    }





}
