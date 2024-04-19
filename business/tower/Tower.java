package business.tower;

import java.util.LinkedList;
import java.util.List;

import business.flyable.Flyable;


public class Tower {
    private List<Flyable> observers;
    protected List<Flyable> landings;

    public Tower() {
        this.observers = new LinkedList<>();
        this.landings = new LinkedList<>();
    }

    public void register(Flyable flyable) throws Exception {
        this.observers.add(flyable);
    }

    public void unregister(Flyable flyable) throws Exception {
        this.observers.remove(flyable);
    }

    protected void conditionsChanged() throws Exception {
        for (Flyable flyable : this.observers) {
            flyable.updateConditions();
            if (flyable.hasLanded()) {
                this.landings.add(flyable);
            }
        }
    }
}
