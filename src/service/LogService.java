
package service;

import model.Log;
import java.util.ArrayList;
import java.util.List;

public class LogService {

    private final List<Log> logs = new ArrayList<>();
    private int nextId = 1;

    public Log createLog(int userId, int deviceId, String sourceIp, String operation, String status) {
        if (sourceIp == null || sourceIp.isBlank()) {
            throw new IllegalArgumentException("Source IP cannot be empty");
        }

        if (operation == null || operation.isBlank()) {
            throw new IllegalArgumentException("Operation cannot be empty");
        }

        if (status == null || status.isBlank()) {
            throw new IllegalArgumentException("Status cannot be empty");
        }

        Log log = new Log(nextId++, userId, deviceId, sourceIp, operation, status);
        logs.add(log);
        return log;
    }

    public Log findById(int id) {
        for (Log log : logs) {
            if (log.getId() == id) {
                return log;
            }
        }

        return null;
    }

    public List<Log> getAllLogs() {
        return new ArrayList<>(logs);
    }

    public List<Log> getLogsByUserId(int userId) {
        List<Log> result = new ArrayList<>();

        for (Log log : logs) {
            if (log.getUserId() == userId) {
                result.add(log);
            }
        }

        return result;
    }

    public List<Log> getLogsByDeviceId(int deviceId) {
        List<Log> result = new ArrayList<>();

        for (Log log : logs) {
            if (log.getDeviceId() == deviceId) {
                result.add(log);
            }
        }

        return result;
    }

    public List<Log> getLogsByStatus(String status) {
        List<Log> result = new ArrayList<>();

        for (Log log : logs) {
            if (log.getStatus().equalsIgnoreCase(status)) {
                result.add(log);
            }
        }

        return result;
    }

    public boolean updateStatus(int id, String status) {
        Log log = findById(id);

        if (log == null || status == null || status.isBlank()) {
            return false;
        }

        log.updateStatus(status);
        return true;
    }

    public boolean deleteLog(int id) {
        Log log = findById(id);

        if (log == null) {
            return false;
        }

        logs.remove(log);
        return true;
    }

    public void displayAllLogs() {
        for (Log log : logs) {
            log.displayLogInfo();
            System.out.println("-------------------------");
        }
    }
}
