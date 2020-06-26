package dev.james.ecc.gui;

import dev.james.ecc.EccMain;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command implements CommandExecutor {

    EccMain plugin;

    public Command(EccMain main) {
        this.plugin = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String s, String[] strings) {
        if (sender instanceof Player) {
            Player player = (Player) sender;


            Gui gui = new Gui(plugin);
            gui.createInventory(player);
        }


        return true;

    }
}
