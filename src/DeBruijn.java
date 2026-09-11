import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class DeBruijn {
    private HashMap<String, String> graph;
    private int kmerLen;
    private String kmers;

    public DeBruijn(String text, int k){
        kmers = text;
        graph = new HashMap<>();
        kmerLen = k;
        for(int i = 0; i <= text.length(); i++) {
            if (i + kmerLen <= text.length()) {
                String key = getPrefix(kmers.substring(i, i + kmerLen));
                String val = getSuffix(kmers.substring(i, i + kmerLen));
                if (!graph.containsKey(key)) {
                    graph.put(key, val);
                }
                else {
                    graph.replace(key, val + "," + graph.get(key));
                }
            }
        }
    }

    public DeBruijn(ArrayList<String> reads){
        graph = new HashMap<>();
        kmerLen = reads.getFirst().length();
        for(String str: reads) {
            String key = getPrefix(str);
            String val = getSuffix(str);
            if (!graph.containsKey(key)) {
                graph.put(key, val);
            }
            else {
                graph.replace(key, val + "," + graph.get(key));
            }
        }
    }

    public String getGraph() {
        ArrayList<String> keys = new ArrayList<>();
        String ans = "";
        for(String strs: graph.keySet()){
            keys.add(strs);
        }
        ArrayList<String> vals = new ArrayList<>();
        for(int i = 0; i < keys.size(); i++){
            vals.add(keys.get(i));
        }
        Collections.sort(vals);
        Collections.sort(keys);
        for(int i = 0; i < vals.size(); i++){
            ans += vals.get(i);
            ans += " -> " + graph.get(keys.get(i)) + "\n";
        }
        return ans;
    }
    public String getPrefix(String kmer){
        return kmer.substring(0, kmer.length() - 1);
    }
    public String getSuffix(String kmer){
        return kmer.substring(1, kmer.length());
    }
}
