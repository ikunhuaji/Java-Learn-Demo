package TTT;
class Flag {

    //静态属性直接初始化

    static int zeroCount = 1;

    private boolean isZero = true;

    private String info;

    //非静态代码块

    {

        System.out.println("非静态代码块");

        setZero(false);

        System.out.println("info = " + info);

    }

    //静态代码块

    static {

        zeroCount = 0;

        System.out.println("静态代码块");

    }

    //构造方法

    public Flag() {

        info = "判断结果非真的次数";

        System.out.println("构造方法");

        System.out.println("zeroCount = " + getZeroCount());

    }

    //非静态属性的访问器方法

    public boolean isZero() {

        System.out.println("非静态属性访问器方法");

        return isZero;

    }

    //非静态属性的设置器方法

    public void setZero(boolean isZero) {

        System.out.println("非静态属性设置器方法");

        this.isZero = isZero;

        if(!isZero) {

            zeroCount++;

        }

    }

    //静态属性的访问器方法（静态方法）

    public static int getZeroCount() {

        System.out.println("静态属性访问器方法");

        return zeroCount;

    }

    //普通成员方法

    public void displayZeroCount() {

        System.out.println("zeroCount = " + getZeroCount());

    }

}

