package kakao2019.오픈채팅방;

import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public String[] solution(String[] record){
        HashMap<String, String> database=new HashMap<>();
        ArrayList<Message> logs=new ArrayList<>();
        for (String s : record) {
            String[] log = s.split(" ");
            if (log[0].equals("Enter")) {
                logs.add(new Message(log[0], log[1]));
                database.put(log[1], log[2]);
            } else if (log[0].equals("Leave")) {
                logs.add(new Message(log[0], log[1]));
            } else {
                database.put(log[1], log[2]);
            }
        }
        int logSize=logs.size();
        String[] answer = new String[logSize];
        for(int i=0; i<logSize; i++){
            answer[i]=logs.get(i).getMsg(database);
        }
        return answer;
    }

}

class Message {
    String uid;
    String state;

    public String getUid() {
        return uid;
    }

    public String getState() {
        return state;
    }

    public String getMsg(HashMap<String, String> database) {
        return database.get(uid) + (state.equals("Enter") ? "님이 들어왔습니다." : "님이 나갔습니다.");
    }

    public Message(String state, String uid) {
        this.uid = uid;
        this.state = state;
    }
}