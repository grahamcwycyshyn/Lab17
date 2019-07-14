import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class CountriesApp {
	public static void main(String[] args) throws IOException {

		Scanner scan = new Scanner(System.in);

		int choice = 0;

		do {
			System.out.println("Welcome to the Countries Maintenance Application!");
			System.out.println("1: See the list of countries");
			System.out.println("2. Add a country");
			System.out.println("3. Exit");
//			System.out.println("4. Exit");
			System.out.println();
			System.out.println("Enter menu number:");
			choice = scan.nextInt();

			if (choice == 1) {
				for (String string : CountriesBinaryFile.readFile()) {
					String[] parts = string.split(":");
					System.out.println(parts[0] + " Pop.: " + parts[1]);
				}

			} else if (choice == 2) {
				scan.reset();
				System.out.println("What country would you like to add?");
				String country = scan.next();
				scan.reset();
				System.out.println("What is the country's population?");
				int population = scan.nextInt();
				CountriesBinaryFile.appendToFile(country + ":" + population);}
//			} else if (choice == 3) {
//				System.out.println("Would you like to: ");
//				System.out.println("1: Delete the whole file");
//				System.out.println("2. Remove a specific country?");
//				int edit = scan.nextInt();
//				if (edit == 1) {
//					CountriesBinaryFile.clearFile();
//				} else {
////					ArrayList<String> list = (ArrayList<String>) Files.readAllLines();
////					System.out.println(list);
////					System.out.println("Which country would you like to remove?");
////					String removal = scan.nextLine();
////					for (String string : list) {
////						if (matchString(scan, "Which country would you like to remove?", re)) {
////							list.remove(removal);
////							c.rewriteFile(list);
//
////						} else {
////							System.out.println("nope!");
////						}
//					}
//				}
			
		} while (choice != 4);

		scan.close();

	}
}
