import java.awt.Color;
import java.util.HashMap;

public class Node
{
    public int x, y;
    public int value;
    public static int radius = 100;

    public HashMap<Integer, Color> colors = new HashMap<>()
    {
        {
            put(0, Color.BLACK);
            put(1, Color.WHITE);
            put(2, Color.RED);
            put(3,new Color(173, 216, 230));
        }
    };

    public Color pathColor = Color.GREEN;

    public Node(int x, int y, int value)
    {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    @Override
    public String toString()
    {
        return "(" + x + ", " + y + ")";
    }
}
