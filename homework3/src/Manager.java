public class Manager extends Employee{
    private int baseSalary;
    private int bonus;

    public Manager(String name, int baseSalary,int bonus) {
        super(name);
        this.baseSalary = baseSalary;
        this.bonus = bonus;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    @Override
    int calculateSalary() {
        return this.getBaseSalary()+this.getBonus();
    }

    @Override
    public String toString() {
        return this.getName()+" Manager";
    }
}
