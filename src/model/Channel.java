package model;

public class Channel{
	private String name = "BlackSnail";
	private String nit; //tax identification number
	private String website; //website address
	private Subscriber [] subscribers;
	private Address address;

	/**
	* Constructor method that creates an instance of subscriber class
	* @param name, String, it is the name of the channel (its default value is "BlackSnail")
	* @param nit, String, it is the tax identification number of the channel (For example: 123456789)
	* @param website, String, it is the website address of the channel (For example: www.blacksnail.com)
	*/
	public Channel(String name, String nit, String website){
		this.name = name;
		this.nit = nit;
		this.website = website;
		this.subscribers = new Subscriber[50];
	}

	/**
	* Gets the name of the channel
	* @return name, String, name of the channel
	*/
	public String getName() {
		return name;
	}

	/**
	* Sets the name of the channel
	* @param name, String, name of the channel
	*/
	public void setName(String name) {
		this.name = name;
	}

	/**
	* Gets the nit of the channel
	* @return nit, String, tax identification number
	*/
	public String getNit() {
		return nit;
	}

	/**
	* Sets the nit of the channel
	* @param nit, String, tax identification number
	*/
	public void setNit(String nit) {
		this.nit = nit;
	}

	/**
	* Gets the website address
	* @return website, String, address of the website
	*/
	public String getWebsite() {
		return website;
	}

	/**
	* Sets the website address
	* @param website, String, address of the website
	*/
	public void setWebsite(String website) {
		this.website = website;
	}

	/**
	* Gets subscriber list
	* @return subscribers, Subscriber [], list of subscribers
	*/
	public Subscriber [] getSubscriberList() {
		return subscribers;
	}

	/**
	* Gets a specific subscriber from the list
	* @param index, int, index of the element
	* @return subscriber, Subscriber, element of the subscribers list
	*/
	public Subscriber getSubscriber(int index) {
		Subscriber subscriber = subscribers[index];
		return subscriber;
	}

	/**
	Sets a specific subscriber into the list
	* @param index, int, index of the empty position
	* @param subscriber, Subscriber, instance of the subscriber class
	*/
	public void setSubscriber(int index, Subscriber subscriber) {
		this.subscribers[index] = subscriber;
	}

	/** 
	* Gets the address of the channel
	* @return address, Address, address of the channel
	*/
	public Address getAddress() {
		return address;
	}

	/**
	* Sets the address of the channel
	* @param address, Address, address of the channel
	*/
	public void setAddress(Address address) {
		this.address = address;
	}


	/**
	* Verifies the existence of at least one registered subscriber
	* @return out, boolean, it is true if exists at least one registered subscriber, false otherwise
	*/
	public boolean verifyExistenceOfAtLeastOneSubscriber() {
		boolean out = false;
		for (int i = 0; i < subscribers.length; i++ ) {
			if (subscribers[i] != null) {
			out = true;
			}
		}
		return out;
	}


	/**
	* Verifies the existence of a repeated identification card
	* @param identificationCard, String, Potential identification card for a new subscriber
	* @return out, booolean, it is true if exists a match to the identification card entered as parameter, false otherwise
	*/
	public boolean verifyRepeatedCard(String identificationCard){
		boolean out = false;
		for (int i = 0; i < subscribers.length; i++ ) {
			if (subscribers[i] != null) {
				if (subscribers[i].getIdentificationCard().equals(identificationCard)) {
					out = true;
				}
			}
		}

		return out;
	}


	/**
	* Creates instances of the class subscriber into the first empty position of the list of subscribers, and returns 
	* a boolean false if there are not empty positions
	* @param identificationCard, String, it is the identification of the subscriber (For example: 1006171667)
	* @param name, String, it is the full name of the subscriber (For example: Gabriel Restrepo)
	* @param age, int, it is the age of the subscriber (For example: 18)
	* @param hours, int, it is the amount of hours the subscriber is diposed to spend to consume audiovisual content (For example: 8)
	* @param type, int, is the number that corresponds to one type of client of the subscriber, it can be 1 (NORMAL), 2 (PLATINUM),3 (GOLD) or 4 (DIAMOND) (For example: 1(NORMAL))
	* @return flag, boolean, true if the subscriber was added successfully, false if there are not empty positions to add 
	* the new subscriber
	*/
	public boolean addSubscriber(String name, String identificationCard, int age, int hours, int type){
		boolean flag = false;
		Type clientType = Type.NORMAL;

		switch (type){
			case 1: 
				clientType = Type.NORMAL;
			break; 

			case 2: 
				clientType = Type.PLATINUM;
			break;

			case 3: 
				clientType = Type.GOLD;
			break;

			case 4:
				clientType = Type.DIAMOND;
			break;

		}

		for (int i = 0 ;i < subscribers.length && !flag; i++) {
			if (subscribers[i] == null) {
				setSubscriber(i, new Subscriber(identificationCard, name, age, hours, clientType));
				flag = true;
			}
		}
		
		return flag;
	}
	/*
	* Creates an instance of the class address into Channel
	* @param department, String, it is the name of the department (For example: Valle del Cauca)
	* @param municipality, String, it is the name of the municipality (For example: Cali)
	* @param neighborhood, String, it is the name of the neighborhood (For example: Pance)
	* @param streetType, String, it is the type of the street (For example: Calle)
	* @param streetNumber, int, it is the number of the street (For example: 18)
	* @param houseNumber, String, it is the number of the property (For example: 122-135)
	*/
	public void addAddress(String department, String municipality, String neighborhood, String streetType, int streetNumber, String houseNumber){
		setAddress(new Address(department, municipality, neighborhood, streetType, streetNumber, houseNumber));
	}


