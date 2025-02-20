import models.VendingMachine;
import models.VendingMachineItem;

import java.util.HashMap;

public class VendingMachineDemo {
	public static void main(String[] args) {
		HashMap<String, VendingMachineItem> vendingMachineItems = new HashMap<>();
		vendingMachineItems.put("Cola", new VendingMachineItem("Cola", 2, 6));
		vendingMachineItems.put("Sprite", new VendingMachineItem("Sprite", 1, 4));
		vendingMachineItems.put("Pepsi", new VendingMachineItem("Pepsi", 2, 5));

		VendingMachine vendingMachine = new VendingMachine(vendingMachineItems);

		vendingMachine.selectItem("Cola");
		vendingMachine.insertCoin(6);
		vendingMachine.dispenseItem(); // Balance: 0

		vendingMachine.selectItem("Cola");
		vendingMachine.insertCoin(8);
		vendingMachine.dispenseItem(); // Balance: 2

		vendingMachine.selectItem("Cola"); // Out of stock

		vendingMachine.selectItem("Sprite");
		vendingMachine.insertCoin(2);
		vendingMachine.dispenseItem(); // Balance: 0

		vendingMachine.selectItem("Sprite"); // Out of stock

		vendingMachine.selectItem("Pepsi");
		vendingMachine.insertCoin(1);
		vendingMachine.dispenseItem(); // Balance is not enough
		vendingMachine.insertCoin(4);
		vendingMachine.dispenseItem();

		vendingMachine.selectItem("Pepsi");
		vendingMachine.insertCoin(5);
		vendingMachine.dispenseItem();

		vendingMachine.selectItem("Pepsi"); // Out of stock

		vendingMachine.setOutOfOrder();
	}
}
