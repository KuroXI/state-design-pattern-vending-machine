package states;

import interfaces.VendingMachineState;
import models.VendingMachine;

public class IdleState implements VendingMachineState {
	@Override
	public void selectItem(VendingMachine vendingMachine, String item) {
		if (!vendingMachine.isItemAvailable(item)) {
			System.out.println("Item out of stock");
			return;
		}

		vendingMachine.setSelectedItem(item);
		vendingMachine.setState(new ItemSelectedState());
		System.out.println("Selected item: " + item);
	}

	@Override
	public void insertCoin(VendingMachine vendingMachine, int amount) {
		System.out.println("Please select an item first before inserting a coin");
	}

	@Override
	public void dispenseItem(VendingMachine vendingMachine) {
		System.out.println("Please select an item first before dispensing the item");
	}

	@Override
	public void setOutOfOrder(VendingMachine vendingMachine) {
		vendingMachine.setState(new OutOfOrderState());
		System.out.println("Out of order");
	}
}
