
package jnflsicDataProcess;

public class Pages {
    private int totalRecords;
    private int firstNumOfRecords;
    //private int lastNumOfRecords;
    private int numRecordsPrePages;
    private int totalPages;
    public Pages(int curPage, int numOfRecords){
        numRecordsPrePages = numOfRecords;
        firstNumOfRecords = (curPage-1)*numOfRecords;
        //System.out.println(firstNumOfR)
        //lastNumOfRecords = firstNumOfRecords + numOfRecords;
    }
    
    public int getNumRecordsPrePages(){
        return numRecordsPrePages;
    }
    
    public int getFirstNumOfRecords(){
        return firstNumOfRecords;
    }
    
//    public int getLastNumOfRecords(){
//        return lastNumOfRecords;
//    }
    
    public int getTotalPages(){
        return totalPages;
    }
    
    public void setTotalPages(int total){
        System.out.println("total"+total);
        System.out.println("num"+ numRecordsPrePages);
        System.out.println("total%"+total%numRecordsPrePages);
        totalPages  = total%numRecordsPrePages>0?(total/numRecordsPrePages+1):(total/numRecordsPrePages);
        //System.out.println(totalPages);
    }
}
