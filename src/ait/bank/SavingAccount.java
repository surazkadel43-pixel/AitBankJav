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
public class SavingAccount extends Account {
    private  double interest_rate;
    private double daily_withdrawl_limit;
    private double interest_amount;
     public SavingAccount(String account_number, double interest_rate, double daily_withdrawl_limit) {
        super(account_number);
        this.account_number=account_number;
        this.interest_rate = interest_rate;
        this.daily_withdrawl_limit=daily_withdrawl_limit;
        interest_amount=balance_amount*interest_rate;
    }
     @Override
     public  void withdraw(double amount){
         if (!is_closed && amount <= daily_withdrawl_limit) {
            balance_amount -= amount;
        } else {
            JOptionPane.showMessageDialog(null,"Account is closed or withdrawal amount exceeds daily limit. Withdrawal failed.");
        }
     }
     
     
    
     @Override
    public  String getDetails(){
         
        String account_details="========================================\n"
                + " \n"+
                "Account Type: "+ " Saving Account\n"+
                "Account Number: "+ account_number+"\n"+
                "Balance Amount: "+ balance_amount+"\n"+
                "Interest Rate: "+ interest_rate+"%"+"\n"+
                "Interest Amount: "+interest_amount+"\n"+
                "\n"+
                "========================================\n";
                
         return account_details;
    }
    public double calculateInterest() {
        interest_amount = (balance_amount * interest_rate)/365.00; // Assuming daily interest calculation
        balance_amount += interest_amount;
        return interest_amount;
    }
    public void setWithdrawlLimit(double daily_withdrawl_limit ){
        this.daily_withdrawl_limit=daily_withdrawl_limit;
    }
    public double getWithdrawlLimit( ){
        return this.daily_withdrawl_limit;
    }
   @Override
    public String getAccountType() {
        return "Saving Account";
    }
}
