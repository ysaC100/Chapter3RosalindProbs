import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;

public class genomeReconstruction {
    public String getGenome(ArrayList<String> kmers){
        HashMap<String, ArrayList<String>> graph = new HashMap<>();
        HashMap<String, Integer> inDegree = new HashMap<>();
        HashMap<String, Integer> outDegree = new HashMap<>();

        for (String kmer : kmers) {
            String prefix = kmer.substring(0, kmer.length() - 1);
            String suffix = kmer.substring(1);

            graph.computeIfAbsent(prefix, k -> new ArrayList<>()).add(suffix);

            outDegree.put(prefix, outDegree.getOrDefault(prefix, 0) + 1);
            inDegree.put(suffix, inDegree.getOrDefault(suffix, 0) + 1);
            // Ensure all nodes exist
            inDegree.putIfAbsent(prefix, inDegree.getOrDefault(prefix, 0));
            outDegree.putIfAbsent(suffix, outDegree.getOrDefault(suffix, 0));
        }

        String start = null;
        for (String node : graph.keySet()) {
            int out = outDegree.getOrDefault(node, 0);
            int in = inDegree.getOrDefault(node, 0);
            if (out - in == 1) {
                start = node;
                break;
            }
        }
        if (start == null) {
            start = graph.keySet().iterator().next(); // any node works for Eulerian cycle
        }

        ArrayList<String> path = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            String current = stack.peek();
            if (graph.containsKey(current) && !graph.get(current).isEmpty()) {
                String next = graph.get(current).remove(0);
                stack.push(next);
            } else {
                path.add(stack.pop());
            }
        }

        // reconstruct string
        Collections.reverse(path);
        StringBuilder ans = new StringBuilder(path.get(0));
        for (int i = 1; i < path.size(); i++) {
            ans.append(path.get(i).charAt(path.get(i).length() - 1));
        }

        return ans.toString();
    }
}
