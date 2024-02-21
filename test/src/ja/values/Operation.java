package ja.values;

import java.util.Scanner;

public class Operation extends AbstractValue{

    protected String value;

    public Operation(Scanner scan, String className) {
        super(scan, className);
        this.value = this.setValue();
    }

    @Override
    public String getValue() {
        return value;
    }
    @Override
    protected String setValue() {
        return this.requestValue();
    }
    @Override
    protected String requestValue() {
        boolean flag = true ;

        while(flag){
            try{
                System.out.println("Please enter " + getClassName());
                scan.nextLine();
                String checkValue = this.checkOperation(scan.nextLine());
                flag = false;
                return checkValue;
            } catch(IllegalArgumentException e){
                System.out.println(e);
            }
        }
        return null;
    }

    /**
     *
     * @param operation operation value
     * @return
     */
    private String checkOperation(String operation){
        if(operation.contains("+")
                || operation.contains("-")
                || operation.contains("*")
                || operation.contains("/")){
            System.out.println(123);
            return operation;
        } else{
            System.out.println(312);
            throw new IllegalArgumentException("Please enter next values operation + - / *");
        }
    }


}
