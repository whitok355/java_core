package ja.values;

import java.util.Scanner;

public abstract class AbstractValue {

    protected static Scanner scan;
    protected static String className;
    protected Object value;


    public AbstractValue(Scanner scan, String className){
        AbstractValue.scan = scan;
        AbstractValue.className = className;
    }

    public String getClassName() {
        return className;
    }
    public abstract Object getValue();

    protected abstract Object setValue();
    protected abstract Object requestValue();
}
