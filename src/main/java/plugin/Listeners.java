// This is free and unencumbered software released into the public domain.
// Author: NotAlexNoyle.
package plugin;

// Import libraries.
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import net.trueog.diamondbankog.DiamondBankOG;
import net.trueog.diamondbankog.PostgreSQL.BalanceType;

// Hook into Bukkit's Listener.
public class Listeners implements Listener {

	// Perform this plugin's action before other plugins actions.
	@EventHandler(priority = EventPriority.HIGHEST)
	// When a block is broken, do this...
	public void onBlockBreak(BlockBreakEvent event) {

		// Open a spectator GUI for the player who broke the block.
		//new SpectatorGui(TemplateOG.getPlugin(), event.getPlayer()).open(true);

		DiamondBankOG diamondBankPlugin = new DiamondBankOG();
		diamondBankPlugin.getPlayerBalance(event.getPlayer().getUniqueId(), BalanceType.ALL)
		.thenAccept(balance -> {
			String formattedBalance = "&BYour balance is: " + String.valueOf(balance.getBankBalance());
			Utils.templateOGPlaceholderMessage(event.getPlayer(), formattedBalance);
		}).exceptionally(error -> {
			TemplateOG.getPlugin().getLogger().info("Error fetching balance: " + error.getMessage());
			return null;
		});

	}

}