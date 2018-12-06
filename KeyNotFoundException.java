//Victoria Severin
//1539768
//February 6, 2018
//KeyNotFoundException.java
//Exception class
//Subclass of RuntimeException
//If a nonexistent key is deleted, KeyNotFoundException throws an exception

public class KeyNotFoundException extends RuntimeException{
	public KeyNotFoundException(String s){
	super(s);
	}
}
