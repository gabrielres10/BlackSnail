package model;

public class Address{
	private String department;
	private String municipality;
	private String neighborhood;
	private String streetType;
	private int streetNumber;
	private String houseNumber;


	/**
	 * Constructor method that creates an instance of Address class
	 * @param department, String, it is the name of the department (For example: Valle del Cauca)
	 * @param municipality, String, it is the name of the municipality (For example: Cali)
	 * @param neighborhood, String, it is the name of the neighborhood (For example: Pance)
	 * @param streetType, String, it is the type of the street (For example: Calle)
	 * @param streetNumber, int, it is the number of the street (For example: 18)
	 * @param houseNumber, String, it is the number of the property (For example: 122-135)
	 */
	public Address(String department, String municipality, String neighborhood, String streetType, int streetNumber, String houseNumber){
		this.department = department;
		this.municipality = municipality;
		this.neighborhood = neighborhood;
		this.streetType = streetType;
		this.streetNumber = streetNumber;
		this.houseNumber = houseNumber;
	}

	/**
	* Gets the department where the property is located on
	* @return department, String, department of the property
	*/
	public String getDepartment() {
		return department;
	}

	/**
	* Sets the department where the property is located on 
	* @param department, String, department of the property
	*/
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	* Gets the municipality where the property is located on
	* @return municipality, String, municipality of the property
	*/
	public String getMunicipality() {
		return municipality;
	}

	/** 
	* Sets the municipality where the property is located on
	* @param municipality, String, municipality of the property
	*/
	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}

	/**
	* Gets the neighborhood where the property is located on
	* @return neighborhood, String, neighborhood of the property
	*/
	public String getNeighborhood() {
		return neighborhood;
	}

	/**
	* Sets the neighborhood where the property is located on
	* @param neighborhood, String, neighborhood of the property
	*/
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	/**
	* Gets the type of the street of the establishment
	* @return streetType, String, type of street
	*/
	public String getStreetType() {
		return streetType;
	}

	/**
	* Sets the type of the street of the establishment
	* @param streetType, String, type of street
	*/
	public void setStreetType(String streetType) {
		this.streetType = streetType;
	}

	/**
	* Gets the street number where the property is located on
	* @return streetNumber, int, number of the street
	*/
	public int getStreetNumber() {
		return streetNumber;
	}

	/**
	* Sets the street number where the property is located on
	* @param streetNumber, int, number of the street
	*/
	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber; 
	}

	/**
	* Gets the number of the house or property
	* @return houseNumber, String, number of the property
	*/
	public String getHouseNumber() {
		return houseNumber;
	}

	/**
	* Sets the number of the house or property
	* @param houseNumber, String, number of the property
	*/
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}


	/**
	* Creates a string with the information of the address
	* @return a string with the information of the address
	* For example: 
	  Cali, Valle del Cauca
	  Pance, Calle 18 #122-135
	*/
	public String toString() {
		String address = "";
		address += municipality + ", " + department + "\n";
		address += neighborhood + ", " + streetType + " " + streetNumber + " #" + houseNumber + "\n";

		return address;
	}
}












