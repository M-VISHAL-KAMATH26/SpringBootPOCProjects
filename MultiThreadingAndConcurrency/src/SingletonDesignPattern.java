class Singleton{
    private static volatile Singleton instance;

    private Singleton(){};

    public static synchronized Singleton getInstance(){
        if(instance==null){
            instance=new Singleton();
        }
        return instance;
    }
}

public class SingletonDesignPattern {

    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        System.out.println(s1);
        System.out.println(s2);

        System.out.println(s1 == s2);

    }
}
