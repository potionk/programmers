package kakao2018.프랜즈4블록;

import java.util.ArrayList;

class Solution {
    static char[][] map;
    static int ySize, xSize;

    public int solution(int m, int n, String[] board) {
        map = new char[m][n];
        ySize = m;
        xSize = n;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }
        boolean isFind = true;
        int[] xArrow = {0, 0, 1, 1};
        int[] yArrow = {0, 1, 0, 1};
        while (isFind) {
            isFind = false;
            ArrayList<XY> removeTargetList = new ArrayList<>();
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (isSearchable(i, j) && isErasable(i, j)) {
                        isFind = true;
                        for (int a = 0; a < 4; a++) {
                            removeTargetList.add(new XY(i + yArrow[a], j + xArrow[a]));
                        }
                    }
                }
            }
            for (XY target : removeTargetList) {
                int y = target.getY();
                int x = target.getX();
                map[y][x] = '.';
            }
            fallBlock();
        }
        int answer = 0;
        for (int i = 0; i < ySize; i++) {
            for (int j = 0; j < xSize; j++) {
                if (map[i][j] == '.') {
                    answer++;
                }
            }
        }
        return answer;
    }

    public void fallBlock() {
        for (int i = 0; i < xSize; i++) {
            for (int j = ySize - 1; j >= 1; j--) {
                if (map[j][i] == '.') {
                    int swapTarget = j - 1;
                    for (int k = j - 1; k >= 0; k--) {
                        if (map[k][i] != '.') {
                            swapTarget = k;
                            break;
                        }
                    }
                    char t = map[j][i];
                    map[j][i] = map[swapTarget][i];
                    map[swapTarget][i] = t;
                }
            }
        }
    }

    public boolean isSearchable(int y, int x) {
        return map[y][x] != '.' && map[y + 1][x] != '.' && map[y][x + 1] != '.' && map[y + 1][x + 1] != '.';
    }

    public boolean isErasable(int y, int x) {
        return (map[y][x] == map[y + 1][x]) && (map[y][x] == map[y][x + 1]) && (map[y][x] == map[y + 1][x + 1]);
    }
}

class XY {
    int x;
    int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public XY(int y, int x) {
        this.y = y;
        this.x = x;
    }
}