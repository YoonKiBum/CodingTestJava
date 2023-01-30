import java.util.*;
import java.io.*;

class Main{
    static int R, C, T;
    static int[][] map;
    static Integer r1, r2;
    static int[] dr= {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void clean(){
        for(int i=r1-1; i>0; i--){
            map[i][0] = map[i-1][0];
        }
        for(int i=0; i<C-1; i++){
            map[0][i] = map[0][i+1];
        }
        for(int i=0; i<r1; i++){
            map[i][C-1] = map[i+1][C-1];
        }
        for(int i=C-1; i>1; i--){
            map[r1][i] = map[r1][i-1];
        }
        for(int i=r2+1; i<R-1; i++){
            map[i][0] = map[i+1][0];
        }
        for(int i=0; i<C-1; i++){
            map[R-1][i] = map[R-1][i+1];
        }
        for(int i=R-1; i>r2; i--){
            map[i][C-1] = map[i-1][C-1];
        }
        for(int i=C-1; i>1; i--){
            map[r2][i] = map[r2][i-1];
        }

        map[r1][1] = 0;
        map[r2][1] = 0;
    }

    public static void spread(){
        int[][] copy = new int[R][C];
        for(int i=0; i<R; i++){
            Arrays.fill(copy[i], 0);
        }


        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(i==r1 && j==0)
                    continue;
                else if(i==r2 && j==0)
                    continue;
                else if(map[i][j]/5>0){
                    int amount = map[i][j]/5;
                    int count=0;
                    for(int k=0; k<4; k++){
                        int nr = i + dr[k];
                        int nc = j + dc[k];

                        if(nr<0 || nr>=R || nc<0 || nc>=C)
                            continue;
                        else if(nr==r1 && nc==0)
                            continue;
                        else if(nr==r2 && nc==0)
                            continue;

                        copy[nr][nc] += amount;
                        count++;
                    }
                    copy[i][j] -= count*amount;
                }
            }
        }

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                map[i][j] += copy[i][j];
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == -1){
                    if(r1 == null){
                        r1 = i;
                    }
                    else
                        r2 = i;
                }
            }
        }

        for(int i=0; i<T; i++){
            spread();
            clean();
        }

        int ans=0;
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(i==r1 && j==0 && map[i][j]==-1){
                    continue;
                }
                else if(i==r2 && j==0 && map[i][j]==-1){
                    continue;
                }
                else{
                  ans += map[i][j];
                }
            }
        }
        System.out.println(ans);
    }
}