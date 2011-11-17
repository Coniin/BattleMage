package coniin.minefagroup.BattleMage.Elemental;




import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import coniin.minefagroup.BattleMage.BattleMage;



public class ElementalMagic {
	
	Player caster;
	ArrayList spellList = new ArrayList();
	
	public ElementalMagic(Player caster){
		this.caster = caster;
		registerSpells();
	}
	
	public boolean registerSpells(){
		Heal spellHeal = new Heal(caster);
		return true;
	}
	
	public boolean unregisterSpell(Spell toUnreg){
		return true;
	}
	
	
	
}
