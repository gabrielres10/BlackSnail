package model;

public class Channel{
	private String name = "BlackSnail";
	private String nit; //tax identification number
	private String website; //website address
	private Subscriber [] subscribers;
	private Address address;
	private Product [] catalogue;

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
		this.catalogue = new Product [85];
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
	* Gets the full catalogue (list of products)
	* @return catalogue, Product [], catalogue of the channel
	*/
	public Product [] getCatalogue() {
		return catalogue;
	}

	/**
	* Gets a specific product from the catalogue
	* @param index, int, index of the element
	* @return product, Product, instance of the product class
	*/
	public Product getProduct(int index) {
		return catalogue[index];
	}

	/**
	* Sets a specific product into the list
	* @param index, int, index of the empty position
	* @param product, Product, instance of the product class
	*/
	public void setProduct(int index, Product product){
		this.catalogue[index] = product;
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
	/**
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
//------------------------------------------------------------------------------------------------- Products section (temporal)

	/**
	* Creates an instance of the class movie into Channel
	* @param director, String, it is the director's name of the movie (For example: James Cameron)
	* @param synopsis, String, it is synopsis of the movie (For example: 
	* En un exuberante planeta llamado Pandora viven los Na'vi, seres que aparentan 
	* ser primitivos pero que en realidad son muy evolucionados. Debido a que el ambiente de Pandora es venenoso, los híbridos humanos/Na'vi, llamados 
	* Avatares, están relacionados con las mentes humanas, lo que les permite moverse libremente por Pandora. Jake Sully, un exinfante de marina 
	* paralítico se transforma a través de un Avatar, y se enamora de una mujer Na'vi.)

	* @param day, int, it is the day of the date (For example: 17)
	* @param month, int, it is the month of the date (For example: 12)
	* @param year, int, it is the year of the date (For example: 2009)
	* @param originalTitle, String, it is the original title of the movie (For example: Avatar)
	* @param minimumAge, int, it is the minimum age allowed to watch the movie (For example: 13)
	* @param productionCompanyName, String, it is production company's name (For example: 20th Century Studios)
	* @param linkOfTrailer, String, it is the link of the trailer (For example: https://www.youtube.com/watch?v=Xg8kYk6uHN0)
	* @param genre, int, it is a number that representates a genre (For example: 2 (Action))
	*/
	public int addProduct(String director, String synopsis, int day, int month, int year, String originalTitle, int minimumAge, String productionCompanyName, String linkOfTrailer, int genre ) {
		boolean flag = false;
		Genre movieGenre = Genre.ROMANCE;
		Date releaseDate = new Date(day, month, year);

		switch (genre){
			case 1: 
				movieGenre = Genre.ROMANCE;
			break; 

			case 2: 
				movieGenre = Genre.ACTION;
			break;

			case 3: 
				movieGenre = Genre.SUSPENSE;
			break;

			case 4:
				movieGenre = Genre.TERROR;
			break;

			case 5:
				movieGenre = Genre.COMEDY;
			break;

		}

		int i = 0;
		
		for (i = 0 ;i < catalogue.length && !flag; i++) {
			if (catalogue[i] == null) {
				setProduct(i, new Movie(director, synopsis, releaseDate, originalTitle, minimumAge, productionCompanyName, linkOfTrailer, movieGenre));
				flag = true;
			}
		}
		

		return i-1;

	}

	/**
	* Creates an instance of the class series
	* @param director, String, it is the director's name of the series (For example: Frank Darabont)
	* @param synopsis, String, it is synopsis of the series (For example:
	* The Walking Dead está basada en un mundo post-apocalíptico repleto de zombis, llamados caminantes, en el que un grupo de supervivientes 
	* debe de luchar por su vida frente a la plaga de estos y los peligros de otros grupos de humanos hostiles.)
	* @param day, int, it is the day of the date (For example: 17)
	* @param month, int, it is the month of the date (For example: 12)
	* @param year, int, it is the year of the date (For example: 2009)
	* @param originalTitle, String, it is the original title of the series 

	* @param protagnistsNames, String [], it is an array of the serie's protagonists
	* @param censorship, int, it is a number that representates a censorship (For example: 1 (Censored))
	* @param censorshipReason, String, it is the reason why the series was censored
	* @return i-1, if this operation is equal to -1, it means that the name in the paramter is already taken, otherwise this operation will be the position where 
	* the product was added
	*/
	public int addProduct(String director, String synopsis, int day, int month, int year, String originalTitle, String [] protagnistsNames, int censorship, String censorshipReason) {
		boolean flag = false;
		Date releaseDate = new Date(day, month, year);
		Censorship seriesCensorship = Censorship.CENSORED;
		switch (censorship){
			case 1: 
				seriesCensorship = Censorship.CENSORED;
			break; 

			case 2: 
				seriesCensorship = Censorship.UNCENSORED;
			break;
		}

		int i = 0;
		
		for (i = 0 ;i < catalogue.length && !flag; i++) {
			if (catalogue[i] == null) {
				setProduct(i, new Series(director, synopsis, releaseDate, originalTitle, protagnistsNames, seriesCensorship, censorshipReason));
				flag = true;
			}
		}
		
		

		return i-1;
	}


	/**
	* @param numberOfSeason, int, it is the number of the season
	* @param amountOfProgrammedEpisodes, int, it is the number of episodes programmed
	* @param linkOfTrailer, String, it is the link of the season's trailer
	* @param releaseDate, Date, it is the date of the serie's release (For example: (mm/dd/y) 31/10/2010)
	* @param day, int, it is the day of the date (For example: 17)
	* @param month, int, it is the month of the date (For example: 12)
	* @param year, int, it is the year of the date (For example: 2009) 
	*/
	public void addSeason(int index,int numberOfSeason, int amountOfProgrammedEpisodes, String linkOfTrailer, int day, int month, int year){
		boolean flag = false;
		Date releaseDate = new Date(day, month, year);
		if (catalogue[index] instanceof Series) {
			Series series = (Series) catalogue[index];
			series.addSeason(new Season (numberOfSeason, amountOfProgrammedEpisodes, linkOfTrailer, releaseDate));
			catalogue[index] = series;
		}
		
	}
	
	/** 
	* Returns the index of the product that matches with the name or title entered as parameter
	* @param title, String, name that will be tried to find
	* @return  matchFound, int, index of the product that matches with the name entered as parameter, the value will be -1 otherwise
	*/
	public int productTitleMatch(String title) {
		int matchFound = -1;
		boolean flag = false;
		String productTitle = "";
		for (int i = 0; i < catalogue.length && !flag; i++ ) {
			if (catalogue[i] != null) {
				productTitle = catalogue[i].getOriginalTitle();
			}
			if (productTitle.equals(title)) {
				matchFound = i;
				flag = true;
			}
		}

		return matchFound;
	}
	
	/**
	* Verifies the existence of at least one registered product
	* @return out, boolean, it is true if exists at least one registered product, false otherwise
	*/
	public boolean verifyExistenceOfAtLeastOneProduct(){
		boolean out = false;
		for (int i = 0; i < catalogue.length; i++ ) {
			if (catalogue[i] != null) {
			out = true;
			}
		}
		return out;
	}

	/**
	* Verifies the existence of at least one registered series
	* @return out, boolean, it is true if exists at least one registered series, false otherwise
	*/
	public boolean verifyExistenceOfAtLeastOneSeries(){
		boolean out = false;
		for (int i = 0; i < catalogue.length; i++ ) {
			if (catalogue[i] != null && catalogue[i] instanceof Series) {
			out = true;
			}
		}
		return out;
	}


	/**
	* Verifies the existence of at least one registered movie
	* @return out, boolean, it is true if exists at least one registered movie, false otherwise
	*/
	public boolean verifyExistenceOfAtLeastOneMovie(){
		boolean out = false;
		for (int i = 0; i < catalogue.length; i++ ) {
			if (catalogue[i] != null && catalogue[i] instanceof Movie) {
			out = true;
			}
		}
		return out;
	}
	

	/**
	* Gets the string of a product
	* @param index, int, index of the product taken as parameter
	* @return toString, String, the string of the product
	*/
	public String getStringOfProduct(int index){
		String toString = catalogue[index].toString();
		String censored = "";

		if (catalogue[index] instanceof Series) {
			Series series = (Series) catalogue[index];
			censored += series.getCensorship();
			if (censored.equals("CENSORED")) {
				toString += " Reason of censorship: " + series.getCensorshipReason();
			}	 
		}
		return toString;
	}

	/**
	* Gets the number of the next season (which has not been created yet)
	* @param index, int, this is the index of the product whose season's number will be got
	* @return numberOfSeason, int, this is the number of the next season
	*/
	public int getNumberOfSeason(int index){
		int numberOfSeason = 0;
		if (catalogue[index] instanceof Series) {
			Series series = (Series) catalogue[index];
			numberOfSeason = series.getSeasonNumber(); 
		}

		return numberOfSeason;
	}

	/**
	* Returns a String with the movies from a category
	* @param genre, int, it is a number that representates a genre (For example: 2 (Action))
	* @return listOfMovies, String, it is a String with the names of the movies from a category
	*/
	public String showMoviesFromACategory(int genre){

		Genre movieGenre = Genre.ROMANCE;
		String listOfMovies = "";
		int n = 0;

		switch (genre){
			case 1: 
				movieGenre = Genre.ROMANCE;
			break; 

			case 2: 
				movieGenre = Genre.ACTION;
			break;

			case 3: 
				movieGenre = Genre.SUSPENSE;
			break;

			case 4:
				movieGenre = Genre.TERROR;
			break;

			case 5:
				movieGenre = Genre.COMEDY;
			break;

		}
		listOfMovies += "List of movies from " + movieGenre + " category: \n";
		for (int i = 0; i < catalogue.length; i++ ) {
			if (catalogue[i] != null && catalogue[i] instanceof Movie) {
				Movie movie = (Movie) catalogue[i];
				if (movie.getGenre().equals(movieGenre)) {
					listOfMovies += " (" + (n+1) + ") " + movie.getOriginalTitle() + "\n";
					n++;
				}
			}
		}
		if (n == 0) {
			listOfMovies = "****There are not movies from " + movieGenre + " category:**** \n";
		}

		return listOfMovies;

	}


	/**
	* Creates a String with the list of all the series
	* @return listOfSeries, String, it is a String with the names of all the series registered
	*/
	public String showAllSeries(){
		String listOfSeries = "";
		int n = 0;
		listOfSeries += "List of all series: \n";
		for (int i = 0; i < catalogue.length; i++ ) {
			if (catalogue[i] != null && catalogue[i] instanceof Series) {
				Series series = (Series) catalogue[i];
				listOfSeries += " (" + (n+1) + ") " + series.getOriginalTitle() + "\n";
				n++;
			}
		}

		return listOfSeries;
	}

	/**
	* Counts the number of series in the catalogue
	* @return amountOfSeries, int, amount of series in the catalogue
	*/
	public int getAmountOfSeries(){
		int amountOfSeries = 0;
		for (int i = 0; i < catalogue.length ; i++ ) {
			if (catalogue[i] != null && catalogue[i] instanceof Series) {
				amountOfSeries++;
			}
		}
		return amountOfSeries;
	}

	/**
	* Creates a String with the information of the last season of a series
	* @param numberOfSeries, int, the index of the series that the user sees in console
	* @return lastSeason, String, it is a String with the information of the last season of the series with the index taken as parameter
	*/
	public String showLastSeason(int numberOfSeries){
		String lastSeason = "";
		int indexOfLastSeason = 0;
		int n = 0;
		int i = 0;
		for (i = 0; i < catalogue.length && n != numberOfSeries; i++ ) {
			if (catalogue[i] != null && catalogue[i] instanceof Series) {
				n++;
			}
		}
		Series series = (Series) catalogue[i-1];
		System.out.println("Indice de la ultima temporada registrada " + series.getSeasonNumber());
		indexOfLastSeason = series.getSeasonNumber() - 2;
		lastSeason += "Information of the last season of the series " + series.getOriginalTitle() + "\n" + series.getSeasonData(indexOfLastSeason);
		return lastSeason;
	}




//----------------------------------------------------------------------------------------------------------------------------

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

























