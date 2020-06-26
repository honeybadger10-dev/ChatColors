package dev.james.ecc;

import dev.james.ecc.gui.Command;
import dev.james.ecc.gui.Events;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;


public class EccMain extends JavaPlugin {

    public HashMap<UUID, String> playerChatColor = new HashMap<UUID, String>();


    public void onEnable() {
        getServer().getPluginManager().registerEvents(new Events(this), this);
        this.getCommand("chatcolors").setExecutor(new Command(this));
    }



}
