/***
 * Veronique Justinvil 
 * Using Inheritance & Polymorphism to create person objects  
 * 8/30/2022
 * 
 */
public class Test3{
    public static void main(String[]args){ 
        Person[] people = new Person[4];  

        Person p = new Person("Helen Brown", "222 10th Street Bethlehem","610-334-2288", "hbrown@gmail.com"); 
        Student s = new Student("Paul Leister", "972 4th Street Allentown","610-331-7177", "pleister@gmail.com",12345,"CSE"); 
        Employee e = new Employee("Beth Down", "234 Main Street Philadelphia", "484-222-4433","bdown@gmail.com",33442,"Systems Administrator",75000.00); 
        Faculty f = new Faculty("Mark Jones", "21 Orchid Street Bethlehem", "610-333-2211","mjones@gmail.com",22222, "Faculty", 100000.00, "Associate Professor"); 

        people[0] = p; 
        people[1] = s;
        people[2] = e; 
        people[3] = f;    

        System.out.println("Unsorted List: ");

        printArray(people);  
        sortArray(people); 
       System.out.println(" \nSorted List: "); 
       printArray(people);




        
    } 
    public static void printArray(Person[]persons){ 
            for(int i = 0; i<persons.length; i++){ 
            System.out.println(persons[i]);
        } 
        } 

    public static void sortArray(Person[]list){ 
        String n1; 
        String n2;
    		for(int i=0; i<list.length; i++){
      		int minIndex = i; 
      		for(int j=i+1; j<list.length; j++){    
                n1 = list[j].getName(); 
                n2 = list[minIndex].getName();
               // str1.equals(str2); 
               // str1.compareTo(str2);  
          		if(n1.compareTo(n2) < 0) //comparing if the first letter is less than or greater than
                 		minIndex=j;
      		
            } 
            Person temp = list[i];
      		list[i] = list[minIndex];
      		list[minIndex] = temp; 
    		}
}

}