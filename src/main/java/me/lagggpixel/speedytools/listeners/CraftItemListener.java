package me.lagggpixel.speedytools.listeners;

import me.lagggpixel.speedytools.Main;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CraftItemListener implements Listener {

    public CraftItemListener() {
        Main.getInstance().getServer().getPluginManager().registerEvents(this, Main.getInstance());
    }

    @EventHandler(ignoreCancelled = true)
    public void onCraftItem(org.bukkit.event.inventory.CraftItemEvent event) {

        Player player = (Player) event.getWhoClicked();
        ItemStack item = event.getRecipe().getResult();

        boolean usePermissions = Main.getInstance().getConfig().getBoolean("use-permissions");
        boolean hasToolPermission = player.hasPermission("speedytools.use.tools");
        boolean hasSwordPermission = player.hasPermission("speedytools.use.swords");
        boolean hasArmorPermission = player.hasPermission("speedytools.use.armor");
        boolean isTool = Main.getInstance().getTools().contains(item.getType());
        boolean isSword = Main.getInstance().getSwords().contains(item.getType());
        boolean isArmor = Main.getInstance().getArmor().contains(item.getType());

        if ((!usePermissions || hasToolPermission) && isTool) {
            ItemMeta itemMeta = item.getItemMeta();
            assert itemMeta != null;
            itemMeta.addEnchant(Enchantment.DIG_SPEED, 3, false);
            itemMeta.addEnchant(Enchantment.DURABILITY, 2, false);
            item.setItemMeta(itemMeta);
            event.setCurrentItem(item);
        } else if ((!usePermissions || hasSwordPermission) && isSword) {
            ItemMeta itemMeta = item.getItemMeta();
            assert itemMeta != null;
            itemMeta.addEnchant(Enchantment.DAMAGE_ALL, 3, false);
            itemMeta.addEnchant(Enchantment.DURABILITY, 2, false);
            item.setItemMeta(itemMeta);
            event.setCurrentItem(item);
        } else if ((!usePermissions || hasArmorPermission) && isArmor) {
            ItemMeta itemMeta = item.getItemMeta();
            assert itemMeta != null;
            itemMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, false);
            itemMeta.addEnchant(Enchantment.DURABILITY, 2, false);
            item.setItemMeta(itemMeta);
            event.setCurrentItem(item);
        }




    }
}