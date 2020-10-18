package hash.베스트앨범;

import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, ArrayList<Data>> streamingSite = new HashMap<>();
        Map<String, Integer> genRank = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            if (streamingSite.get(genres[i]) == null) {
                int thisI = i;
                streamingSite.put(genres[i], new ArrayList<Data>() {{
                    add(new Data(thisI, plays[thisI]));
                }});
                genRank.put(genres[i], plays[i]);
            } else {
                ArrayList<Data> list = streamingSite.get(genres[i]);
                list.add(new Data(i, plays[i]));
                streamingSite.put(genres[i], list);
                genRank.put(genres[i], genRank.get(genres[i]) + plays[i]);
            }
        }
        Genres[] genRankArr = new Genres[genRank.size()];
        int idx = 0;
        for (Map.Entry<String, Integer> elem : genRank.entrySet()) {
            genRankArr[idx++] = new Genres(elem.getKey(), elem.getValue());
        }
        Arrays.sort(genRankArr);
        for (Map.Entry<String, ArrayList<Data>> elem : streamingSite.entrySet()) {
            ArrayList<Data> data = elem.getValue();
            Collections.sort(data);
        }
        ArrayList<Integer> answerList = new ArrayList<>();
        for (Genres value : genRankArr) {
            String gen = value.getGenres();
            ArrayList<Data> list = streamingSite.get(gen);
            if (list.size() == 1) {
                answerList.add(list.get(0).getCode());
                continue;
            }
            for (int j = 0; j < 2; j++) {
                answerList.add(list.get(j).getCode());
            }
        }
        Object[] objAnswer = answerList.toArray();
        int[] answer = new int[objAnswer.length];
        for (int i = 0; i < objAnswer.length; i++) {
            answer[i] = (int) objAnswer[i];
        }
        return answer;
    }
}

class Data implements Comparable<Data> {
    int code;
    int play;

    public int getCode() {
        return code;
    }

    public int getPlay() {
        return play;
    }

    public Data(int code, int play) {
        this.code = code;
        this.play = play;
    }

    @Override
    public int compareTo(Data o) {
        return Integer.compare(o.getPlay(), this.play);
    }
}

class Genres implements Comparable<Genres> {
    String genres;
    int total;

    public String getGenres() {
        return genres;
    }

    public int getTotal() {
        return total;
    }

    public Genres(String genres, int total) {
        this.genres = genres;
        this.total = total;
    }

    @Override
    public int compareTo(Genres o) {
        return Integer.compare(o.getTotal(), this.total);
    }
}