package designPatterns.ObserverPattern.subject;

import designPatterns.ObserverPattern.observer.Observer;

public interface Subject {

    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObserver();
}
