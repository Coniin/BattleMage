package coniin.minefagroup.BattleMage;

import org.bukkit.entity.Player;

import coniin.minefagroup.BattleMage.Blood.BloodMagic;
import coniin.minefagroup.BattleMage.Divine.DivineMagic;
import coniin.minefagroup.BattleMage.Elemental.ElementalMagic;
import coniin.minefagroup.BattleMage.Lower.LowerMagic;

public class Magic {
	
	ElementalMagic elementalMagic;
	LowerMagic lowerMagic;
	BloodMagic bloodMagic;
	DivineMagic divineMagic;
	
	public Magic(Player aktPlayer){
		elementalMagic = new ElementalMagic(aktPlayer);
		lowerMagic = new LowerMagic();
		bloodMagic = new BloodMagic();
		divineMagic = new DivineMagic();
	}
	
}
