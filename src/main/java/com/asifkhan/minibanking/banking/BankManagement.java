/**
 *
 * Author: Asif Khan Email:<asif.cse12@gmail.com>
   Created Date:Aug 18, 2025
 */
package com.asifkhan.minibanking.banking;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;


public class BankManagement {
    

    static Connection con = DbConnection.getConnection();
    public String sql = "";
    
    public  boolean createAccount(String customerName,String customerPassCode ){
            if (customerName == "" || customerPassCode == "") {
                   
                   return false;
            }else{
                try{
                    Statement st = con.createStatement();
                    sql = "INSERT INTO customer(customer_name,customer_blance,customer_pass_code) values('"+ customerName + "',0.0," + customerPassCode + ")";
                    if (st.executeUpdate(sql) == 1) {
                        return true;
                    }
                }catch(SQLIntegrityConstraintViolationException e){
                    System.out.println(e);
                }catch(Exception e){
                
                     System.out.println(e);
                }
 
            }
        return false;
    }
    
    public boolean isValidUser(String customerName, String customerPassCode){
    
            if (customerName == "" || customerPassCode == "") {
                   
                   return false;
            }else{
                try{
                    Statement st = con.createStatement();
                    sql = "Select customer_account_no From customer where customer_name='"+customerName+"' and customer_pass_code='"+customerPassCode+"'";
                    
                    ResultSet rs = st.executeQuery(sql);
                    while(rs.getBoolean("customer_account_no")){
                        return true;
                    }
                }catch(SQLIntegrityConstraintViolationException e){
                    System.out.println(e);
                }catch(Exception e){
                
                     System.out.println(e);
                }
 
            }
        return false;
    }
    
    public String  checkBlance(String customerName, String customerPassCode){
        
        String accountBlance="";
        try{
            Statement st = con.createStatement();
            sql = "Select customer_blance from customer where customer_name='"+customerName+"' and customer_pass_code='"+customerPassCode+"'";
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                return rs.getString("customer_blance");
            }
        }catch(SQLIntegrityConstraintViolationException e){
                    System.out.println(e);
        }catch(Exception e){
                
                     System.out.println(e);
        }
        return accountBlance;
    }
    
    public void viewBlance(String customerName, String customerPassCode){
    
        try{
            Statement st = con.createStatement();
            sql = "Select * from customer where customer_name='"+customerName+"' and customer_pass_code='"+customerPassCode+"'";
            ResultSet rs = st.executeQuery(sql);
            System.out.println("Account no ---- Account Name ---- Blance ");
            while(rs.next()){
             System.out.println("   "+rs.getString("customer_account_no")+"              "+rs.getString("customer_name")+"           "+rs.getString("customer_blance"));
            }
        }catch(SQLIntegrityConstraintViolationException e){
                    System.out.println(e);
        }catch(Exception e){
                
                     System.out.println(e);
        }
    }
    
    public boolean  blanceTransfer(String customerName, String customerPassCode, int transfarBlanceAccountNo, double transfarBlanceAmout){
        
        try{

            //current account blance
            Statement st = con.createStatement();
            sql = "Select customer_blance from customer where customer_name='"+customerName+"' and customer_pass_code='"+customerPassCode+"'";
            ResultSet rs = st.executeQuery(sql);
            double currentAccountBlance=Double.parseDouble(rs.getString("customer_blance"));
            
            //transfar account blance
            
            Statement st1 = con.createStatement();
            sql = "Select customer_blance from customer where customer_account_no='"+transfarBlanceAccountNo+"'";
            ResultSet rs1 = st1.executeQuery(sql);
            double transferAccountBlance=Double.parseDouble(rs1.getString("customer_blance"));
            
            if(transfarBlanceAmout  < currentAccountBlance){

                double newAmount = transferAccountBlance+transfarBlanceAmout;
                 Statement st2 = con.createStatement();
                 sql = "UPDATE customer SET customer_blance = "+newAmount+" WHERE customer_account_no ="+transfarBlanceAccountNo+"";
                 
                if (st2.executeUpdate(sql) == 1) {
                    return true;
                }
                   
            }else{

                System.out.println("InSufficent blance");
            }
        }catch(SQLIntegrityConstraintViolationException e){
                    System.out.println(e);
        }catch(Exception e){
                
                     System.out.println(e);
        }
        
        return false;
    }
}
