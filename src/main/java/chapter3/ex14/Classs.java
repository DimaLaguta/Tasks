package chapter3.ex14;

public class Classs {
    public static  Runnable f(Runnable... objects){
       return ()->{
            for(Runnable i : objects){
                i.run();
            }
        };
    }
}
