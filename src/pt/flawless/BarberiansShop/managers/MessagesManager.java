package pt.flawless.BarberiansShop.managers;

import pt.flawless.BarberiansShop.BarberiansShop;

public class MessagesManager
{
    //GENERAL STRINGS

    public static String playerOff = (String) BarberiansShop.plugin.getConfig().get("Mensagens.playeroff");
    public static String playersOnly = (String) BarberiansShop.plugin.getConfig().get("Mensagens.playersOnly");

    //SHOP STRINGS
    public static String invalidArgument = (String) BarberiansShop.plugin.getConfig().get("Mensagens.invalidArgument");
    public static String quantiyMissing = (String) BarberiansShop.plugin.getConfig().get("Mensagens.quantityMissing");
    public static String priceMissing = (String) BarberiansShop.plugin.getConfig().get("Mensagens.priceMissing");
    public static String shopTypeMissing = (String) BarberiansShop.plugin.getConfig().get("Mensagens.shopTypeMissing");
    public static String shopError = (String) BarberiansShop.plugin.getConfig().get("Mensagens.shopError");
    public static String shopCreated = (String) BarberiansShop.plugin.getConfig().get("Mensagens.shopCreated");

    //ITEMADD STRING

    public static String usageItemAdd = "§cArgumentos inválidos: /itemadd (preco)";
    public static String itemAdded = "§eItem §f(" + VariablesManager.item + "§f) §eadicionado por §f" + VariablesManager.price;
}
