
package ait.bank;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;






public class ATM implements ActionListener{
    protected JTextArea textarea1;
    // Creating Button 0 to 9 for Atm button
    protected JButton button1;
    protected JButton button2;
    protected JButton button3;
    protected JButton button4;
    protected JButton button5;
    protected JButton button6;
    protected JButton button7;
    protected JButton button8;
    protected JButton button9;
    protected JButton button0;
    
    //  Creating Button Other Function Button for Atm Function
    protected JButton button_dot;
    protected JButton button_enter;
    protected JButton button_withdraw;
    protected JButton button_clear;
    protected JButton button_cancel;
    
    // Creating Button Other Function Button for Atm Function
    protected JButton button_deposite;
    protected JButton button_balance_inquiry;
    protected JButton button_help;
    protected JPanel panel_number_button;
    protected JPanel panel_funtion_button;
    protected JPanel panel_cancel_enter;
    protected JPanel panel_number_function;
   
    //  Creating String to access the Command value 
    protected String button_value;
    
    protected boolean login;  // for mainting login access
    protected boolean select_option; // for mainting menu selection access
    protected boolean select_account;// for mainting menu selection access
     // Creating Four Types of Accounts from Account class.
    protected SavingAccount saving_account;
    protected FixedAccount fixed_account;
    protected ChequeAccount cheque_account;
    protected NetSavingAccount netsaving_account;
    
   // Creating Character For Menu
    protected char option_operator;
    protected char account_type;
    
    public ATM(){
        // Assigning Button value to All the buttons
      textarea1=new JTextArea(AtmMonitorDisplay.displayPassword(""));
      button1=new JButton("1");
      button2=new JButton("2");
      button3=new JButton("3");
      button4=new JButton("4");
      button5=new JButton("5");
      button6=new JButton("6");
      button7=new JButton("7");
      button8=new JButton("8");
      button9=new JButton("9");
      button0=new JButton("0");
      button_dot=new JButton(".");
      button_enter=new JButton("Enter");
      button_withdraw=new JButton("Withdraw");
      button_clear=new JButton("clr");
      button_cancel=new JButton("Cancel");
      button_deposite=new JButton("Deposite");
      button_balance_inquiry=new JButton("Balance Inquiry");
      button_help=new JButton("Help");
      
      // Adding Jpanel to Jframe to Design Layout of ATM
      panel_number_button=new JPanel();
      panel_funtion_button=new JPanel();
      panel_cancel_enter=new JPanel();
      panel_number_function=new JPanel();
      button_value="";
      login=false;  
      select_option=false;
      select_account=false;
      option_operator = '0';
      account_type='A';
      // Passing Account Number,  Interest rate and withdrawl limit
      saving_account= new SavingAccount("1456 65743", 7, 5000);
      fixed_account= new FixedAccount("56378 90341", 10);
      netsaving_account= new NetSavingAccount("48571 77373", 10, 6000);
      cheque_account= new ChequeAccount("80402 31903");
      
      

}
    
    
    
