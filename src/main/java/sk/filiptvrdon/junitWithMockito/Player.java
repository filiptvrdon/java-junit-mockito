package sk.filiptvrdon.junitWithMockito;

import java.util.Objects;

public class Player {

    private String name;
    private int age;

    public Player(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        // check obj class for Player class
        if (!(obj instanceof Player)) {
            return false;
        }
        Player p = (Player) obj;
        return Objects.equals(p.getName(), this.getName());
    }
}
