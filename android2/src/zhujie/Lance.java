package zhujie;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE,ElementType.METHOD})//限定注解的作用类型，如函数，类……
@Retention(RetentionPolicy.SOURCE)//限定标记的注解的存储方式
public @interface Lance {
    String value();
    int age() default 1;

    String id();
}
