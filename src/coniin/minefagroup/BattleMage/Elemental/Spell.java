package coniin.minefagroup.BattleMage.Elemental;

import java.util.Timer;
import java.util.TimerTask;

import org.bukkit.Location;
import org.bukkit.entity.Player;


public abstract class Spell {
	
	String name;
	long warmUpTime = 0;
	long coolDownTime = 0;
	ElementalMagic mag;
	Timer cdt = new Timer();;
	boolean isOnCoolDown = false;
	boolean castedSpell = false;

	TimerTask cdtTask = new cdtTask(this);
	TimerTask wutTask ;

	public Spell(Player caster) {
		wutTask = new wutTask(this, caster, warmUpTime);
	}
	
	public void spellCasted(){
		castedSpell = true;
	}
	
	public void resetCoolDown() {
		this.isOnCoolDown = false;
	}

	public int castSpell(Player caster) {
		if (isOnCoolDown) {
			return 2;
		} else {
			// Starte WarmUpTime und führe evtl Spell aus
			cdt.schedule(wutTask, 0);
			if (castedSpell){
				//Adde Spell zur CoolDownList und nehme ihn nach CoolDownTime wieder runter
				isOnCoolDown = true;
				cdt.schedule(cdtTask, coolDownTime);
				castedSpell = false;
			} else {
				return 1;
			}

		}
		return 0;

	}

	public abstract boolean doSpell(Player caster);

	private class cdtTask extends TimerTask {

		public cdtTask(Spell s) {
			s.resetCoolDown();
		}

		@Override
		public void run() {

		}

	}

	private class wutTask extends TimerTask {

		Player caster;
		long wut;
		Spell s;
		
		public wutTask(Spell s,Player caster, long wut){
			this.s = s;
			this.caster = caster;
			this.wut = wut;
		}
		
		@Override
		public void run() {
			Location oldLoc = caster.getLocation();
			try {
				Thread.sleep(wut);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Vergleiche anfangs mit EndPosition und breche evtl Spell ab
			if (oldLoc == caster.getLocation()) {
				s.doSpell(caster);
				s.spellCasted();
			}
			
		}
		
	}
	
}
