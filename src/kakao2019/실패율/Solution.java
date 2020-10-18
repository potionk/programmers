package kakao2019.실패율;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
    }

    public int[] solution(int N, int[] stages) {
        Arrays.sort(stages);
        double[] failRate = new double[N + 1];
        Data[] failRateData = new Data[N];
        int findTarget = 1;
        for (int i = 0; i < stages.length; i++) {
            if (stages[i] >= findTarget) {
                if (stages[i] == N + 1) {
                    break;
                }
                findTarget = stages[i];
                int count = 1;
                for (int j = i + 1; j < stages.length; j++) {
                    if (stages[j] == findTarget) {
                        count++;
                    } else {
                        break;
                    }
                }
                failRate[findTarget] = (double) count / (stages.length - i);
                findTarget++;
                i += count - 1;
            }
        }
        for(int i=1; i<N+1; i++){
            failRateData[i-1]=new Data(i, failRate[i]);
        }
        Arrays.sort(failRateData);
        int[] answer = new int[N];
        for(int i=0; i<N; i++){
            answer[i]=failRateData[i].getIndex();
        }
        return answer;
    }
}

class Data implements Comparable<Data> {
    int index;
    double data;

    public int getIndex() {
        return index;
    }

    public double getData() {
        return data;
    }

    public Data(int index, double data) {
        this.index = index;
        this.data = data;
    }

    @Override
    public int compareTo(Data o) {
        if(this.data<o.getData()){
            return 1;
        } else if(this.data==o.getData()){
            if(this.index<o.getIndex()){
                return -1;
            } else {
                return 1;
            }
        } else {
            return -1;
        }
    }
}