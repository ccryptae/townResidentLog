package com.cryptae.townResidentLog.utils;

import java.util.ArrayList;
import java.util.List;

public class HistoryManager {

    private static final List<ResidentLogEntry> residentLogEntries = new ArrayList<>();

    public static void logEntry(String townName, String playerName, String action, String performedBy) {
        residentLogEntries.add(new ResidentLogEntry(townName, playerName, action, performedBy));
    }

    public static List<ResidentLogEntry> getLogEntriesForTown(String townName) {
        List<ResidentLogEntry> logs = new ArrayList<>();
        for (ResidentLogEntry entry : residentLogEntries) {
            if (entry.getTownName().equals(townName)) {
                logs.add(entry);
            }
        }
        return logs;
    }
}