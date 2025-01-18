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
public class NetSavingAccount extends Account {
    private  double interest_rate;
    private double daily_withdrawl_limit;
    private double interest_amount;
     public NetSavingAccount(String account_number, double interest_rate, double daily_withdrawl_limit) {
        super(account_number);
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
     public void setWithdrawalLimit(double daily_withdrawl_limit){
         this.daily_withdrawl_limit=daily_withdrawl_limit;
     }
     public double getWithdrawlLimit( ){
        return this.daily_withdrawl_limit;
    }
     public void calculateInterest() {
        interest_amount = (balance_amount * interest_rate)/12.00; // Assuming monthly interest calculation
        balance_amount += interest_amount;
    }
     @Override
    public  String getDetails(){
        String account_details="========================================\n"
                + " \n"+
                "Account Type: "+ " Net Saving Account\n"+
                "Account Number: "+ account_number+"\n"+
                "Balance Amount: "+ balance_amount+"\n"+
                "Interest Rate: "+ interest_rate+"%"+"\n"+
                "Interest Amount: "+interest_amount+"\n"
                +"\n"+
                "========================================\n";
         return account_details;
        
    }
    @Override
    public String getAccountType() {
        return "NetSaving Account";
    }
}
