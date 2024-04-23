package others;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.ref.ReferenceQueue;

/**
 * @author 【享学课堂】 King老师
 * 方法句柄（MethodHandle）使用案例
 **/
public class MethodHandleDemo222 {
    static  class  Bike  {

        void   sound()  {
            System.out.println( "ding  ding ding");
        }
    }
    static  class  Animal  {
        void  sound()
        {
            System.out.println( "wow  wow wow");
        }
    }

    static  class  Man  extends  Animal  {
        @Override
        void  sound()  {
            System.out.println(  "ha ha ha");
        }
    }

    void   sound(Object  o)  throws  Throwable  {
            //方法句柄--工厂方法Factory
            MethodHandles.Lookup  lookup  =  MethodHandles.lookup();
            //方法类型表示接受的参数和返回类型（第一个参数是返回参数）
            MethodType  methodType  =  MethodType.methodType(void.class);
            //拿到具体的MethodHandle(findVirtual相当于字节码)
            MethodHandle  methodHandle  =  lookup.findVirtual(o.getClass(),  "sound",  methodType);
             methodHandle.invoke(o);
    }

    public  static  void  main(String[]  args)  throws  Throwable {
         new MethodHandleDemo222().sound(new Bike());//每次送入的实例不一样

        new MethodHandleDemo222().sound(new Animal());

        new MethodHandleDemo222().sound(new Man());

    }
}
