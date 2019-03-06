package br.com.kaio.teste;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AppData1 {

	
	public static void main(String[] args) {
		
		String tc ="0331";
		
		
		String monthDate = tc.substring(0, 2);
		String day = tc.substring(0, 2);
		Format format = new SimpleDateFormat("MM");
		String month = format.format(new Date().getTime());

		Format f = new SimpleDateFormat("yyyy");
		Calendar cal = Calendar.getInstance();
		
		if(Integer.parseInt(monthDate)<=Integer.parseInt(month)) {
			cal.set(Integer.parseInt(f.format(new Date().getTime())), Integer.parseInt(monthDate), Integer.parseInt(day));
		}else {
			cal.set(Integer.parseInt(f.format(new Date().getTime()))-1, Integer.parseInt(monthDate), Integer.parseInt(day));
		}
		
		System.out.println(cal.getTime());
	}
}
