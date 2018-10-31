import java.math.*;
import java.util.Arrays;

public class module2 {
    public static void main(String[] args) {
        Robot robot = new Robot(0,0, Direction.DOWN); // создание конструктора
        moveRobot(robot, -10, 20);
    }

    public enum Direction { // список
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public static class Robot { // текущее положение
        int x;
        int y;
        Direction dir;

        public Robot (int x, int y, Direction dir) { // обзываем переменные
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        public Direction getDirection() {return dir;}

        public int getX() {return x;} // возвращает текущее положение

        public int getY() {return y;}

        public void turnLeft() {
            if      (dir == Direction.UP)    {dir = Direction.LEFT;}
            else if (dir == Direction.DOWN)  {dir = Direction.RIGHT;}
            else if (dir == Direction.LEFT)  {dir = Direction.DOWN;}
            else if (dir == Direction.RIGHT) {dir = Direction.UP;}
        }

        public void turnRight() {
            if      (dir == Direction.UP)    {dir = Direction.RIGHT;}
            else if (dir == Direction.DOWN)  {dir = Direction.LEFT;}
            else if (dir == Direction.LEFT)  {dir = Direction.UP;}
            else if (dir == Direction.RIGHT) {dir = Direction.DOWN;}
        }

        public void stepForward() {
            if (dir == Direction.UP)    {y++;}
            if (dir == Direction.DOWN)  {y--;}
            if (dir == Direction.LEFT)  {x--;}
            if (dir == Direction.RIGHT) {x++;}
        }
    }

    public static void moveRobot(Robot robot, int toX, int toY) {
        if (toX<robot.getX()){
            while (robot.getDirection() != Direction.values()[2]) {
                robot.turnRight();

            }
        }
        else {
            while (robot.getDirection() != Direction.values()[3]) {
                robot.turnRight();

            }
        }
        while (toX!=robot.getX()) {
            robot.stepForward();
        }
        if (toY<robot.getY()){
            while (robot.getDirection() != Direction.values()[1]) {
                robot.turnRight();

            }
        }

        else {
            while (robot.getDirection() != Direction.values()[0]) {
                robot.turnRight();

            }
        }
        while (toY!=robot.getY()) {
            robot.stepForward();
        }
        System.out.println(robot.getY());
    }
}