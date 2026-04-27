package eu.braincluster.javarepl01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	private static final String VERSION = "V1.0.1";

	public static void main(String[] args) {

		System.out.println("Java REPL program");
		System.out.println("Készítette: Kapitany & ChatGPT");

		var scanner = new Scanner(System.in);

		boolean running = true;

		Map<String, Command> commands = initCommands();

		while (running) {
			System.out.print("> ");
			String line = scanner.nextLine();

			var parts = line.split(" ", 2);
			String command = parts[0].toLowerCase();
			String commandArgs = parts.length > 1 ? parts[1] : "";

			var action = commands.get(command);

			if (action != null) {
				running = action.execute(commandArgs);
			}
			else {
				System.out.println("Hibás parancs!");
			}
		}

		scanner.close();

		shutdown();
	}

	private static Map<String, Command> initCommands() {
		Map<String, Command> commands = new HashMap<>();

		var quotes = new Quotes();

		commands.put("date", (args) -> {
			System.out.println(DateTimeHelper.getCurrentDate());
			return true;
		});

		commands.put("quote", (args) -> {
			System.out.println(quotes.getRandomQuote());
			return true;
		});

		commands.put("echo", (args) -> {
			System.out.println(args);
			return true;
		});

		commands.put("version", (args) -> {
			System.out.println("Verzió: " + VERSION);
			return true;
		});

		commands.put("help", (args) -> {
			printHelp();
			return true;
		});

		commands.put("exit", (args) -> {
			System.out.println("Kilépés folyamatban...");
			return false;
		});

		return commands;
	}

	private static void printHelp() {
		System.out.println("Elérhető parancsok:");
		System.out.println(" - date    : aktuális dátum");
		System.out.println(" - quote   : véletlenszerű idézet megjelenítése");
		System.out.println(" - echo    : szöveg kiírása");
		System.out.println(" - version : program verziójának megjelenítése");
		System.out.println(" - help    : súgó megjelenítése");
		System.out.println(" - exit    : kilépés a programból");
	}

	private static void shutdown() {
		System.out.println("A Java REPL leállt");
	}
}
