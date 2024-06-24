import java.util.*;
import java.io.*;


public class Main{    
    public static class Top {
        public int height;
        public int num;

        public Top(int height, int num) {
            this.height = height;
            this.num = num;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int height = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Stack<Top> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            height = Integer.parseInt(st.nextToken());
            while (true) {
                if (stack.empty()) {
                    sb.append("0 ");
                    stack.push(new Top(height, i + 1));
                    break;
                }

                Top peek = stack.peek();

                if (peek.height > height) {
                    sb.append(peek.num + " ");
                    stack.push(new Top(height, i + 1));
                    break;
                }

                stack.pop();
            }
        }
        System.out.println(sb);
    }
}