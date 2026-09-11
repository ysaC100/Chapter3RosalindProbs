import java.util.ArrayList;
import java.util.HashMap;

public class OverlapGraph {
    private ArrayList<String> kmers;
    private HashMap<String, String> graph;
    private int kmerLen;

    public OverlapGraph(ArrayList<String> pattern){
        kmers = pattern;
        graph = new HashMap<>();
        kmerLen = pattern.getFirst().length();
        for(int i = 0; i < kmers.size(); i++){
            String key = kmers.get(i);
            for(int j = 0; j < kmers.size(); j++) {
                String val = kmers.get(j);
                if (getSuffix(key).equals(getPrefix(val))){
                    graph.put(key, val);
                }
            }
        }
    }

    public String getGraph() {
        ArrayList<String> keys = new ArrayList<>();
        String ans = "";
        for(String strs: graph.keySet()){
            keys.add(strs);
        }
        /*ArrayList<String> vals = new ArrayList<>();
        for(String strs: graph.values()){
            vals.add(strs);
        }*/
        for(int i = 0; i < keys.size(); i++){
            ans += keys.get(i);
            ans += " -> " + graph.get(keys.get(i)) + "\n";
        }
        return ans;
    }
    public String getPrefix(String kmer){
        return kmer.substring(0, kmerLen - 1);
    }
    public String getSuffix(String kmer){
        return kmer.substring(1, kmerLen);
    }
}