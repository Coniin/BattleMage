package coniin.minefagroup.BattleMage.Elemental;



import org.bukkit.entity.Player;




public class Heal extends Spell{


	public Heal(Player caster) {
		super(caster);
		// TODO Auto-generated constructor stub
	}

	//Spell Veriablen
	final public String name = "Heal";
	final private float warmUpTime = 5;
	final private float coolDownTime = 30;
	//eigene Var
	final private int halfHeartsToHeal = 2; 
	
	@Override
	public boolean doSpell(Player caster) {
		caster.setHealth(halfHeartsToHeal);
		return true;
	}
	
	
	
	
}
