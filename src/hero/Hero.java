package hero;

import item.base.Item;

public class Hero {
	
	private String name;
	private int hp, attack, defense, inventorySize, inventoryCap;
	private Item[] inventory;
	
	public Hero(String name, int hp, int attack, int defense, int inventorySize) {
		if(inventorySize < 1) {
			inventorySize = 1;
		}
		if(inventorySize > 6) {
			inventorySize = 6;
		}
		setHp(hp);
		this.name = name;
		setAttack(attack);
		setDefense(defense);
		inventory = new Item[inventorySize];
		inventoryCap = inventorySize;
		this.inventorySize = 0;
	}

	public Item[] getInventory() {
		Item[] cloned = inventory.clone();
		return cloned;
	}

	public int equipItem(Item item) throws EquipItemFailedException {
		if(inventorySize == inventoryCap) {
			throw new EquipItemFailedException("Hero inventory is full");			
		}
		int i = 0;
		for(; i < inventoryCap; i++) {
			if(inventory[i] == null) {
				inventory[i] = item;
				item.applyBonuses(this);
				inventorySize++;
				break;
			}
		}
		return(i);
	}

	public Item unequipItem(int slotNumber) throws UnequipItemFailedException {
		if(slotNumber > inventoryCap) {
			throw new UnequipItemFailedException("Hero does not have that many slots");
		} else if (inventory[slotNumber] == null) {
			throw new UnequipItemFailedException("No item in that slot");
		}
		Item unequipped = inventory[slotNumber];
		inventory[slotNumber].unapplyBonuses(this);
		inventory[slotNumber] = null;
		inventorySize--;
		return(unequipped);
	}

	@Override
	public String toString() {
		// you do NOT need to modify this method
		return new StringBuilder()
				.append("{").append(this.getName()).append("}")
				.append(":[")
				.append("hp:").append(this.getHp())
				.append(" atk:").append(this.getAttack())
				.append(" def:").append(this.getDefense())
				.append("] ")
				.append("(").append(this.getInventorySize()).append(" item slots)")
				.toString();
	}
	
	public String getName() {
		return name;
	}
	
	public int getHp() {
		return hp;
	}
	
	public int getAttack() {
		return attack;
	}
	
	public int getDefense() {
		return defense;
	}
	
	public int getInventorySize() {
		return inventoryCap;
	}
	
	public void setHp(int hp) {
		if(hp < 1) {
			hp = 1;
		}
		this.hp = hp;
	}
	
	public void setAttack(int attack) {
		this.attack = attack;
	}
	
	public void setDefense(int defense) {
		this.defense = defense;
	}
}
