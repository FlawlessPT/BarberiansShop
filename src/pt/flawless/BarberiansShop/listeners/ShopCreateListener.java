package pt.flawless.BarberiansShop.listeners;

import mcmacau.barberianscore.Group.BGroup;
import mcmacau.barberianscore.Group.BGroups;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import pt.flawless.BarberiansShop.shops.SignShop;

public class ShopCreateListener implements Listener
{
    @EventHandler
    public void onShopCreate(SignChangeEvent e)
    {
        Player p = e.getPlayer();
        String title = e.getLine(0);

        if (title.equalsIgnoreCase("Mercado") && BGroup.hasPermission(BGroups.GROUP_MODERATOR, p))
        {
            SignShop signShop = new SignShop((Sign) e.getBlock(), p);
            signShop.createServerShop();
        }
        else if (title.equalsIgnoreCase(p.getName()) && BGroup.hasPermission(BGroups.GROUP_PLAYER, p))
        {
            SignShop signShop = new SignShop((Sign) e.getBlock(), p);
            signShop.createPlayerShop();
        }
    }
}
