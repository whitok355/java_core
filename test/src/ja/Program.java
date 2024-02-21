package ja;

import ja.services.Calculator;
import ja.utils.Decorator;
import ja.values.Number;
import ja.values.Operation;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Program {
    private final Scanner scan = new Scanner(System.in);
    public void start(){

        System.out.println("Hello it is first homework with seminar Java Core!");

        try{
            System.out.println("Shall we start the calculation? \n 1: yes \n 2: no");
            choiceRoute(scan.nextInt());
        } catch(InputMismatchException e){
            System.out.println("Please enter type integer in route: " + e);
        }
    }

    /**
     *
     * @param route 1 -calc ,2 exit
     */
    private void choiceRoute(int route){
        boolean flag = true;

        while(flag){
            if(route == 1){
                this.calculate();
            } else if( route == 2) {
                this.endCalculate();
                flag = false;
            } else{
                System.out.println("Please enter 1 are 2");
            }
        }
    }
    private void calculate(){
        Number firstNumber = new Number(scan, "first");
        Number secondNumber = new Number(scan, "second");
        Operation operation = new Operation(scan, "operation");

        Calculator calculator = new Calculator(firstNumber.getValue(),
                secondNumber.getValue(),
                operation.getValue()
        );

        Decorator decorationAnswer = new Decorator(firstNumber.getValue(),
                secondNumber.getValue(),
                operation.getValue(),
                calculator.getAnswer());

        System.out.println(decorationAnswer.toString());
    }
    private void endCalculate(){
        System.out.println("Good bye see you later");
    }
}
