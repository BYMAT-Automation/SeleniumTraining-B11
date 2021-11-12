package testpckg;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.testng.annotations.Test;

public class TryCatchBlock {

	public static Properties config;
	
	@Test
	public static void tryCatchBlock() {
		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\files\\config_B11.properties");
		} catch (FileNotFoundException e1) {
			System.out.println("I am in catch block");
			//e1.printStackTrace();
		}
		config = new Properties();
		try {
			config.load(fis);
			System.out.println("I am in second try block");
		} catch (IOException e) {
			
			//e.printStackTrace();
		} finally {
			System.out.println("I am in finally block");
		}
		System.out.println("Config file has been loaded");

	}



}
