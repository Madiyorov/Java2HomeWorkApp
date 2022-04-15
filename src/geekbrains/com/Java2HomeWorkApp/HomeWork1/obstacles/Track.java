package geekbrains.com.Java2HomeWorkApp.HomeWork1.obstacles;

import geekbrains.com.Java2HomeWorkApp.HomeWork1.participant.Participant;

public class Track implements Obstacle {

    private final int length;

    public Track(int length) {
        this.length = length;
    }

    @Override
    public boolean passObstacleBy(Participant participant) {
        if (participant.run() > length) {
            System.out.printf("Участник %s УСПЕШНО ПРОБЕЖАЛ по дорожке длиной %d метров %n", participant, length);
            return true;
        } else {
            System.out.printf("Участник %s НЕ СМОГ ПРОБЕЖАТЬ по дорожке длиной %d м %n", participant, length);
            return false;
        }
    }
}
