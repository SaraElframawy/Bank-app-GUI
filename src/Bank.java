//manage bank accounts
import java.util.ArrayList;
public class Bank {
    //collection of accounts
    private static int accountCounter=1000;
    private static double FEE = 2.5;
    private static double IR = 0.05; //interest rate

    private ArrayList<Account> accounts; //referring to the account class
    public Bank(){
        accounts = new ArrayList<>();
    }
    public void addAccount(Account account){
        this.accounts.add(account);

    }

    public Account getAccount(int accountNumber){ //find account with given account number
        for (Account account : accounts){ //using the array of accounts to get through each element
            if (account.getAccountNumber()== accountNumber){
                return account;
            }

        }
        return null; //*
    }
    public boolean deposit(int accountNumber,double amount){ //deposit amount to certain account
        Account account=this.getAccount(accountNumber);
        if(account==null) { //if the account number doesn't match *
            return false;
        }
        if(amount>0){
            account.deposit(amount);
            return true;
        }
        return false;

    }
    public boolean withdraw(int accountNumber,double amount){
        Account account = this.getAccount(accountNumber);
        if(account==null){
            return false;
        }
        if (amount>0){
            account.withdraw(amount);
            return true;
        }
        return false;
    }
    public static int getNextAccountNumber(){
        accountCounter++;
        return accountCounter;
    }
    public static double getFEE(){
        return FEE;
    }
    public static double getIR(){
        return IR;
    }


}
