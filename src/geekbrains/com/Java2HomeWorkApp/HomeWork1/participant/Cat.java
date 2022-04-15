package geekbrains.com.Java2HomeWorkApp.HomeWork1.participant;

public class Cat implements Participant {

    private final String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public int run() {
        return 20;
    }

    @Override
    public int jump() {
        return 3;
    }

    @Override
    public int swim() {
        return 2;
    }

    @Override
    public String toString() {
        return "Cat {" +
                "name='" + name + '\'' +
                '}';
    }
}
