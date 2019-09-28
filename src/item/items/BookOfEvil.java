package item.items;

import hero.Hero;
import item.base.UpgradableItem;

public class BookOfEvil extends UpgradableItem {
	
	private int level = 0, attackBonus;
	
	public BookOfEvil() {
		// use the given name and description
		super("Book of Evil", "A book containing evil knowledges, can store infinitely many pages");
//		String name = "Book of Evil";
//		String description = "A book containing evil knowledges, can store infinitely many pages";
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
		attackBonus = 10+(3*level);
		hero.setAttack(hero.getAttack() + attackBonus);
	}
	
	@Override
	public void unapplyBonuses(Hero hero) {
		hero.setAttack(hero.getAttack() - attackBonus);
	}
}
