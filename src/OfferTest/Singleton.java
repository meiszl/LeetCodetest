package OfferTest;

public class Singleton {
    private static class SingletonHodler{
        private static Singleton ourInstance = new Singleton();
    }
    public static Singleton getInstance(){
        return SingletonHodler.ourInstance;
    }
    private Singleton(){

    }
}
