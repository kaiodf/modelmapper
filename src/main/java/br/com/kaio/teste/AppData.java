package br.com.kaio.teste;

import java.time.Duration;
import java.time.LocalDateTime;

public class AppData {
	private static final int MILISEGUNDOS = 1000;
	static final int MINUTES_PER_HOUR = 60;
	static final int SECONDS_PER_MINUTE = 60;
	static final int SECONDS_PER_HOUR = SECONDS_PER_MINUTE * MINUTES_PER_HOUR;

	public static void main(String[] args) throws InterruptedException {
		System.out.println("start");
		LocalDateTime start = LocalDateTime.now();
		new Thread().sleep(5000);
		LocalDateTime end = LocalDateTime.now();
		long[] time = getTime(start, end);
		
		System.out.println(time[0]+","+time[1]+","+time[2]+","+time[3]);


	}

	private static long[] getTime(LocalDateTime dob, LocalDateTime now) {
		LocalDateTime today = LocalDateTime.of(now.getYear(),
				now.getMonthValue(), now.getDayOfMonth(), dob.getHour(), dob.getMinute(), dob.getSecond());
		Duration duration = Duration.between(today, now);

		long seconds = duration.getSeconds();

		long hours = seconds / SECONDS_PER_HOUR;
		long minutes = ((seconds % SECONDS_PER_HOUR) / SECONDS_PER_MINUTE);
		long secs = (seconds % SECONDS_PER_MINUTE);
		long mil = secs*MILISEGUNDOS;

		return new long[]{hours, minutes, secs, mil};
	}
}
