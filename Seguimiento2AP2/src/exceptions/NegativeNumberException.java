package exceptions;

public class NegativeNumberException extends Exception{
	public NegativeNumberException (String name, String weight) {
		super ("Está intentando usar un número negativo  \"" + weight + "\"  para el peso del ingrediente " + name);
	}
}
