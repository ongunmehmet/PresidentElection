import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {

    public static void voteResult(String input) {
        char[] votes = input.toCharArray();
        HashMap<Character, Integer> voteCounts = new HashMap<Character, Integer>();
        for (int i = 0; i < votes.length; i++) {
            if (voteCounts.get(votes[i]) == null) {
                voteCounts.put(votes[i], 1);
            } else {
                voteCounts.replace(votes[i], voteCounts.get(votes[i]) + 1);
            }
        }
        Iterator it = voteCounts.entrySet().iterator();
        int voteSum = 0;
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            System.out.println(pair.getKey() + ":" + pair.getValue());
            voteSum = voteSum + Integer.parseInt(pair.getValue().toString());
        }
        Map.Entry<Character, Integer> maxEntry = null;

        for (Map.Entry<Character, Integer> entry : voteCounts.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }
        double result = Double.parseDouble(maxEntry.getValue().toString()) / (double) voteSum;
        if (result >= 0.5) {
            System.out.println(maxEntry.getKey() + " " + maxEntry.getValue() + " oyla secimleri kazanmistir ");

        } else {
            System.out.println("%50 barajinin ustunde oy alan olmadi secim tekrarlanacak");
        }

    }
    public static void main(String[] args) {
        String example = "AAABCABD";
        voteResult(example);
    }
}
