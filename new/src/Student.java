public class Student {
        public String name;
        public int id;
        public int age;

//        public getnew()
//        {
//
//        }

        public Student (int x)
        {
           // this();
            System.out.println(x);
        }
        public void study()
        {
            System.out.println(this.age+": 学习");
            this.age++;
        }
        public void playGames()
        {
            this.fly();
            System.out.println(this.age+": 打游戏");
            this.age++;
        }
        public void printAll()
        {
            System.out.println(this.name+" "+this.id+" "+this.age);
        }
        public void fly()
        {
            System.out.println(this.name+"在"+this.age+"岁开直升机");
        }
}
