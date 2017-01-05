package Main;

import control.builder.SwitchWindowController;
import junit.framework.TestCase;
/**
 * Testing for BuilderApplication: initializeControllers()
 * @author Tesia Shizume (ttshiz@wpi.edu)
 */
public class BuilderApplicationTest extends TestCase {
	BuilderApplication bldApp;
	protected void setUp() throws Exception {
		super.setUp();
		bldApp = new BuilderApplication();
	}

	public void testInitializeControllers() {
		bldApp.initializeControllers();
		assertTrue(bldApp.levelBuilder.getLButton().getActionListeners()[0] instanceof SwitchWindowController);
		assertTrue(bldApp.levelBuilder.getPButton().getActionListeners()[0] instanceof SwitchWindowController);
		assertTrue(bldApp.levelBuilder.getRButton().getActionListeners()[0] instanceof SwitchWindowController);
		assertTrue(bldApp.levelBuilder.getEButton().getActionListeners()[0] instanceof SwitchWindowController);
	}


}
