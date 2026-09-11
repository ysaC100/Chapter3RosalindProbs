import java.util.*;

public class CycleGraph {
    private ArrayList<String> reads;
    private int kmerLen;
    private HashMap<String, ArrayList<String>> graphMap;
    private int maxNum;

    private String path;
    private ArrayList<String> setPath;
    public CycleGraph(){//ArrayList<String> path, int len){
        //reads = path;
        //kmerLen = len;
        graphMap = new HashMap();
        maxNum = 0;
        path = "";
        setPath = new ArrayList<>();
    }
    public CycleGraph(ArrayList<String> paths, int len){
        reads = paths;
        kmerLen = len;
        graphMap = new HashMap();
        maxNum = 0;
        graphMap = getGraphMap(reads);
        path = "";
        setPath = new ArrayList<>();
    }

    public HashMap<String, ArrayList<String>> getGraphMap(ArrayList<String> path) {
        HashMap<String, ArrayList<String>> tempGraph = new HashMap<>();
        for (String edgeString : path) {
            // Split the string by " -> "
            String[] parts = edgeString.split(" -> ");
            String source = parts[0];
            String destinationsString = parts[1];
            String[] destinationNodes = destinationsString.split(",");
            ArrayList<String> neighbors = tempGraph.computeIfAbsent(source, k -> new ArrayList<>());
            for (String dest : destinationNodes) { // Add all destination nodes to the list of neighbors
                neighbors.add(dest.trim()); // Trim any spaces
            }
        }
        return tempGraph;
    }

    public ArrayList<String> findEulerianCycle() {
        Stack<String> currentPath = new Stack<>();
        ArrayList<String> cycle = new ArrayList<>();
        String startNode = graphMap.keySet().iterator().next(); // Find a starting node
        currentPath.push(startNode);
        while (!currentPath.isEmpty()) {
            String currentNode = currentPath.peek();
            if (graphMap.get(currentNode) != null && !graphMap.get(currentNode).isEmpty()) {
                String nextNode = graphMap.get(currentNode).remove(0); // Take and remove an edge
                currentPath.push(nextNode);
            }
            else {
                cycle.add(0, currentPath.pop()); // Add to the beginning of the cycle
            }
        }
        return cycle;
    }

}
