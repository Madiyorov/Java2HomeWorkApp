package geekbrains.com.Java2HomeWorkApp.HomeWork1.obstacles;

import geekbrains.com.Java2HomeWorkApp.HomeWork1.participant.Participant;

public class River implements Obstacle {

    private final int width;

    public River(int width) {
        this.width = width;
    }

    @Override
    public boolean passObstacleBy(Participant participant) {
        if (participant.swim() > width) {
            System.out.printf("Участник %s УСПЕШНО ПРЕПЛЫЛ через реку шириной %d метров %n", participant, width);
            return true;
        } else {
            System.out.printf("Участник %s НЕ СМОГ ПЕРЕПЛЫТЬ через реку шириной %d м %n", participant, width);
            return false;
        }
    }
}
