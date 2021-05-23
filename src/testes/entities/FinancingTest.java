package testes.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Financing;

public class FinancingTest {


	@Test
	public void entryShouldReturnTwentyPercentOfTotalAmount() {
		
		Financing f = new Financing(100000.0, 2000.0, 80);
		
		double entry = f.entry();
		double expectedValue = 100000.0 * 0.2;
		
		Assertions.assertEquals(expectedValue, entry);
	}
	
	
	@Test
	public void quotaShouldReturnCorrectQuotaValue() {
		
		Financing f = new Financing(100000.0, 2000.0, 80);
		
		double quota = f.quota();
		double expectedValue = 100000 * 0.8 / 80;
		
		Assertions.assertEquals(expectedValue, quota);
		
	}
	
	
	@Test
	public void constructorShouldSetValuesWhenValidData() {
		
		Financing f = new Financing(100000.0, 2000.0, 80);
		
		Assertions.assertEquals(100000.0, f.getTotalAmount());
		Assertions.assertEquals(2000.0, f.getIncome());
		Assertions.assertEquals(80, f.getMonths());
		
	}
	
	
	@Test
	public void constructorShouldThrowIllegalArgumentException() {
		 
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			new Financing(100000.0, 2000.0, 79);
		});
		
	}
	
	
	
	@Test
	public void setTotalAmountShouldSetValueWhenValidData() {
		
		Financing f = new Financing(100000.0, 2000.0, 80);
		f.setTotalAmount(90000.0);
		
		Assertions.assertEquals(90000.0, f.getTotalAmount());

	}

	
	@Test
	public void setTotalAmountShouldThrowIllegalArgumentExceptionWhenInvalidDate() {
		 
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			Financing f = new Financing(100000.0, 2000.0, 80);
			f.setTotalAmount(110000.0);
		});
		
	}
	
	
	@Test
	public void setIncomeShouldSetValueWhenValidData() {
		
		Financing f = new Financing(100000.0, 2000.0, 80);
		f.setIncome(3000.0);
		
		Assertions.assertEquals(3000.0, f.getIncome());

	}

	
	@Test
	public void setIncomeShouldThrowIllegalArgumentExceptionWhenInvalidDate() {
		 
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			Financing f = new Financing(100000.0, 2000.0, 80);
			f.setIncome(1500.0);
		});
		
	}
	
	
	@Test
	public void setMonthsShouldSetValueWhenValidData() {
		
		Financing f = new Financing(100000.0, 2000.0, 80);
		f.setMonths(81);
		
		Assertions.assertEquals(81, f.getMonths());

	}

	
	@Test
	public void setMonthsShouldThrowIllegalArgumentExceptionWhenInvalidDate() {
		 
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			Financing f = new Financing(100000.0, 2000.0, 80);
			f.setMonths(79);
		});
		
	}
	
}
