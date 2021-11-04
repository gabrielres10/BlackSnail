package model;

public class Series{
	private String name; //name of the series


	/**
	* Constructor method that creates an instance of series class
	* @param name, String, it is the name of the series (For example: Breaking Bad)
	*/
	public Series(String name) {
		this.name = name;
	}

	/** 
	* Gets the name of the series
	* @return name, String, name of the series
	*/
	public String getName() {
		return name;
	}

	/**
	* Sets the name of the series
	* @param name, String, the name of the series
	*/
	public void setName(String name) {
		this.name = name;
	}

	/**
	* Creates a string with the information of the series
	* @return a string with the information of the series 
	* For example: 
	   Series name: Breaking Bad
	*/
	public String toString() {
		String series = "";
		series += "Series name:" + name + "\n";
	}
}