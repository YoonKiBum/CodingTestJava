import java.util.*;
import java.io.*;

public class Main {
  public static int[] dx = {-1, 0, 1, 0};
  public static int[] dy = {0, 1, 0, -1};
  public static int N, L, R;
  public static int[][] graph;
  public static boolean[][] visited;
  public static int ans = 0;
  public static ArrayList<Node> temp;
  
  public static boolean bfs(int x, int y) {
    temp = new ArrayList<Node>(); // 인구 이동을 할 수 있는 좌표를 모아두는 Arrayist
    
    Queue<Node> q = new LinkedList<>();
    q.offer(new Node(x, y));
    visited[x][y] = true;
    temp.add(new Node(x, y));
    int sum = graph[x][y]; // 연합의 인구수 합
    
    while(!q.isEmpty()) {
      Node node = q.poll();
      x = node.x;
      y = node.y;
      for(int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (nx < 0 || ny < 0 || nx >= N || ny >= N)
          continue;
        if(visited[nx][ny] == false) { // 방문한 적이 없고 국경선을 공유하는 두 나라의 인구 차이가 L명 이상, R명 이하라면
          if(L <= Math.abs(graph[x][y] - graph[nx][ny]) && Math.abs(graph[x][y] - graph[nx][ny]) <= R) {
            temp.add(new Node(nx, ny)); // 연합에 포함시키기
            q.offer(new Node(nx, ny));
            visited[nx][ny] = true;
            sum += graph[nx][ny]; // 연합의 인구수 합 증가
          }
        }
      }
    }

    for(int i = 0; i < temp.size(); i++) { // 연합에 포함시킨 좌표들을 조회하며 인구 이동 
      Node node = temp.get(i);
      graph[node.x][node.y] = sum / temp.size();
    }

    if(temp.size() > 1) // 연합의 개수가 1초과라면 즉 인구 이동한 경우
      return true;
    else // 연합의 개수가 1 즉 인구이동하지 않은 경우
      return false;
  }

  static class Node {
    int x;
    int y;
    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    N = Integer.parseInt(st.nextToken());
    L = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());

    graph = new int[N][N];
    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for(int j = 0; j < N; j++) {
        graph[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    while(true) { // 이동을 한번도 못할때까지 반복
      visited = new boolean[N][N]; // 매번 초기화
      boolean flag = false; 
      boolean result; 
      
      for(int i = 0; i < N; i++) {
        for(int j = 0; j < N; j++) {
          if(!visited[i][j]) {
            result = bfs(i, j); // 이중 for문을 조회하면서 결과를 result로 반환해준다
            if(flag == false && result == true) { // flag가 false이면서 결과가 true인 경우 즉 이중 for문 전체에서 첫 이동을 한 경우
              flag = true; // flag에 true 넣어준다
            }
          }
        }
      }

      if(flag) // 이동을 한 경우라면
        ans += 1; // 인구 이동수 증가
      if(!flag) // 인구 이동을 하지 않았다면
        break; // while문 탈출
    }
    System.out.println(ans);
  }
}
