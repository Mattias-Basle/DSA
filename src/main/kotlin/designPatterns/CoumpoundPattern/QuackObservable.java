package designPatterns.CoumpoundPattern;

public interface QuackObservable {

    public void registerObserver(Observer observer);
    public void notifyObservers();
}
