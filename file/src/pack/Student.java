package pack;

import java.io.Serializable;

public class Student implements Serializable
{
    private static Student stu;
    private Student()
    {

    }

    public static Student getInstance()
    {
        if(stu==null)
            stu = new Student();

        return stu;
    }
}
