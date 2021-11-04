package model;

public class Movie{
	private String name; //name of the movie


	/**
	* Constructor method that creates an instance of movie class
	* @param name, String, it is the name of the movie (For example: Toy Story)
	*/
	public Movie(String name){
		this.name = name;
	}

	/** 
	* Gets the name of the movie
	* @return name, String, name of the movie
	*/
	public String getName(){
		return name;
	}

	/**
	* Sets the name of the movie
	* @param name, String, the name of the movie
	*/
	public void setName(String name){
		this.name = name;
	}

	/**
	* Creates a string with the information of the movie
	* @return a string with the information of the movie 
	* For example: 
	   Name of the movie: Toy Story
	*/
	public String toString() {
		String movie = "";
		movie += "Name of the movie:" + name + "\n";
	}
}