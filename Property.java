/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: This is the property class. It defines the property object and provides constructors, getters, setters.
 * Due: 11/08/2022
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Daniel Xu
 */

public class Property {



	// declare instance variables
	private String propertyName, city, owner;
	private double  rentalAmount;
	private Plot plot;


	public Property(){
		propertyName = "";
		city = "";
		rentalAmount = 0;
		owner = "";
		this.plot = new Plot(0, 0, 1, 1);
	}

	public Property(String propertyName, String city, double rentalAmount, String owner){
		this.propertyName = propertyName;
		this.city = city;
		this.rentalAmount = rentalAmount;
		this.owner = owner;
		this.plot = new Plot(0, 0, 1, 1);
		System.out.println("New plot is: " + plot);
	}

	public Property(String propertyName, String city, double rentalAmount, String owner, int x, int y, int width, int depth){
		this.propertyName = propertyName;
		this.city = city;
		this.rentalAmount = rentalAmount;
		this.owner = owner;
		this.plot = new Plot(x, y, width, depth);
	}

	public Property(Property otherProperty){
		this.propertyName = otherProperty.propertyName;
		this.city = otherProperty.city;
		this.owner = otherProperty.owner;
		this.rentalAmount = otherProperty.rentalAmount;
		this.plot = otherProperty.plot;

	}
	// Get property name
	public String getPropertyName() {
		return propertyName;
	}

	// Set property name
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	// get city
	public String getCity() {
		return city;
	}

	// set city
	public void setCity(String city) {
		this.city = city;
	}

	// get rental amount
	public double getRentalAmount() {
		return rentalAmount;
	}

	// set rental amount
	public void setRentalAmount(double rentalAmount) {
		this.rentalAmount = rentalAmount;
	}

	// get owner
	public String getOwner() {
		return owner;
	}

	// set owner
	public void setOwner(String owner) {
		this.owner = owner;
	}

	// get plot
	public Plot getPlot() {
		return plot;
	}


	// to string method
	public String toString(){
		String str = "[" + getPropertyName() + "],[" + getCity() + "],[" + getRentalAmount() + "],[" + getOwner() + "]";

		return str;

	}



}
