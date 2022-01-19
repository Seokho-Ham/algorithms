package level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpenChat {
    public String[] solution(String[] record) {

        Map<String, String> userList = new HashMap<>();
        List<String[]> actions = new ArrayList<>();

        for (String r : record) {
            String[] action = r.split(" ");

            if (action[0].equals("Enter")) {
                userList.put(action[1], action[2]);
                actions.add(new String[]{action[0], action[1]});
            } else if (action[0].equals("Change")) {
                userList.put(action[1], action[2]);
            } else {
                actions.add(new String[]{action[0], action[1]});
            }
        }

        String[] answer = new String[actions.size()];

        for (int i = 0; i < actions.size(); i++) {
            String act = actions.get(i)[0];
            String id = actions.get(i)[1];
            if (act.equals("Enter")) {
                answer[i] = userList.get(id) + "님이 들어왔습니다.";
            } else {
                answer[i] = userList.get(id) + "님이 나갔습니다.";
            }
        }

        return answer;
    }

}
