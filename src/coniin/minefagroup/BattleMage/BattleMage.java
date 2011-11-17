package coniin.minefagroup.BattleMage;

import java.util.HashMap;
import java.util.logging.Logger;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerInteractEvent;

public class BattleMage extends JavaPlugin {
	private PluginManager pm;
	private final BattleMagePlayerListener playerListener = new BattleMagePlayerListener(
			this);;
	Logger log = Logger.getLogger("Minecraft");
	boolean debugmod = true;
	// CastItems
	final int castItemIDElemantal = -1;
	final int castItemIDLower = -2;
	final int castItemIDBlood = -3;
	final int castItemIDDivine = -4;

	HashMap<Player, Magic> playerList = new HashMap<Player, Magic>();

	@Override
	public void onDisable() {
		log.info("[BattleMage] Version 0.0 disabled!");
	}

	@Override
	public void onEnable() {
		log.info("[BattleMage] Version 0.0 enabled!");
		pm = this.getServer().getPluginManager();
		if (debugmod) {
			log.info("[BattleMage] PluginManager loaded!");
		}

		pm.registerEvent(Event.Type.PLAYER_INTERACT, playerListener,
				Event.Priority.Normal, this);
		if (debugmod) {
			log.info("[BattleMage] PluginManager - PLAYER_INTERACT registered!");
		}
		pm.registerEvent(Event.Type.PLAYER_JOIN, playerListener,
				Event.Priority.Normal, this);
		if (debugmod) {
			log.info("[BattleMage] PluginManager - PLAYER_LOGIN registered!");
		}
		pm.registerEvent(Event.Type.PLAYER_QUIT, playerListener,
				Event.Priority.Normal, this);
		if (debugmod) {
			log.info("[BattleMage] PluginManager - PLAYER_QUIT registered!");
		}

		Player[] players = this.getServer().getOnlinePlayers();
		for (int i = 0; i < players.length; i++) {
			registerPlayer(players[i]);
		}
	}

	public void registerPlayer(Player toReg) {
		playerList.put(toReg, new Magic(toReg));
	}

	public void unregisterPlayer(Player toUnreg) {
		playerList.remove(toUnreg);
	}

	public void changeSpell(PlayerInteractEvent event) {
		switch (event.getPlayer().getItemInHand().getTypeId()) {
		case castItemIDElemantal:

			break;
		case castItemIDLower:

			break;
		case castItemIDBlood:

			break;
		case castItemIDDivine:

			break;
		}
		
	}

}
