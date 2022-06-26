package com.skilldistillery.foodtruck.app;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.skilldistillery.foodtruck.entities.FoodTruck;

public class FoodTruckApp {
	private FoodTruck[] foodieFoodTrucks = new FoodTruck[5];

//scanner - input from the user
//ONLY static method 
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		FoodTruckApp foodTruckApp = new FoodTruckApp();
		foodTruckApp.startFoodTruckApp(userInput);

	}

	private void startFoodTruckApp(Scanner userInput) {
		
				for (int i = 0; i < foodieFoodTrucks.length; i++) {
					try {
					System.out.println("Please enter the Food Truck's name: ");
					String name = userInput.nextLine();
					if (name.equals("quit") || name.equals("QUIT") || name.equals("Quit")) {
						break;
					}
					System.out.println("What is the food type? ");
					String foodType = userInput.nextLine();
					System.out.println("What is the rating? ");
					double rating = userInput.nextDouble();
					userInput.nextLine();
					foodieFoodTrucks[i] = new FoodTruck(name, foodType, rating);
					} catch (InputMismatchException e) {
						userInput.nextLine();
						i--;
						System.out.println("Rating needs a numerical value. Item not saved. Please try again.");
		 			}
				}

		boolean running = true;
		do {
			printMenu();
			int menuChoice = userInput.nextInt();
			switch (menuChoice) {
			case 1:
				listAllFoodTrucks(foodieFoodTrucks);
				break;
			case 2:
				foodTruckAverage(foodieFoodTrucks);
				break;
			case 3:
				highestRatedFoodTruck(foodieFoodTrucks);
				break;
			case 4:
				System.out.println("Goodbye!");
				running = false;
				break;
			default:
				System.out.println("Please enter a valid number.");
			}
		} while (running);
	}

	private void printMenu() {
		System.out.println("|\t      FoodieFoodTrucks       \t|");
		System.out.println("|\t                             \t|");
		System.out.println("|\t 1. List all Food Trucks     \t|");
		System.out.println("|\t 2. Average ratings          \t|");
		System.out.println("|\t 3. Highest rated food truck \t|");
		System.out.println("|\t 4. Quit                     \t|");

	}

	private void listAllFoodTrucks(FoodTruck[] foodieFoodTrucks) {
		for (int i = 0; i < foodieFoodTrucks.length; i++) {
			if (foodieFoodTrucks[i] != null) {
				System.out.println(foodieFoodTrucks[i].toString());
			}
		}
	}

	private void foodTruckAverage(FoodTruck[] foodieFoodTrucks) {
		double sum = 0;
		double average = 0;
		int counter = 0;

		for (int i = 0; i < foodieFoodTrucks.length; i++) {
			if (foodieFoodTrucks[i] != null) {
				sum = sum + foodieFoodTrucks[i].getRating();
				counter++;
			}
		}
		average = sum / counter;
		System.out.println(average);
	}

	private void highestRatedFoodTruck(FoodTruck[] foodieFoodTrucks) {
		double currentHighestRating = foodieFoodTrucks[0].getRating();
		int highestRatingIndex = 0;
		for (int i = 0; i < foodieFoodTrucks.length; i++) {
			if (foodieFoodTrucks[i] != null && foodieFoodTrucks[i].getRating() > currentHighestRating) {
				currentHighestRating = foodieFoodTrucks[i].getRating();
				highestRatingIndex = i;

			}
		}
		System.out.println(foodieFoodTrucks[highestRatingIndex].toString());

	}

}
