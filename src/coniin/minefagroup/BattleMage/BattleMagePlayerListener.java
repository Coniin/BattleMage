package coniin.minefagroup.BattleMage;


import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerQuitEvent;

public class BattleMagePlayerListener extends PlayerListener {
	
	BattleMage battleMagePlugin;
	
	public BattleMagePlayerListener(BattleMage instanceOf) {
		super();
		this.battleMagePlugin = instanceOf;
		if (battleMagePlugin.debugmod){
			battleMagePlugin.log.info("[BattleMage] PlayerListener enabled!");	
		}		
	}
	
	@Override
	public void onPlayerJoin(PlayerJoinEvent event) {
		if (battleMagePlugin.debugmod){
			battleMagePlugin.log.info("[BattleMage] PLAYER_LOGIN "+ event.getPlayer().getDisplayName() +"!");	
		}
		battleMagePlugin.registerPlayer(event.getPlayer());
	}
	
	@Override
	public void onPlayerQuit(PlayerQuitEvent event) {
		if (battleMagePlugin.debugmod){
			battleMagePlugin.log.info("[BattleMage] PLAYER_QUIT: "+ event.getPlayer().getDisplayName() +"!");	
		}
		battleMagePlugin.unregisterPlayer(event.getPlayer());
	}
	
	@Override
	public void onPlayerInteract(PlayerInteractEvent event){
		switch (event.getAction()){
		case LEFT_CLICK_AIR:
			battleMagePlugin.log.info("[BattleMage] PLAYER_INTERACT.LEFT_CLICK_AIR "+event.getPlayer().getDisplayName());
			break;
		case LEFT_CLICK_BLOCK:
			battleMagePlugin.log.info("[BattleMage] PLAYER_INTERACT.LEFT_CLICK_BLOCK "+event.getPlayer().getDisplayName());
			break;
		case RIGHT_CLICK_AIR:
			battleMagePlugin.log.info("[BattleMage] PLAYER_INTERACT.RIGHT_CLICK_AIR "+event.getPlayer().getDisplayName());
			break;
		case RIGHT_CLICK_BLOCK:
			battleMagePlugin.log.info("[BattleMage] PLAYER_INTERACT.RIGHT_CLICK_BLOCK "+event.getPlayer().getDisplayName());
			break;
		default:
			//TODO Error
		}
	}
		
}
