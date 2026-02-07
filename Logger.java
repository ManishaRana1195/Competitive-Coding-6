import java.util.HashMap;
import java.util.Map;

// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
// Approach :

// We can keep the log string with its current time in the map. If a new entry comes in for that log, if the new time is more
// than 10 seconds, the existing entry is updated else the new time is ignored. If the log entry doesnt exist it is added to the
// map.
class Logger {
    private final Map<String, Integer> logTimestampMap;
    int timeGap;

    public Logger() {
        logTimestampMap = new HashMap<>();
        timeGap = 10;
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (logTimestampMap.containsKey(message)) {
            Integer loggedTime = logTimestampMap.get(message);
            if (timestamp - loggedTime < timeGap) {
                return false;
            }
            logTimestampMap.put(message, timestamp);
        } else {
            logTimestampMap.put(message, timestamp);
        }
        return true;
    }
}

