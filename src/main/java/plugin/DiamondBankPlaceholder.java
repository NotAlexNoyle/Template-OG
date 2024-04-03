package plugin;

import org.bukkit.entity.Player;

import io.github.miniplaceholders.api.Expansion;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.trueog.diamondbankog.DiamondBankOG;
import net.trueog.diamondbankog.PostgreSQL.BalanceType;

public final class DiamondBankPlaceholder {

	public void registerExpansion() {

		DiamondBankOG diamondBankPlugin = new DiamondBankOG();
		Expansion.builder("diamondbankog").filter(Player.class) .audiencePlaceholder("balance", (aud, queue, ctx) -> {

			final Player player = (Player) aud;

			return Tag.preProcessParsed(String.valueOf(diamondBankPlugin.getPlayerBalance(player.getUniqueId(), BalanceType.ALL)));

		}).build().register();

	}

}