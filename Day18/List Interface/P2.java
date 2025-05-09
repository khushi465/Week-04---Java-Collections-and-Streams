
import java.util.*;

public class P2 {

    boolean compareWords(String s1, String s2) {
        if (s1.length() == s2.length()) {
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    Map<String, Integer> counter(List<String> li) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < li.size(); i++) {
            int count[] = new int[li.size()];
            int index = 0;
            for (int j = 0; j < li.size(); j++) {
                if (li.get(i) == li.get(j)) {
                    count[index]++;
                }
            }
            map.put(li.get(i), count[index]);
            index++;

        }
        return map;
    }

    void display(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }

    }

    public static void main(String[] args) {
        List<String> li = new ArrayList<>();
        li.add("apple");
        li.add("banana");
        li.add("apple");
        li.add("orange");
        P2 obj = new P2();
        Map<String, Integer> map = obj.counter(li);
        obj.display(map);

    }
}
