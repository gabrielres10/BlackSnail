package model;

public class Product{
	protected String directorName;
	protected String synopsis;
	protected Date releaseDate;
	protected String originalTitle;


	/**
	* Constructor method
	* @param directorName, String, it is the name of the director (For example: Gabriel Restrepo)
	* @param synopsis, String, it is a short description of an audiovisual production (For example: This is the story about a programmer from Colombia...)
	*/
	public Product(String directorName, String synopsis, Date releaseDate, String originalTitle) {
		this.directorName = directorName;
		this.synopsis = synopsis;
		this.releaseDate = releaseDate;
		this.originalTitle = originalTitle;
	}

	/**
	* Gets the name of the director
	* @return directorName, String,the name of the director
	*/
	public String getDirectorName(){
		return directorName;
	}

	/**
	* Sets the name of the director
	* @param directorName, String, the name of the director
	*/
	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

	/**
	* Gets the synopsis
	* @return synopsis, String, the synopsis of the audiovisual production
	*/
	public String getSynopsis() {
		return synopsis;
	}

	/**
	* Sets the synopsis
	* @param synopsis, String, the synopsis of the audiovisual production
	*/
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	/**
	* Gets the date
	* @return date, Date, this is the date related with the audiovisual production
	*/
	public Date getDate() {
		return releaseDate;
	}

	/**
	* Sets the date
	* @param date, Date, this is the date related with the audiovisual production
	*/
	public void setDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}


	/**
	* Gets the name of the product
	* @return originalTitle, String, name of the audiovisual product
	*/
	public String getOriginalTitle() {
		return originalTitle;
	}

	/**
	* Gets the name of the product
	* @return originalTitle, String, name of the audiovisual product
	*/
	public void setOriginalTitle(String title) {
		this.originalTitle = title;
	}
}