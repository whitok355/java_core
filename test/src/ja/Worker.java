package ja;

public class Worker extends People {
    public Worker(int id, double workDay, double bet) {
        super(id, workDay, bet);
    }

    @Override
    public void calcSalary() {
        double calcSalary = this.getWorkDay() * this.getBet();
        this.setSalary(calcSalary);
    }
}
