package model;

public class Movie extends Product{
	private int minimumAge;
	private String productionCompanyName;
	private String linkOfTrailer;
	private Genre genre;

	
	/**
	* Creates an instance of the class movie
	* @param directorName, String, it is the director's name of the movie (For example: James Cameron)
	* @param synopsis, String, it is synopsis of the movie (For example: 
	* En un exuberante planeta llamado Pandora viven los Na'vi, seres que aparentan 
	* ser primitivos pero que en realidad son muy evolucionados. Debido a que el ambiente de Pandora es venenoso, los híbridos humanos/Na'vi, llamados 
	* Avatares, están relacionados con las mentes humanas, lo que les permite moverse libremente por Pandora. Jake Sully, un exinfante de marina 
	* paralítico se transforma a través de un Avatar, y se enamora de una mujer Na'vi.)

	* @param releaseDate, Date, it is the date of the movie's release (For example: (mm/dd/y) 17/12/2009)
	* @param originalTitle, String, it is the original title of the movie (For example: Avatar)
	* @param minimumAge, int, it is the minimum age allowed to watch the movie (For example: 13)
	* @param productionCompanyName, String, it is production company's name (For example: 20th Century Studios)
	* @param linkOfTrailer, String, it is the link of the trailer (For example: https://www.youtube.com/watch?v=Xg8kYk6uHN0)
	* @param genre, Genre, it is the genre of the movie (For example: Action)
	*/
	public Movie (String directorName, String synopsis, Date releaseDate, String originalTitle, int minimumAge, String productionCompanyName, String linkOfTrailer, Genre genre){
		super(directorName,synopsis, releaseDate, originalTitle);
		this.minimumAge = minimumAge;
		this.productionCompanyName = productionCompanyName;
		this.linkOfTrailer = linkOfTrailer;
		this.genre = genre;
	}
	
	public int getMinimumAge(){
		return minimumAge;
	}

	public void setMinimumAge(int minimumAge){
		this.minimumAge = minimumAge;
	}

	public String getProductionCompanyName(){
		return productionCompanyName;
	}

	public void setProductionCompanyName(String productionCompanyName){
		this.productionCompanyName = productionCompanyName;
	}

	public String getLinkOfTrailer() {
		return linkOfTrailer;
	}

	public void setLinkOfTrailer(String linkOfTrailer){
		this.linkOfTrailer = linkOfTrailer;
	}

	public Genre getGenre(){
		return genre;
	}

	public void setGenre(Genre genre){
		this.genre = genre;
	}

	/**
	* Creates a string with the information of the movie
	* @return a string with the information of the movie 
	* For example: 
	   Name of the movie: Toy Story
	*/
	public String toString() {
		String movie = " Name of the movie: ";
		movie += originalTitle + "\n";
		movie += " Synopsis: ";
		movie += synopsis + "\n";
		movie += " Director name : " + directorName + "\n";
		movie += " Release date: " + releaseDate.toString() + "\n";
		movie += " Minimum age to watch the movie: " + minimumAge + "\n";
		movie += " Production company name: " + productionCompanyName + "\n";
		movie += " Trailer: " + linkOfTrailer + "\n";
		movie += " Genre: " + genre;
		
		//movie += "Name of the movie:" + name + "\n";
		return movie;
	}
}