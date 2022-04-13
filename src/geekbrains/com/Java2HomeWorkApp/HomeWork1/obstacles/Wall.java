package geekbrains.com.Java2HomeWorkApp.HomeWork1.obstacles;

import geekbrains.com.Java2HomeWorkApp.HomeWork1.participant.Participant;

public class Wall implements Obstacle {

    private final int height;

    public Wall(int length) {
        this.height = length;
    }

    @Override
    public boolean passObstacleBy(Participant participant) {
        if (participant.jump() > height) {
            System.out.printf("Участник %s УСПЕШНО ПЕРЕПРЫГПУЛ через стену высотой %d м %n", participant, height);
            return true;
        } else {
            System.out.printf("Участник %s НЕ СМОГ ПЕРЕПРЫГНУТЬ через стену высотой %d м %n", participant, height);
            return false;
        }
    }
}
