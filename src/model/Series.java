package model;

public class Series extends Product{
	private String [] protagonistsNames;
	private Censorship censorship;
	private Season [] seasons;
	private String censorshipReason;


	/**
	* Creates an instance of the class series
	* @param directorName, String, it is the director's name of the series (For example: Frank Darabont)
	* @param synopsis, String, it is synopsis of the series (For example:
	* The Walking Dead está basada en un mundo post-apocalíptico repleto de zombis, llamados caminantes, en el que un grupo de supervivientes 
	* debe de luchar por su vida frente a la plaga de estos y los peligros de otros grupos de humanos hostiles.)
	* @param releaseDate, Date, it is the date of the serie's release (For example: (mm/dd/y) 31/10/2010)
	* @param originalTitle, String, it is the original title of the series 
	* @param protagnistsNames, String [], it is an array of the serie's protagonists
	* @param censorship, Censorship, it can be censored or uncensored
	* @param seasons, Season [], it is an array of the serie's seasons
	* @param censorshipReason, String, it is the reason why the series was censored
	*/
	public Series(String directorName, String synopsis, Date releaseDate, String originalTitle, String [] protagonistsNames, Censorship censorship, String censorshipReason){
		super(directorName,synopsis, releaseDate, originalTitle);
		this.protagonistsNames = protagonistsNames;
		this.censorship = censorship;
		this.seasons = new Season [30];
		this.censorshipReason = censorshipReason;
		
	}

	public String getProtagistsNames(){
		String allProtagonistsNames = "";
		return allProtagonistsNames;
	}

	public void setProtagonistNames(String [] protagonistsNames) {
		this.protagonistsNames = protagonistsNames;
	}

	public Censorship getCensorship() {
		return censorship;
	}

	public void setCensorship(Censorship censorship){
		this.censorship = censorship;
	}

	public Season [] getSeasons(){
		return seasons;
	}

	public void setSeasons(Season [] seasons){
		this.seasons = seasons;
	}

	public void setSeason(int index, Season season){
		this.seasons[index] = season;
	}

	public String getCensorshipReason(){
		return censorshipReason;
	}

	public void setCensorshipReason(String censorshipReason){
		this.censorshipReason = censorshipReason;
	}

	/**	
	* Adds a season into the first empty position found
	*/
	public void addSeason(Season season) {
		boolean flag = false;
		for (int i = 0; i < seasons.length && !flag ;i++ ) {
			if (seasons[i] == null) {
				setSeason(i, season);
				flag = true;
			}
		}
	}

	/**
	* Gets the number of the next season (which has not been created yet)
	* @return nextSeasonNumber, int, it is the number of the next free position of the array of seasons
	*/
	public int getSeasonNumber(){
		boolean flag = false;
		int seasonNumber = 1;
		for (int i = 0; i < seasons.length && !flag ;i++ ) {
			if (seasons[i] == null) {
				seasonNumber += i;
				flag = true;
			}
		}
		return seasonNumber;
	}

	/**
	* Gets the information of a season
	* @param index, int, index of the season
	* @return seasonData, String, it is a String with the information of the season
	*/
	public String getSeasonData(int index){
		return seasons[index].toString();
	}


	/**
	* Creates a string with the information of the series
	* @return a string with the information of the series 
	* For example: 
	   Series name: Breaking Bad
	*/
	public String toString() {

		String protagonists = "";
		for (int i = 0; i<protagonistsNames.length ; i++ ) {
			if (protagonistsNames[i] != null) {
				protagonists = protagonists + "  - " +protagonistsNames[i] + "\n";
			}
		}
		String series = " Name of the series: ";
		series += originalTitle + "\n";
		series += " Synopsis: ";
		series += synopsis + "\n";
		series += " Release date: " + releaseDate.toString() + "\n";
		series += " Names of the protagonists: \n" + protagonists;
		series += " Status of the series: " + censorship + "\n";
		
		return series;
	}
}