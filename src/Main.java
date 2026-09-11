import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> strands = new ArrayList<>();
        /*strands.add("ACCGA");
        strands.add("CCGAA");
        strands.add("CGAAG");
        strands.add("GAAGC");
        strands.add("AAGCT");*/
        /*Scanner in = new Scanner(System.in);
        File txt = new File("rosalind_ba3b.txt");
        try {
            in = new Scanner(txt);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while(in.hasNext()){
            String sample = in.nextLine();
            strands.add(sample);
        }
        String ans = "";
        int kmerLen = strands.getFirst().length();
            ans += strands.getFirst();
            for(String str: strands) {
                if(!str.equals(strands.getFirst())) {
                    ans += str.substring(kmerLen - 1);
                }
            }
        System.out.println(ans);*/
        Scanner in = new Scanner(System.in);
        /*File txt = new File("rosalind_ba3c.txt");
        try {
            in = new Scanner(txt);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while(in.hasNext()){
            String sample = in.nextLine();
            strands.add(sample);
        }*/
        /*strands.add("ATGCG");
        strands.add("GCATG");
        strands.add("CATGC");
        strands.add("AGGCA");
        strands.add("GGCAT");*/
        //OverlapGraph graph = new OverlapGraph(strands);
        //System.out.println(graph.getGraph());
        //DeBruijn deBruijn = new DeBruijn("GAAAACATTCCAGTCAAGGGCCCATCTTCGTTTACTGGTTGAGCAGTAGGAGGGAGCGGATGGTTGATATATCGTAAGACCAGCTAGGTCGTAGTAACTTGATAGCGCTAGGTTTATTGTGAAGTGCTTATAATACGTTATTGCAGTGGAGTGAAGCTGAACGAGGTCTCAAGTGGAGAGCTAACGTAAAACACTCAACGACTTATTATGAACAGACGCACATATTTCGTATAAGCCGCGTCTATGCCCTTAGTCTACGCCCAAGGATGTTCTAAATTAGCATATCTTTCATTCCGAACCTACGAACGAGGGGCAGGCGGTTTGGTTTAGTGGCCTTTAAGCGCTGCGCCTTCATATAGCTCCGCTATCCCGGTGTTACCAGTTCGTGAACTTACTGGGATTTATCGCTCGTGCCACCCTTGAAAGGACATAAAAGCGGGGGTTCTCTTGCGCGAGGTCATATACGACGATTACAGCCCGAAGTAGTCGGAATAGTGTAATGTGGGACGTTAGTGGAAAGACAATCAAACCTAGCGATTAATTGACCAGGTACGCTTTTAGTACAGACGCGCATAATCGTCGCAAAATGGGGGGGCGATGCTGAGGTGAGTCGTCGCCTGTGAGCTGATCGCTTCATCCATAAAGCGTTGTCCACTTGTCCAGCTCACGTTCTTAGACATCCGCACGTCGCAGTCCAATGGCGGCCGCGTACCGTACTCAGTCAGAGGGGGACACCTAAATGACTAAAGACCCCTATCAAGATCTACTGGAAGACGAGCATGCCCTTGCTTTTCCCATCGCTGAATTTTTCCGAATAACCTCCCTCGTCATGTGGTCTCGCCGATTTCGTCATAGGACAGATGATTTTATCGTTAACAGCAGTTTAGGTAGCGAAGGGTTATCATCATCGGCAAACGGAGCGGCGTTTTCAACCTTCAGTGGAAGAGATACACCTTTTGATCACTGCTCGAGAGGGAGCTTCAAAGCGTAATATAAAGGCCCATCACTGGCAGAAAAACCACGTCATCACTACCACCTGGGAGTCCAAACAGTGGAGGAGTCCGCTTTAGAGTAGAGTTAAGAAAAGGGTCGCATTTGCCATAGCACCCTTACTATTCCCCCGCGTTTGCACGATGGCTCGAGCTGTTTTTCATGTCGCACCCATCGTCTGACGTTATGTAGTCGTTCATGGGCGAGAGATAGAGCGATACTAAACCTGAACAGATGTTAGTGGCTTATGCAACGACACCCATAGCCTATAAGAGTAGCTGGGGCTATACCTTAATGGCCTGCAACTTAACCCGAATATGCAGTGAGCAGATCGGTAAATGTCGTATACAGCGTTTCGCGTACACTCGGCGAGGATCGTACGACTAAATTTGCATCTCAGAAGCGCTCTCAGTTGATTGCAACGAAGGCCAATTTAAAAGCAAGGAAGAGTGACTCGATCCTCCTTAACTATTCTTCATCCCATCTTTTTGACAGGCCCGTTCCACGGCAAGATTAACGAGTAGGGGGTCAAGACTTGAGAATGCTAGCTATATAAGGTGAGCCGTAGATCCCTGAGTCGCGCGGAACAAGCGCGTCAGTCTGCTACAACTTGATAGCTCGCGTCCGCCACACTCACGCGTCCTCTGATGCATAGGCACCTCTGACGAGCAACAAGAAATTATCTATTTGCACCGTCCATTACTAGTTCGGTTGAGTCGCCTATAGGAGGAACTTATGCATGGACGGCGTTAGGACCCGTTGGTTTTGTTGTTCGTGAATGTAAGGGAGTCCGGTCCTACTGTATATCTGTCACAGCGGAGAGTGATGAAAGTCTACATCCGTCATCTTCGTGAGCGCGCGTGCCGCTTAGAGTCGTTGAGCCACGGATACTGATTTAGCGAATCAAATGTCCCGTTGGTGAGACTTGTCCTACACGTCGTCGTTGGATCTTGACCTTTCTATTTTGGAAACTCTGCAAGACGCTCAACTTTGGCTGACAGCTAGCCTTG", 12);
        //System.out.println(deBruijn.getGraph());
        ArrayList<String> reads = new ArrayList<>();
       /* File txt2 = new File("rosalind_ba3e.txt");
        try {
            in = new Scanner(txt2);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while(in.hasNext()){
            String sample = in.nextLine();
            reads.add(sample);
        }
        DeBruijn deBruijn2 = new DeBruijn(reads);
        System.out.println(deBruijn2.getGraph());*/
        String[] edges = {
                "0 -> 3",
        "1 -> 0",
        "2 -> 1,6",
        "3 -> 2",
        "4 -> 2",
        "5 -> 4",
        "6 -> 5,8",
                "7 -> 9",
                "8 -> 7",
                "9 -> 6"
        };


        /*for (String edge : edges) {
            String[] parts = edge.split(" -> ");
            cyclePath1.addEdge(parts[0], parts[1]);
        }

        ArrayList<String> cycle = cyclePath1.findEulerianCycle();
        if (!cycle.isEmpty()) {
            // Reconstruct the de Bruijn sequence if needed
            StringBuilder deBruijnSequence = new StringBuilder(cycle.get(0));
            for (int i = 1; i < cycle.size(); i++) {
                deBruijnSequence.append(cycle.get(i).charAt(cycle.get(i).length() - 1));
            }
            System.out.println("Eulerian Cycle: " + String.join("->", cycle));
            System.out.println("De Bruijn Sequence: " + deBruijnSequence.toString());
        } else {
            System.out.println("No Eulerian cycle found.");
        }*/
        File txt2 = new File("rosalind_ba3g.txt");
        try {
            in = new Scanner(txt2);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while(in.hasNext()){
            String sample = in.nextLine();
            reads.add(sample);
        }
        /*strands.add("0 -> 3");
        strands.add("1 -> 0");
        strands.add("2 -> 1,6");
        strands.add("3 -> 2");
        strands.add("4 -> 2");
        strands.add("5 -> 4");
        strands.add("6 -> 5,8");
        strands.add("7 -> 9");
        strands.add("8 -> 7");
        strands.add("9 -> 6");
        CycleGraph cyclePath1 = new CycleGraph(reads, 1);
        ArrayList<String> eulerianCycle = cyclePath1.findEulerianCycle();
        // Format the output as requested
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < eulerianCycle.size(); i++) {
            sb.append(eulerianCycle.get(i));
            if (i < eulerianCycle.size() - 1) {
                sb.append("->");
            }
        }
        System.out.println(sb.toString());*/
        strands.add("0 -> 2");
        strands.add("1 -> 3");
        strands.add("2 -> 1");
        strands.add("3 -> 0,4");
        strands.add("6 -> 3,7");
        strands.add("7 -> 8");
        strands.add("8 -> 9");
        strands.add("9 -> 6");
        CyclePath cyclePath1 = new CyclePath(reads);
        ArrayList<String> eulerianCycle = cyclePath1.getEulerianPath();
        // Format the output as requested
        /*StringBuilder sb = new StringBuilder();
        for (int i = 0; i < eulerianCycle.size(); i++) {
            sb.append(eulerianCycle.get(i));
            if (i < eulerianCycle.size() - 1) {
                sb.append("->");
            }
        }
        System.out.println(sb.toString());*/

        ArrayList<String> strings = new ArrayList<>();
        /*strings.add("CTTA");
        strings.add("ACCA");
        strings.add("TACC");
        strings.add("GGCT");
        strings.add("GCTT");
        strings.add("TTAC");*/
        File txt3 = new File("rosalind_ba3h.txt");
        try {
            in = new Scanner(txt3);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while(in.hasNext()){
            String sample = in.nextLine();
            strings.add(sample);
        }
        strings.remove(0);
        genomeReconstruction genomeReconstruction = new genomeReconstruction();
        //System.out.println(genomeReconstruction.getGenome(strings));
        
        ///LAB ASSIGNMENT PART
        ArrayList<String> nucleotides = new ArrayList<>();
        nucleotides.add("A");
        nucleotides.add("C");
        nucleotides.add("T");
        nucleotides.add("G");
        String ans = "";
        for(int i = 0; i < 1000; i++){
            int randNum = (int) (Math.random() * 4);
            ans += nucleotides.get(randNum);
        }
        //System.out.println(ans);
        getSegments g1 = new getSegments();
        String ans2 = "CTTAGCGGTTATTCGCTACATCTAGTCGTTAGTATGAGTAGATGAGTGCATAAGAGGTTTCGCACATGACGCCATTTCGGGGCGCCCTGTGGGGCCGCCCCAACCAGTGAAATCTGCAAAAGATACTTGTGAGGACTTGGCGTTCTATCAAGTAGACCAGGGGTCATACCGTGGGGGCCCTTATTAAAAATACCATGAGCGTCACTCCTGGTGAGCAGGTGTATCGCGTTAAGTGCATCGGCCAACCCTCATGAGCGTACTGCCGGCAGGATATCGATTTCAAAAACTGCGTCTGGGATTGCATTGACCGCCCAGAGTGTTAATAGCTTTACTATCCGTTATATTTTGCCATAAACGCCCGATTTGGCCAGCCCAACGTATGGGGTGTGCGAACTGCAATGGCAGGTCAGGATTATATCCCCGTCTGGATGTCACTGCCTTAAATGTTATTTCCAGACTAGGTCCAGTAGGCGTGACGCACTTTCACATTCCGTCCCACTCATATGCTGCATCATTCCTGGGGAGTTCATCCAAATCTTCCCGCCCCGTTAGGAACTCTTGGTCCCTGCCTTAAACCGTAGATACTGGTAGACCGCTATAGCATGTCAGCCATGAAGTCTCTAGCTTCGTGAAGAAAAATTTGAGATGGCGGGAATGAATGCTGTTTATTCGAGAGCTGCCATGGAGCTGTGGTCATATTTCGAGCTACTCTCAGTAGGAGAGCTGTTCTCGGACCAGCGCCCCAGTGTTTTAAACTTCGGTCCTTTCGATTCCACCAGTGGCCTACTGGCCAGATAGAGACGGGCAACAAACACCGGAAGGCCGACGGTTAGGGCTTCAGTGAGTACCCCTGTTGCCGCAAACGACTATACTCTTCGAATGCGGCAGACAACGCCCCCAGAACCCCACCTTGCGACGGAGAGCACACGGACCTTCGGTAGTACGGAGGACTGCGTGATGCAAAAGTATGCTACGAGTCACTAACGAACCGGGGGATACA";
        ArrayList<String> read = g1.getSegments(ans2);
        Collections.shuffle(read);
        genomeReconstruction g2 = new genomeReconstruction();
        String ans3 = g2.getGenome(read);
        System.out.println(ans3);
    }
}