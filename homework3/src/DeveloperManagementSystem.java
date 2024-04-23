import java.util.ArrayList;

public class DeveloperManagementSystem
{
    ArrayList<Developer> developers;

    public DeveloperManagementSystem()
    {
        developers = new ArrayList<>();
    }
    //添加开发人员
    public void addDeveloper(String name, int hourlyRate,int hoursWorked)
    {
        Developer developer = new Developer(name, hourlyRate, hoursWorked);
        developers.add(developer);
    }

    //根据姓名查找并且打印姓名、工资
    public void find(String name)
    {
        for(Developer it:developers)
        {
            if(it.getName()==name)
            {
                System.out.println(name + " " + it.calculateSalary());
            }
        }
    }

    //获取所有开发人员姓名
    public void printAllName()
    {
        for(Developer it: developers)
        {
            System.out.println(it.getName());
        }
    }
}
