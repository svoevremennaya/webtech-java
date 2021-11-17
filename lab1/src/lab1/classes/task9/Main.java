package lab1.classes.task9;

public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();
        Ball ball1 = new Ball("blue", 2);
        Ball ball2 = new Ball("red", 5);
        Ball ball3 = new Ball("pink", 3);
        Ball ball4 = new Ball("blue", 4);
        Ball ball5 = new Ball();

        basket.add(ball1);
        basket.add(ball2);
        basket.add(ball3);
        basket.add(ball4);
        basket.add(ball5);

        System.out.println("The weight of ball in basket is "+ basket.weight());
        System.out.println("The number of blue balls is " + basket.numberOfColorBalls("blue"));
    }
}
