/***
 * Veronique Justinvil 
 * CSE 017: Employee  
 * Ziltz
 * Using Inheritance & Polymorphism to create person objects  
 * 8/30/2022
 * 
 */
public class Employee extends Person{ 
    private int id; 
    private String position; 
    private double salary;  

    public Employee(){ //default constructor 

    } 

    public Employee(String name, String address, String phone, String email,
    int id, String position, double salary){ 
        super(name,address,phone,email); 
        this.id = id; 
        this.position = position; 
        this.salary = salary;
    } 

    public int getID(){ 
        return id;
    } 
    public void setID(int id){
        this.id = id;
    } 
    public String getPosition(){ 
        return position;
    } 
    public void setID(String position){
        this.position = position;
    } 
    public double getSalary(){ 
        return salary;
    } 
    public void setSalary(double salary){
        this.salary = salary;
    } 

    @Override
    public String toString(){ 
        String x = super.toString(); //returns name, address, birthday, email  
        x+= "ID: "+ id; //already has
        x+= "\nPosition: " + position; 
        x+= "\nSalary: $" + salary; 

        return x;

    }

}