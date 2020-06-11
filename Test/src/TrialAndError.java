import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TrialAndError {

	public static void main(String args[]) throws IOException {
		/*
		 * Example of Assert. Window-preferences-Installed JREs - edit - set VM
		 * arguments as "-ea"
		 */
		String proverb = "Health is wealth";
		assert proverb.contains("wealth");
		System.out.println("All is well :-)");
		String workingDir = System.getProperty("user.dir");
		System.out.println("Current working directory : " + workingDir);

		// To access data from property file
		Properties p = new Properties();
		FileReader reader = new FileReader(workingDir + "\\Resources\\config.properties");
		p.load(reader);
		System.out.println(p.getProperty("user"));
		System.out.println(p.getProperty("password"));
		p.setProperty("user", "Indu");
		System.out.println(p.getProperty("user"));
		p.put("user", "xxx");
		System.out.println(p.getProperty("user"));

		/*
		 * // To read and access xml file File inputFile = new
		 * File(System.getProperty("user.dir") + "\\properties.xml"); SAXReader
		 * saxReader = new SAXReader(); Document document = saxReader.read(inputFile);
		 * String mobileTesting =
		 * document.selectSingleNode("//menu/mobiletesting").getText(); String
		 * emailTextBox = document.selectSingleNode("//menu/email").getText(); String
		 * signUpButton = document.selectSingleNode("//menu/signup").getText();
		 */

		// To read data from external text file
		File file = new File("C:\\Users\\SAIKARTHICK\\Desktop\\Automation\\Assignment.txt");

		BufferedReader br = new BufferedReader(new FileReader(file));

		String st;
		while ((st = br.readLine()) != null)
			System.out.println(st);

	}
}
