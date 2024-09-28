import java.awt.*;

public class BigRectangleFilter implements Filter
{
    @Override
    public boolean accept(Object x)
    {
     Rectangle Rect = (Rectangle) x;

        if((Rect.width * 2) + (Rect.height * 2) > 10)
        {
            return true;
        }
            return false;
    }
}
