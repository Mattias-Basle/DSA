package designPatterns.SingletonPattern;

public class SingletonClient {
    public static void main(String[] args) {
        EnumSingleton singleton = EnumSingleton.UNIQUE_INSTANCE;
    }
}
