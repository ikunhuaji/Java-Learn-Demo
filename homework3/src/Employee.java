public abstract class Employee implements Comparable{

    abstract int calculateSalary();

    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString()
    {
        return this.getName();
    }

    @Override
    public int compareTo(Employee employee) {
        if(this.calculateSalary()==employee.calculateSalary())return 0;
        else if(this.calculateSalary()>employee.calculateSalary())return 1;
        else return -1;
    }
}

