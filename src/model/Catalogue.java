package model;

public class Catalogue{
	private int numberOfMovies;
	private int numberOfSeries;
	private Product catalogue;


	/**
	* Constructor method that creates an instance of catalogue class
	* @param numberOfMovies, int, it is the number of movies in the catalogue (For example: 34)
	* @param numberOfSeries, int, it is the number of series in the catalogue (For example: 40)
	*/
	public Catalogue(int numberOfMovies, int numberOfSeries){
		setNumberOfMovies(numberOfMovies);
		setNumberOfSeries(numberOfSeries);
		movies = new Movie [numberOfMovies];
		series = new Series [numberOfSeries];
	}

	/**
	* Gets the number of movies in the catalogue
	* @return numberOfMovies, int, number of movies in the catalogue
	*/
	public int getNumberOfMovies(){
		return numberOfMovies;
	}

	/**
	* Sets the number of movies in the catalogue
	* @param numberOfMovies, int, number of movies in the catalogue
	*/
	public void setNumberOfMovies(int numberOfMovies){
		this.numberOfMovies = numberOfMovies;
	}

	/**
	* Gets the number of series in the catalogue
	* @return numberOfMovies, int, number of series in the catalogue
	*/
	public int getNumberOfSeries(){
		return numberOfMovies;
	}

	/**
	* Sets the number of series in the catalogue
	* @param numberOfSeries, int, number of series in the catalogue
	*/
	public void setNumberOfSeries(int numberOfSeries){
		this.numberOfSeries = numberOfSeries;
	}

	/**
	* Creates a string with the information of the catalogue
	* @return a string with the information of the catalogue
	* For example: 
	* Information of the catalogue
 	   Number of movies in the catalogue: 34
 	   Number of series in the catalogue: 40
	*/
	public String toString(){
		String catalogue = "";
		catalogue += "Information of the catalogue: \n";
		catalogue += " Number of movies in the catalogue: " + numberOfMovies + "\n";
		catalogue += " Number of series in the catalogue: " + numberOfSeries + "\n";

		return catalogue;
	}


}