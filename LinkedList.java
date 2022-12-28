/***Veronique Justinvil   
 * The use of a Hash map to create a dictionary stored from a file and evaluate the function of searching from each 
 * data structure 
 * 11/17/2022 
 */ 
import java.util.Iterator; 
import java.util.NoSuchElementException;
public class LinkedList<E> {
        // Data members
        private Node head, tail;
        int size; 
    
    // Inner class Node
        private class Node{
        E value;
        Node next;
        Node(E initialValue){
            value = initialValue;  
            next = null;
          }
        } 
    
        // Constructor
        public LinkedList() {
            head = tail = null; //both equal the same thing
            size = 0; 
        }  
    
        // Adding an item to the list
    public boolean addFirst(E item) {
        Node newNode = new Node(item);
        if(head == null) {  
            head = tail = newNode;  
        }
        else {  
            newNode.next = head;
            head = newNode;
        }
        size++;  
        return true;
        } 
    
    public boolean addLast(E item) {
        Node newNode = new Node(item);
        if(head == null) {  
            head = tail = newNode;  
        }
        else {  
            tail.next = newNode;  
            tail = newNode;  
        }
        size++;  
        return true;
        } 
    
    public boolean add(E item) {
        return addFirst(item);
        }  
    
    public E getFirst(){ 
        if(head == null){ 
            throw new NoSuchElementException();
        } 
        return head.value;
    } 
    
    public E getLast(){ 
        if(tail == null){ 
            throw new NoSuchElementException();
        } 
        return tail.value;
    }
    
    // Removing an item from the list
    public boolean removeFirst() {
        if (head == null) throw new NoSuchElementException();
        head = head.next;
        if(head == null) tail=null;
        size--;  
        return true;
        } 
    
    public boolean removeLast() {
        if (head == null) { 
            throw new NoSuchElementException(); 
        }  
        if(size == 1) {
            return removeFirst(); 
          } 
    
        Node current = head; //starting place
        Node previous = null; //holds the thing before current
        while(current.next != null) {
            previous = current; 
            current = current.next;//iterating through without an iterator 
        }
        previous.next = null;  
        tail = previous;
        size--;  
        return true;
        } 
    
        public String toString() {
            String output = "[";
            Node node = head;
            while(node != null) {
                output += node.value + " ";
                node = node.next; //the actual iteration
            }
            output += "]";
            return output;
        } 
    
        public void clear() {  
            head = tail = null;  
            size = 0; 
         }
        public boolean isEmpty() {  
            return (size == 0);  
        }
        public int size() {  
            return size; 
         } 
    
        public Iterator<E> iterator(){ 
            return new LinkedListIterator();
        } 
    
        private class LinkedListIterator implements Iterator<E>{ 
            private Node current = head; 
            public boolean hasNext(){ 
                return current != null;
            } 
            public E next(){ 
                if(current == null){ 
                    throw new NoSuchElementException();
                } 
                E value = current.value; 
                current = current.next; 
                return value;
            }
        } 
    
         public int contains(E item){ 
            int iterations = 0;  
            Iterator<E> iter = iterator(); 
            while(iter.hasNext()){ 
                iterations++; 
                if(iter.next().equals(item)){ 
                    return iterations;
                }
            } 
            return iterations; 
        }  
      /*   public int contains(Object o){   
            int iterations = 0; 
            E item = (E) o; 
            Iterator<E> iterator = iterator(); 
            while(iterator.hasNext()){ //the object
                iterations++; //actual # finding the elment
                if(iterator.next().equals(item)){ 
                    return iterations;
                }
            } 
            return iterations;
        }*/
    
        public int remove(E item){ 
            int iterations = 0; 
            Node current = head; 
            Node previous = null; 
            
            while(current != null && !current.value.equals(item)){ 
                iterations++; 
                previous = current; 
                current = current.next; 
            } 
            if(current != null){ //what we're looking for
                previous.next = current.next;  
                size--;
            } 
            return iterations;
        } 
    
        public int add(int index, E item){ 
            int iterations = 0; 
            if(index > size || index < 0){ 
                throw new NoSuchElementException();
            } 
            if(index == 0){ 
                addFirst(item);
            } 
            if(index == size-1){ 
                addLast(item); 
                return iterations; 
            } 
    
            Node current = head; 
            Node previous = null; 
            int i = 0; 
            while(i<index){ 
                iterations++; 
                i++; 
                previous = current; 
                current = current.next; 
            } 
            Node newNode = new Node(item); 
            previous.next = newNode;  
            newNode.next = current; 
            size++; 
            return iterations;
        }
    }
    