    public void atmGui(){
        //Adding Jframe
        JFrame frame1=new JFrame();
        GridLayout layout1=new GridLayout(3,1,10,10);
        frame1.setLayout(layout1);
        frame1.add(textarea1);
        
       // Adding All the Number button ( 0 to 9) to panel_number _button
        panel_number_button.add(button1);
        panel_number_button.add(button2);
        panel_number_button.add(button3);
        panel_number_button.add(button4);
        panel_number_button.add(button5);
        panel_number_button.add(button6);
        panel_number_button.add(button7);
        panel_number_button.add(button8);
        panel_number_button.add(button9);
        panel_number_button.add(button0);
        panel_number_button.add(button_dot);
        panel_number_button.add(button_clear);
        panel_number_button.setLayout(new GridLayout(4,3)); 
        
         // Adding other Function button  to panel_number _button
        panel_funtion_button.add(button_withdraw);
        panel_funtion_button.add(button_deposite);
        panel_funtion_button.add(button_balance_inquiry);
        panel_funtion_button.add(button_help);
        panel_funtion_button.setLayout(new GridLayout(4,1));
        
        // Adding other Function button  to panel_number _button
        panel_number_function.add(panel_number_button);
        panel_number_function.add(panel_funtion_button);
        panel_number_function.setLayout(new GridLayout(1,2,10,10));
        panel_number_function.setSize(300, 300);
        
        frame1.add(panel_number_function);
        
        panel_cancel_enter.add(button_cancel);
        panel_cancel_enter.add(button_enter);
        panel_cancel_enter.setLayout(new GridLayout(1,2));
        panel_cancel_enter.setSize(50,50);
        frame1.add(panel_cancel_enter);
        
        frame1.setSize(500,500);
        frame1.setVisible(true);
        
        // Adding All the button to ActionListener to perform 
       
        button1.addActionListener(this);
        button2.addActionListener(this); 
        button3.addActionListener(this); 
        button4.addActionListener(this); 
        button5.addActionListener(this); 
        button6.addActionListener(this); 
        button7.addActionListener(this); 
        button8.addActionListener(this); 
        button9.addActionListener(this); 
        button0.addActionListener(this); 
        button_dot.addActionListener(this); 
        button_clear.addActionListener(this); 
        button_withdraw.addActionListener(this); 
        button_deposite.addActionListener(this); 
        button_balance_inquiry.addActionListener(this); 
        button_help.addActionListener(this); 
        button_cancel.addActionListener(this);
        button_enter.addActionListener(this); 
        
        
    }
    @SuppressWarnings("empty-statement")
    
    // This menuSelection methods handels the menu selecting part 
    public void menuSelection(String menu_value){
      // If user click 1 from the Jframe Screen 
        if(menu_value.equals( "1") || menu_value.equals( "Withdraw")){
                        option_operator='W';
                        chooseAccount();
                        
                     }
                    else if(menu_value.equals( "2") || menu_value.equals( "Deposite")){
                        option_operator='D';
                       chooseAccount();
                    }
                    else if(menu_value.equals( "3") || menu_value.equals( "Balance Inquiry")){
                        option_operator='B';
                        chooseAccount();
                    }
                    else if(menu_value.equals( "4") ){
                        option_operator='C';
                        chooseAccount();
                    }
                    else if(menu_value.equals( "5") ){
                        login=false;
                        button_value="";
                        select_account=false;
                        select_option=false;
                        textarea1.setText(AtmMonitorDisplay.displayPassword(""));
                       
                   }
                    else{
                         JOptionPane.showMessageDialog(null, "Please choose the Account List Properly");
                        chooseMenu();
                       
                         
                   }
        disableFunctionButton(false);
        disableUnUsedNumberButton(false);
      
                    
                
               
    }
    // this methods takes user to Account Selection Step
    public void accountSelection(String account_index){
               
        switch (account_index) {
            case "1":
                account_type='S';
                if(saving_account.isClosedAccount()){ JOptionPane.showMessageDialog(null,"Saving Account is Closed !, Please Try Different Account");
                chooseAccount();
                }
                else {   
                    
                    manageAtmFunction(option_operator); 
                    
                }
                break;
            case "2":
                account_type='C';
                if(cheque_account.isClosedAccount()){ JOptionPane.showMessageDialog(null,"Cheque Account is Closed !, Please Try Different Account");
                chooseAccount();
                
                }
                else {   manageAtmFunction(option_operator);     }
                
                break;
            case "3":
                account_type='F';
                if(fixed_account.isClosedAccount()){ JOptionPane.showMessageDialog(null,"Fixed Account is Closed !, Please Try Different Account");
                chooseAccount();
                }
                else {   manageAtmFunction(option_operator);     }
                
                break;
            case "4":
                account_type='N';
                if(netsaving_account.isClosedAccount()){ JOptionPane.showMessageDialog(null,"NetSaving Account is Closed !, Please Try Different Account");
                chooseAccount();
                }
                else {   manageAtmFunction(option_operator);     }
                
                break;
            case "5":
                account_type='A';
                chooseMenu();
                break;
            default:
                break;
        }
                disableFunctionButton(false);
                disableUnUsedNumberButton(true);
                select_account=false;
                
                
                
    }
    
