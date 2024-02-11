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

		int amountEntered = 1000;
		int workingBalance = 1000;
		String expected = formattedDate + " FEED MONEY: $10.00 $10.00 ";

		// Act
		Transactions.updateLog("","",amountEntered, workingBalance,"FEED_MONEY");
		String actual = "";
		String test = "";

		File fileToRead = new File("vending.log");
		try (Scanner readFile = new Scanner(fileToRead)) {
			//actual = readFile.nextLine();
			while (readFile.hasNextLine() ) {
				test = readFile.nextLine();

				if (test.contains("FEED MONEY")) {
					actual = test;
				}
			}

		} catch (FileNotFoundException fnf) {
			// Alligator
		}

		// Assert
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void TEST_updateLog_dispenseProduct() {
		// Arrange
		LocalDateTime myDateTimeObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss a");
		String formattedDate = myDateTimeObj.format(myFormatObj);

		String name = "Yellow Duck";
		String slotLocation = "A1";
		int price = 90;
		int workingBalance = 910;

		// 11/02/2024 12:56:26 PM Yellow Duck  A1 $0.90 $9.10
		String expected = formattedDate + " Yellow Duck  A1 $0.90 $9.10 ";
		// Act
		Transactions.updateLog(name,slotLocation,price, workingBalance, "SELECTED_ITEM");
		String actual = "";
		String test = "";

		File fileToRead = new File("vending.log");
		try (Scanner readFile = new Scanner(fileToRead)) {
			while (readFile.hasNextLine() ) {
				test = readFile.nextLine();

				if (test.contains("Yellow Duck")) {
					actual = test;
				}
			}
		} catch (FileNotFoundException fnf) {
			// Alligator
		}

		// Assert
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void TEST_updateLog_finishTransaction() {
		// Arrange
		LocalDateTime myDateTimeObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss a");
		String formattedDate = myDateTimeObj.format(myFormatObj);

		int workingBalance = 1000;

		// 11/02/2024 12:56:26 PM Yellow Duck  A1 $0.90 $9.10
		String expected = formattedDate + " Give Change: $10.00 0.00 ";
		// Act
		Transactions.updateLog("","",0, workingBalance, "GIVE_CHANGE");
		String actual = "";
		String test = "";

		File fileToRead = new File("vending.log");
		try (Scanner readFile = new Scanner(fileToRead)) {
			while (readFile.hasNextLine() ) {
				test = readFile.nextLine();

				if (test.contains("Give Change")) {
					actual = test;
				}
			}
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
