package masq.trade.utils;

import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import net.minecraft.server.v1_7_R4.ChatSerializer;
import net.minecraft.server.v1_7_R4.IChatBaseComponent;
import net.minecraft.server.v1_7_R4.PacketPlayOutChat;

public class Chat implements Listener {

	public static void tradeRequest(Player p, Player p2) {
		IChatBaseComponent c = ChatSerializer.a("{\"text\":\"§a" + p2.getDisplayName() + " vous a envoyé une demande d'échange : \",\"extra\":[{\"text\":\"||§a[Accepter]\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":\"§fAccepter la demande\"},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/tradeaccept\"}}]}");
		PacketPlayOutChat pa = new PacketPlayOutChat(c, true);
        ((CraftPlayer) p).getHandle().playerConnection.sendPacket(pa);
	}
}
