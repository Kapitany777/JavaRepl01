package eu.braincluster.javarepl01;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Quotes {
	
	private final List<String> quotes;
	private final Random random;
	
	public Quotes() {
		this.random = new Random();
		
		this.quotes = Arrays.asList(
                "A kód olyan, mint a humor. Ha magyarázni kell, baj van.",
                "Először működjön, aztán legyen szép.",
                "A legegyszerűbb megoldás gyakran a legjobb.",
                "Debugolni annyi, mint detektívet játszani a saját bűnügyedben.",
                "A jó név fél dokumentáció."
        );
	}
	
	public String getRandomQuote() {
		int index = random.nextInt(quotes.size());
		
		return quotes.get(index);
	}
}
