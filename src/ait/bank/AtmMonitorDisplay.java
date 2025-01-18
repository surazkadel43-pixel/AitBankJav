/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ait.bank;


public class AtmMonitorDisplay   {

    public AtmMonitorDisplay(String account_number) {
        
    }

    
    public static String displayPassword(String password_pin){
        String for_password=
                  "========================================\n"
                + "\n"
                + "         ENTER PASSWORD \n"
                + "      --------------------\n"
                + "      |"+"     "+password_pin+"        |\n"
                + "      --------------------\n"
                + "\n"
                + "========================================\n";
        //System.out.println(for_password);
        return for_password;
    }
    public static String displayRePassword(String password_pin){
        String for_repassword=
                  "========================================\n"
                + "\n"
                + "       Incorrect Password         \n"
                + "         RE-ENTER PASSWORD \n"
                + "      --------------------\n"
                + "      |"+"     "+password_pin+"        |\n"
                + "      --------------------\n"
                + "\n"
                + "========================================\n";
        //System.out.println(for_repassword);
        return for_repassword;
    }
    
    public static String displaySelectOption(){
        String select_option=
                  "========================================\n"
                + "\n"
                + "\n"
                + "         SELECT YOUR CHOICE\n"
                + "      1. WITHDRAW\n"
                + "      2. DEPOSITE\n"
                + "      3. BALANCE INQUIRY\n"
                + "      4. CLOSE ACCOUNT\n"
                + "      5. EXIT           \n"
                + "\n"
                + "\n"
                + "========================================\n";
        //System.out.println(select_option);
        return select_option;
    }
    public static String displaySelectAccount(){
        String select_account=
                  "========================================\n"
                + "\n"
                + "\n"
                + "         SELECT ACCOUNT\n"
                + "      1. SAVING ACCOUNT\n"
                + "      2. CHEQUE ACCOUNT\n"
                + "      3. FIXED ACCOUNT\n"
                + "      4. NETSAVING ACCOUNT\n"
                + "      5. EXIT \n"
                + "\n"
                + "\n"
                + "========================================\n";
        //System.out.println(select_account);
        return select_account;
    }
    public static String displayAccountDetails(String account_number, String balance_amount, String intrest_amount, String intrest_rate ){
        String account_details=
                  "========================================\n"
                + "\n"
                + "\n"
                + "         Account Type: Saving Account\n"
                + "      Account Number:" + account_number +"\n"
                + "      Balance Amount:"+ balance_amount+"\n"
                + "      Interest Rate:"+intrest_rate+"%\n"
                + "      Interest Amount: " + intrest_amount +"\n"
                + "      5. EXIT \n"
                + "\n"
                + "\n"
                + "========================================\n";
        //System.out.println(account_details);
        return account_details;
    }
    public static String deposite(String deposite, String account_number, String balance_amount, String account_type){
        String for_deposite=
                  "========================================\n"
                + " \n"
                + "    Account Type: "+ account_type+ " \n"
                + "    Account Number: "+account_number+ " \n"
                + "    Account Balance: "+ balance_amount+ " \n"
                + "      Enter Deposite Ammount: "
                +deposite+"\n"
                + "\n"
                + "========================================\n";
        //System.out.println(for_password);
        return for_deposite;
    }
      public static String withdraw(String withdraw ,String account_number, String balance_amount, String account_type){
          
        String for_withdraw=
                  "========================================\n"
                + " \n"
                + "    Account Type: "+ account_type+ " \n"
                + "    Account Number: "+account_number+ " \n"
                + "    Account Balance: "+ balance_amount+ " \n"
                + "      Enter withdraw Ammount: "
                +withdraw+"\n"
                 
                + "\n"
                + "========================================\n";
        //System.out.println(for_password);
        return for_withdraw;
    }

    

    public void getDetails() {
       
    }
     
    
    
}
