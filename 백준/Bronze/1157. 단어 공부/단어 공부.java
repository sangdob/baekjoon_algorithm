import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = br.readLine().split("");

        Map<String, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        String outString = "";

        for (String token : tokens) {
            String upper = token.toUpperCase();
            if (!map.containsKey(upper)) {

                map.put(upper, 1);
            } else {
                map.put(upper, map.get(upper) + 1);
            }
        }

        for (String s : map.keySet()) {
            Integer i = map.get(s);

            if (i > max) {
                max = i;
                outString = s;
            }
        }

        for (String s : map.keySet()) {
            Integer i = map.get(s);

            if (i == max && s != outString) {
                System.out.println("?");
                return;
            }
        }

        System.out.print(outString);

    }
}
