package Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ConvertionLogs {
    private List<String> logs;

    public ConvertionLogs() {
        this.logs = new ArrayList<>();
    }

    public void addLog(String detail) {
        String log = "[" + LocalDateTime.now() + "] : " + detail;
        this.logs.add(log);
    }

    public void saveLogsToFile(String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, true))) {
            for (String log : logs) {
                writer.println(log);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
