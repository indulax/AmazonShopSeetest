
//package <set your test package>;
import com.experitest.client.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.junit.*;

/**
 *
*/
public class TestcaseExecutor {

	private String host = "localhost";
	private int port = 8889;
	private String projectBaseDirectory = "C:\\Users\\SAIKARTHICK\\workspace\\project2";
	protected Client client = null;
	Properties config = new Properties();
	Properties repo = new Properties();

	@Before
	public void setUp() throws IOException {
		client = new Client(host, port, true);
		client.setProjectBaseDirectory(projectBaseDirectory);
		client.setReporter("xml", "reports", "Test");
		FileReader configReader = new FileReader("config.properties");
		config.load(configReader);
		FileReader repoReader = new FileReader("ObjectRepository.properties");
		repo.load(repoReader);
	}

	@Test
	public void testTest() {
		client.setDevice("adb:Honor7");
		// if(client.uninstall("com.experitest.ExperiBank")){
		// If statement
		// }
		// if(client.install("com.experitest.ExperiBank", true, false)){
		// If statement
		// }
		// client.launch("com.experitest.ExperiBank", true, true);
		//public void setup(client, repoProperties) {
			
		//}
		client.elementSendText("NATIVE", repo.getProperty("UsernameTUsernameTextField"), 0, config.getProperty("user"));
		client.elementSendText("NATIVE", repo.getProperty("PasswordTextField"), 0, config.getProperty("password"));
		client.click("NATIVE", "id=loginButton", 0, 1);
		
	}
	
	@After
	public void tearDown() {
		// Generates a report of the test case.
		// For more information -
		// https://docs.experitest.com/display/public/SA/Report+Of+Executed+Test
		client.generateReport(false);
		// Releases the client so that other clients can approach the agent in the near
		// future.
		client.releaseClient();
	}
	
}
