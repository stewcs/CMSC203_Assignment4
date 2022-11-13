/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: This is the management class. It defines the property object and provides constructors, getters, setters. It has multiple utility methods 
 * such as deleting the last property in the array, adding a property to the array, returning the total rent of the array, and more.
 * Due: 11/10/2022
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Daniel Xu
 */



public class ManagementProperty {


	// instance variables
	private String name;
	private String taxID;
	private double fee;

	static final int MAX_PROPERTY = 5;
	private static final int MGMT_DEPTH = 10;
	private static final int MGMT_WIDTH = 10;

	private Property[] properties;
	private Plot plot;
	private double numberOfProperties;


	// constructor 1
	// Creates a ManagementCompany object using empty strings, creates a default Plot with maximum width and depth and it initializes the properties array.
	public ManagementProperty() {
		this.name = "";
		this.taxID = "";
		this.plot = new Plot(0, 0, 1, 1);
		this.properties = new Property[MAX_PROPERTY];
	}

	// constructor 2
	// Creates a ManagementCompany object using the given values, creates a default Plot with maximum width and depth and it initializes the properties array.
	public ManagementProperty(String name, String taxID, double fee) {
		this.name = name;
		this.taxID = taxID;
		this.fee = fee;
		this.plot = new Plot(0, 0, 1, 1);
		this.properties = new Property[MAX_PROPERTY];
	}


	// constructor 3
	// Creates a ManagementCompany object using the given values creates a Plot using the given values and it initializes the properties array.
	public ManagementProperty(String name, String taxID, double fee, int x, int y, int width, int depth) {
		this.name = name;
		this.taxID = taxID;
		this.fee = fee;
		this.plot = new Plot(x, y, width, depth);
		this.properties = new Property[MAX_PROPERTY];
	}

	// constructor 4
	// Creates a new ManagementCompany copy of the given ManagementCompany.
	public ManagementProperty(ManagementProperty otherCompany) {
		this.name = otherCompany.name;
		this.taxID = otherCompany.taxID;
		this.fee = otherCompany.fee;
		this.plot = otherCompany.plot;
		this.properties = otherCompany.properties;
	}

	//getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTaxID() {
		return taxID;
	}

	public void setTaxID(String taxID) {
		this.taxID = taxID;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	public Property[] getProperties() {
		return properties;
	}

	public void setProperties(Property[] properties) {
		this.properties = properties;
	}

	public Plot getPlot() {
		return plot;
	}

	public void setPlot(Plot plot) {
		this.plot = plot;
	}

	public double getNumOfProp() {
		return numberOfProperties;
	}

	public void setNumOfProp(double numOfProp) {
		this.numberOfProperties = numOfProp;
	}

	// overload 1
	// Creates a property object by copying from another property and adds it to the properties array.
	public int addProperty(Property property){

		int val = 0;

		if (property == null) { // if property is empty, we can't copy that. return -2
			return -2;
		}


		int store = -1;

		Property newProp = new Property(property);



		if (properties[properties.length-1] != null){ // if array is full, we can't add property. return -1
			val = -1;
		} 

		else {	

			for (int index = 0; index < properties.length; index++){ // validates array has space for new property and returns index of that location.
				if(properties[index] == null) {
					store = index;
					break;
				}
			}
			properties[store] = newProp;
			val = store;

			for  (int i = 0; i < MAX_PROPERTY; i++){ // create a loop that loops through length of array (5)

				if(properties[i] != null) { 

					if (properties[i].getPlot().overlaps(newProp.getPlot())) { // if plot for the property overlaps any other property’s plot, return -4
						val = -4;

					} else if(properties[i].getPlot().encompasses(newProp.getPlot())) { // if plot for property not encompassed by management plot, return -3
						val = -3;
					}
				}	
			}

		}
		return val;
	}

	// overload 2. Because the first version of addproperties already does all the checks and nuances, overload 2 and 3 can simply call the original method.
	// Adds a new property to the properties array, this method should call an appropriate existing overloaded method. 
	public int addProperty(String name, String city, double rentalAmount, String owner) {


		Property newProp = new Property(name, city, rentalAmount, owner);

		return addProperty(newProp);
	}

	// overload 3. Because the first version of addproperties already does all the checks and nuances, overload 2 and 3 can simply call the original method.
	// Adds a new property to the properties array, this method should call an appropriate existing overloaded method.
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {

		Property newProp = new Property(name, city, rent, owner, x, y,  width, depth);

		return addProperty(newProp);
	}


	// Checks if the management company has a valid (between 0-100) fee
	public boolean isManagementFeeValid(){

		if(fee > 0 && fee < 100) // checks if fee is greater than 0 or less than 100
			return true; // return true if fee is valid
		else
			return false; // return false if fee is not valid

	}

	// Checks if the properties array has reached the maximum capacity
	public boolean isPropertiesFull() {

		if (properties[properties.length-1] != null) // checks that the last spot of array not null, therefore it is full
			return true; // return true as the last spot of array is not null, meaning it is full
		return false; // return false as the last spot of array is null, meaning it is not full


	}

	// Removes(nullifies) the LAST property in the properties array
	public void removeLastProperty() {

		if(properties[0] != null) { // make sure array is not null otherwise this method makes no sense


			int index = getPropertiesCount(); // get index for location of last property in array
			properties[index] = null; // set last property in array to null
		}
	}


	// return total rent of the properties in the property array
	public double getTotalRent(){

		int total = 0; 

		for (int i = 0; i < properties.length; i++){ // loop through array
			if(properties[i] != null) // make sure there is a property
				total += properties[i].getRentalAmount(); // add to total
		}
		return total; // return the total
	}

	// Gets the number of existing properties in the array
	public int getPropertiesCount() {

		int value = -1; // create a value to store the index of the last property

		for (int index = 0; index < properties.length; index++)
			if(properties[index] != null)
				value = index;

		return (value + 1); // value stores the index of the last property, but we must add one to actually get the real number, because index starts at 0.

	}


	public Property getHighestRentPropperty() {

		double value = -1; // holding current highest rent
		int highestRent = -1; // saves the index of property with highest rent

		for (int index = 0; index < properties.length; index++) // loop through entire array 
			if(properties[index] != null) // makes sure the index we are checking is not null/has a property
				if (properties[index].getRentalAmount() > value) {	// checks if current index property rent is greater than current highest value			
					value = properties[index].getRentalAmount(); // sets current highest value to the current index property rent
					highestRent = index; // saves the index of the property with the highest value, this will be returned
				}
		return properties[highestRent];
	}

	// to string
	public String toString(){

		String str = ""; // create empty string to hold result

		for (int i = 0; i < properties.length; i++){ // loop through array
			if(properties[i] != null) // make sure there is a property
				str += properties[i].toString(); // concatenate the info to Str.

		}

		return str; // return to String.
	}



}
