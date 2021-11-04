package model;

public class Subscriber {

	private String identificationCard; //the identification card of the subscriber is unique and requires a validation to ensure this is the case
	private String name;
	private int age;
	private int hours; //hours that the subscriber is disposed to spend to consume content
	private Status status; //the status of the subscriber can be ACTIVE or INACTIVE
	private Type clientType; //the type of the client can be NORMAL, PLATINUM GOLD or DIAMOND

	/**
	 * Constructor method that creates an instance of subscriber class
	 * @param identificationCard, String, it is the identification of the subscriber (For example: 1006171667)
	 * @param name, String, it is the full name of the subscriber (For example: Gabriel Restrepo)
	 * @param age, int, it is the age of the subscriber (For example: 18)
	 * @param hours, int, it is the amount of hours the subscriber is diposed to spend to consume audiovisual content (For example: 8)
	 * @param clientType, Type, is the type of client of the subscriber, it can be NORMAL, PLATINUM, GOLD or DIAMOND (For example: NORMAL)
	 */
	public Subscriber(String identificationCard, String name, int age, int hours, Type clientType){
		this.identificationCard = identificationCard;
		this.name = name;
		this.age = age;
		this.hours = hours;
		this.status = Status.ACTIVE;
		this.clientType = clientType;

	}

	/**
	* Gets the identification number of the subscriber
	* @return identificationCard, String, identification number of the subscriber 
	*/
	public String getIdentificationCard(){
		return identificationCard;
	}

	/**
	* Sets the identification number of the subscriber
	* @param identificationCard, String, identification number of the subscriber
	*/
	public void setIdentificationCard(String identificationCard){
		this.identificationCard = identificationCard;
	}

	/**
	* Gets the name
	* @return name, String, name of the subscriber
	*/
	public String getName(){
		return name;
	}

	/**
	* Sets the name of the subscriber
	* @param name, String, name of the subscriber
	*/
	public void setName(String name){
		this.name = name;
	}

	/**
	* Gets the age of the subscriber
	* @return age, int, age of the subscriber
	*/
	public int getAge(){
		return age;
	}

	/**
	* Sets the age of the subscriber
	* @param age, int, age of the subscriber
	*/
	public void setAge(int age){
		this.age = age;
	}

	/**
	* Gets the amount of hours the subscriber is diposed to spend to consume audiovisual content
	* @return hours, amount of hours the subscriber is diposed to spend to consume audiovisual content
	*/
	public int getHours(){
		return hours;
	}

	/**
	* Sets the amount of hours the subscriber is diposed to spend to consume audiovisual content
	* @param hours, int, amount of hours the subscriber is diposed to spend to consume audiovisual content
	*/
	public void setHours(int hours){
		this.hours = hours;
	}

	/**
	* Gets the status of the subscriber
	* @return status, Status, status of the subscriber
	*/
	public Status getStatus(){
		return status;
	}

	/**
	* Sets the status of the subscriber
	* @param status, Status, status of the subscriber
	*/
	public void setStatus(Status status){
		this.status = status;
	}

	/**
	* Gets the type of client of the subscriber
	* @return clietType, Type, Type of client of the subscriber
	*/
	public Type getClientType(){
		return clientType;
	}

	/**
	* Sets the type of clietn of the subscriber
	* @param clientType, Type, type of client of the subscriber
	*/
	public void setClientType(Type clientType){
		this.clientType = clientType;
	}

	/**
	* Creates a string with the information of the instance of the class
	* @return a string with the information of the subscriber
	* For example: 
	* Information of the subscriber: 
	   Name: Gabriel Restrepo
	   Age: 18 years old
	   Hours to spend in consuming content: 8 hours
	   Status: ACTIVE
	   Type of client: NORMAl
	*/
	public String toString(){
		String subscriber = "";

		subscriber += "Information of the subscriber: \n";
		subscriber += " Name: " + name + "\n";
		subscriber += " Age: " + age + " years old \n";
		subscriber += " Hours to spend in consuming content: " + hours + " hours\n";
		subscriber += " Status: " + status + "\n";
		subscriber += " Type of client: " + clientType;

		return subscriber;
	}
}