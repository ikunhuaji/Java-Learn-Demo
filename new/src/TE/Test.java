package TE;


class C {
    C(  ) { System.out.print("C"); }
}
class A {
    C c = new C(  );
    A(  ) {
        this("A");
        System.out.print("A");
    }
    A(String s) {
        System.out.print(s);
    }
}
class B extends A {
    B(  ) {
        super("B");
        System.out.print("B");
    }
    public static void main(String[] args) {
        new B(  );
    }
}

