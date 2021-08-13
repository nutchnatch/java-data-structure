package queue.questions;

public abstract class Animal {

    private int order;
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract String name();

    public void setOrder(int order) {
        this.order = order;
    }

    public int getOrder() {
        return this.order;
    }

    public boolean isOlderThan(Animal a) {
        return this.order < a.order;
    }
}
