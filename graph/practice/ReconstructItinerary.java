package graph.practice;

import java.util.*;

public class ReconstructItinerary {

    public static List<String> findItinerary(List<List<String>> tickets) {
        int flights = tickets.size();
        Map<String, List<String>> flightMap = new HashMap<>();
        Map<String, boolean[]> visitMap = new HashMap<>();
        for (int i=0; i<flights; i++) {
            List<String> ticket = tickets.get(i);
            String origin = ticket.get(0);
            String dest = ticket.get(1);
            if (!flightMap.containsKey(origin)) {
                flightMap.put(origin, new ArrayList<>());
            }
            flightMap.get(origin).add(dest);
        }
        for (String airport : flightMap.keySet()) {
            List<String> list = flightMap.get(airport);
            Collections.sort(list);
            visitMap.put(airport, new boolean[list.size()]);
        }
        List<String> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        path.add("JFK");
        dfs(flightMap, visitMap, "JFK", path, ans, flights);
        return ans;
    }

    private static boolean dfs(Map<String, List<String>> flightMap, Map<String, boolean[]> visitMap, String origin, List<String> path, List<String> ans, int flights) {
        if (path.size() == flights+1) {
            ans.addAll(new ArrayList<>(path));
            return true;
        }
        if (!flightMap.containsKey(origin)) {
            return false;
        }
        List<String> destinations = flightMap.get(origin);
        boolean[] visit = visitMap.get(origin);
        int i=0;
        for (String dest : destinations) {
            if (!visit[i]) {
                visit[i] = true;
                path.add(dest);
                boolean res = dfs(flightMap, visitMap, dest, path, ans, flights);
                path.remove(path.size()-1);
                visit[i] = false;
                if (res) {
                    return true;
                }
            }
            i++;
        }
        return false;
    }

    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("EZE","AXA"));
        tickets.add(Arrays.asList("TIA","ANU"));
        tickets.add(Arrays.asList("ANU","JFK"));
        tickets.add(Arrays.asList("JFK","ANU"));
        tickets.add(Arrays.asList("ANU","EZE"));
        tickets.add(Arrays.asList("TIA","ANU"));
        tickets.add(Arrays.asList("AXA","TIA"));
        tickets.add(Arrays.asList("TIA","JFK"));
        tickets.add(Arrays.asList("ANU","TIA"));
        tickets.add(Arrays.asList("JFK","TIA"));

        System.out.println(findItinerary(tickets));
    }
}