     // this methods Handels all the operation of atm
    public void atmFunction(String command_value) {
        
        
             if(!login){
            textarea1.setText(AtmMonitorDisplay.displayPassword(button_value));
             }  
             else if(select_option){
                
                menuSelection(command_value);
                
              }
              else if(select_account){
                
               accountSelection(command_value);
            
            }
              else {
                
                  atmTranscation();
              }
    }
    
     // this methods operate the Atm Transcation
   public void manageAtmFunction(char menu_operator){
       
        switch(menu_operator){
            
                    case 'W':
                        switch(account_type){
                            case 'S':
                                if(saving_account.isClosedAccount()){ 
                                    JOptionPane.showMessageDialog(null, "This Saving Account Is closed!! Try Different Account\n"
                                            + "Here is Your Saving Account Details \n"
                                            + saving_account.getDetails());
                                    chooseAccount();
                                   
                                }
                                else {
                                    textarea1.setText(AtmMonitorDisplay.withdraw(button_value, saving_account.getAccountNumber(), String.valueOf(saving_account.getBalance()),saving_account.getAccountType()));
                                }
                                break;
                            case 'F':
                            if(fixed_account.isClosedAccount()){ 
                                    JOptionPane.showMessageDialog(null, "This Fixed Account Is closed!! Try Different Account\n"
                                            + "Here is Your Fixed Account Details \n"
                                            + fixed_account.getDetails());
                                    chooseAccount();
                                   
                                }
                                else {
                                    textarea1.setText(AtmMonitorDisplay.withdraw(button_value, fixed_account.getAccountNumber(), String.valueOf(fixed_account.getBalance()),fixed_account.getAccountType()));
                                }break;
                            case 'C':
                            if(cheque_account.isClosedAccount()){ 
                                    JOptionPane.showMessageDialog(null, "This Cheque Account Is closed!! Try Different Account\n"
                                            + "Here is Your Cheque Account Details \n"
                                            + cheque_account.getDetails());
                                    chooseAccount();
                                   
                                }
                                else {
                                    textarea1.setText(AtmMonitorDisplay.withdraw(button_value, cheque_account.getAccountNumber(), String.valueOf(cheque_account.getBalance()),cheque_account.getAccountType()));
                                } break;
                            case 'N':
                            if(netsaving_account.isClosedAccount()){ 
                                    JOptionPane.showMessageDialog(null, "This NetSaving Account Is closed!! Try Different Account\n"
                                            + "Here is Your NetSaving Account Details \n"
                                            + netsaving_account.getDetails());
                                    chooseAccount();
                                   
                                }
                                else {
                                    textarea1.setText(AtmMonitorDisplay.withdraw(button_value, netsaving_account.getAccountNumber(), String.valueOf(netsaving_account.getBalance()),netsaving_account.getAccountType()));
                                } break;
                            default:
                            break;
                        }
                       
                        break;
                    case 'D':
                        switch(account_type){
                            case 'S':
                            if(saving_account.isClosedAccount()){ 
                                    JOptionPane.showMessageDialog(null, "This Saving Account Is closed!! Try Different Account\n"
                                            + "Here is Your Saving Account Details \n"
                                            + saving_account.getDetails());
                                    chooseAccount();
                                   
                                }
                                else {
                                    textarea1.setText(AtmMonitorDisplay.deposite(button_value, saving_account.getAccountNumber(), String.valueOf(saving_account.getBalance()),saving_account.getAccountType()));
                                }break;
                            case 'F':
                            if(fixed_account.isClosedAccount()){ 
                                    JOptionPane.showMessageDialog(null, "This Fixed Account Is closed!! Try Different Account\n"
                                            + "Here is Your Fixed Account Details \n"
                                            + fixed_account.getDetails());
                                    chooseAccount();
                                   
                                }
                                else {
                                    textarea1.setText(AtmMonitorDisplay.deposite(button_value, fixed_account.getAccountNumber(), String.valueOf(fixed_account.getBalance()),fixed_account.getAccountType()));
                                }break;
                            case 'C':
                            if(cheque_account.isClosedAccount()){ 
                                    JOptionPane.showMessageDialog(null, "This Cheque Account Is closed!! Try Different Account\n"
                                            + "Here is Your Cheque Account Details \n"
                                            + cheque_account.getDetails());
                                    chooseAccount();
                                   
                                }
                                else {
                                    textarea1.setText(AtmMonitorDisplay.deposite(button_value, cheque_account.getAccountNumber(), String.valueOf(cheque_account.getBalance()),cheque_account.getAccountType()));
                                }break;
                            case 'N':
                            if(netsaving_account.isClosedAccount()){ 
                                    JOptionPane.showMessageDialog(null, "This NetSaving Account Is closed!! Try Different Account\n"
                                            + "Here is Your NetSaving Account Details \n"
                                            + netsaving_account.getDetails());
                                    chooseAccount();
                                   
                                }
                                else {
                                    textarea1.setText(AtmMonitorDisplay.deposite(button_value, netsaving_account.getAccountNumber(), String.valueOf(netsaving_account.getBalance()),netsaving_account.getAccountType()));
                                }break;
                            default:
                            break;
                        }
                      
                        break;
                    case 'B':
                        switch(account_type){
                            case 'S':
                               if(saving_account.isClosedAccount()){ 
                                    JOptionPane.showMessageDialog(null, "This Saving Account Is closed!! Try Different Account\n"
                                            + "Here is Your Saving Account Details \n"
                                            + saving_account.getDetails());
                                    
                                   
                                }
                                else {
                                    textarea1.setText(saving_account.getDetails());
                                    JOptionPane.showMessageDialog(null,"Here is Your Saving Account Details \n"
                                            + saving_account.getDetails());
                                    }
                               chooseMenu();
                            break;
                            case 'F':
                               if(fixed_account.isClosedAccount()){ 
                                    JOptionPane.showMessageDialog(null, "This Fixed Account Is closed!! Try Different Account\n"
                                            + "Here is Your Fixed Account Details \n"
                                            + fixed_account.getDetails());
                                    
                                   
                                }
                                else {
                                    textarea1.setText(fixed_account.getDetails());
                                    JOptionPane.showMessageDialog(null,"Here is Your Fixed Account Details \n"
                                            + fixed_account.getDetails());
                                    }
                               chooseMenu();
                            break;
                            case 'C':
                                if(cheque_account.isClosedAccount()){ 
                                    JOptionPane.showMessageDialog(null, "This Cheque Account Is closed!! Try Different Account\n"
                                            + "Here is Your Cheque Account Details \n"
                                            + cheque_account.getDetails());
                                    
                                   
                                }
                                else {
                                    textarea1.setText(cheque_account.getDetails());
                                    JOptionPane.showMessageDialog(null,"Here is Your Cheque Account Details \n"
                                            + cheque_account.getDetails());
                                    }
                               chooseMenu();
                            break;
                            case 'N':
                                
                                if(netsaving_account.isClosedAccount()){ 
                                    JOptionPane.showMessageDialog(null, "This NetSaving Account Is closed!! Try Different Account\n"
                                            + "Here is Your NetSaving Account Details \n"
                                            + netsaving_account.getDetails());
                                    
                                   
                                }
                                else {
                                    textarea1.setText(netsaving_account.getDetails());
                                    JOptionPane.showMessageDialog(null,"Here is Your NetSaving Account Details \n"
                                            + netsaving_account.getDetails());
                                    }
                               chooseMenu();
                                
                            break;
                            default:
                            break;
                        }
                            chooseMenu();
                        break;
                    case 'C':
                        switch(account_type){
                            case 'S':
                                if(saving_account.isClosedAccount()){ 
                                    JOptionPane.showMessageDialog(null, "This Saving Account Is closed!! Try Different Account\n"
                                            + "Here is Your Saving Account Details \n"
                                            + saving_account.getDetails());
                                    
                                   
                                }
                                else {
                                   saving_account.closeAccount();
                                  JOptionPane.showMessageDialog(null, "Saving Account Closed !! \n Here is the details of your Saving Account\n");
                                  JOptionPane.showMessageDialog(null,saving_account.getDetails());
                                    }
                               chooseMenu();
                                
                             
                            break;
                            case 'F':
                               if(fixed_account.isClosedAccount()){ 
                                    JOptionPane.showMessageDialog(null, "This Fixed Account Is closed!! Try Different Account\n"
                                            + "Here is Your Fixed Account Details \n"
                                            + fixed_account.getDetails());
                                    
                                   
                                }
                                else {
                                   fixed_account.closeAccount();
                                  JOptionPane.showMessageDialog(null, "Fixed Account Closed !! \n Here is the details of your Fixed Account\n");
                                  JOptionPane.showMessageDialog(null,fixed_account.getDetails());
                                    }
                               chooseMenu();
                              
                            break;
                            case 'C':
                               if(cheque_account.isClosedAccount()){ 
                                    JOptionPane.showMessageDialog(null, "This Cheque Account Is closed!! Try Different Account\n"
                                            + "Here is Your Cheque Account Details \n"
                                            + cheque_account.getDetails());
                                    
                                   
                                }
                                else {
                                   cheque_account.closeAccount();
                                  JOptionPane.showMessageDialog(null, "Cheque Account Closed !! \n Here is the details of your Cheque Account\n");
                                  JOptionPane.showMessageDialog(null,cheque_account.getDetails());
                                    }
                               chooseMenu();
                              
                            break;
                            case 'N':
                               if(netsaving_account.isClosedAccount()){ 
                                    JOptionPane.showMessageDialog(null, "This NetSaving Account Is closed!! Try Different Account\n"
                                            + "Here is Your NetSaving Account Details \n"
                                            + netsaving_account.getDetails());
                                    
                                   
                                }
                                else {
                                   netsaving_account.closeAccount();
                                  JOptionPane.showMessageDialog(null, "NetSaving Account Closed !! \n Here is the details of your NetSaving Account\n");
                                  JOptionPane.showMessageDialog(null,netsaving_account.getDetails());
                                    }
                               chooseMenu();
                                
                            break;
                            default:
                            break;
                        }
                       break;
                    
                    default:
                         
                       JOptionPane.showMessageDialog(null, "Please choose the Account List Properly");
                       chooseMenu();
                        
                        break;
                }
       
   }
   
