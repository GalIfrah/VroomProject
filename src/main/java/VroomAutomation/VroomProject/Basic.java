package VroomAutomation.VroomProject;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.rules.TestWatcher;
import org.junit.rules.Timeout;
import org.junit.runner.Description;

import Services.MongoService;

public class Basic {
	public static MongoService mServices;

	public WebDriverWrapper webDriver;

	@Rule
	public TestName testName = new TestName();

	@Rule
	public Timeout testTimeOut = Timeout.seconds(600);

	@Rule
	public TestWatcher testWatcher = new TestWatcher() {

		@Override
		protected void starting(Description description) {

			TestParams params = description.getAnnotation(TestParams.class);

			if (params != null) {

				System.out.println("test params are: " + params.testDescription() + " and " + params.testTimeout());

				// System.out.println(params.testDescription());
				// System.out.println(params.testTimeout());

			}

			// TODO Auto-generated method stub
			super.starting(description);
		}
	};

	// run before each test

	@Before
	public void setup() throws IOException {

		webDriver = new WebDriverWrapper();
		webDriver.init("http://localhost:4444/wd/hub");
		GenericPageObject.setWebDriver(webDriver);
	}

	// run after each test

	@After
	public void tearDown() {
		System.out.println("the test: " + testName.getMethodName() + " end.");
	}
}