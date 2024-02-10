package com.techelevator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UnitTest1 {

	@Test
	public void TEST_updateLog_feedMoney() {
		// Arrange
		LocalDateTime myDateTimeObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss a");
		String formattedDate = myDateTimeObj.format(myFormatObj);

		int amountEntered = 10;
		int workingBalance = 10;
		String expected = formattedDate + " FEED MONEY: $10.00 $10.00 ";

		// Act
		Transactions.updateLog("","",amountEntered, workingBalance,0);
		String actual = "Bob";

		File fileToRead = new File("vending.log");
		try (Scanner readFile = new Scanner(fileToRead)) {
			actual = readFile.nextLine();

		} catch (FileNotFoundException fnf) {
			// Alligator
		}

		// Assert
		Assert.assertEquals(expected, actual);
	}


	@Test
	public void TEST_feedMoney_GIVEN_10_INCREASE_10() {
		// Arrange
		String userInput = "10"; // Represents what the user enters
		int expected = 1000; // represents the expected result of the tested method



		// Act
		Transactions.feedMoney(userInput); // call the method using the test input
		int actual = Transactions.getWorkingBalance(); // the actual result of running the method

		// Assert
		Assert.assertEquals(expected, actual); // Compare the expected result with the actual result

	}

	@Test
	public void TEST_finishTransaction_SET_0() {
		// Arrange
		int expected = 0;


		// Act
		Transactions.finishTransaction();
		int actual = Transactions.getWorkingBalance();

		// Assert
		Assert.assertEquals(expected, actual);

	}




	@Test
	public void TEST_selectProduct_AND_dispenseProduct_DECREASE_QUANTITY_ON_PURCHASE() {
		// Arrange
		int expectedQuantity = 4;
		LoadInventory li = LoadInventory.getInstance();

		Transactions.feedMoney("10");


		// Act
		Transactions.selectProduct("A1", li);
		int actualQuantity = li.getAllProducts().get(0).getInitialQuantity();

		// Assert
		Assert.assertEquals(expectedQuantity, actualQuantity);

	}


}
