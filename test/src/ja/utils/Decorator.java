package ja.utils;

public class Decorator {
    private final int firstNumber;
    private final int secondNumber;
    private final String operation;
    private final int answer;

    public Decorator(int firstNumber, int secondNumber, String operation, int answer) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operation = operation;
        this.answer = answer;
    }

    @Override
    public String toString() {
        return String.format("The answer to your task with parameters:" +
                "\nfirst number: %s" +
                "\nsecond number: %s" +
                "\noperation: %s" +
                "\nanswer: %s",  firstNumber, secondNumber, operation, answer
        );
    }
}
