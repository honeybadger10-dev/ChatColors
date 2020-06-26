package dev.james.ecc.gui;

import dev.james.ecc.EccMain;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;

public class Gui {


    EccMain plugin;
    public Gui(EccMain main) {
        this.plugin = main;
    }


    public void createInventory(Player player) {
        Inventory gui = Bukkit.createInventory(player, 27, ChatColor.GREEN + "Chat Color Menu");


        ItemStack playerskull = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
        SkullMeta meta = (SkullMeta) playerskull.getItemMeta();
        meta.setOwner(player.getName());
        meta.setDisplayName(ChatColor.GRAY + "Current Chat Color");
        ArrayList<String> lore = new ArrayList<>();
        lore.add(plugin.playerChatColor.get(player.getUniqueId()) + "*********");
        meta.setLore(lore);
        playerskull.setItemMeta(meta);


        gui.setItem(26, playerskull);



        //Colors
        ItemStack black = new ItemStack(Material.WOOL, 1, (short) DyeColor.BLACK.getData());
        ItemStack red = new ItemStack(Material.WOOL, 1, (short) DyeColor.RED.getData());
        ItemStack green = new ItemStack(Material.WOOL, 1, (short) DyeColor.GREEN.getData());
        ItemStack blue = new ItemStack(Material.WOOL, 1, (short) DyeColor.BLUE.getData());
        ItemStack purple = new ItemStack(Material.WOOL, 1, (short) DyeColor.PURPLE.getData());
        ItemStack cyan = new ItemStack(Material.WOOL, 1, (short) DyeColor.CYAN.getData());
        ItemStack gray = new ItemStack(Material.WOOL, 1, (short) DyeColor.GRAY.getData());
        ItemStack pink = new ItemStack(Material.WOOL, 1, (short) DyeColor.PINK.getData());
        ItemStack lime = new ItemStack(Material.WOOL, 1, (short) DyeColor.LIME.getData());
        ItemStack yellow = new ItemStack(Material.WOOL, 1, (short) DyeColor.YELLOW.getData());
        ItemStack aqua = new ItemStack(Material.WOOL, 1, (short) DyeColor.LIGHT_BLUE.getData());
        ItemStack orange = new ItemStack(Material.WOOL, 1, (short) DyeColor.ORANGE.getData());
        ItemStack white = new ItemStack(Material.WOOL, 1, (short) DyeColor.WHITE.getData());


        ItemStack[] colors = {black, red, green, blue, purple, cyan, gray, pink, lime, yellow, aqua, orange,
        white};
        String[] colorNames = {"Black", "Red", "Green", "Blue", "Purple", "Cyan", "Gray", "Pink", "Lime",
                "Yellow", "Aqua", "Orange", "White"};
        for(int i = 0; i < 13; i++) {
            ItemMeta colorMeta = colors[i].getItemMeta();
            meta.setDisplayName(ChatColor.GRAY + "Click To Change To " +
                    plugin.playerChatColor.get(player.getUniqueId()) + colorNames[i]);
            colors[i].setItemMeta(meta);
        }


        //Assign Places
        gui.setItem(0, red);
        gui.setItem(1, orange);
        gui.setItem(2, yellow);
        gui.setItem(3, lime);
        gui.setItem(4, green);
        gui.setItem(5, cyan);
        gui.setItem(6, aqua);
        gui.setItem(7, blue);
        gui.setItem(8, purple);
        gui.setItem(9, pink);
        gui.setItem(10, white);
        gui.setItem(11, gray);
        gui.setItem(12, black);

        player.openInventory(gui);

    }

}
