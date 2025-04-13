import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Window extends JPanel
{
    private boolean highlightPaths;

    public Window(boolean highlightPaths)
    {

        this.highlightPaths = highlightPaths;
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        for (ArrayList<Node> row : Graph.matrix)
        {
            for (Node node : row)
            {
                g.setColor(node.colors.getOrDefault(node.value, Color.BLACK));
                if (highlightPaths && node.value == 1 && node.pathColor == Color.GREEN)
                {
                    g.setColor(node.pathColor);
                }
                g.fillRect(node.y * Node.radius, node.x * Node.radius, Node.radius, Node.radius);
                g.setColor(Color.BLACK);
                g.drawRect(node.y * Node.radius, node.x * Node.radius, Node.radius, Node.radius);
                g.setColor(Color.BLUE);
                g.drawRect(node.y * Node.radius, node.x * Node.radius, Node.radius - 1, Node.radius - 1);
            }
        }
    }
}



