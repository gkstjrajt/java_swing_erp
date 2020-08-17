package java_swing_erp.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriter {
	public static void main(String[] args) {
		System.out.println("현재 실행 경로 : " + System.getProperty("user.dir"));
		
		String pathName = System.getProperty("user.dir") + File.separator + "src" + File.separator +
							"java_jungsuk2" + File.separator + "ch15" + File.separator + "FileIOEx.java";
		File f = new File(pathName);
		
		System.out.println(f.getAbsolutePath());
		System.out.println(f.exists());
		
		try(BufferedReader br = new BufferedReader(new FileReader(f));
				BufferedWriter bw = new BufferedWriter(new FileWriter("java_copy.txt"))){
			String line;
			while ( (line = br.readLine()) != null ) {
				bw.write(line + "\n");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
