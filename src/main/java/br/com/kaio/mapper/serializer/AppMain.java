package br.com.kaio.mapper.serializer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

import org.jsefa.Deserializer;
import org.jsefa.flr.FlrIOFactory;

public class AppMain {
	
	public static void main(String[] args) {
		File[] files = load();
		String line = null;
		M1 m1 = new M1();
		
		Deserializer deserialMyRecord = FlrIOFactory.createFactory(M1.class).createDeserializer();
		
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(files[0].getAbsolutePath()))) {
			while(bufferedReader.ready()) {
				line = bufferedReader.readLine();
				deserialMyRecord.open(new StringReader(line));
				m1 = deserialMyRecord.next();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(m1);
	}
	
	private static File[] load() {
		final File folder = new File("m1");
		if (!folder.exists()) {
			return new File[0];
		}
		
		return folder.listFiles();
	}
}
