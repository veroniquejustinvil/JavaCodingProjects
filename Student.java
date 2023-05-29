/***
 * Veronique Justinvil 
 * CSE 017: Student  
 * Ziltz
 * Using Inheritance & Polymorphism to create person objects  
 * 8/30/2022
 * 
 */
public class Student extends Person{ 
    private int id; 
    private String major; 

    public Student(){} 

    public Student(String name, String address, String phone, String email, int id, String major){ 
        super(name,address,phone,email); 
        this.id = id; 
        this.major = major; 
    } 

    public int getID(){ 
        return id;
    } 
    public void setID(int id){ 
        this.id = id;
    } 
    public String getMajor(){ 
        return major; 
    }  
    public void setMajor(String major){ 
        this.major = major;
    } 

    @Override 
    public String toString(){ 
        String x = super.toString(); 
        x+= "ID: "+id; 
        x+= "\nMajor: "+ major;   

        return x;
    }
}