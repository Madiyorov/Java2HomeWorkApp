package geekbrains.com.Java2HomeWorkApp.HomeWork1.participant;

public class Robot implements Participant {

    private final String name;

    public Robot(String name) {
        this.name = name;
    }

    @Override
    public int run() {
        return 1000;
    }

    @Override
    public int jump() {
        return 10;
    }

    @Override
    public int swim() {
        return 100;
    }

    @Override
    public String toString() {
        return "Robot {" +
                "name='" + name + '\'' +
                '}';
    }
}
