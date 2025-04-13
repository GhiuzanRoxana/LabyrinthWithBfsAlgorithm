import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Graph
{
    public static ArrayList<ArrayList<Node>> matrix = new ArrayList<>();
    public static ArrayList<Node> graphNodes = new ArrayList<>();

    public static void readMatrixFromFile(String filename)
    {
        try
        {
            Scanner scanner = new Scanner(new File(filename));
            int rowIndex = 0;
            while (scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                ArrayList<Node> row = new ArrayList<>();
                for (int colIndex = 0; colIndex < line.length(); colIndex++)
                {
                    int value = Character.getNumericValue(line.charAt(colIndex));
                    Node node = new Node(rowIndex, colIndex, value);
                    row.add(node);
                    if (value != 0)
                    {
                        graphNodes.add(node);
                    }
                }
                matrix.add(row);
                rowIndex++;
            }
            scanner.close();
        } catch (FileNotFoundException e)
        {
            System.out.println("File not found: " + filename);
            e.printStackTrace();
        }
    }

    public static Node findStartNode()
    {
        for (Node node : graphNodes)
        {
            if (node.value == 3)
            {
                return node;
            }
        }
        return null;
    }
}

