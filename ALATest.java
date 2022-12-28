/***Veronique Justinvil 
 * The use of a Hash map to create a dictionary stored from a file and evaluate the function of searching from each 
 * data structure 
 * 11/17/2022 
 */

 /***Discussion of Results: 
  * The display shows using the generic contains method amongst the three data structures. As shown for the hash map, 
  it returns the getIterations which represents the number of iterations the specific data structure used for the particular 
  word. With the LinkedList & BST, it displays the contains which is a built in method from the object class. The search operation for 
  the hash map structure was result with time complexity with O(1). 
  */  
  /*** The maximum number of collisions represents that in the hash table there's 5 collisions that are hashed at the same index 
   * of the data structure. 
    */

import java.util.ArrayList;  
import java.io.File; 
import java.io.FileNotFoundException; 
import java.util.Scanner;

public class ALATest {
    public static void main(String[]args){
        HashMap<String,String> dictionaryHM = new HashMap<>(50000); 
        BST<String> dictionaryBST = new BST<>(); 
        LinkedList<String> dictionaryLL = new LinkedList<>(); 
        ArrayList<HashMapEntry<String,String>> words = new ArrayList<>();  

        readFile(words, "dictionary.txt");   
        java.util.Collections.shuffle(words);  
        addWords(words,dictionaryHM,dictionaryBST,dictionaryLL);  
        searchWords(words,dictionaryHM,dictionaryBST,dictionaryLL);  

        System.out.println("\n\nMax # of Collisions: " + dictionaryHM.collisions()); 


    }  
    public static void addWords(ArrayList<HashMapEntry<String,String>> al, HashMap<String,String> hm, BST<String> bst, LinkedList<String> ll){ 
        for(int i = 0; i<al.size(); i++){ 
            HashMapEntry<String,String> entry = al.get(i); 
            hm.put(entry.getKey(), entry.getValue()); 
            bst.add(entry.getKey()); 
            ll.add(entry.getKey()); 
        }
    } 

    public static void searchWords(ArrayList<HashMapEntry<String,String>> al, HashMap<String,String> hm, BST<String> bst, LinkedList<String> ll){ 
        //keeping track of iterations 
        int totalHM = 0, totalBST = 0, totalLL = 0;   
        System.out.println("Testing Contains: "); 
        System.out.printf("%-30s\t%-10s\t%-10s\t%-10s\n", "Words: "," LinkedList", "BST", "Hash Table");
        for(int i = 0; i<1000; i++){ 
           int random = (int)(Math.random() * al.size()); 
           HashMapEntry<String,String> entry = al.get(random);  
           HashMap.getIterations = 0;  

           hm.get(entry.getKey()); 
           int hmIter = HashMap.getIterations; 
           int bstIter = bst.contains(entry.getKey()); //both return int (# of iterations)  
           int llIter = ll.contains(entry.getKey()); 

           totalHM += hmIter; 
           totalBST += bstIter; 
           totalLL += llIter; 

           if(i%50 == 0){ 
            System.out.printf("%-30s\t%-10d\t%-10d\t%-10d\n", entry.getKey(), llIter, bstIter, hmIter); 
           }


        } 
        System.out.printf("%-30s\t%-10d\t%-10d\t%-10d\n","Average: ", (totalLL/1000),(totalBST/1000), (totalHM/1000));
    }

    public static void readFile(ArrayList<HashMapEntry<String,String>> list, String filename){ 
        File file = new File(filename); 
        try{  
            Scanner read = new Scanner(file); 
            while(read.hasNextLine()){
                String line = read.nextLine(); 
                String [] items = line.split("\\|"); 
                list.add(new HashMapEntry<>(items[0], items[1]));
            }
            read.close();
        }catch(FileNotFoundException e){ 
            System.out.println("File not found"); 
            System.exit(0);
        }

    }
}
