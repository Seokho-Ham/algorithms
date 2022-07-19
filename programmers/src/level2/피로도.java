package level2;

public class 피로도 {
    public static int answer = -1;
    public static boolean[] visited;
    public int solution(int k, int[][] dungeons) {


        visited = new boolean[dungeons.length];
        dfs(0, k, dungeons);

        return answer;
    }

    public void dfs(int num, int k, int[][]dungeons) {

        for (int i = 0; i < dungeons.length; i++) {
            visited[i] = true;
            dfs(num+1, )

        }
        answer = Math.max(answer, num);
    }
}
