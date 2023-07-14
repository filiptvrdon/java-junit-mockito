package sk.filiptvrdon.junitWithMockito;

public class Zookeeper {

    private String name;

    public Zookeeper(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "ZooKeeper{" +
                "name='" + name + '\'' +
                '}';
    }
}