package ja;

import ja.exceptions.InsufficientFundsException;

import java.io.IOError;
import java.util.Scanner;

public class User {
    //region
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getSecondName() {
        return secondName;
    }
    //endregion
    public double getBalance(){
        return acc.getBalance();
    }
    public String getNumber(){
        return acc.getNumber();
    }
    private final String firstName;
    private final String lastName;
    private final String secondName;
    Account acc;
    private Msg msg = new Msg();
    public User(String firstName, String lastName, String secondName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.secondName = secondName;
    }
    public int createAccount(Scanner scan){
        try{
            if(acc == null){
                acc = new Account(Generator.generateNumberAccount());
                msg.printMsg("Please enter your start balance ");
                acc.setBalance(scan.nextDouble());
                acc.setActivity(true);
                msg.printMsg("The account has been created ");
                return 1;
            } else{
                if(!acc.isActivity()){
                    msg.printMsg("The account is block ");
                    return 0;
                } else{
                    msg.printMsg("The account already exists ");
                    return 1;
                }
            }
        } catch(IllegalArgumentException e){
            e.printStackTrace();
            return 0;
        } catch(RuntimeException e){
            e.printStackTrace();
            return 0;
        }
    }
    public void addingFunds(double summ){
        try{
            acc.addingFunds(summ);
            System.out.println("Error when depositing funds to the account");
        } catch (IllegalArgumentException e){
            System.out.println("The money has been deposited into the account");
        }
    }
    public void withdrawFunds(double summ){
        try{
            acc.withdrawFunds(summ);
            System.out.println("The money withdraw into the account");
        } catch(IllegalArgumentException e){
            System.out.println("Error when withdraw funds to the account" + e);
        } catch(InsufficientFundsException e){
            e.printStackTrace();
        }

    }
    public class Account{
        //region
        private String getNumber() {
            return number;
        }
        private boolean isActivity() {
            return activity;
        }
        private double getBalance() {
            return balance;
        }
        private void setActivity(boolean activity) {
            this.activity = activity;
        }
        private void setBalance(double newBalance) {
            this.balance = newBalance;
        }
        //endregion
        private final String number;
        private boolean activity = false;
        private double balance;
        private Account(String number){
            this.number = number;
        }
        private void addingFunds(double summ){
            if(summ < 0){
                throw new IllegalArgumentException();
            } else{
                this.setBalance(this.getBalance() + summ);
            }
        }
        private void withdrawFunds(double summ) throws InsufficientFundsException {
            double res = this.getBalance() - summ;
            if(res >= getBalance()){
                this.setBalance(res);
            } else{
                throw new InsufficientFundsException("Insufficient funds in the account");
            }

        }
    }
}
