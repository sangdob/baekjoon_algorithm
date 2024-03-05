import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (min.size() == max.size()) {
                max.offer(num);
            }else {
                min.offer(num);
            }

            if (!min.isEmpty() && !max.isEmpty()) {
                if (min.peek() < max.peek()) {
                    int temp = min.poll();
                    min.offer(max.poll());
                    max.offer(temp);
                }
            }
            bw.write(max.peek() + "\n");
        }

        br.close();
        bw.close();
    }
}