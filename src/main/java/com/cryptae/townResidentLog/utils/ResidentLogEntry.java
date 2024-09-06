package com.cryptae.townResidentLog;

public class ResidentLogEntry {
    private final String townName;
    private final String playerName;
    private final String action;
    private final String performedBy;

    public ResidentLogEntry(String townName, String playerName, String action, String performedBy) {
        this.townName = townName;
        this.playerName = playerName;
        this.action = action;
        this.performedBy = performedBy;
    }

    public String getTownName() {
        return townName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getAction() {
        return action;
    }

    public String getPerformedBy() {
        return performedBy;
    }

    @Override
    public String toString() {
        return "Player: " + playerName + ", Action: " + action + ", Performed by: " + performedBy;
    }
}