   public void atmTranscation(){
       manageAtmFunction(option_operator);
       
   }
   
   // this methods takes you to the Menu Selection
   public void chooseMenu(){
                    disableFunctionButton(true);
                    disableUnUsedNumberButton(false);
                                select_option=true;
                                select_account=false;
                                button_value="";
                                textarea1.setText(AtmMonitorDisplay.displaySelectOption());
   }
   
     // this methods takes you to the Account  Selection
   public void chooseAccount(){
                    disableFunctionButton(false);
                    disableUnUsedNumberButton(false);
                                select_option=false;
                                select_account=true;
                                button_value="";
                                textarea1.setText(AtmMonitorDisplay.displaySelectAccount());
   }
   
     // this methods enable or disable the unused Number button 
   public void disableUnUsedNumberButton(boolean decision){  
       button6.setEnabled(decision);
       button7.setEnabled(decision);
       button8.setEnabled(decision);
       button9.setEnabled(decision);
       button0.setEnabled(decision);
       button_dot.setEnabled(decision);
       button_clear.setEnabled(decision);    
   }
   
   // this methods enable or disable the unused Function  button 
    public void disableFunctionButton(boolean decision){
       button_withdraw.setEnabled(decision);
       button_deposite.setEnabled(decision);
       button_balance_inquiry.setEnabled(decision);
       button_help.setEnabled(decision);
   
   }
    

