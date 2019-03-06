package br.com.kaio.mapper.factory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AppFactory {
	
	public static void main(String[] args) throws IOException {
		File[] listFile = loadArquivo();
		String line = null;
		IReplyCommand tcs =null;
		List<IReplyCommand> list = new ArrayList<>();
		
		
		for (File file : listFile) {
			try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file.getAbsolutePath()))) {
				while(bufferedReader.ready()) {
					line = bufferedReader.readLine();
					tcs = CommandFactory.parseCommand(line);
					list.add(tcs);
					System.out.println(tcs);
				}
			}
		}
		
	}

	
	private static File[] loadArquivo() {
		final File folder = new File("incomming");
		if (!folder.exists()) {
			return new File[0];
		}
		
		return folder.listFiles();
	}

}
