package states;

import interfaces.VendingMachineState;
import models.VendingMachine;

public class ItemSelectedState implements VendingMachineState {
	@Override
	public void selectItem(VendingMachine vendingMachine, String item) {
		System.out.println("Item already selected");
	}

	@Override
	public void insertCoin(VendingMachine vendingMachine, int amount) {
		System.out.println("Coin inserted: " + amount);
		vendingMachine.addBalance(amount);

		if (vendingMachine.isBalanceGreaterThanOrEqualPrice()) {
			vendingMachine.setState(new DispensingState());
		}
	}

	@Override
	public void dispenseItem(VendingMachine vendingMachine) {
		System.out.println("Please insert a coin first before dispensing the item");
	}

	@Override
	public void setOutOfOrder(VendingMachine vendingMachine) {
		vendingMachine.setState(new OutOfOrderState());
		System.out.println("Out of order");
	}
}