	/**
	* Returns the amount of active subscribers
	* @return activeSubscribers, int, number of active subscribers
	*/
	public int getActiveSubscribersNumber() {
		int activeSubscribers = 0;
		Status status = Status.ACTIVE;
		for (int i = 0; i<subscribers.length; i++) {
			if (subscribers[i] != null && subscribers[i].getStatus().equals(status)) {
				activeSubscribers++;
			}
		}

		return activeSubscribers;
	}


	/**
	* Returns the amount of active subscribers that have a NORMAL subscription
	* @return activeNormalSubscribers, int, number of active subscribers that have a normal subscription
	*/
	public int getActiveNormalSubscribersNumber() {
		int activeNormalSubscribers = 0;
		Type type = Type.NORMAL;
		Status status = Status.ACTIVE;
		for (int i = 0; i<subscribers.length; i++) {
			if (subscribers[i] != null && subscribers[i].getStatus().equals(status) && subscribers[i].getClientType().equals(type)) {
				activeNormalSubscribers++;
			}
		}

		return activeNormalSubscribers;
	}


	/**
	* Returns the amount of active subscribers that have a PLATINUM subscription
	* @return activePlatinumSubscribers, int, number of active subscribers that have a platinum subscription
	*/
	public int getActivePlatinumSubscribersNumber() {
		int activePlatinumSubscribers = 0;
		Type type = Type.PLATINUM;
		Status status = Status.ACTIVE;
		for (int i = 0; i<subscribers.length; i++) {
			if (subscribers[i] != null && subscribers[i].getStatus().equals(status) && subscribers[i].getClientType().equals(type)) {
				activePlatinumSubscribers++;
			}
		}

		return activePlatinumSubscribers;
	}


	/**
	* Returns the amount of active subscribers that have a GOLD subscription
	* @return activeGoldSubscribers, int, number of active subscribers that have a gold subscription
	*/
	public int getActiveGoldSubscribersNumber() {
		int activeGoldSubscribers = 0;
		Type type = Type.GOLD;
		Status status = Status.ACTIVE;
		for (int i = 0; i<subscribers.length; i++) {
			if (subscribers[i] != null && subscribers[i].getStatus().equals(status) && subscribers[i].getClientType().equals(type)) {
				activeGoldSubscribers++;
			}
		}

		return activeGoldSubscribers;
	}


	/**
	* Returns the amount of active subscribers that have a DIAMOND subscription
	* @return activeDiamondSubscribers, int, number of active subscribers that have a diamond subscription
	*/
	public int getActiveDiamondSubscribersNumber() {
		int activeDiamondSubscribers = 0;
		Type type = Type.DIAMOND;
		Status status = Status.ACTIVE;
		for (int i = 0; i<subscribers.length; i++) {
			if (subscribers[i] != null && subscribers[i].getStatus().equals(status) && subscribers[i].getClientType().equals(type)) {
				activeDiamondSubscribers++;
			}
		}

		return activeDiamondSubscribers;
	}


	/** 
	* Returns the index of the subscriber that matches with the ID entered as parameter
	* @return  matchFound, int, index of the subscriber that matches with the ID entered as parameter, the value will be -1 otherwise
	*/
	public int identificationCardMatch(String identificationCard) {
		int matchFound = -1;
		boolean flag = false;
		String id = "";
		for (int i = 0; i<subscribers.length && !flag ;i++ ) {
			if (subscribers[i] != null) {
				id = subscribers[i].getIdentificationCard();
			}
			if (id.equals(identificationCard)) {
				matchFound = i;
				flag = true;
			}
		}
		return matchFound;
	}


	/**
	* Deactivates a specific subscriber
	* @param index, int, index of the subscriber that will be deactivated
	*/
	public void deactivateSubscriber(int index){
		Status status = Status.INACTIVE;
		Type type = Type.DIAMOND;
		subscribers[index].setStatus(status);
		subscribers[index].setClientType(type);
	}



	/**
	* Gets the subscriber with most hours of consumption
	* @return index, int, index of the subscriber with most hours of consumption
	*/
	public int getMostHoursOfContentConsumption(){
		int index = -1;
		int mostHours = 0;

		for (int i = 0; i < subscribers.length; i++ ) {
			if ( subscribers[i] != null && subscribers[i].getAge() < 18 && subscribers[i].getHours() > mostHours) {
				index = i;
				mostHours = subscribers[i].getHours();
			}
		}

		return index;
	}


	/**
	* Gets the string of a subscriber
	* @param index, int, index of the subscriber taken as parameter
	* @return toString, String, the string of the subscriber
	*/
	public String getStringOfSubscriber(int index){
		String toString = subscribers[index].toString();

		return toString;
	}


	/**
	* Creates a string with the information of the channel
	* @return channel, String, string with the information of the channel
	* For example:
	* ***Information of the Channel***
	   Name: BlackSnail
	   WebSite: www.blacksnail.com
	   Subscribers: 12
	     NORMAL: 3
	     PLATINUM: 3
	     GOLD: 3
	     DIAMOND: 3
	*/
	public String toString(){
		String channel = "";
		channel += "***Information of the Channel*** \n";
		channel += " Name: " + name + "\n";
		channel += " NIT: " + nit + "\n";
		channel += " Website: " + website + "\n";
		channel += " Subscribers: " + getActiveSubscribersNumber() + "\n";
		channel += "   NORMAL: "+ getActiveNormalSubscribersNumber() + "\n";
		channel += "   PLATINUM: " + getActivePlatinumSubscribersNumber()+ "\n";
		channel += "   GOLD: " + getActiveGoldSubscribersNumber()+ "\n";
		channel += "   DIAMOND: " + getActiveDiamondSubscribersNumber()+ "\n";
		return channel;
	}


}

























