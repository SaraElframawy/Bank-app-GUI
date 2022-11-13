//Bank Ui using java swing
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class BankUI extends JFrame implements ActionListener {
    //button withdraws,deposit,calculate interest,apply interest,check balance
    //,create account
    //labels : account number,balance,amount
    //text field : account number,amount
    private JButton btnTransaction;
  //  private JButton btnDeposit;
    private JButton btnCalculateInterestInterest;
    private JButton btnApplyInterest;
    private JButton btnExit;
    private  JButton btnCreate;
    private  JButton btnBalance;

    private JLabel lblAccountNumber;
    private JLabel lblBalance;
    private JLabel lblAmount;
    private JLabel lblMessage;
     //text field
    private JTextField txtAccountNumber;
    private JTextField txtAmount;
    private  JTextField txtBalance;
    //transaction button
    private JRadioButton radWithDraw;
    private JRadioButton radDeposit;
    // account creation buttons
    private JRadioButton radChecking;
    private JRadioButton radSavings;
    //button group
    private ButtonGroup transGroup;
    private ButtonGroup accountGroup;

    private JPanel inputPanel; //for input
    private JPanel commandPanel; //for buttons
    private Bank bank;

    public BankUI(){
        //setup frame feature
        this.bank= new Bank();
        this.setTitle("Bank Account UI");
        this.setSize(660,430);
        this.setPreferredSize(new Dimension(660,430));
        this.setLocation(200,200);
        setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
        this.setVisible(true);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //set up the inputs
        setUpInputs();
        setUpCommands();

        //setup commands


        //pack UI
        pack(); //instead of set size or set bounds

    }
    private void setUpInputs(){
        this.inputPanel= new JPanel();
        this.inputPanel.setPreferredSize(new Dimension(650,200));
        this.inputPanel.setLayout(new FlowLayout(FlowLayout.CENTER,10,20));
        this.inputPanel.setBorder(BorderFactory.createTitledBorder("Inputs"));
      //  this.add(this.inputPanel); //adding the j panel to frame
         JPanel top = new JPanel();
        top.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
        top.setPreferredSize(new Dimension(540,40));
        this.inputPanel.add(top);

        //account number both label and text field
        this.lblAccountNumber= new JLabel("Account number:");
        this.lblAccountNumber.setPreferredSize(new Dimension(120,30));
        this.inputPanel.add(this.lblAccountNumber);

        this.txtAccountNumber=new JTextField();
        this.txtAccountNumber.setPreferredSize(new Dimension(120,30));
        this.inputPanel.add(this.txtAccountNumber);
        //balance
        this.lblBalance= new JLabel("Account Balance");
        this.lblBalance.setPreferredSize(new Dimension(130,30));
        this.inputPanel.add(this.lblBalance);

        this.txtBalance=new JTextField();
        this.txtBalance.setPreferredSize(new Dimension(130,30));
        this.inputPanel.add(this.txtBalance);
        this.txtBalance.setEditable(false); // no balance manipulation

        // two radio buttons for withdraw and deposit
        this.radWithDraw= new JRadioButton("Withdraw");
        this.radWithDraw.setPreferredSize(new Dimension(120,30));
        this.radWithDraw.setSelected(true);
        this.inputPanel.add(this.radWithDraw);

        this.radDeposit= new JRadioButton("Deposit"); // the radio button is the check button
        this.radDeposit.setPreferredSize(new Dimension(130,30));
        this.inputPanel.add(this.radDeposit);
        this.transGroup= new ButtonGroup();
        this.transGroup.add(this.radDeposit);
        this.transGroup.add(this.radWithDraw);
                this.add(this.inputPanel);

                //transaction amount
        this.lblAmount= new JLabel("Transaction Amount");
        this.lblAmount.setPreferredSize(new Dimension(120,30));
        this.inputPanel.add(this.lblAmount);

        this.txtAmount= new JTextField();
        this.txtAmount.setPreferredSize(new Dimension(130,30));
        this.inputPanel.add(this.txtAmount);




        JLabel lblType= new JLabel("Select account type");
        top.add(lblType);

        //two button radio for account type
        this.radChecking= new JRadioButton("Checking");
        this.radChecking.setPreferredSize(new Dimension(130,30));
        top.add(radChecking);
        this.radChecking.setSelected(true);


        this.radSavings= new JRadioButton("Saving");
        this.radSavings.setPreferredSize(new Dimension(130,30));
        top.add(radSavings);
        this.transGroup = new ButtonGroup();
        this.transGroup.add(this.radChecking);
        this.transGroup.add(this.radSavings);


        // add to frame
        this.add(this.inputPanel);

        // add command buttons to user interface


    }
    private void setUpCommands(){
        this.commandPanel= new JPanel();
        this.commandPanel.setPreferredSize(new Dimension(550,150));
        this.commandPanel.setLayout(new FlowLayout(FlowLayout.CENTER,10,20));
        // spaces between the panel item
        this.commandPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));


        //button
        this.btnCreate = new JButton("Create");
        this.btnCreate.setPreferredSize(new Dimension(140,30));
        this.btnCreate.addActionListener(this);
        this.commandPanel.add(btnCreate); // adding the command panel to frame
        //balance button
        this.btnBalance = new JButton("Check Balance");
        this.btnBalance.setPreferredSize(new Dimension(140,30));
        this.btnBalance.addActionListener(this);
        this.commandPanel.add(this.btnBalance);
        //Withdraw
        this.btnTransaction = new JButton("Do Transaction");
        this.btnTransaction.setPreferredSize(new Dimension(140,30));
        this.btnTransaction.addActionListener(this);
        this.commandPanel.add(this.btnTransaction);
        //Deposit button
       // this.btnDeposit= new JButton("Deposit");
      //  this.btnDeposit.setPreferredSize(new Dimension(140,30));
      //  this.btnDeposit.addActionListener(this);
      //  this.commandPanel.add(btnDeposit);
        //Create calculate interest button
        this.btnCalculateInterestInterest = new JButton("show interest");
        this.btnCalculateInterestInterest.setPreferredSize(new Dimension(140,30));
        this.btnCalculateInterestInterest.addActionListener(this);
        this.commandPanel.add(this.btnCalculateInterestInterest);
        //Apply interest
        this.btnApplyInterest= new JButton("Apply interest");
        this.btnApplyInterest.setPreferredSize(new Dimension(140,30));
        this.btnApplyInterest.addActionListener(this);
        this.commandPanel.add(btnApplyInterest);
        // Exit button
        this.btnExit = new JButton("Exit");
        this.btnExit.setPreferredSize(new Dimension(140, 30));
        this.btnExit.addActionListener(this);
        this.commandPanel.add(this.btnExit);
        this.add(this.commandPanel); // the frame should add the command panel

    }

    @Override
    public void actionPerformed (ActionEvent event){
        Object src = event.getSource();
        if(src.equals(this.btnCreate)){
            this.createAccount();
        }else if(src.equals(this.btnExit)){
            System.exit(0);

        } else if(src.equals(this.btnBalance)){
            this.checkBalance();

        }
        else if (src.equals(this.btnTransaction)){
            DoTransaction();
        }
        else if(src.equals(this.btnCalculateInterestInterest)){
            this.calInterest();
        }
        else if (src.equals(this.btnApplyInterest)){
            this.applyInterest();
        }
    }
    private void applyInterest(){
        try {
            // account number
            int accountNumber = Integer.parseInt(this.txtAccountNumber.getText());

            // get account
            Account account = bank.getAccount(accountNumber); // the object uphold the account with specific account number

            // check its savings account
            if(account instanceof SavingsAccount) {
                double interest = ((SavingsAccount) account).calcInterest();
                bank.deposit(account.getAccountNumber(), interest);
                showMessage("Interest has been added");
                // display balance
                this.txtBalance.setText(String.format("$%.2f", account.getBalance()));
            } else {
                showError("This is not a Savings account!");
            }
        } catch(Exception e) {
            showError(e.getMessage() + "\n" + e.toString());
        }
    }
    private void calInterest(){
        try {
            //account number
            int accountNumber =Integer.parseInt(this.txtAccountNumber.getText());
            // get account
            Account account = bank.getAccount(accountNumber); //calling the method of get account using the account number as parameter
            if(account instanceof SavingsAccount){
                double interest = ((SavingsAccount) account).calcInterest();
                showMessage(String.format("Interest earned:  $%.2f",interest));

            }
            else{
                showError("this is not saving accounts");
            }

        } catch (Exception e){
            showError(e.getMessage()+"\n"+e.toString());

        }
    }
    private void DoTransaction(){ //withdraw and deposit
      try{
          double amount = Double.parseDouble(this.txtAmount.getText());
          int accountNumber = Integer.parseInt(this.txtAccountNumber.getText());

          if(this.radDeposit.isSelected()) {
              if (bank.deposit(accountNumber, amount)) {
                  showMessage("transaction is successful");
                  txtAmount.setText("");
                  double balance = bank.getAccount(accountNumber).getBalance();
                  txtBalance.setText(String.format("$%.2f", balance));
              } else {
                  showError("Transaction failed! try again");
              }
          } else {
              if(bank.withdraw(accountNumber, amount)) { //when we execute the withdrawal method
                  showMessage("Transaction is Successful!");
                  txtAmount.setText("");
                  double balance = bank.getAccount(accountNumber).getBalance();
                  txtBalance.setText(String.format("$%.2f", balance));
              } else {
                  showError("Transaction Failed! Try again");
              }
          }

              }
     catch (Exception e){
          showError(e.getMessage()+"\n"+e.toString());
      }

    }

    private void checkBalance(){
        //parse account number
        try {
            int accountNumber=Integer.parseInt(this.txtAccountNumber.getText());
            Account account = bank.getAccount(accountNumber);
            //the object which uphold the specific account number
            if(account==null){
                showError("No account Exist with account number: "+accountNumber);
                return;
            }
            this.txtBalance.setText(String.format("$%.2f",account.getBalance())); //set
            //whatever the number written in the text field is the balance of the exact chosen account
        } catch (Exception e){
            showError(e.getMessage()+"\n"+e.toString()); //printing the message error according to the type of the error
        }

    }
    private void createAccount(){
        Account account=null;
        if(radChecking.isSelected()){
        account = new CheckingAccount(Bank.getNextAccountNumber(),Bank.getFEE()); //checking account constructor
            //extends account so it is account object as well

        } else {
            account= new SavingsAccount(Bank.getNextAccountNumber(),Bank.getIR());
            //so it either to choose the radiobutton checking account or save

        }
        bank.addAccount(account); // we are going to add both the saving account and the checking account
        showMessage("your account has been created\n Account number:"+ account.getAccountNumber());

    }
    private void showMessage(String message){
        JOptionPane.showMessageDialog(this,message,"Information",JOptionPane.INFORMATION_MESSAGE);
    }
    private void showError(String message){
        JOptionPane.showMessageDialog(this,message,"Information,",JOptionPane.ERROR_MESSAGE);
    } //this means on the frame,information is the dialog box name,Error Message

}
