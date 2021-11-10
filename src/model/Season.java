package model;

public class Season{
	private int numberOfSeason;
	private int amountOfProgrammedEpisodes;
	private int amountOfPublishedEpisodes;
	private String linkOfTrailer;
	private Date releaseDate;


	/**
	* Creates an instance of the class series
	* @param numberOfSeason, int, it is the number of the season
	* @param amountOfProgrammedEpisodes, int, it is the number of episodes programmed
	* @param linkOfTrailer, String, it is the link of the season's trailer
	* @param releaseDate, Date, it is the date of the serie's release (For example: (mm/dd/y) 31/10/2010)
	*/
	public Season (int numberOfSeason, int amountOfProgrammedEpisodes, String linkOfTrailer, Date releaseDate){
		this.numberOfSeason = numberOfSeason;
		this.amountOfProgrammedEpisodes = amountOfProgrammedEpisodes;
		this.linkOfTrailer = linkOfTrailer;
		this.releaseDate = releaseDate;
		amountOfPublishedEpisodes = 0;
	}

	public int getNumberOfSeason() {
		return numberOfSeason;
	}

	public void setNumberOfSeason(int numberOfSeason) {
		this.numberOfSeason = numberOfSeason;
	}

	public int getAmountOfProgrammedEpisodes() {
		return amountOfProgrammedEpisodes;
	}

	public void setAmountOfProgrammedEpisodes(int amountOfProgrammedEpisodes){
		this.amountOfProgrammedEpisodes = amountOfProgrammedEpisodes;
	}

	public int getAmountOfPublishedEpisodes() {
		return amountOfPublishedEpisodes;
	}

	public void setAmountOfPublishedEpisodes(int amountOfPublishedEpisodes){
		this.amountOfPublishedEpisodes = amountOfPublishedEpisodes;
	}

	public String getLinkOfTrailer() {
		return linkOfTrailer;
	}

	public void setLinkOfTrailer(String linkOfTrailer){
		this.linkOfTrailer = linkOfTrailer;
	}

	public Date getReleaseDate(){
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate){
		this.releaseDate = releaseDate;
	}


	/**
	* Creates a string with the information of the season
	* @return a string with the information of the season 
	* For example: 
	   Series name: Breaking Bad
	*/
	public String toString() {

		String season = " Number of the season: " + numberOfSeason + "\n";
		season += " Amount of episodes programmed: " + amountOfProgrammedEpisodes + "\n";
		season += " Trailer: " + linkOfTrailer + "\n";
		season += " Release date: " + releaseDate.toString() + "\n";
		
		return season;
	}
}