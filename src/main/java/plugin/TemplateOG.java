package plugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.barny1094875.utilitiesog.UtilitiesOG;
import net.trueog.diamondbankog.DiamondBankOG;

public class TemplateOG extends JavaPlugin {

	private static TemplateOG plugin;
	private static DiamondBankOG diamondBankPlugin = (DiamondBankOG) Bukkit.getPluginManager().getPlugin("DiamondBank-OG");
	private static UtilitiesOG utilitiesPlugin = (UtilitiesOG) Bukkit.getPluginManager().getPlugin("UtilitiesOG");
	public void onEnable() {

		plugin = this;

		getServer().getPluginManager().registerEvents(new Listeners(), this);
		//registerExpansion();

	}

	public static DiamondBankOG getDiamondBankPlugin() {
		return diamondBankPlugin;
	}

	public static UtilitiesOG getUtilitiesPlugin() {
		return utilitiesPlugin;
	}

	public static TemplateOG getPlugin() {

		return plugin;

	}

	/*public void registerExpansion() {

		// Create <diamondbankog_balance> placeholder.
		Expansion expansion = Expansion.builder("diamondbankog").globalPlaceholder("balance", (queue, ctx) -> {

			CompletableFuture<Double> balanceFuture = DiamondBankOG.getPlayerBalance(player.getUniqueId(), BalanceType.ALL);
			double balance = 0.0;
			try {
			    balance = balanceFuture.get(); // This might block the current thread
			    if (balance != null) {
			        System.out.println("Player balance: " + balance);
			    } else {
			        System.out.println("Player balance could not be retrieved.");
			    }
			} catch (InterruptedException | ExecutionException e) {
			    System.out.println("Error getting balance: " + e.getMessage()); 
			}

			return Tag.selfClosingInserting(Component.text(balance));
		}).build();

		expansion.register();

	}*/

}