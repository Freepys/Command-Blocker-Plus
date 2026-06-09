// Freeperr copyright

package me.Freeperr.commandBlockerPlus;

import java.util.List;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerCommandSendEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandBlockerPlus extends JavaPlugin implements Listener {
    public void onEnable() {
        this.saveDefaultConfig();
        this.getServer().getPluginManager().registerEvents(this, this);
        this.getLogger().info("CommandBlockerPlus has been enabled successfully!");
    }

    public void onDisable() {
        this.getLogger().info("CommandBlockerPlus has been disabled!");
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onCommandProcess(PlayerCommandPreprocessEvent e) {
        Player p = e.getPlayer();
        if (p.isOp()) return;

        String message = e.getMessage().toLowerCase();
        String mainCommand = message.split(" ")[0].replace("/", "");

        List<String> allowedCommands = this.getConfig().getStringList("allowed-commands");
        List<String> noneOpsCommands = this.getConfig().getStringList("noneops-commands");

        boolean isAllowed = false;

        if (p.hasPermission("commandblockerplus.noneopscommands")) {
            for (String cmd : noneOpsCommands) {
                if (mainCommand.equalsIgnoreCase(cmd)) {
                    isAllowed = true;
                    break;
                }
            }
        }

        if (!isAllowed) {
            for (String allowedCmd : allowedCommands) {
                if (mainCommand.equalsIgnoreCase(allowedCmd)) {
                    isAllowed = true;
                    break;
                }
            }
        }

        if (!isAllowed) {
            e.setCancelled(true);
            String blockedMsg = ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("blocked-message"));
            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(blockedMsg));
            p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0F, 1.0F);
        }
    }

    @EventHandler
    public void onCommandSend(PlayerCommandSendEvent e) {
        Player p = e.getPlayer();
        if (p.isOp()) return;

        List<String> allowedCommands = this.getConfig().getStringList("allowed-commands");
        List<String> noneOpsCommands = this.getConfig().getStringList("noneops-commands");

        e.getCommands().removeIf((command) -> {
            if (command.contains(":")) return true;

            for (String allowed : allowedCommands) {
                if (command.equalsIgnoreCase(allowed)) return false;
            }

            if (p.hasPermission("commandblockerplus.noneopscommands")) {
                for (String cmd : noneOpsCommands) {
                    if (command.equalsIgnoreCase(cmd)) return false;
                }
            }

            return true;
        });
    }
}
