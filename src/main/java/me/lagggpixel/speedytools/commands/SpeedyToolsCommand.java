package me.lagggpixel.speedytools.commands;

import me.lagggpixel.speedytools.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public class SpeedyToolsCommand implements TabExecutor {

    public SpeedyToolsCommand() {
        Objects.requireNonNull(Main.getInstance().getCommand("speedytools")).setExecutor(this);
        Objects.requireNonNull(Main.getInstance().getCommand("speedytools")).setTabCompleter(this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
            Main.getInstance().reloadConfig();
            commandSender.sendMessage(ChatColor.LIGHT_PURPLE + "SpeedyTools" + ChatColor.GRAY + ": " + ChatColor.WHITE + "Configuration files reloaded.");
            return true;
        }
        commandSender.sendMessage(ChatColor.WHITE + "----------------" + ChatColor.GRAY + "[" + ChatColor.LIGHT_PURPLE + "SpeedyTools" + ChatColor.GRAY + "]" + ChatColor.WHITE + "----------------");
        commandSender.sendMessage(ChatColor.WHITE + "speedytools reload: Reload configuration files.");

        return true;
    }

    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 0 || args.length == 1) {
            return List.of("reload");
        }
        else {
            return null;
        }

    }
}
