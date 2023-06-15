package me.lagggpixel.speedytools;

import lombok.Getter;
import me.lagggpixel.speedytools.listeners.CraftItemListener;
import org.bstats.bukkit.Metrics;
import org.bstats.config.MetricsConfig;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public final class Main extends JavaPlugin {

    private static Main INSTANCE;

    List<Material> tools;
    List<Material> swords;
    List<Material> armor;

    @Override
    public void onEnable() {
        INSTANCE = this;

        Metrics metrics = new Metrics(this, 18756);

        //<editor-fold desc="Populating tools array">
        tools = new ArrayList<>(Arrays.asList(
                Material.WOODEN_AXE,
                Material.WOODEN_HOE,
                Material.WOODEN_PICKAXE,
                Material.WOODEN_SHOVEL,
                Material.WOODEN_SWORD,
                Material.STONE_AXE,
                Material.STONE_HOE,
                Material.STONE_PICKAXE,
                Material.STONE_SHOVEL,
                Material.STONE_SWORD,
                Material.IRON_AXE,
                Material.IRON_HOE,
                Material.IRON_PICKAXE,
                Material.IRON_SHOVEL,
                Material.IRON_SWORD,
                Material.GOLDEN_AXE,
                Material.GOLDEN_HOE,
                Material.GOLDEN_PICKAXE,
                Material.GOLDEN_SHOVEL,
                Material.GOLDEN_SWORD,
                Material.DIAMOND_AXE,
                Material.DIAMOND_HOE,
                Material.DIAMOND_PICKAXE,
                Material.DIAMOND_SHOVEL,
                Material.DIAMOND_SWORD,
                Material.NETHERITE_AXE,
                Material.NETHERITE_HOE,
                Material.NETHERITE_PICKAXE,
                Material.NETHERITE_SHOVEL,
                Material.NETHERITE_SWORD,
                Material.SHEARS
        ));
        //</editor-fold>
        //<editor-fold desc="Populating swords array">
        swords = new ArrayList<>(Arrays.asList(
                Material.WOODEN_SWORD,
                Material.STONE_SWORD,
                Material.IRON_SWORD,
                Material.GOLDEN_SWORD,
                Material.DIAMOND_SWORD,
                Material.NETHERITE_SWORD
        ));
        //</editor-fold>
        //<editor-fold desc="Populating armor array">
        armor = new ArrayList<>(Arrays.asList(
                Material.LEATHER_HELMET,
                Material.LEATHER_CHESTPLATE,
                Material.LEATHER_LEGGINGS,
                Material.LEATHER_BOOTS,
                Material.CHAINMAIL_HELMET,
                Material.CHAINMAIL_CHESTPLATE,
                Material.CHAINMAIL_LEGGINGS,
                Material.CHAINMAIL_BOOTS,
                Material.IRON_HELMET,
                Material.IRON_CHESTPLATE,
                Material.IRON_LEGGINGS,
                Material.IRON_BOOTS,
                Material.GOLDEN_HELMET,
                Material.GOLDEN_CHESTPLATE,
                Material.GOLDEN_LEGGINGS,
                Material.GOLDEN_BOOTS,
                Material.DIAMOND_HELMET,
                Material.DIAMOND_CHESTPLATE,
                Material.DIAMOND_LEGGINGS,
                Material.DIAMOND_BOOTS,
                Material.NETHERITE_HELMET,
                Material.NETHERITE_CHESTPLATE,
                Material.NETHERITE_LEGGINGS,
                Material.NETHERITE_BOOTS
        ));
        //</editor-fold>

        loadConfigs();
        registerListeners();
    }

    @Override
    public void onDisable() {
    }

    private void registerListeners() {
        new CraftItemListener();
    }

    private void loadConfigs() {
        Main.getInstance().getConfig().options().copyDefaults(true);
        Main.getInstance().saveDefaultConfig();
    }

    public static Main getInstance() {
        return INSTANCE;
    }
}
