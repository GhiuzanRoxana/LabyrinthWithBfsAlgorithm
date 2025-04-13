import java.awt.Color;
import java.util.*;

public class BFS
{
    public static void breadthFirstSearch(Node startNode)
    {
        if (startNode == null)
        {
            System.out.println("Nodul de start nu a fost găsit!");
            return;
        }

        for (Node node : Graph.graphNodes)
        {
            node.pathColor = null;
        }

        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        Map<Node, List<Node>> paths = new HashMap<>();

        queue.add(startNode);
        visited.add(startNode);
        paths.put(startNode, new ArrayList<>(Arrays.asList(startNode)));

        System.out.println("\n=== DRUMURILE GĂSITE ===");
        int drumNr = 1;

        while (!queue.isEmpty())
        {
            Node currentNode = queue.poll();
            List<Node> currentPath = paths.get(currentNode);

            if (currentNode.value == 2)
            {
                System.out.println("\nDrumul " + drumNr + ":");
                System.out.println("Start " + startNode + " -> Ieșire " + currentNode);
                System.out.print("Traseu complet: ");
                for (int i = 0; i < currentPath.size(); i++)
                {
                    System.out.print(currentPath.get(i));
                    if (i < currentPath.size() - 1)
                    {
                        System.out.print(" -> ");
                    }
                }
                System.out.println("\nLungime drum: " + (currentPath.size() - 1) + " pași");
                System.out.println("--------------------");
                drumNr++;

                for (Node pathNode : currentPath)
                {
                    pathNode.pathColor = Color.GREEN;
                }
                continue;
            }

            for (Node neighbor : Graph.graphNodes)
            {
                if (!visited.contains(neighbor) &&
                        Math.abs(currentNode.x - neighbor.x) + Math.abs(currentNode.y - neighbor.y) == 1)
                {

                    queue.add(neighbor);
                    visited.add(neighbor);

                    List<Node> newPath = new ArrayList<>(currentPath);
                    newPath.add(neighbor);
                    paths.put(neighbor, newPath);
                }
            }
        }


        if (drumNr == 1) {
            System.out.println("Nu s-a găsit niciun drum către ieșire!");
        }
    }
}