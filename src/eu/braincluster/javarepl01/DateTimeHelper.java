package eu.braincluster.javarepl01;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeHelper {

	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy.MM.dd.");

	public static String getCurrentDate() {
		var now = LocalDateTime.now();

		return now.format(FORMATTER);
	}
}
