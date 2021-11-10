package ui;

import java.util.Scanner;
import model.Channel;
/**
* This is the main class, it allows the user to interact with the program
* @author Gabriel Restrepo
*/
public class BlackSnail {
	private Channel myChannel;
	private Scanner sc;

	/**
	* Constructor method of the class BlackSnail
	*/
	public BlackSnail() {
		sc = new Scanner(System.in);
	}


	/**
	 * Main method. **Description of the program**
	 * @param args The command line arguments.
	 **/
	public static void main(String[] args) {
		
		BlackSnail bs = new BlackSnail();


		System.out.println("Starting app...");

		int option = 0;
		bs.createChannel();
		do{
			option = bs.showMenu();
			bs.executeOperation(option);
		}while(option != 0);

	}

	/**
	* Shows the main menu to the user and returns its answer
	* @return option, int, the number of the option chosen by the user
	*/
	public int showMenu(){
		int option = 0;

		System.out.println(
			"Main menu, choose an option with a number: \n" + 
			"(1) Subscriber management \n" +
			"(2) Catalogue management \n" +
			"(3) Services \n" +
			"(0) Exit <-"
			);
		option = askForNumber();
		return option;
	}

	/**
	* Executes the operation chosen by the user, according the number of the option
	* @param operation, int, the number of the option chosen by the user
	* @return option, int, variable with the option selected by the user
	*/
	public void executeOperation(int operation) {
		int option;
		switch(operation) {
		case 0:
			System.out.println("Bye!");
			break;
		case 1:
			do{
				option = showMenuSubscriber();
			}while(option != 0);
			
			break;
		case 2:
			do{
			option = showMenuCatalogue();
			}while(option != 0);
			
			break;
		case 3:
			showMenuServices();
			break;
		
		default:
			System.out.println(" Warning!, invalid option");
		
		}
	}


	/**
	* Shows the menu of the subscriber management, and executes the option chosen by the user
	*/
	public int showMenuSubscriber() {
		int option = 0;
		System.out.println(
			"SUBSCRIBER MENU, select an option \n" +
			"(1) Add a new subscriber \n" +
			"(2) Deactivate a subscriber \n" +
			"(3) Show active subscribers \n" +
			"(4) Young subscriber with most hours of content consumption \n" +
			"(0) <- Back"
			);
		option = askForNumber();

		switch(option) {
		case 1:
			registerSubscriber();
			break;
		case 2:
			deactivateSubscriber();
			break;
		case 3: 
			showActiveSubscribers();
			break;
		case 4:
			showMostHoursOfContentConsumption();
			break;
		}

		return option;
	}


	/**
	* Creates a channel with given parameters by the user
	*/
	public void createChannel(){

		String name = "BlackSnail";
		String nit = "";
		String website = "";

		String department = "";
		String municipality = "";
		String neighborhood = "";
		String streetType = "";
		int streetNumber = 0;
		String houseNumber = "";

		System.out.println(" ....This is the channel creation format.... \n" + 
			"  The default name of the channel is " + name + ", Do you want to change it? \n" +
			" (1) Yes \n"+
			" (2) No"
			);

		if (askForYesOrNoAnswer()) {
			System.out.printf(" Name of the channel: ");
			name = sc.nextLine();
		}else{
			System.out.println(" Name of the channel: \n" + name);
			name = name;
		}

		System.out.println(" Tax Identification Number (Numero de Identificacion Tributaria o NIT): ");
		nit += askForNumber();

		System.out.println(" Website URL: ");
		website = sc.nextLine();

		myChannel = new Channel(name, nit, website);

		System.out.println("Now you must add the address of " + name + ":");
		System.out.println(" Department: ");
		department = sc.nextLine();
		System.out.println(" Municipality: ");
		municipality = sc.nextLine();
		System.out.println(" Neighborhood: ");
		neighborhood = sc.nextLine();
		System.out.println(" Street Type: ");
		streetType = sc.nextLine();
		System.out.println(" Street Number: ");
		streetNumber = askForNumber();
		System.out.println(" House Number: ");
		houseNumber = sc.nextLine();

		myChannel.addAddress(department, municipality, neighborhood, streetType, streetNumber, houseNumber);

		System.out.println("**** The channel has been created successfully ****");

	}


