/***
 * Veronique Justinvil 
 * Using Inheritance & Polymorphism to create person objects  
 * 8/30/2022
 * 
 */
public class Faculty extends Employee{ 
    private String rank; 

    public Faculty(){ 

    } 

    public Faculty(String name, String address, String phone, String email, int id, String position, double salary, String rank){ 
        super(name, address,phone,email,id,position,salary); 
        this.rank = rank; 
    } 

    public String getRank(){ 
        return rank; 
    } 

    public void setRank(String rank){
        this.rank = rank;
    } 

    @Override 
    public String toString(){ 
       String x = super.toString(); //comes from Employee 
       x+="\n Rank: "+rank;  

       return x;
    }
}