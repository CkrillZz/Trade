package masq.trade.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import masq.trade.utils.Chat;

public class Trade implements CommandExecutor {
	
	@Override
    public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
		Player p = (Player) s;
		Player p2 = Bukkit.getServer().getPlayer(args[0]);
		
		if(!(s instanceof Player)) {
		    s.sendMessage("Cette commande est seulement executable par un joueur.");
		} else if(args.length == 0) {
			s.sendMessage(ChatColor.RED + "e");
		} else {
			if(p2 == null) {
				s.sendMessage(ChatColor.RED + "Ce joueur n'est pas connecté.");
			/*} else if(s == p2) {
				s.sendMessage(ChatColor.RED + "Vous ne pouvez pas échanger avec vous même.");*/
			} else {
				/* Ajouter une verification pour le ct
				p.openInventory(Bukkit.createInventory(null, 27, ChatColor.GREEN + "Echange avec " + p2.getDisplayName()));
				p2.sendMessage(ChatColor.GREEN + "" + p.getDisplayName() + " vous a envoyé une demande d'échange :");
				p2.sendMessage(Utils.center(new String(ChatColor.GREEN + "[Accepter] " + ChatColor.RED + "[Refuser]")));*/
				Chat.tradeRequest(p2, p);
			}
		}
		return true;
	}
	
	public void gi(Player p, Player p2) {
		Inventory i = Bukkit.createInventory(null, 45, ChatColor.GREEN + "Echange avec " + p2.getDisplayName());
		ItemStack ir = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
		ItemMeta irm = ir.getItemMeta();
		irm.setDisplayName(ChatColor.RED + "Annuler");
		ir.setItemMeta(irm);
		ItemStack ia = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)5);
		ItemMeta iam = ia.getItemMeta();
		iam.setDisplayName(ChatColor.GREEN + "Confirmer");
		ia.setItemMeta(iam);
		i.setItem(43, ir);
		i.setItem(44, ia);
		p.openInventory(i);
	}
}
