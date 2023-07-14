package sk.filiptvrdon.junitWithMockito;

public class Animal {

    private Zookeeper zooKeeper;
    public int age;

    public Animal(Zookeeper zooKeeper) {
        this.zooKeeper = zooKeeper;
    }

    public Zookeeper getZooKeeper() {
        return zooKeeper;
    }

    public int getAge() {
        return age;
    }
}