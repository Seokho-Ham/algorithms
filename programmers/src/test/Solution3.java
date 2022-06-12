package test;

import java.util.*;

public class Solution3 {
    public int[] solution(int n, String[] plans, String[] clients) {
        int[] answer = new int[clients.length];
        ArrayList<Integer> s = new ArrayList<>();
        List<Plan> planList = new ArrayList<>();

        for (String plan : plans) {
            String[] p = plan.split(" ");
            for (int i = 1; i < p.length; i++) {
                s.add(Integer.parseInt(p[i]));
            }
            planList.add(new Plan(Integer.parseInt(p[0]), (ArrayList<Integer>) s.clone()));
        }

        for (int i = 0; i < clients.length; i++) {
            String[] c = clients[i].split(" ");
            int data = Integer.parseInt(c[0]);
            String[] userPlan = Arrays.copyOfRange(c,1,c.length);

            Optional<Plan> plan = planList.stream()
                    .filter(p -> p.data >= data)
                    .filter(p -> p.contains(userPlan))
                    .findFirst();
            answer[i] = plan.isEmpty() ? 0 : planList.indexOf(plan.get())+1;
        }

        return answer;
    }

    class Plan {
        int data;
        ArrayList<Integer> services;

        public Plan(int data, ArrayList<Integer> services) {
            this.data = data;
            this.services = services;
        }

        public boolean contains(String[] userService) {
            for (String s : userService) {
                if (!services.contains(Integer.parseInt(s))) {
                    return false;
                }
            }
            return true;
        }
    }
}
