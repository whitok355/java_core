package ja;

public class Freelancer extends People {
    public Freelancer(int id, double workDay, double bet) {
        super(id, workDay, bet);
    }

    @Override
    public void calcSalary() {
        double calcSalary = this.getWorkDay() * 8 * this.getBet();
        this.setSalary(calcSalary);
    }
}
