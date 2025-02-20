package states;

import interfaces.VendingMachineState;
import models.VendingMachine;

public class DispensingState implements VendingMachineState {
	@Override
	public void selectItem(VendingMachine vendingMachine, String item) {
		System.out.println("Item is dispensing. Selecting an item is not allowed");
	}

	@Override
	public void insertCoin(VendingMachine vendingMachine, int amount) {
		System.out.println("Item is dispensing. Inserting a coin is not allowed");
	}

	@Override
	public void dispenseItem(VendingMachine vendingMachine) {
		System.out.println("Dispensing an item");
		vendingMachine.decreaseItemQuantity();
		vendingMachine.decreaseBalance();
		vendingMachine.printInformation();
		vendingMachine.setState(new IdleState());
	}

	@Override
	public void setOutOfOrder(VendingMachine vendingMachine) {
		vendingMachine.setState(new OutOfOrderState());
		System.out.println("Out of order");
	}
}
