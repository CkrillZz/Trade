package masq.trade;

import org.bukkit.plugin.java.JavaPlugin;

import masq.trade.commands.Accept;
import masq.trade.commands.Trade;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		this.getCommand("trade").setExecutor(new Trade());
		this.getCommand("tradeaccept").setExecutor(new Accept());
	}
	
	public void onDisable() {
		
	}

}
