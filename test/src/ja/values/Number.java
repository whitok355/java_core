package ja.values;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Number extends AbstractValue{
    protected Integer value;
    public Number(Scanner scan, String className) {
        super(scan, className);
        this.value = this.setValue();
    }

    /**
     *
     * @return value
     */
    @Override
    public Integer getValue() {
        return this.value;
    }

    /**
     *
     * @return request value
     */
    @Override
    protected Integer setValue() {
        return this.requestValue();
    }

    /**
     *
     * @return null are request value
     */
    @Override
    protected Integer requestValue() {
        boolean flag = true;

        while(flag){
            try{
                System.out.println("Please enter "+ getClassName() +" number");
                flag = false;
                return scan.nextInt();
            } catch(InputMismatchException e) {
                System.out.println("Please enter "+ getClassName() +" number in integer:" + e);
            }
        }
        return null;
    }


}
