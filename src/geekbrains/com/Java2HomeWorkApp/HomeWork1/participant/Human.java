package geekbrains.com.Java2HomeWorkApp.HomeWork1.participant;

public class Human implements Participant {

    private final String name;

    public Human(String name) {
        this.name = name;
    }

    @Override
    public int run() {
        return 100;
    }

    @Override
    public int jump() {
        return 2;
    }

    @Override
    public int swim() {
        return 15;
    }

    @Override
    public String toString() {
        return "Human {" +
                "name='" + name + '\'' +
                '}';
    }
}
