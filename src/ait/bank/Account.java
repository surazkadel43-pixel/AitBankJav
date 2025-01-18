
package ait.bank;

/**
 *
 * @author suraj
 */
public abstract class Account {
    protected String account_number;
    protected double balance_amount;
    protected boolean is_closed;
    
    public Account(String account_number) {
        this.account_number = account_number;
        this.balance_amount = 0.0;
        this.is_closed = false;
    }
    public void setAccountNumber(String account_number){
        this.account_number = account_number;
    }
    public String getAccountNumber(){
        return this.account_number;
    }
    public abstract void withdraw(double amount);
    
    public  abstract String getDetails();
    public abstract String getAccountType();
    
    public void deposite(double amount) {
        if (!is_closed) {
            balance_amount += amount;
        } else {
            System.out.println("Account is closed. Deposit failed.");
        }
    }
    
    public double getBalance() {
        return balance_amount;
    }
    
    public void closeAccount() {
        is_closed = true;
    }
    public boolean isClosedAccount(){
        return is_closed;
    }
}
