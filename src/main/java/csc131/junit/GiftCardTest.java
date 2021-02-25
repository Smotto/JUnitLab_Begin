package csc131.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;
import org.junit.rules.ExpectedException;

public class GiftCardTest
{
 @Test
 public void getIssuingStore()
 {
	 double balance;
	 GiftCard card;
	 int issuingStore;

	 issuingStore = 1337;
	 balance = 100.00;
	 card = new GiftCard(issuingStore, balance);
	 assertEquals("getIssuingStore()", issuingStore, card.getIssuingStore());
 }
 
 @Test
 public void getBalance()
 {
	 double balance;
	 GiftCard card;
	 int issuingStore;

	 issuingStore = 1337;
	 balance = 100.00;
	 card = new GiftCard(issuingStore, balance);
	 assertEquals("getBalance()", balance, card.getBalance(), 0.001);
 }
 
 @Test
 public void deduct_RemainingBalance()
 {
	 double balance;
	 GiftCard card;
	 int issuingStore;
	 String whatever;

	 issuingStore = 1337;
	 balance = 100.00;
	 card = new GiftCard(issuingStore, balance);
	 
	 whatever = "Remaining Balance: " + String.format("%6.2f", 95.00);
	 assertEquals("deduct()", whatever, card.deduct(5.0));
 }
 
 @Test
 public void deduct_AmountDue()
 {
	 double balance;
	 GiftCard card;
	 int issuingStore;
	 String whatever;

	 issuingStore = 1337;
	 balance = 10.00;
	 card = new GiftCard(issuingStore, balance);
	 
	 whatever = "Amount Due: " + String.format("%6.2f", 10.00);
	 assertEquals("deduct 20.0 from 10.0", whatever, card.deduct(20.0));
 }
 
 @Test
 public void deduct_InvalidTransaction()
 {
	 double balance;
	 GiftCard card;
	 int issuingStore;
	 String whatever;

	 issuingStore = 1337;
	 balance = 100.00;
	 card = new GiftCard(issuingStore, balance);
	 
	 whatever = "Invalid Transaction";
	 assertEquals("deduct negative from positive",
			 whatever, card.deduct(-10.00));
 }
 
 @Test
 public void test_assertThrowsGiftCard()
 {
	 //new GiftCard(1,-100.0);
	 assertThrows("Illegal Balance: -100.0", IllegalArgumentException.class, () -> {new GiftCard(1,-100.0);});
 }
 
 @Test
 public void constructor_IncorrectID_Low()
 {
	 //new GiftCard(-1, 100.0);
	 assertThrows("Illegal Store ID: -1 ", IllegalArgumentException.class, () -> {new GiftCard(-1, 100.0);});
 }

 
 @Test
 public void constructor_IncorrectID_High()
 {
	 //new GiftCard(999999999, 100.0);
	 assertThrows("Illegal Store ID: 999999999", IllegalArgumentException.class, () -> {new GiftCard(999999999, 100.0);});
 }
 
} 