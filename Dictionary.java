//Victoria Severin 
//1539768
//February 4, 2018
//Dictionary.java

public class Dictionary implements DictionaryInterface{
	//implementing the link list

Node head_;

//helper method
    private Node findKey(String key) {
        Node n = head_;

        while (n != null) {
            if (n.key_.equals(key))
                break;
            n = n.next_;
        }
        return n;
    }
//returns true if the Dictionary contains no pairs, false otherwise
    public boolean isEmpty() {
        return (head_ == null);
    }

//returns the number of (key,value) pairs in the Dictionary
    public int size() {
        if (head_ == null) return 0;

        int count = 1;
        Node n = head_;

        while (n.next_ != null) {
            n = n.next_;
            count++;
        }
        return count;
    }


//If the dictionary contains a pair whose key field matches the argument key
//lookup returns the associated value field. If no such pair exists in the 
//Dictionary, a null reference is returned
    public String lookup(String key) {
        Node n = findKey(key);

        if (n != null)
            return n.value_;

        return null;
    }

//If the Dictionary does not currently contain a pair whose key matches the 
//argument key, then the pair (key,value) is added to the Dictionary
//If such a pair does exist, DuplicateKeyException will be thrown with the 
//message "cannot insert duplicate keys"
    public void insert(String key, String value) throws DuplicateKeyException {
        if (findKey(key) != null) {
            throw new DuplicateKeyException("cannot insert duplicate keys");
        }

        Node node = new Node(key, value);

        if (head_ == null) {
            head_ = node;
        } else {
            Node n = head_;
            while (n.next_ != null) {
                n = n.next_;
            }
            n.next_ = node;
        }

    }

//If the Dictionary currently contains a pair whose key field matches the argument key, then that pair is removed from the Dictionary
//If no such pair exists, then a KeyNotFoundExceptioin is thrown with the message "cannot delete non-existent key"
    public void delete(String key) throws KeyNotFoundException {
        // First check if list is empty
        if (head_ == null)
            throw new KeyNotFoundException("cannot delete non-existent key");

        // Second check is desired key is in the head
        if (head_.key_.equals(key)) {
            head_ = head_.next_;
            return;
        }

        // Finally, If none of the above, move through the list
        Node prev = head_;
        Node current = head_.next_;
        while (current != null) {
            if (current.key_.equals(key)) {
                prev.next_ = current.next_;
                return;
            }

            prev = current;
            current = current.next_;

        }

        throw new KeyNotFoundException("cannot delete non-existent key");
    }
//Resets the Dictionary to the emty state
    public void makeEmpty() {
        head_ = null;
    }

//Returns a String representation of the current state of the Dictionary
//Keys will be separated from the values by a single space
    public String toString() {
        Node n = head_;
        StringBuffer sb = new StringBuffer();

        while (n != null) {
            sb.append(n.key_ + " " + n.value_ + '\n');
            n = n.next_;
        }

        return sb.toString();
    }

    class Node {
        private String key_;
        private String value_;

        Node next_;

        Node(String key, String value) {
            key_ = key;
            value_ = value;
        }
    }

}
