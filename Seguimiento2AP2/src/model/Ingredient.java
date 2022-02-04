package model;

import exceptions.NegativeNumberException;

public class Ingredient {
	private String name;
	private double weight;
	
	public Ingredient(String n, double w) {
		name = n;
		weight = w;
	}
	
	public String getName() {
		return name;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void addWeight(double additionalW) throws NegativeNumberException{
		weight = weight + additionalW;
		
		if(additionalW < 0){
			throw new NegativeNumberException(this.name, additionalW);
		}
	}
	
	public void removeWeight() {
		
	}
	

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Ingredient) {
			Ingredient other = (Ingredient) obj;
			if(this.name.equals(other.getName()) && this.weight == other.getWeight()) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	
}
