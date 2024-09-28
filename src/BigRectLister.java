import java.awt.*;
import java.util.ArrayList;


public class BigRectLister
{
    public static void main(String[] args)
    {
        BigRectangleFilter filter = new BigRectangleFilter();
        ArrayList<Rectangle> rectangle = new ArrayList<>();
        rectangle.add(new Rectangle(2, 5));
        rectangle.add(new Rectangle(2, 2));
        rectangle.add(new Rectangle(3, 6));
        rectangle.add(new Rectangle(1, 4));
        rectangle.add(new Rectangle(2, 4));
        rectangle.add(new Rectangle(5, 8));
        rectangle.add(new Rectangle(7, 7));
        rectangle.add(new Rectangle(9, 9));
        rectangle.add(new Rectangle(1, 2));
        for (Rectangle Rect : rectangle)
        {
            boolean BigRect;
            BigRect = filter.accept(Rect);

            if (BigRect)
            {
                System.out.println("The big rectangles are: " + Rect);
            }
        }
    }
}
