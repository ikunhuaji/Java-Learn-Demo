public class Test {
    public static void main(String[] args) {

        DeveloperManagementSystem developerManagementSystem = new DeveloperManagementSystem();

        developerManagementSystem.addDeveloper("杨二",70,100);
        developerManagementSystem.addDeveloper("张三",60,200);
        developerManagementSystem.addDeveloper("李四",50,160);

        developerManagementSystem.find("张三");

        developerManagementSystem.printAllName();
        
    }
}

//       Employee[] employees = new Employee[5];
//
//       employees[0]=new Manager("武大",2000,3000);
//       employees[1]=new Developer("杨二",70,100);
//       employees[2]=new Manager("张三",4000,4000);
//       employees[3]=new Developer("李四",50,160);
//       employees[4]=new Manager("王五",5000,3000);
//
//        System.out.println("工资最多的员工:");
//
//       for(int i=0;i<5;i++)
//       {
//           int cnt=0;
//
//           for(int j=0;j<5;j++)
//           {
//               if(employees[i].compareTo(employees[j])==0||employees[i].compareTo(employees[j])==1)
//                   cnt++;
//           }
//
//           if(cnt==5)System.out.println(employees[i].getName());
//       }

//    Manager manager = new Manager("张三",5000,2000);
//    Developer developer = new Developer("李四",50,160);
//
//
//        System.out.println(manager.toString()+" 基本工资"+manager.getBaseSalary()+" 奖金"+manager.getBonus());
//                System.out.println(developer.toString()+" 小时工资"+developer.getHourlyRate()+" 工作小时数"+developer.getHoursWorked());