package csc131.junit;

// JUnit 5 imports
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
	 assertEquals(issuingStore, card.getIssuingStore(), "getIssuingStore()");
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
	 assertEquals(balance, card.getBalance(), 0.001, "getBalance()");
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
	 assertEquals(whatever, card.deduct(5.0), "deduct()");
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
	 assertEquals(whatever, card.deduct(20.0), "deduct 20.0 from 10.0");
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
	 assertEquals(whatever, card.deduct(-10.00), "deduct negative from positive");
 }
 
 @Test
 public void test_assertThrowsGiftCard()
 {
	 // new GiftCard(1,-100.0);
	 assertThrows(IllegalArgumentException.class, () -> {new GiftCard(1,-100.00);});

 }
 
 @Test
 public void constructor_IncorrectID_Low()
 {
	 // new GiftCard(-1, 100.0);
	 assertThrows(IllegalArgumentException.class, () -> {new GiftCard(-1, 100.0);});
 }

 
 @Test
 public void constructor_IncorrectID_High()
 {
	 //new GiftCard(999999999, 100.0);
	 assertThrows(IllegalArgumentException.class, () -> {new GiftCard(999999999, 100.0);});
 }
 
} 