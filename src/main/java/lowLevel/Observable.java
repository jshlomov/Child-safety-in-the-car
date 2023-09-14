package lowLevel;

import HighLevel.Observer;

import java.util.ArrayList;

public class Observable <T> {
    public ArrayList<Observer<T>> observers = new ArrayList<>();

    public void addObserver(Observer<T> observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer<T> observer) {
        observers.remove(observer);
    }

    public void notifyObservers(T data) {
        for (var observer : observers) {
            observer.update(data);
        }
    }
}

