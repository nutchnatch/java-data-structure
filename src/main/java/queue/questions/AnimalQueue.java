package queue.questions;

import java.util.LinkedList;

public class AnimalQueue {

    public static void main(String[] args) {
        AnimalQueue animals = new AnimalQueue();
        animals.enqueue(new Cat("Kiki"));
        animals.enqueue(new Cat("Kari"));
        animals.enqueue(new Dog("Beji"));
        animals.enqueue(new Cat("Reki"));
        animals.enqueue(new Dog("Dexter"));

//        System.out.println(animals.dequeueAny().name());
//        System.out.println(animals.dequeueAny().name());
        System.out.println(animals.dequeueDog().name());
        System.out.println(animals.dequeueCat().name());
    }

    LinkedList<Dog> dogs = new LinkedList<Dog>();
    LinkedList<Cat> cats = new LinkedList<Cat>();

    private int order = 0;

    public void enqueue(Animal a) {
        a.setOrder(order);
        order ++;
        if(a instanceof Dog) {
            dogs.addLast((Dog)a);
        } else if(a instanceof Cat)  {
            cats.addLast((Cat) a);
        }
    }

    public int size() {
        return dogs.size() + cats.size();
    }

    public Dog dequeueDog() {
        return dogs.poll();
    }

    public Dog peekDog() {
        return dogs.peek();
    }

    public Cat dequeueCat() {
        return cats.poll();
    }

    public Cat peekCat() {
        return cats.peek();
    }

    public Animal dequeueAny() {
        if(dogs.size() == 0) {
            return dequeueCat();
        } else if(cats.size() == 0) {
            return dequeueDog();
        }

        Dog dog = dogs.peek();
        Cat cat = cats.peek();
        if(dog.isOlderThan(cat)) {
            return dogs.poll();
        } else {
            return cats.poll();
        }
    }

    public Animal peekAny() {
        if(dogs.size() == 0) {
            return peekCat();
        } else if(cats.size() == 0) {
            return peekDog();
        }

        Dog dog = dogs.peek();
        Cat cat = cats.peek();
        if(dog.isOlderThan(cat)) {
            return dog;
        } else {
            return cat;
        }
    }
}
