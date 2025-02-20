package states;

import interfaces.VendingMachineState;
import models.VendingMachine;

public class OutOfOrderState implements VendingMachineState {
	@Override
	public void selectItem(VendingMachine vendingMachine, String item) {
		System.out.println("Out of order. Cannot select an item");
	}

	@Override
	public void insertCoin(VendingMachine vendingMachine, int amount) {
		System.out.println("Out of order. Cannot insert a coin");
	}

	@Override
	public void dispenseItem(VendingMachine vendingMachine) {
		System.out.println("Out of order. Cannot dispense an item");
	}

	@Override
	public void setOutOfOrder(VendingMachine vendingMachine) {
		System.out.println("Already out of order");
	}
}
