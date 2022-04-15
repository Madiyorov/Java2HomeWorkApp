package geekbrains.com.Java2HomeWorkApp.HomeWork1;

import geekbrains.com.Java2HomeWorkApp.HomeWork1.obstacles.Obstacle;
import geekbrains.com.Java2HomeWorkApp.HomeWork1.obstacles.River;
import geekbrains.com.Java2HomeWorkApp.HomeWork1.obstacles.Track;
import geekbrains.com.Java2HomeWorkApp.HomeWork1.obstacles.Wall;
import geekbrains.com.Java2HomeWorkApp.HomeWork1.participant.Cat;
import geekbrains.com.Java2HomeWorkApp.HomeWork1.participant.Human;
import geekbrains.com.Java2HomeWorkApp.HomeWork1.participant.Participant;
import geekbrains.com.Java2HomeWorkApp.HomeWork1.participant.Robot;

public class Demonstration {

    public static void main(String[] args) {
        Human human = new Human("Ислом");
        Cat cat = new Cat("Барсик");
        Robot robot = new Robot("Робокоп");

        Track track = new Track(100);
        Wall wall = new Wall(15);
        River river = new River(150);

        Participant[] participants = {human, cat, robot};
        Obstacle[] obstacles = {track, wall, river};

        for (Participant participant : participants) {
            for (Obstacle obstacle : obstacles) {
                if (!obstacle.passObstacleBy(participant)) {
                    System.out.printf("Участник %s ВЫБЫВАЕТ из соревнований %n", participant);
                    break;
                }
            }
        }
    }
}
