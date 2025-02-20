package models;

import interfaces.VendingMachineState;
import states.IdleState;

import java.util.HashMap;

public class VendingMachine {
	private VendingMachineState state;
	private final HashMap<String, VendingMachineItem> items;
	private int balance;
	private String selectedItem;

	public VendingMachine(HashMap<String, VendingMachineItem> items) {
		this.state = new IdleState();
		this.items = items;
		this.balance = 0;
		this.selectedItem = null;
	}

	public void addBalance(int amount) {
		this.balance += amount;
	}

	public void decreaseItemQuantity() {
		this.items.get(this.selectedItem).reduceQuantity();
	}

	public void decreaseBalance() {
		this.balance -= this.items.get(this.selectedItem).getPrice();
	}

	public boolean isBalanceGreaterThanOrEqualPrice() {
		return this.balance >= this.items.get(this.selectedItem).getPrice();
	}

	public boolean isItemAvailable(String item) {
		return this.items.get(item).getQuantity() > 0;
	}

	public void setState(VendingMachineState state) {
		this.state = state;
	}

	public void setSelectedItem(String item) {
		this.selectedItem = item;
	}

	public void selectItem(String item) {
		this.state.selectItem(this, item);
	}

	public void insertCoin(int amount) {
		this.state.insertCoin(this, amount);
	}

	public void dispenseItem() {
		this.state.dispenseItem(this);
	}

	public void setOutOfOrder() {
		this.state.setOutOfOrder(this);
	}

	public void printInformation() {
		System.out.println();
		for (VendingMachineItem item : this.items.values()) {
			System.out.println("Item: " + item.getName() + ", Quantity: " + item.getQuantity() + ", Price: " + item.getPrice());
		}

		System.out.println("Balance: " + this.balance);
		System.out.println();
	}
}