	/**
	* Creates a new subscriber with the information given by the user
	*/
	public void registerSubscriber() {

		String name = "";
		String identificationCard = "";
		int age;
		int hours;
		int clientType;

		System.out.println(" ....Registration of a new subscriber.... \n" +
			" Type the full name of the subscriber: " );
		name = sc.nextLine();

		System.out.println(" Identification card of the subscriber: ");
		do{
			/*
			* asks the user for an identification card until a unique number is typed
			*/
			identificationCard += askForNumber();
			if (myChannel.verifyRepeatedCard(identificationCard)) {
				System.out.println("This ID currently exists, it must be unique");
			}
		}while(myChannel.verifyRepeatedCard(identificationCard));
		

		System.out.println(" Age of the subscriber: ");
		age = askForNumber();

		System.out.println(" Number of hours the subscriber spends consuming content: ");
		hours = askForNumber();

		System.out.println(" Type of subscription: ");

		System.out.println(
			"(1) Normal \n" +
			"(2) Platinum \n" +
			"(3) Gold \n" +
			"(4) Diamond \n"
			);
		clientType = selectSubscriptionType();

	
		if (myChannel.addSubscriber(name, identificationCard, age, hours, clientType)) {

			System.out.println("**** The subscriber has been registered successfully **** "); 
		}else{

			System.out.println("Warning! the limit of subscribers has been reached");
		}
		


	}


	/**
	* Returns an int value, according to the option given by the user
	* @return option, int, an integer between 1 and 4 that corresponds to one of the options
	*/
	public int selectSubscriptionType(){
		int option = 0;
		do{
			option = askForNumber();
			if (option > 4 || option <= 0) {
				System.out.println("You must answer \"1\", \"2\", \"3\" or \"4\" ");
			}

		}while(option > 4 || option <= 0);

		return option;
	}


	/**
	* Deactivate a subscriber with the information given by the user
	*/
	public void deactivateSubscriber() {

		String identificationCard = "";
		int indexOfDeactivation;


		System.out.println(" Input the ID of the subscriber that you want to deactivate: ");

		do{
			identificationCard += askForNumber();
			indexOfDeactivation = myChannel.identificationCardMatch(identificationCard);
			if (indexOfDeactivation != -1) {
				myChannel.deactivateSubscriber(indexOfDeactivation);


				System.out.println(" The subscriber has been deactivated successfully ");
			}else{
				System.out.println(" The ID entered does not exist");
			}
		}while(indexOfDeactivation == -1);
	}


	/**
	* Shows the active subscribers in the channel
	*/
	public void showActiveSubscribers() {

		//String [] activeNormalSubscribers =  myChannel.getActiveNormalSubscribers();
		int i = 0;

		System.out.println(" The amount of active subscribers is : " + myChannel.getActiveSubscribersNumber() + ", distributed in the form below");

		System.out.println("  NORMAL: " + myChannel.getActiveNormalSubscribersNumber() +
			"\n  PLATINUM: " + myChannel.getActivePlatinumSubscribersNumber() +
			"\n  GOLD: " + myChannel.getActiveGoldSubscribersNumber() +
			"\n  DIAMOND: " + myChannel.getActiveDiamondSubscribersNumber()
			);


	}

	/**
	* Executes the necessary operations to show the young subscriber with most hours of content consumption
	*/
	public void showMostHoursOfContentConsumption(){
		System.out.println(" ....This is the system that shows the young subscriber with most hours of consumption.... ");
		String stringOfSubscriber = "";

		if (myChannel.verifyExistenceOfAtLeastOneSubscriber()) {
			int index = myChannel.getMostHoursOfContentConsumption();
			if (index != -1) {
				stringOfSubscriber = myChannel.getStringOfSubscriber(index);
				System.out.println(stringOfSubscriber);
			}else{
				System.out.println("***** Any young subscriber registered yet ***** ");
			}	
			
		}else{
			System.out.println("***** There is not any subscriber registered yet ***** ");
		}
		

	}

	/**
	* Shows the menu of the catalogue management
	* @return option, int, variable with the option selected by the user
	*/
	public int showMenuCatalogue() {
		int option = 0;
		System.out.println(
			"CATALOGUE MENU, select an option \n" +
			"(1) Add product \n" +
			"(2) Show information of a product \n" +
			"(3) Create next season of a series \n" +
			"(4) Show movies from a category \n" +
			"(5) Show series and their last season \n" +
			"(0) <- Back"
			);
		option = askForNumber();

		switch(option) {
		case 1:
			createProducts();
			break;
		case 2:
			searchProduct();
			break;
		case 3: 
			createNextSeason();
			break;
		case 4:
			showCategoryOfMovies();
			break;
		case 5:
			showSeriesAndLastSeason();
		}
		return option;
	}


