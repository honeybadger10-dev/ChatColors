package dev.james.ecc.gui;

import dev.james.ecc.EccMain;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Events implements Listener {

    EccMain plugin;

    public Events(EccMain main) {
        this.plugin = main;

    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        plugin.playerChatColor.put(player.getUniqueId(), "§7");

    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        if(plugin.playerChatColor.containsKey(player.getUniqueId())) {
            plugin.playerChatColor.remove(player.getUniqueId());
        }

    }

    @EventHandler
    public void PlayerChatEvent(AsyncPlayerChatEvent e) {

        Player player = e.getPlayer();
        String colorCode = plugin.playerChatColor.get(player.getUniqueId());
        e.setMessage(colorCode + e.getMessage());

    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {

        if(e.getClickedInventory() == null){
            return;
        }
        if(e.getClickedInventory().getName() == null){
            return;
        }
        if (e.getClickedInventory().getTitle().equalsIgnoreCase(ChatColor.GREEN + "Chat Color Menu") && e.getClickedInventory()
                != null) {
            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();


            switch (e.getCurrentItem().getDurability()) {

                case 0:
                    plugin.playerChatColor.remove(player.getUniqueId());
                    plugin.playerChatColor.put(player.getUniqueId(), "§f");
                    break;
                case 1:
                    plugin.playerChatColor.remove(player.getUniqueId());
                    plugin.playerChatColor.put(player.getUniqueId(), "§6");
                    break;
                case 2:
                    plugin.playerChatColor.remove(player.getUniqueId());
                    plugin.playerChatColor.put(player.getUniqueId(), "§5");
                    break;
                case 3:
                    plugin.playerChatColor.remove(player.getUniqueId());
                    plugin.playerChatColor.put(player.getUniqueId(), "§b");
                    break;
                case 4:
                    plugin.playerChatColor.remove(player.getUniqueId());
                    plugin.playerChatColor.put(player.getUniqueId(), "§e");
                    break;
                case 5:
                    plugin.playerChatColor.remove(player.getUniqueId());
                    plugin.playerChatColor.put(player.getUniqueId(), "§a");
                    break;
                case 6:
                    plugin.playerChatColor.remove(player.getUniqueId());
                    plugin.playerChatColor.put(player.getUniqueId(), "§d");
                    break;
                case 7:
                    plugin.playerChatColor.remove(player.getUniqueId());
                    plugin.playerChatColor.put(player.getUniqueId(),  "§8");
                    break;
                case 9:
                    plugin.playerChatColor.remove(player.getUniqueId());
                    plugin.playerChatColor.put(player.getUniqueId(), "§3");
                    break;
                case 11:
                    plugin.playerChatColor.remove(player.getUniqueId());
                    plugin.playerChatColor.put(player.getUniqueId(), "§9");
                    break;
                case 13:
                    plugin.playerChatColor.remove(player.getUniqueId());
                    plugin.playerChatColor.put(player.getUniqueId(), "§2");
                    break;
                case 14:
                    plugin.playerChatColor.remove(player.getUniqueId());
                    plugin.playerChatColor.put(player.getUniqueId(), "§c");
                    break;
                case 15:
                    plugin.playerChatColor.remove(player.getUniqueId());
                    plugin.playerChatColor.put(player.getUniqueId(), "§0");
                    break;
                default:
                    plugin.playerChatColor.remove(player.getUniqueId());
                    plugin.playerChatColor.put(player.getUniqueId(), "§7");
                    break;
            }


        }

    }
}
