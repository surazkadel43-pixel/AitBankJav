/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ait.bank;

import javax.swing.JOptionPane;

/**
 *
 * @author suraj
 */
public class ChequeAccount extends Account {
    public ChequeAccount(String account_number) {
        
            super(account_number);
        
    }
     @Override
     public  void withdraw(double amount){
         if (!is_closed ) {
            balance_amount -= amount;
        } else {
            JOptionPane.showMessageDialog(null,"Account is closed or withdrawal amount exceeds daily limit. Withdrawal failed.");
        }
     }
     
     @Override
    public  String getDetails(){
         
        String account_details="========================================\n"
                + " \n"+
                "Account Type: "+ " Cheque  Account\n"+
                "Account Number: "+ account_number+"\n"+
                "Balance Amount: "+ balance_amount+"\n"+
                "\n"+
                "========================================\n";
         return account_details;
       
    }

    @Override
    public String getAccountType() {
        return "Cheque Account";
    }
}
