package cse12pa1student;

import java.util.Collection;
import java.util.Arrays;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BasketTest {

	public static Collection<Object[]> BAGNUMS =
			Arrays.asList(new Object[][] { {0}, {1}, {2}, {3}, {4}, {5}, {6}, {7}, {8}, {9}, {10}, {11}, {12} });
	private int bagType;

	public BasketTest(int bagType) {
		super();
		this.bagType = bagType;
	}

	@Parameterized.Parameters(name = "Basket{index}")
	public static Collection<Object[]> bags() {
		return BAGNUMS;
	}
	
	private Basket makeBasket() {
		switch(this.bagType) {
			case 0: return new Basket0();
			case 1: return new Basket1();
			case 2: return new Basket2();
			case 3: return new Basket3();
			case 4: return new Basket4();
			case 5: return new Basket5();
			case 6: return new Basket6();
			case 7: return new Basket7();
			case 8: return new Basket8();
			case 9: return new Basket9();
			case 10: return new Basket10();
			case 11: return new Basket11();
			case 12: return new Basket12();
		}
		return null;
	}
	
	@Test
	public void checkingCountingWithNullVals() {
		Basket bsk = makeBasket();
		bsk.addToBasket(null);
		bsk.addToBasket(null);
		
		assertEquals(0, bsk.count());
	}
	
	public void checkingRemovingWithNullVals() {
		Basket bsk = makeBasket();
		bsk.addToBasket(null);
		bsk.addToBasket(null);

		assertEquals(false, bsk.removeFromBasket(null));
		assertEquals(false, bsk.removeAllFromBasket(null));
	}
	
	@Test
	public void addedHasCount1() {
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		basketToTest.addToBasket(i);
		assertEquals(1, basketToTest.count());
	}
	
	@Test
	public void testingCountWith1002Items() {
		Basket basketToTest = makeBasket();
		
		Item item = new Item("Shopping Cart", 10);
		
		for(int i = 0; i < 1002; i++) {
			basketToTest.addToBasket(item);
		}
		
		assertEquals(1002, basketToTest.count());
		
	}
	
	@Test
	public void checkingFunctionallityWithMultipleBaskets() {
		Basket bsk1 = makeBasket();

		Item item = new Item("Shopping Cart", 10);
		bsk1.addToBasket(item);
		bsk1.addToBasket(item);
		bsk1.addToBasket(item);

		Basket bsk2 = makeBasket();
		
		assertEquals(3, bsk1.count());
	}

	@Test
	public void checkingStorageOfItems() {
		Basket basketToTest = makeBasket();
		
		Item item = new Item("Shopping Cart", 10);
		
		for(int i = 0; i < 12; i++) {
			basketToTest.addToBasket(item);
		}
	}
	
	
	@Test
	public void checkingCountItem() {
		Basket basketToTest = makeBasket();
		Item i = new Item("Shampoo", 5);
		Item j = new Item("Soap", 3);
		
		basketToTest.addToBasket(j);
		basketToTest.removeFromBasket(j);
		basketToTest.addToBasket(j);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(j);
		basketToTest.addToBasket(j);
		
		assertEquals(3, basketToTest.countItem(i));
		assertEquals(3, basketToTest.countItem(j));
	}

	@Test
	public void checkingCountItemWithDuplicateItems() {
		Basket basketToTest = makeBasket();
		Item i = new Item("Shampoo", 5);
		Item i2 = new Item("Shampoo", 5);
		Item j = new Item("Soap", 3);
		
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i2);
		basketToTest.addToBasket(j);
		basketToTest.addToBasket(i2);
		basketToTest.addToBasket(j);
		
		assertEquals(3, basketToTest.countItem(i));
		assertEquals(5, basketToTest.count());
	}
	
	@Test
	public void checkTotalCost() {
		Basket basketToTest = makeBasket();
		Item i = new Item("Shampoo", 5);
		Item i2 = new Item("Shampoo", 5);
		Item j = new Item("Soap", 3);
		
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i2);

		basketToTest.addToBasket(j);

		basketToTest.addToBasket(i2);
		basketToTest.addToBasket(j);
		
		assertEquals(3*5+2*3, basketToTest.totalCost());
	}
	
	@Test
	public void checkingRemoveFromBasket() {
		Basket basketToTest = makeBasket();
		Item i = new Item("Shampoo", 5);
		Item i2 = new Item("Shampoo", 5);
		Item j = new Item("Soap", 3);
		
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i2);
		basketToTest.addToBasket(j);
		basketToTest.addToBasket(i2);
		basketToTest.addToBasket(j);
		
		basketToTest.removeFromBasket(i);
		
		assertEquals(3, basketToTest.countItem(i));
		assertEquals(5, basketToTest.count());
	}
	
	@Test
	public void checkingRemoveFromBasketOutput() {
		Item i = new Item("Shampoo", 3);
		Item i2 = new Item("Shoes", 3);
		Item i3 = new Item("Clothing", 3);
		
		Basket bsk = makeBasket();
		bsk.addToBasket(i2);
		bsk.addToBasket(i2);
		bsk.addToBasket(i3);
		bsk.addToBasket(i3);
		bsk.addToBasket(i3);
		
		assertEquals(false, bsk.removeFromBasket(i));
		assertEquals(true, bsk.removeFromBasket(i3));
		assertEquals(true, bsk.removeFromBasket(i2));
	}
	
	@Test
	public void checkRemoveAllFromBasket() {		
		Basket basketToTest = makeBasket();
		Item i =new Item("Shampoo", 5);
		Item i2 = new Item("Shampoo", 5);
		Item j = new Item("Soap", 3);
		
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i2);
		basketToTest.addToBasket(j);
		basketToTest.addToBasket(i2);
		basketToTest.addToBasket(j);
		
		basketToTest.removeAllFromBasket(i);
		
		assertEquals(0, basketToTest.countItem(i));
		assertEquals(2, basketToTest.count());
	}

	@Test
	public void checkingRemoveAllFromBasketOutput() {
		Item i = new Item("Shampoo", 3);
		Item i2 = new Item("Shoes", 3);
		Item i3 = new Item("Clothing", 3);
		
		Basket bsk = makeBasket();
		bsk.addToBasket(i2);
		bsk.addToBasket(i2);
		bsk.addToBasket(i3);
		bsk.addToBasket(i3);
		bsk.addToBasket(i3);
		
		assertEquals(false, bsk.removeAllFromBasket(i));
		assertEquals(true, bsk.removeAllFromBasket(i2));
	}
	
	@Test
	public void checkEmptyItems() {
		Basket basketToTest = makeBasket();
		Item i = new Item("Shampoo", 5);
		Item i2 = new Item("Shampoo", 5);
		Item j = new Item("Soap", 3);
		
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i2);
		basketToTest.addToBasket(j);
		basketToTest.addToBasket(i2);
		basketToTest.addToBasket(j);
		
		basketToTest.empty();
		
		assertEquals(0, basketToTest.count());
		assertEquals(0, basketToTest.countItem(i));
		assertEquals(0, basketToTest.countItem(i2));
		assertEquals(0, basketToTest.countItem(j));
	}
}
