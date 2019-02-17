package pt.flawless.BarberiansShop;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import pt.flawless.BarberiansShop.listeners.ShopCreateListener;
import pt.flawless.BarberiansShop.listeners.SignClickListener;

public class BarberiansShop extends JavaPlugin
{
    public static Plugin plugin;

    private void registerEvents()
    {
        Bukkit.getPluginManager().registerEvents(new SignClickListener(), this);
        Bukkit.getPluginManager().registerEvents(new ShopCreateListener(), this);
    }

    @Override
    public void onEnable()
    {
        registerEvents();
        plugin = this;

        ConsoleCommandSender ccs = Bukkit.getConsoleSender();
        ccs.sendMessage("§e");
        ccs.sendMessage("§e[BShop] Plugin ativado!");
        ccs.sendMessage("§e");
    }

    @Override
    public void onDisable()
    {
        ConsoleCommandSender ccs = Bukkit.getConsoleSender();
        ccs.sendMessage("§c");
        ccs.sendMessage("§c[BShop] Plugin desativado!");
        ccs.sendMessage("§c");
    }

}
