//Victoria Severin
//1539768
//February 6, 2018
//DuplicateKeyException.java
//An exception class
//Subclass of RuntimeException
//An exception is thrown if there are duplicate keys in the linked list

public class DuplicateKeyException extends RuntimeException{
	public DuplicateKeyException( String s){
	super(s);
	}
}
