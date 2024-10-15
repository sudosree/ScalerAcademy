package hashmap.practice;

import java.util.HashMap;
import java.util.Map;

public class FaultyServerReplacement {

  private static int countFaultyServersReplaced(int n, String[] logs) {
    Map<String, Integer> serverToStatusMapping = new HashMap<>();
    // keep track of the no. of times a faulty server is replaced
    int count = 0;
    for (String log : logs) {
      String[] str = log.split(" ");
      String server = str[0];
      String status = str[1];
      if (serverToStatusMapping.containsKey(server)) {
        int val = serverToStatusMapping.get(server);
        if (status.equals("error")) {
          val++;
        } else {
          val--;
        }
        if (val == 3) {
          count++;
          val = 0;
        }
        serverToStatusMapping.put(server, val);
      } else {
        if (status.equals("error")) {
          serverToStatusMapping.put(server, 1);
        } else {
          serverToStatusMapping.put(server, 0);
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    int n = 2;
    String[] logs = {"s1 error", "s1 error", "s2 error", "s1 error", "s1 error", "s2 success"};
    System.out.println(countFaultyServersReplaced(n, logs));
  }
}
