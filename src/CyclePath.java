import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class CyclePath extends CycleGraph{
    private HashMap<String,ArrayList<String>> map;
    private HashMap<String, ArrayList<String>> adjList;
    private HashMap<String, Integer> inDegrees;
    private HashMap<String, Integer> outDegrees;

    public CyclePath(ArrayList<String> graph){
        map = getGraphMap(graph);
        inDegrees = new HashMap<>();
        outDegrees = new HashMap<>();
    }

    public ArrayList<String> getEulerianPath() {
        EulerPathChecker(map);

        String startNode = null;
        for (String node : map.keySet()) {
            int out = outDegrees.getOrDefault(node, 0);
            int in = inDegrees.getOrDefault(node, 0);
            if (out - in == 1) {
                startNode = node;
            }
        }
        if (startNode == null) {// start random if Eulerian cycle
            startNode = map.keySet().iterator().next();
        }

        ArrayList<String> path = new ArrayList<>();
        ArrayList<String> stack = new ArrayList<>();
        HashMap<String, ArrayList<String>> tempGraph = new HashMap<>();
        for (String node : map.keySet()) {
            tempGraph.put(node, new ArrayList<>(map.get(node)));
        }

        stack.add(startNode);
        while (!stack.isEmpty()) {
            String str = stack.get(stack.size() - 1);
            if (tempGraph.containsKey(str) && !tempGraph.get(str).isEmpty()) {
                String u = tempGraph.get(str).remove(0);
                stack.add(u);
            }
            else {
                path.add(0, str);
                stack.remove(stack.size() - 1);
            }
        }
        return path;
    }

    public void EulerPathChecker(HashMap<String, ArrayList<String>> map) {
        adjList = map;
        inDegrees = new HashMap<>();
        outDegrees = new HashMap<>();
        // Initialize all nodes with zero in- and out-degrees
        HashSet<String> allNodes = new HashSet<>();
        for (String start : adjList.keySet()) {
            allNodes.add(start);
            for (String dest : adjList.get(start)) {
                allNodes.add(dest);
            }
        }
        for (String node : allNodes) {
            inDegrees.put(node, 0);
            outDegrees.put(node, 0);
        }

        for (String source : adjList.keySet()) {
            outDegrees.put(source, adjList.get(source).size());
        }

        for (String source : adjList.keySet()) {
            for (String dest : adjList.get(source)) {
                inDegrees.put(dest, inDegrees.get(dest) + 1);
            }
        }
    }

}