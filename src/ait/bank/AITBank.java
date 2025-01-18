/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ait.bank;


public class AITBank {

    
    public static void main(String[] args) {
        try{
       ATM atm1=new ATM();
       atm1.atmGui();
        }
        catch(Exception e){
            String error_message=e.getMessage();
            System.out.println(error_message);
        }
    }
    
}
