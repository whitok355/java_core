package ja;

import java.util.Scanner;

public class Program {
    User user = new User("Ivan", "Ivanov", "Ivanovich");
    Scanner scan = new Scanner(System.in);
    public void createAcc(){
        Boolean flag = true;
            int res = user.createAccount(scan);
            switch(res){
                case 1:
                    router();
                    flag = true;
                    break;
                case 0:
                    flag = false;
                    Msg.printMsg("Account block or no exist");
                    break;
            }
    }

    public void router(){
        Boolean flag = true;
        while(flag){
            try{
                System.out.println("Please select an action.\n1-adding funds\n2-withdraw funds\n3-find out the account balance \n4-Exit");
                int action = scan.nextInt();
                switch(action){
                    case 1:
                        Msg.printMsg("Enter the deposit amount");
                        user.addingFunds(scan.nextDouble());
                        break;
                    case 2:
                        Msg.printMsg("Enter the withdrawal amount");
                        user.withdrawFunds(scan.nextDouble());
                        break;
                    case 3:
                        Msg.printMsg(String.format("User %s %s, Account number: %s, balance: %s",user.getFirstName(),user.getSecondName(), user.getNumber(), user.getBalance()));
                        break;
                    case 4:
                        flag = false;
                        Msg.printMsg("See you soon");
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }
}
