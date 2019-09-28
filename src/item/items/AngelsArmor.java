package item.items;

import hero.Hero;
import item.base.UpgradableItem;

// You CAN modify the first line
public class AngelsArmor extends UpgradableItem {
	
	private int level = 1, hpBonus, defenseBonus, attackBonus;
	
	public AngelsArmor() {
		super("Angel's Armor", "Armor wielded by Heaven's people");
		// use the given name and description
//		String name = "Angel's Armor";
//		String description = "Armor wielded by Heaven's people";
	}

	@Override
	public void upgrade() {
		level++;
	}

	@Override
	public int getUpgradeLevel() {
		return level;
	}

	@Override
	public void applyBonuses(Hero hero) {
		switch(level) {
			case 1:
				defenseBonus = 10;
				hpBonus = 0;
				attackBonus = 0;
				break;
			case 2:
				defenseBonus = 27;
				hpBonus = 233;
				attackBonus = 0;
				break;
			case 3:
				defenseBonus = 46;
				hpBonus = 326;
				attackBonus = 23;
				break;
		}
		hero.setDefense(hero.getDefense() + defenseBonus);
		hero.setHp(hero.getHp() + hpBonus);
		hero.setAttack(hero.getAttack() + attackBonus);
	}

	@Override
	public void unapplyBonuses(Hero hero) {
		hero.setDefense(hero.getDefense() - defenseBonus);
		hero.setHp(hero.getHp() - hpBonus);
		hero.setAttack(hero.getAttack() - attackBonus);
	}
	
	public int getDefenseBonus() {
		return defenseBonus;
	}
}
