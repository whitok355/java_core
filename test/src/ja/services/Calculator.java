package ja.services;

public class Calculator {

    private final int firstNumber;
    private final String operation;
    private final int secondNumber;
    private int answer;

    public Calculator(int firstNumber, int secondNumber, String operation) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operation = operation;
    }

    //region getters and setters
    public int getSecondNumber() {
        return secondNumber;
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public String getOperation() {
        return operation;
    }

    public int getAnswer() {
        this.calculate();
        return this.answer;
    }

    private void setAnswer(int newAnswer) {
        this.answer = newAnswer;
    }
    //endregion

    public void calculate(){

        int res;

        switch(this.operation){
            case "+":
                res = this.firstNumber + this.secondNumber;
                setAnswer(res);
                break;
            case "-":
                res = this.firstNumber - this.secondNumber;
                setAnswer(res);
                break;
            case "/":
                res = this.firstNumber / this.secondNumber;
                setAnswer(res);
                break;
            case "*":
                res = this.firstNumber * this.secondNumber;
                setAnswer(res);
                break;
            default:
                System.out.println("This is operation not found");
            break;
        }
    }
}
