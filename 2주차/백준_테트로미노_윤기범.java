import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static int[][] graph;
    public static int ans = 0;
    public static ArrayList<Integer> arr = new ArrayList<>();

    // 1번 모형 
    public static int a(int i, int j) {
        return graph[i][j] + graph[i][j + 1] + graph[i][j + 2] + graph[i][j + 3];
    }

    // 1번 모형 90도 회전
    public static int a90(int i, int j) {
        return graph[i][j] + graph[i + 1][j] + graph[i + 2][j] + graph[i + 3][j];
    }

    // 2먼 모형
    public static int b(int i, int j) {
        return graph[i][j] + graph[i][j + 1] + graph[i + 1][j] + graph[i + 1][j + 1];
    }

    // 3번 모형
    public static int c(int i, int j) {
        return graph[i][j] + graph[i + 1][j] + graph[i + 2][j] + graph[i + 2][j + 1];
    }
    
    // 3번 모형 90도 회전
    public static int c90(int i, int j) {
        return graph[i][j] + graph[i][j + 1] + graph[i][j + 2] + graph[i + 1][j];
    }

    // 3번 모형 180도 회전
    public static int c180(int i, int j) {
        return graph[i][j] + graph[i][j + 1] + graph[i + 1][j + 1] + graph[i + 2][j + 1];
    }

    // 3번 모형 270도 회전
    public static int c270(int i, int j) {
        return graph[i][j] + graph[i][j+1] + graph[i][j +2] + graph[i - 1][j + 2];
    }

    // 3번 모형 대칭
    public static int c2(int i, int j) {
        return graph[i][j] + graph[i][j + 1] + graph[i - 1][j + 1] + graph[i - 2][j + 1];
    }

    // 3번 모형 대칭후 90도 회전
    public static int c2_90(int i, int j) {
        return graph[i][j] + graph[i + 1][j] + graph[i + 1][j + 1] + graph[i + 1][j + 2];
    }

    // 3번 모형 대칭후 180도 회전
    public static int c2_180(int i, int j) {
        return graph[i][j] + graph[i][j + 1] + graph[i + 1][j] + graph[i + 2][j];
    }

    // 3번 모형 대칭후 270도 회전
    public static int c2_270(int i, int j) {
        return graph[i][j] + graph[i][j + 1] + graph[i][j + 2] + graph[i + 1][j + 2];
    }

    // 4번 모형
    public static int d(int i, int j) {
        return graph[i][j] + graph[i + 1][j] + graph[i + 1][j + 1] + graph[i + 2][j + 1];
    }

    // 4번 모형 90도 회전
    public static int d90(int i, int j) {
        return graph[i][j] + graph[i][j + 1] + graph[i - 1][j + 1] + graph[i - 1][j + 2];
    }

    // 4번 모형 대칭
    public static int d2(int i, int j) {
        return graph[i][j] + graph[i - 1][j] + graph[i - 1][j + 1] + graph[i - 2][j + 1];
    }

    // 4번 모형 대칭후 90도 회전
    public static int d2_90(int i, int j) {
        return graph[i][j] + graph[i][j + 1] + graph[i + 1][j + 1] + graph[i + 1][j + 2];
    }

    // 5번 모형
    public static int e(int i, int j) {
        return graph[i][j] + graph[i][j + 1] + graph[i + 1][j + 1] + graph[i][j + 2];
    }

    // 5번 모형 90도
    public static int e90(int i, int j) {
        return graph[i][j] + graph[i + 1][j] + graph[i + 1][j - 1] + graph[i + 2][j];
    }

    // 5번 모형 180도 회전
    public static int e180(int i, int j) {
        return graph[i][j] + graph[i][j + 1] + graph[i - 1][j + 1] + graph[i][j + 2];
    }

    // 5번 모형 270도 회전
    public static int e270(int i, int j) {
        return graph[i][j] + graph[i + 1][j] + graph[i + 1][j + 1] + graph[i + 2][j];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 각각의 경우 확인
        int maximum = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m-3; j++) {
                maximum = Math.max(maximum, a(i, j));
            }
        }
        arr.add(maximum);

        maximum = 0;
        for(int i = 0; i < n - 3; i++) {
            for(int j = 0; j < m; j++) {
                maximum = Math.max(maximum, a90(i, j));
            }
        }
        arr.add(maximum);

        maximum = 0;
        for(int i = 0; i <= n - 2; i++) {
            for(int j = 0; j <= m -2; j++) {
                maximum = Math.max(maximum, b(i, j));
            }
        }
        arr.add(maximum);

        maximum = 0;
        for(int i = 0; i <= n - 3; i++) {
            for(int j = 0; j < m - 1; j++) {
                maximum = Math.max(maximum, c(i, j));
            }
        }
        arr.add(maximum);

        maximum = 0;
        for(int i = 0; i <= n - 2; i++) {
            for(int j = 0; j <= m - 3; j++) {
                maximum = Math.max(maximum, c90(i, j));
            }
        }
        arr.add(maximum);

        maximum = 0;
        for(int i = 0; i <= n - 3; i++) {
            for(int j = 0; j <= m -2; j++) {
                maximum = Math.max(maximum, c180(i, j));
            }
        }
        arr.add(maximum);

        maximum = 0;
        for(int i = 1; i <= n - 1; i++) {
            for(int j = 0; j < m - 2; j++) {
                maximum = Math.max(maximum, c270(i, j));
            }
        }
        arr.add(maximum);

        maximum = 0;
        for(int i = 2; i < n; i++) {
            for(int j = 0; j <= m - 2; j++) {
                maximum = Math.max(maximum, c2(i, j));
            }
        }
        arr.add(maximum);

        maximum = 0;
        for(int i = 0; i <= n - 2; i++) {
            for(int j = 0; j <= m - 3; j++) {
                maximum = Math.max(maximum, c2_90(i, j));
            }
        }
        arr.add(maximum);

        maximum = 0;
        for(int i = 0; i <= n - 3; i++) {
            for(int j = 0; j <= m - 2; j++) {
                maximum = Math.max(maximum, c2_180(i, j));
            }
        }
        arr.add(maximum);

        maximum = 0;
        for(int i = 0; i <= n - 2; i++) {
            for(int j = 0; j <= m - 3; j++) {
                maximum = Math.max(maximum, c2_270(i, j));
            }
        }
        arr.add(maximum);

        maximum = 0;
        for(int i = 0; i <= n - 3; i++) {
            for(int j = 0; j <= m - 2; j++) {
                maximum = Math.max(maximum, d(i, j));
            }
        }
        arr.add(maximum);

        maximum = 0;
        for(int i = 1; i <= n -1; i++) {
            for(int j = 0; j <= m - 3; j++) {
                maximum = Math.max(maximum, d90(i, j));
            }
        }
        arr.add(maximum);

        maximum = 0;
        for(int i = 2; i < n; i++) {
            for(int j = 0; j <= m -2; j++) {
                maximum = Math.max(maximum, d2(i, j));
            }
        }
        arr.add(maximum);

        maximum = 0;
        for(int i = 0; i <= n -2; i++) {
            for(int j = 0; j <= m - 3; j++) {
                maximum = Math.max(maximum, d2_90(i, j));
            }
        }
        arr.add(maximum);

        maximum = 0;
        for(int i = 0; i <= n -2; i++) {
            for(int j = 0; j <= m - 3; j++) {
                maximum = Math.max(maximum, e(i, j));
            }
        }
        arr.add(maximum);

        maximum = 0;
        for(int i = 0; i <= n - 3; i++) {
            for(int j = 1; j < m; j++) {
                maximum = Math.max(maximum, e90(i, j));
            }
        }
        arr.add(maximum);

        maximum = 0;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j <= m - 3; j++) {
                maximum = Math.max(maximum, e180(i, j));
            }
        }
        arr.add(maximum);

        maximum = 0;
        for(int i = 0; i <= n - 3; i++) {
            for(int j = 0; j <= m - 2; j++) {
                maximum = Math.max(maximum, e270(i, j));
            }
        }
        arr.add(maximum);

        // 최대 값으 찾은 후 출력
        for(Integer ar: arr) {
            ans = Math.max(ans, ar);
        }
        System.out.println(ans);
    }
}
