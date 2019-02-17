package pt.flawless.BarberiansShop.shops;

import mcmacau.barberianscore.Group.BGroup;
import mcmacau.barberianscore.Group.BGroups;
import mcmacau.barberianscore.ItemStack.BItemStack;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import pt.flawless.BarberiansShop.managers.MessagesManager;
import pt.flawless.BarberiansShop.managers.SignsManager;
import pt.flawless.BarberiansShop.managers.VariablesManager;


public class SignShop
{
    private Sign sign;
    private Player player;

    private enum ShopType
    {
        ServerShop, PlayerShop
    }

    public SignShop(Sign sign, Player player)
    {
        this.setSign(sign);
        this.setPlayer(player);
    }

    private void setTitleQuantityItem(int quantity, ShopType shopType)
    {
        if (shopType == ShopType.PlayerShop)
        {
            sign.setLine(0, "§6" + player.getName() + "");
        }
        else
        {
            sign.setLine(0, "§6" + player.getName() + "");
        }

        sign.setLine(1, "§1Quantidade: " + quantity);
        sign.setLine(3, "---");
    }

    private void verifyShop(String shopType, int price)
    {
        if (shopType.equalsIgnoreCase("C"))
        {
            sign.setLine(2, "§aC " + price);
            player.sendMessage(MessagesManager.shopCreated);
            VariablesManager.sucess.send(player);
        }
        else if (shopType.equalsIgnoreCase("V"))
        {
            sign.setLine(2, "§cV " + price);
            player.sendMessage(MessagesManager.shopCreated);
            VariablesManager.sucess.send(player);
        }

        else if (shopType.equalsIgnoreCase("CV"))
        {
            int espaco = sign.getLine(2).indexOf(" ");
            int preco_compra = Integer.parseInt(sign.getLine(2).substring(0, espaco));
            int preco_venda = Integer.parseInt(sign.getLine(2).substring(espaco + 1));
            sign.setLine(2, "§aC " + preco_compra + " §0/ §cV " + preco_venda);
            VariablesManager.sucess.send(player);
            player.sendMessage(MessagesManager.shopCreated);
        }
        else
        {
            sign.getBlock().breakNaturally();
            player.sendMessage(MessagesManager.shopError);
            VariablesManager.fail.send(player);
        }
    }

    private void verifyErrors(String shopType)
    {
        if (sign.getLine(1).equals(""))
        {
            sign.getBlock().breakNaturally();
            player.sendMessage(MessagesManager.quantiyMissing);
            VariablesManager.fail.send(player);
        }
        if (sign.getLine(2).equals(""))
        {
            sign.getBlock().breakNaturally();
            player.sendMessage(MessagesManager.priceMissing);
            VariablesManager.fail.send(player);
        }
        if (shopType.equals(""))
        {
            player.getWorld().dropItemNaturally(player.getLocation(), new BItemStack(Material.SIGN, 1).create());
            player.sendMessage(MessagesManager.shopTypeMissing);
            VariablesManager.fail.send(player);
        }
    }

    public void createPlayerShop()
    {
        int quantity = Integer.parseInt(sign.getLine(1));
        String shopType = sign.getLine(2);
        int price = Integer.parseInt(sign.getLine(3));

        if (!(sign.getLine(1).equals("")) && !(sign.getLine(2).equals("")) && !(shopType.equals("")))
        {
            try
            {
                setTitleQuantityItem(quantity, ShopType.PlayerShop);
                verifyShop(shopType, price);

            } catch (NumberFormatException e1)
            {
                sign.getBlock().breakNaturally();
                player.sendMessage(MessagesManager.invalidArgument + " §o(Valor inserido: " + e1.getLocalizedMessage().substring(18) + ")");
                VariablesManager.fail.send(player);
            }
        }
        else
        {
            verifyErrors(shopType);
        }
    }

    public void createServerShop()
    {
        String serverShop = sign.getLine(0);
        int quantity = Integer.parseInt(sign.getLine(1));
        String shopType = sign.getLine(2);
        int price = Integer.parseInt(sign.getLine(3));

        if (!(sign.getLine(1).equals("")) && !(sign.getLine(2).equals("")) && !(shopType.equals("")))
        {
            try
            {
                setTitleQuantityItem(quantity, ShopType.ServerShop);
                verifyShop(shopType, price);

            } catch (NumberFormatException e1)
            {
                sign.getBlock().breakNaturally();
                player.sendMessage(MessagesManager.invalidArgument + " §o(Valor inserido: " + e1.getLocalizedMessage().substring(18) + ")");
                VariablesManager.fail.send(player);
            }
        }
        else if (serverShop.equalsIgnoreCase(player.getName()) && BGroup.hasPermission(BGroups.GROUP_PLAYER, player))
        {
            verifyErrors(shopType);
        }
    }

    public void insertItemName(Material itemInHand)
    {
        //        sign.setLine(3, ChatColor.DARK_PURPLE + player.getItemInHand().getType().toString());
        //        sign.setLine(3, player.getItemInHand().getType().toString());
        //        sign.update();

        if (!hasItem())
        {
            SignsManager.updateLine(sign, 3, itemInHand.toString());
        }
    }

    public boolean hasItem()
    {
        if (sign.getLine(3).equalsIgnoreCase("---"))
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public boolean hasEnchantments()
    {
        if (player.getItemInHand().getEnchantments().toString().equalsIgnoreCase(""))
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public Sign getSign()
    {
        return sign;
    }

    public void setSign(Sign sign)
    {
        this.sign = sign;
    }

    public Player getPlayer()
    {
        return player;
    }

    public void setPlayer(Player player)
    {
        this.player = player;
    }
}
