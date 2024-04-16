package business.tower;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import business.flyable.Flyable;

public class Tower {
    private List<Flyable> observers;

    public Tower() {
        this.observers = new LinkedList<>();
    }

    public void register(Flyable flyable) {
        this.observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        this.observers.remove(flyable);
    }


    protected void conditionsChanged() {
        for (Flyable flyable : this.observers) {
            flyable.updateConditions();
        }
    }
}
