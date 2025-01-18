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
public class FixedAccount extends Account {
    private  double interest_rate;
    private boolean is_early_withdrawl;
    private double interest_amount;
     public FixedAccount(String account_number, double interest_rate) {
        super(account_number);
        this.interest_rate = interest_rate;
        is_early_withdrawl=false;
        interest_amount=balance_amount*interest_rate;
    }
     @Override
     public  void withdraw(double amount){
         if (!is_closed && !is_early_withdrawl) {
            balance_amount -= amount;
        } else {
            JOptionPane.showMessageDialog(null,"Account is closed or withdrawal amount exceeds daily limit. Withdrawal failed.");
        }
     }
     public void calculateInterest() {
         if(!is_early_withdrawl){
        interest_amount = balance_amount * interest_rate;
        balance_amount += interest_amount;
         }
         else{
              System.out.println("You withdraw early before your contract period: \n So, no interest amount will be added into your account: " );
            interest_amount = 0.0;
            balance_amount += interest_amount;
         }
    }
     @Override
    public  String getDetails(){
       
      
        String account_details="========================================\n"
                + " \n"+
                "Account Type: "+ " Fixed Account\n"+
                "Account Number: "+ account_number+"\n"+
                "Balance Amount: "+ balance_amount+"\n"+
                "Interest Rate: "+ interest_rate+"%"+"\n"+
                "Interest Amount: "+interest_amount+"\n"
                + "Is Early Withdrawl: "+is_early_withdrawl+"\n"+
                "\n"+
                "========================================\n";
            return account_details;

    }
    public void setEarlyWithdrawal(boolean isEarlyWithdrawal) {
        this.is_early_withdrawl = isEarlyWithdrawal;
    }
    public boolean getEarlyWithdrawal() {
        return this.is_early_withdrawl;
    }
    
    @Override
    public String getAccountType() {
        return "Fixed Account";
    }
}
