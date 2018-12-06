//Victoria Severin
//1539768
//February 6, 2018
//DictionaryTest.java
//Purpose it to serve as a test client for the Dictionary ADT while it is under construction
//Will define the class DictionaryTest which need not contain any more than a main() method
//ADT should be thoroughly tested in isolation before it is used in any application
//Calling each operation from within DictionaryTest.java
public class DictionaryTest {

    public static void main(String[] args) {

        Dictionary dict = new Dictionary();

        int max_size = 15;
	//int max_size=25; 

        // Test isEmpty()
        if (!dict.isEmpty()) {
            System.out.println("isEmpty() Failed!");
        }

        // Test insert()
        for (int i = 0; i < max_size; i++)
            dict.insert( "Index-"+i, "Value-"+i);

        if (dict.isEmpty()) {
            System.out.println("isEmpty() Failed. List not empty!");
        }

        // Test insert() with DuplicateKeyException()
        // want to catch any duplicates
        try {
            dict.insert("Index-2", "xxx");
        } catch (DuplicateKeyException e) {
            System.out.println("DuplicateKeyException() is correctly processed. Pass!");
            System.out.println();
        }

        // Test toString()
        String s = dict.toString();
        System.out.println(s);

        // Test size()
        // 14 things are print
        // visually look at it and see if its what you expect to get
        if (dict.size() != max_size)  {
            System.out.println("size() Failed!");
        }

        // Test lookup()
        String value = dict.lookup("Index-2");
        if (!value.equals("Value-2")) {
            System.out.println("lookup() Failed!");
        }

        // Test delete()
        dict.delete("Index-2");
        if (dict.size() != max_size-1)  {
            System.out.println("delete() Failed!");
        }

        dict.delete("Index-14");
        if (dict.size() != max_size-2)  {
            System.out.println("delete() Failed!");
        }

        // Test delete() with KeyNotFoundException()
        try {
            dict.delete("Index-2");
        } catch (KeyNotFoundException e) {
            System.out.println("KeyNotFoundException() is correctly processed. Pass!");
        }

        // Test makeEmpty()
        dict.makeEmpty();
        if (!dict.isEmpty()) {
            System.out.print("makeEmpty() Failed!");
        }



    }


}