    @Override
    @SuppressWarnings("empty-statement")
    public void actionPerformed(ActionEvent e) {
        String action_value=e.getActionCommand();  // getting user input
        
       // if user click (.,1, 2, 3, 4, 5, 6, 7, 8, 9,0) from the screen, assign one of these value into button_vale,
       //other wise do no assign because button value is jsut to save number not the others button value
       
        if( action_value.equals(".")|| action_value.equals("1")|| action_value.equals("2")|| action_value.equals("3")|| action_value.equals("4")
                || action_value.equals("5")|| action_value.equals("6")|| action_value.equals("7")|| action_value.equals("8")|| action_value.equals("9")|| action_value.equals("0")){
            
               button_value+=action_value;
               System.out.println(button_value);
        }
        
        
     // if user click (.,1, 2, 3, 4, 5, 6, 7, 8, 9,0) from the screen, the pass one the these value to atmFuntion() method.
     
        if( action_value.equals(".")|| action_value.equals("1")|| action_value.equals("2")|| action_value.equals("3")|| action_value.equals("4")
                || action_value.equals("5")|| action_value.equals("6")|| action_value.equals("7")|| action_value.equals("8")|| action_value.equals("9")|| action_value.equals("0")){
            
               atmFunction(action_value);
        }
        // this clr button is to remove last number digit from the gropu of number digits.
        //  For example, If user click clr then 12345 become 1234 in the screen
        else if(action_value.equals("clr")){
            String valueRecieved="";
            if(!login){
            for(int i=0;i<button_value.length()-1;i++){
                valueRecieved += button_value.charAt(i);
            }
            button_value=valueRecieved;
            textarea1.setText(AtmMonitorDisplay.displayPassword(button_value));
            }
            else if(!select_option && !select_account){
                valueRecieved="";
                for(int i=0;i<button_value.length()-1;i++){
                    valueRecieved += button_value.charAt(i);
                }
                button_value=valueRecieved;
                manageAtmFunction(option_operator);
            }
            
             
      // if user click withdraw button it pass the process in to next step, but only if user is logined
        }  else if(action_value.equals("Withdraw")){
           
            option_operator='W';
            if(login){
                chooseAccount();
            }
            else{
               
                textarea1.setText(AtmMonitorDisplay.displayPassword(button_value));
              
            }
              
            
            // if user click deposite button it pass the process in to next step, but only if user is logined
        }  else if(action_value.equals("Deposite")){
            
            option_operator='D';
            if(login){
                chooseAccount();
            }
            else{
                textarea1.setText(AtmMonitorDisplay.displayPassword(button_value));
            }
              
            // if user click Balance Inquiry button it pass the process in to next step, but only if user is logined
        }  else if(action_value.equals("Balance Inquiry")){
            
            option_operator='B';
            if(login){
                chooseAccount();
            }
            else{
                textarea1.setText(AtmMonitorDisplay.displayPassword(button_value));
            }
              
            // if user click withdraw button it will show the help guideLines,  but only if user is logined
        }  else if(action_value.equals("Help")){
            
            option_operator='H';
            if(login){
                chooseMenu();
            }
            else{
                textarea1.setText(AtmMonitorDisplay.displayPassword(button_value));
            }
             
              // if user click cancel button , this will cancel the current process and take user to menu option, but only if user is logined
        }  else if(action_value.equals("Cancel")){
            if(!login){  
                button_value="";
                textarea1.setText(AtmMonitorDisplay.displayPassword(button_value));
            }
            else if(!select_option && !select_account && account_type!='A'){
                JOptionPane.showMessageDialog(null, "Transcation Cancelled!! By User Returning to Main Menu (-: ");
                disableFunctionButton(true);
                chooseMenu();
            }
             else {
                
                disableFunctionButton(true);
                chooseMenu();
            }
       // if user click Enter button , this will process the value given by user and take user to netx process accordingly , but only if user is logined
        }  else if(action_value.equals("Enter")){
            
            if(!login){
            if(button_value.equals("144343")){
                
                login=true;
                chooseMenu();
               
            }
            
            else {
                disableFunctionButton(true);
                button_value="";
               textarea1.setText(AtmMonitorDisplay.displayRePassword(button_value)); 
            }
            }
            else if(!select_option && !select_account && account_type!='A'){
                
                switch(option_operator){
                    case 'W':
                        switch(account_type){
                            case 'S':
                                if(Double.valueOf(button_value)>saving_account.getWithdrawlLimit()){
                                    JOptionPane.showMessageDialog(null,"Transcation Failed. Withdrawl limit exceeded\n"
                                            + " Your Withdrawl limit is: "+saving_account.getWithdrawlLimit()+"\n");
                                    String choice=JOptionPane.showInputDialog("Do you want to Increase your Withdrawl Limit\n"
                                            + " Type Y- Yes and N-No ");
                                    if (choice.equals("Y")){
                                   String withdrawl=JOptionPane.showInputDialog("saving_account.getDetails()\n"
                                           + "Enter your Withdraw Limit:");
                                   saving_account.setWithdrawlLimit(Double.valueOf(withdrawl));
                                   }
                                    else{
                                    JOptionPane.showMessageDialog(null,"Failed!! Better Luck Next Time.\n"
                                            + "Try to Withdraw with your withdrawl Limit: "+saving_account.getWithdrawlLimit());
                                    }  
                                }
                                else{
                                   saving_account.withdraw(Double.valueOf(button_value));
                                   JOptionPane.showMessageDialog(null,"Transcation Completed !!!\n");
                                   JOptionPane.showMessageDialog(null,saving_account.getDetails());
                                 
                                }
                                chooseMenu();
                                
                                
                            break;
                            case 'F':
                               if(!fixed_account.getEarlyWithdrawal()){
                                    fixed_account.withdraw(Double.valueOf(button_value));
                                    JOptionPane.showMessageDialog(null,"Transcation Completed !!!\n");
                                    JOptionPane.showMessageDialog(null,fixed_account.getDetails());
                                
                                }
                                else{
                                   String choice=JOptionPane.showInputDialog("Transcation Failed.  Early Withdrawl \n"
                                            + " Your money is in fixed funds and There is still time left to withdraw : "+"\n"
                                        + "Do you want to set Early Withdraw Now, Type Y- Yes and N-No ");
                                       if (choice.equals("Y")){
                                          fixed_account.setEarlyWithdrawal(true);
                                           JOptionPane.showMessageDialog(null,"Now You are able To withdraw from Your account");
                                        }
                                        else{
                                           JOptionPane.showMessageDialog(null,"Failed!! Early Withdrawl, Now you have to wait A bit Longer. ");
                                        }
                                   
                               }
                                chooseMenu();
                                
                            break;
                            case 'C':
                                
                                 cheque_account.withdraw(Double.valueOf(button_value));
                                 JOptionPane.showMessageDialog(null,"Transcation Completed !!!\n");
                                 JOptionPane.showMessageDialog(null,cheque_account.getDetails());
                                
                                 chooseMenu();
                                
                            break;
                            case 'N':
                                if(Double.valueOf(button_value)>netsaving_account.getWithdrawlLimit()){
                                     JOptionPane.showMessageDialog(null,"Transcation Failed. Withdrawl limit exceeded\n"
                                            + " Your Withdrawl limit is: "+netsaving_account.getWithdrawlLimit()+"\n");
                                     String choice=JOptionPane.showInputDialog("Do you want to Increase your Withdrawl Limit\n"
                                            + " Type Y- Yes and N-No ");
                                    if (choice.equals("Y")){
                                         String withdrawl=JOptionPane.showInputDialog("saving_account.getDetails()\n"
                                           + "Enter your Withdraw Limit:");
                                            netsaving_account.setWithdrawalLimit(Double.valueOf(withdrawl));
                                    }
                                    else{
                                         JOptionPane.showMessageDialog(null,"Failed!! Better Luck Next Time.\n"
                                         + "Try to Withdraw with your withdrawl Limit: "+netsaving_account.getWithdrawlLimit());
                                    }
                                    
                                    
                                }
                                else{
                                    netsaving_account.withdraw(Double.valueOf(button_value));
                                    JOptionPane.showMessageDialog(null,"Transcation Completed !!!\n");
                                    JOptionPane.showMessageDialog(null,netsaving_account.getDetails());
                                
                                }
                               chooseMenu();
                                 
                            
                            default:
                            break;
                            
                        }
                        break;
                    case 'D':
                       switch(account_type){
                            case 'S':
                                if(Double.valueOf(button_value)>10000000.0){
                                    JOptionPane.showMessageDialog(null,"Transcation Failed.Deposite limit exceeded\n"
                                            + " Your deposit limit is: "+10000000+"  Please try again!");
                                }
                                else{
                                   saving_account.deposite(Double.valueOf(button_value));
                                   JOptionPane.showMessageDialog(null,"Deposite Succesful !!! \n  ");
                                   JOptionPane.showMessageDialog(null,saving_account.getDetails());
                                 
                                }
                                chooseMenu();
                                
                                
                            break;
                            case 'F':
                               if(Double.valueOf(button_value)>10000000.0){
                                    JOptionPane.showMessageDialog(null,"Transcation Failed.Deposite limit exceeded\n"
                                            + " Your deposit limit is: "+10000000+"  Please try again!");
                                }
                                else{
                                   fixed_account.deposite(Double.valueOf(button_value));
                                   JOptionPane.showMessageDialog(null,"Deposite Succesful !!! \n  ");
                                   JOptionPane.showMessageDialog(null,fixed_account.getDetails());
                                 
                                }
                                chooseMenu();
                                   
                               
                                
                                
                            break;
                            case 'C':
                                
                                 if(Double.valueOf(button_value)>100000000.0){
                                    JOptionPane.showMessageDialog(null,"Transcation Failed.Deposite limit exceeded\n"
                                            + " Your deposit limit is: "+1000000+"  Please try again!");
                                }
                                else{
                                   cheque_account.deposite(Double.valueOf(button_value));
                                   JOptionPane.showMessageDialog(null,"Deposite Succesful !!! \n  ");
                                   JOptionPane.showMessageDialog(null,cheque_account.getDetails());
                                 
                                }
                                chooseMenu();
                                
                            break;
                            case 'N':
                                if(Double.valueOf(button_value)>100000.0){
                                    JOptionPane.showMessageDialog(null,"Transcation Failed.Deposite limit exceeded\n"
                                            + " Your deposit limit is: "+100000+"  Please try again!");
                                }
                                else{
                                   netsaving_account.deposite(Double.valueOf(button_value));
                                   JOptionPane.showMessageDialog(null,"Deposite Succesful !!! \n  ");
                                   JOptionPane.showMessageDialog(null,netsaving_account.getDetails());
                                 
                                }
                                chooseMenu();
                                
                                 
                            
                            default:
                            break;
                            
                        }
                       
                        break;
                    
                    
                    default:
                         JOptionPane.showMessageDialog(null, "Please choose the Account List Properly");
                        chooseMenu();
                       
                        break;
                }
                button_value="";
                
            }
            
            
            
        }  
                System.out.println(login);
                System.out.println(select_option);
                System.out.println(select_account);
                System.out.println("");
                
    }

  
    
}