	/** 
	* Creates a product with the information given by the user
	*/
	public void createProducts(){
		String product;
		String originalTitle;
		String director;
		String synopsis;
		int day;
		int month;
		int year;
		int minimumAge;
		String productionCompanyName;
		String linkOfTrailer;
		int genre;
		//
		String [] protagonists = new String [100];
		int censorship;
		String censorshipReason = "";
		//
		int numberOfSeason;
		int programmedEpisodes;

		System.out.println( " Which product do you want to create? \n" +
			" (1) Movie \n" + 
			" (2) Series ");
		boolean answer = askForYesOrNoAnswer();
		if (answer) {
			product = "movie";
		}else{
			product = "series";
		}
		
		System.out.println(" ....This is the " + product + " creation format....");
		System.out.println(" Director of the " + product + ": ");
		director = sc.nextLine();
		System.out.println(" Synopsis of the " + product + ": ");
		synopsis = sc.nextLine();

		System.out.println("  Release date of the " + product + ": ");
		System.out.println(" day: ");
		day = askForNumber();
		System.out.println(" month: ");
		month = askForNumber();
		System.out.println(" year: ");
		year = askForNumber();
		do{
			System.out.println( "Original title: ");
			originalTitle = sc.nextLine();
			if (myChannel.productTitleMatch(originalTitle) != -1) {
				System.out.println("This name is already registered, please input a different one");
			}
		}while(myChannel.productTitleMatch(originalTitle) != -1);

		if (answer) {
			System.out.println(" Minimum age to watch the " + product + ": ");
			minimumAge = askForNumber();
			System.out.println(" Name of the production company: ");
			productionCompanyName = sc.nextLine();
			System.out.println(" Link of the trailer: ");
			linkOfTrailer = sc.nextLine();

			System.out.println("  Select the genre of the " + product + " \n" + 
				" (1) ROMANCE \n" + 
				" (2) ACTION \n" +
				" (3) SUSPENSE \n" +
				" (4) TERROR\n" + 
				" (5) COMEDY");
			genre= selectGenre();

			//the product is added:
			if (myChannel.addProduct(director, synopsis, day, month, year, originalTitle, minimumAge, productionCompanyName, linkOfTrailer, genre) != -1) {
				System.out.println("**** The product has been added successfully ****");
			}else{
				System.out.println(" Warning! the limit of products has been reached");
			}
		}else{
			System.out.println(" Protagonists of the series: ");
			int n = 0;
			do{
				System.out.println(" Protagonist #" + (n+1) + ": ");
				protagonists[n] = sc.nextLine();
				n++;
				System.out.println("  Do you want to add another protagonist? \n" +
					" (1) Yes \n" +
					" (2) No");
			}while(askForYesOrNoAnswer());
			System.out.println("  Has the series been censored?\n" +
					" (1) Yes \n" +
					" (2) No");
			do{
				censorship = askForNumber();
			}while(censorship != 1 && censorship != 2);
			if (censorship == 1) {
				System.out.println(" What is the reason of the censorship?");
				censorshipReason = sc.nextLine();
			}
			//the product is added:
			int index = myChannel.addProduct(director, synopsis, day, month, year, originalTitle, protagonists, censorship, censorshipReason);
			System.out.println("  To create a series, you must create the first season: ");
			System.out.println(" Number of the new season: \n" + myChannel.getNumberOfSeason(index));
			numberOfSeason = 1;
			System.out.println(" Amount of programmed episodes");
			programmedEpisodes = askForNumber();
			System.out.println(" Link of the trailer: ");
			linkOfTrailer = sc.nextLine();
			System.out.println("  Release date of the season: ");
			System.out.println(" day: ");
			day = askForNumber();
			System.out.println(" month: ");
			month = askForNumber();
			System.out.println(" year: ");
			year = askForNumber();
			if (index != -1){
				myChannel.addSeason(index, numberOfSeason, programmedEpisodes, linkOfTrailer, day, month, year);
				System.out.println("**** The product has been added successfully ****");
			}else{
				System.out.println("Warning! the limit of products has been reached");
			}
			//the season for the product is added:
			
		}

	}


	/**
	* Returns an int value, according to the option given by the user
	* @return option, int, an integer between 1 and 5 that corresponds to one of the options
	*/
	public int selectGenre(){
		int option = 0;
		do{
			option = askForNumber();
			if (option > 5 || option <= 0) {
				System.out.println("You must answer \"1\", \"2\", \"3\", \"4\" or \"5\" ");
			}

		}while(option > 5 || option <= 0);

		return option;
	}


	/**
	* Shows a product searched by the user
	*/
	public void searchProduct() {
		if (myChannel.verifyExistenceOfAtLeastOneProduct()) {
			String title;
			int index;
			String stringOfProduct = "";

			System.out.println(" ....Search a product format....");
			System.out.println(" Input the name of the product that you want to search");
			do{
				title = sc.nextLine();
				index = myChannel.productTitleMatch(title);
				if ( index == -1) {
					System.out.println(" There is no product with that name!");
				}else{
					stringOfProduct = myChannel.getStringOfProduct(index);
				}
			}while(index == -1);

			System.out.println(stringOfProduct);
		}else{
			System.out.println("***** There is not any product registered yet ***** ");
		}
		

	}


