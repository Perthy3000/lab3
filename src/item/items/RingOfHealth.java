package item.items;

import hero.Hero;
import item.base.Item;

// You CAN modify the first line
public class RingOfHealth extends Item {
	
	private int hpBonusPer, hpBonus;
	
	public RingOfHealth(int hpPercentageBonus) {
		super("Orb of Health (+" + hpPercentageBonus + "%)", "increase hp by " + hpPercentageBonus + "%");
		hpBonusPer = hpPercentageBonus;
//		String name = "Orb of Health (+" + hpPercentageBonus + "%)";
//		String description =  "increase hp by " + hpPercentageBonus + "%";
	}
	
	@Override
	public void applyBonuses(Hero hero) {
		hpBonus = hero.getHp()*hpBonusPer/100;
		hero.setHp(hero.getHp() + hpBonus);
	}
	
	@Override
	public void unapplyBonuses(Hero hero) {
		hero.setHp(hero.getHp() - hpBonus);
	}
}
