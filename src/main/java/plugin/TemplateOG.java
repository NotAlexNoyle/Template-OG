package plugin;

import org.bukkit.plugin.java.JavaPlugin;

public class TemplateOG extends JavaPlugin {

	private static TemplateOG plugin;

	public void onEnable() {

		plugin = this;

		getServer().getPluginManager().registerEvents(new Listeners(), this);
		DiamondBankPlaceholder balancePlaceholder = new DiamondBankPlaceholder();
		balancePlaceholder.registerExpansion();

	}

	public static TemplateOG getPlugin() {

		return plugin;

	}

	/*public static void registerExpansion() {
		Expansion.Builder builder = Expansion.builder("diamondbank_og_balance").filter(Player.class);

		builder.audiencePlaceholder("name", (audience, ctx, queue) -> {
			final Player player = (Player) audience;
			DiamondBankOG diamondBankPlugin = new DiamondBankOG();
			diamondBankPlugin.getPlayerBalance(player.getUniqueId(), BalanceType.ALL)
			.thenAccept(balance -> {
				String formattedBalance = "&BYour balance is: " + String.valueOf(balance.getBankBalance());
				Utils.templateOGPlaceholderMessage(player, formattedBalance);
			}).exceptionally(error -> {
				player.sendMessage("Error fetching balance.");
				plugin.getLogger().info("Error fetching balance: " + error.getMessage());
				return null;
			});

			TextComponent nameHandler = LegacyComponentSerializer.legacyAmpersand().deserialize(player.getName());
			return Tag.selfClosingInserting(nameHandler); 
		}).globalPlaceholder("tps", (ctx, queue) -> Tag.selfClosingInserting(Component.text(Bukkit.getTPS()[0]))).build();

		Expansion expansion = builder.build();
		expansion.register();

	}*/

}