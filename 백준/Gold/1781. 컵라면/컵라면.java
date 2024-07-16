import java.io.*;
import java.util.*;

// 문제 class
class Homework implements Comparable<Homework> {
    int no;
    int deadline;
    int noodle;

    public Homework(int no, int deadline, int noodle) {
        this.no = no;
        this.deadline = deadline;
        this.noodle = noodle;
    }
	
    // 데드라인을 기준으로 정렬(같다면 컵라면을 많이 주는 순으로 정렬)
    @Override
    public int compareTo(Homework o) {
        if(this.deadline == o.deadline) return o.noodle - this.noodle;
        return this.deadline - o.deadline;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        List<Homework> homeworkList = new ArrayList<>();
        PriorityQueue<Integer> noodles = new PriorityQueue<>();		// 최종적으로 받을 수 있는 컵라면 수 저장 큐

        for(int i = 0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int deadline = Integer.parseInt(st.nextToken());
            int noodle = Integer.parseInt(st.nextToken());
            homeworkList.add(new Homework(i+1, deadline, noodle));
        }

        Collections.sort(homeworkList);

        for(int i = 0; i<N; i++) {
            Homework hw = homeworkList.get(i);
            // 데드라인이 지나지 않았는지 판단 후 컵라면 수 추가
            if(noodles.size() < hw.deadline) noodles.add(hw.noodle);
            // 대체할 문제가 있는지 확인 후 컵라면을 더 많이 받을 수 있다면 대체
            else if(noodles.size() == hw.deadline) {
                if(noodles.peek() < hw.noodle) {
                    noodles.poll();
                    noodles.add(hw.noodle);
                }
            }
        }
		
        // 컵라면 수 모두 더하기
        while(!noodles.isEmpty()) {
            result += noodles.poll();
        }

        System.out.println(result);

    }
}