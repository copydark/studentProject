
package jnflsicDepDataProcess;

import jnflsicDepDatabase.DepartmentData;

public class Department {
    int depID;
    String dep;
    String pho;
    String lea;
    String des;
    public Department(){
        
    }
    
    public Department(String depName, String phone, String leader, String description){
        dep = depName;
        pho = phone;
        lea = leader;
        des = description;
    }
    
    public void setID(int id){
        depID = id;
    }
    
    public void setName(String depName){
        dep = depName;
    }
    
    public void setPhone(String phone){
        pho = phone;
    }
    
    public void setLeader(String leader){
        lea = leader;
    }
    
    public void setDescription(String description){
        des = description;
    }
    
    public int getID(){
        return depID;
    }
    
    public String getName(){
        return dep;
    }
    
    public String getPhone(){
        return pho;
    }
    
    public String getLeader(){
        return lea;
    }
    
    public String getDes(){
        return des;
    }
    
    public static boolean operateData(char oper, Department d){
        if(oper == 'i'){
            return DepartmentData.insertData(d);
        }else if(oper == 'u'){
            return DepartmentData.updateData(d);
        }else{
            return DepartmentData.delateData(d);
        }
    }
}
