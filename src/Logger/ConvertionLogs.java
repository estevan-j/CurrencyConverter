package Logger;

import java.time.LocalDateTime;
import java.util.List;

public class ConvertionLogs {
    private List<String> logs;

    public ConvertionLogs() {
        this.logs = new ArrayList<>();
    }

    public void addLog(String log) {
        String log = "[" + LocalDateTime.now() + "] : " + log;
        this.logs.add(log);
    }

    
}
