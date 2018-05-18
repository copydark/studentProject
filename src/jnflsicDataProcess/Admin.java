
package jnflsicDataProcess;

public class Admin {
    private String name;
    private String password;
    
    public Admin(String name, char[] password){
        this.name = name;
        this.password = String.copyValueOf(password);
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getName(){
        return name;
    }
    
    public String getPass(){
        return password;
    }
}
