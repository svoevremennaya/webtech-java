package lab1.classes.task9;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    List listBall = new ArrayList();

    public Basket() {

    }

    public void add(Ball ball) {
        listBall.add(ball);
    }

    public int weight() {
        int w = 0;
        for (Object element : listBall) {
            w += ((Ball)element).weight;
        }
        return w;
    }

    public int numberOfColorBalls(String color) {
        int n = 0;
        for (Object element : listBall) {
            if (((Ball)element).color == color) {
                n++;
            }
        }
        return n;
    }
}
