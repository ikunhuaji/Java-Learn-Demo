public class Developer extends Employee{
    private int hourlyRate,hoursWorked;

    public Developer(String name, int hourlyRate,int hoursWorked) {
        super(name);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    public int getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(int hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    @Override
    int calculateSalary() {
        return this.getHourlyRate()*this.getHoursWorked();
    }

    @Override
    public String toString() {
        return this.getName()+" Developer";
    }
}