	/**
	* Creates the next season of a product by searching its name / title
	*/
	public void createNextSeason() {

		String title;
		int day;
		int month;
		int year;
		String linkOfTrailer;
		int numberOfSeason;
		int programmedEpisodes;
		int index;

		if (myChannel.verifyExistenceOfAtLeastOneSeries()) {
			System.out.println(" Input the title of the series for which you want to create the next season");
			do{
				title = sc.nextLine();
				index = myChannel.productTitleMatch(title);
				if ( index == -1) {
					System.out.println(" There is no series with that name!");
				}
			}while(index == -1);

			numberOfSeason = myChannel.getNumberOfSeason(index);
			System.out.println(" Number of the new season: \n" + numberOfSeason);
			
			System.out.println(" Amount of programmed episodes");
			programmedEpisodes = askForNumber();
			System.out.println(" Link of the trailer: ");
			linkOfTrailer = sc.nextLine();
			System.out.println("  Release date of the season: ");
			System.out.println(" day: ");
			day = askForNumber();
			System.out.println(" month: ");
			month = askForNumber();
			System.out.println(" year: ");
			year = askForNumber();
			myChannel.addSeason(index, numberOfSeason, programmedEpisodes, linkOfTrailer, day, month, year);
			System.out.println("**** The season has been created successfully ****");
		}else{
			System.out.println("***** There is not any series registered yet ***** ");
		}
		
	}

	/**
	* Shows a list of movies from a category
	*/
	public void showCategoryOfMovies(){
		int genre;

		if (myChannel.verifyExistenceOfAtLeastOneMovie()) {
			System.out.println(" ....This is the system that shows a list of movies from a category....");

			System.out.println("  Select the category of the movie \n" + 
					" (1) ROMANCE \n" + 
					" (2) ACTION \n" +
					" (3) SUSPENSE \n" +
					" (4) TERROR\n" + 
					" (5) COMEDY");
			genre = selectGenre();
			System.out.println(myChannel.showMoviesFromACategory(genre));
		}else{
			System.out.println("***** There is not any movie registered yet ***** ");
		}

	}

	/**
	* Shows all the series and the last season of the season that the user selects
	*/
	public void showSeriesAndLastSeason(){
		int amountOfSeries;
		int numberOfSeries;

		if (myChannel.verifyExistenceOfAtLeastOneSeries()) {
			System.out.println(myChannel.showAllSeries());
			System.out.println(" - Consult the last season one of the series - ");
			System.out.println("Number of the series: (from the list)");
			numberOfSeries = selectSeries();
			System.out.println(myChannel.showLastSeason(numberOfSeries));
		}else{
			System.out.println("***** There is not any series registered yet ***** ");
		}
	}

	/**
	* Returns an int value, according to the option given by the user
	* @return option, int, an integer between 1 and the number of series that corresponds to one of the series
	*/
	public int selectSeries(){
		int option = 0;
		int numberOfSeries = myChannel.getAmountOfSeries();
		do{
			option = askForNumber();
			if (option > numberOfSeries || option <= 0) {
				System.out.println("Your answer must be between \"1\" and \"" + numberOfSeries + "\"");
			}

		}while(option > numberOfSeries || option <= 0);

		return option;
	}

	/**
	* Shows the menu of the services management
	*/
	public void showMenuServices() {

	}


	/**
	* Requests and validates a number
	* @return number, int, integer number typed by the user
	*/
	public int askForNumber(){
		String num = "";
		boolean validInput = true;
		do{
			validInput = true;
			num = sc.nextLine();
			for (int i = 0; i < num.length() ; i++ ) {
				char singleNum = num.charAt(i);
				if (singleNum != '1' && singleNum != '2' && singleNum != '3' && singleNum != '4' && singleNum != '5' && singleNum != '6' && singleNum != '7' && singleNum != '8' && singleNum != '9' && singleNum != '0') {
					System.out.println("\"" + singleNum + "\" is not a number");
					validInput = false;
				}
			}
		}while(!validInput);
		int number = (int) Integer.parseInt(num);

		return number;

	}

	/**
	* Reads and verifies the user's answer to an affirmative or negative question 
	* @return answer, boolean, is the user's response, true if the user responds yes, false otherwise 
	*/
	public boolean askForYesOrNoAnswer(){
		int input = 0; 
		boolean answer = true;
		boolean validInput = false;
		do{
			input = askForNumber();
			if (input != 1 && input != 2) {
				System.out.println("You must answer \"1\" or \"2\" ");
			}else{
				validInput = true;
			}
			if (input==1) {
				answer = true;
			}else if(input == 2){
				answer = false;
			}
		}while(!validInput);

		return answer;
	}


}
