package ja;

public abstract class People {
    //region
    public int getId() {
        return id;
    }
    public double getWorkDay() {
        return workDay;
    }
    public double getBet() {
        return bet;
    }
    public double getSalary() {
        return salary;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setWorkDay(double workDay) {
        this.workDay = workDay;
    }
    public void setBet(double bet) {
        this.bet = bet;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    //endregion
    protected int id;
    protected double workDay;
    protected double bet;
    protected double salary;

    public People(int id, double workDay, double bet){
        this.id = id;
        this.workDay = workDay;
        this.bet = bet;
        this.salary = 0;
    }

    public abstract void calcSalary();

}
