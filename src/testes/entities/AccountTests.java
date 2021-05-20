package testes.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;
import tests.factory.AccountFactory;

public class AccountTests {

	@Test
	public void depositShouldIncreaseBalanceWhenPositiveAmount() {
		
		double amount = 200.00;
		double expectedValue = 196.00;
		
		Account acc = AccountFactory.createEmptyAccount();
		acc.deposit(amount);
		Assertions.assertEquals(expectedValue, acc.getBalance());
		
	}
	
	
	@Test
	public void depositShouldToNothingWhenNegativeAmount() {
		
		double expectedValue = 100.00;
		double amount = -200.00;
		
		Account acc = AccountFactory.createAccount(expectedValue);
		acc.deposit(amount);
		Assertions.assertEquals(expectedValue, acc.getBalance());
		
	}
	
	@Test
	public void fullWithdrawShouldClearBalance() {
		
		double expectedValue = 0.0;
		double initialBalance = 800.0;
		
		Account acc = AccountFactory.createAccount(initialBalance);
		
		double result = acc.fullWithdraw();
		
		Assertions.assertTrue(expectedValue == acc.getBalance());
		Assertions.assertTrue(result == initialBalance);

	}
	
	@Test
	public void withdrawShouldDecreaseBalanceWhenSuficientBalance() {
		
		Account acc = AccountFactory.createAccount(800.00);
		acc.withdraw(500);
		Assertions.assertEquals(300.00, acc.getBalance());
		
	}
	
	@Test
	public void withdrawShouldThrowExceptionWhenInsufficientBalance() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			Account acc = AccountFactory.createAccount(800.0);
			acc.withdraw(801.0);
		});
	}
	
}
