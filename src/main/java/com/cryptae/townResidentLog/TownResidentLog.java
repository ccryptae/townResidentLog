package com.cryptae.townResidentLog;

import com.cryptae.townResidentLog.commands.CommandHandler;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class TownResidentLog extends JavaPlugin {

    @Override
    public void onEnable() {
        // Register the command and its aliases
        CommandHandler commandHandler = new CommandHandler(this);
        Objects.requireNonNull(getCommand("town")).setExecutor(commandHandler);
        Objects.requireNonNull(getCommand("t")).setExecutor(commandHandler);
    }

    @Override
    public void onDisable() {
        // Any cleanup logic goes here
    }
}
