package Generic_Method_Class_Interface;

public class GenericInnerMethod {
    public class Inner<T>{
        private T key;
        public Inner(T key) {
            this.key = key;
        }
        public T getKey() {
            return key;
        }

//        public E setKey(E key){
//            this.key=key;
//        }
//        报错：类未声明泛型 E，调用E，机器无法识别
//        不是泛型方法
        public <E> E show(Inner<E>op){
            return op.getKey();
        }
    }
}
