/**
 * 
 */
package edu.ncsu.csc216.requirements_manager.model.manager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 * Tests the RequirementsManager Class
 * 
 * @author stbeuav
 *
 */
class RequirementsManagerTest {

	/** Valid projects file */
	private final String validTestFile = "test-files/project1.txt";

	/** String version of user story 1 **/
	public final String u1 = "* 0,Completed,Load Catalog,High,sesmith5,\n- student\n- load a course catalog file\n- plan a schedule for next semester";
	/** String version of user story 2 **/
	public final String u2 = "* 1,Verifying,Select Course,Medium,jctetter,\n- student\n- select a course to add to my schedule\n- plan a schedule for next semester";
	/** String version of user story 3 **/
	public final String u3 = "* 2,Working,Add Event,Medium,ignacioxd,\n- student\n- add a recurring event\n- schedule extra curricular activities";
	/** String version of user story 4 **/
	public final String u4 = "* 3,Backlog,Export Schedule,Low,\n- student\n- export my schedule\n- so it's available when I register for classes";
	/** String version of user story 5 **/
	public final String u5 = "* 4,Submitted,Change Title,\n- student\n- change the title of my schedule\n- so I can have different schedules to consider";
	/** String version of user story 6 **/
	public final String u6 = "* 5,Rejected,Post to Piazza,,,Inappropriate,\n- student\n- post my schedule to Piazza for feedback\n- see which of my friends are interested in taking the same courses";

	/**
	 * Resets the singleton for use in other tests.
	 */
	@BeforeEach
	public void setUp() {
		RequirementsManager.getInstance().resetManager();
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.requirements_manager.model.manager.RequirementsManager#saveCurrentProjectToFile(java.lang.String)}.
	 */
	@Test
	void testSaveCurrentProjectToFile() {
		assertThrows(IllegalArgumentException.class, () -> RequirementsManager.getInstance()
				.saveCurrentProjectToFile("test-files/RequirementsManagerTestActual.txt"));

		RequirementsManager.getInstance().createNewProject("New Project");
		assertThrows(IllegalArgumentException.class, () -> RequirementsManager.getInstance()
				.saveCurrentProjectToFile("test-files/RequirementsManagerTestActual.txt"));

		RequirementsManager.getInstance().addUserStoryToProject("title1", "user1", "action1", "value1");
		RequirementsManager.getInstance().addUserStoryToProject("title2", "user2", "action2", "value2");
		RequirementsManager.getInstance().saveCurrentProjectToFile("test-files/RequirementsManagerTestActual.txt");

		checkFiles("test-files/RequirementsManagerTestExpected.txt", "test-files/RequirementsManagerTestActual.txt");

	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.requirements_manager.model.manager.RequirementsManager#loadProjectsFromFile(java.lang.String)}.
	 */
	@Test
	void testLoadProjectsFromFile() {
		RequirementsManager.getInstance().loadProjectsFromFile(validTestFile);
		assertEquals(1, RequirementsManager.getInstance().projects.size());

		String[] userStories = { u1, u2, u3, u4, u5, u6 };

		for (int i = 0; i < userStories.length; i++) {
			assertEquals(userStories[i],
					RequirementsManager.getInstance().projects.get(0).getUserStoryById(i).toString());
		}

	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.requirements_manager.model.manager.RequirementsManager#createNewProject(java.lang.String)}.
	 */
	@Test
	void testCreateNewProject() {
		RequirementsManager.getInstance().createNewProject("New Project");
		assertEquals(1, RequirementsManager.getInstance().projects.size());
		assertEquals("New Project", RequirementsManager.getInstance().currentProject.getProjectName());

		RequirementsManager.getInstance().createNewProject("Newer Project");
		assertEquals(2, RequirementsManager.getInstance().projects.size());
		assertEquals("Newer Project", RequirementsManager.getInstance().currentProject.getProjectName());

		assertThrows(IllegalArgumentException.class, () -> RequirementsManager.getInstance().createNewProject(null));
		assertThrows(IllegalArgumentException.class, () -> RequirementsManager.getInstance().createNewProject(""));
		assertThrows(IllegalArgumentException.class,
				() -> RequirementsManager.getInstance().createNewProject("New Project"));
		assertThrows(IllegalArgumentException.class,
				() -> RequirementsManager.getInstance().createNewProject("Newer Project"));
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.requirements_manager.model.manager.RequirementsManager#getUserStoriesAsArray()}.
	 */
	@Test
	void testGetUserStoriesAsArray() {
		RequirementsManager.getInstance().createNewProject("New Project");
		RequirementsManager.getInstance().addUserStoryToProject("title1", "user1", "action1", "value1");
		RequirementsManager.getInstance().addUserStoryToProject("title2", "user2", "action2", "value2");

		assertEquals("0", RequirementsManager.getInstance().getUserStoriesAsArray()[0][0]);
		assertEquals("Submitted", RequirementsManager.getInstance().getUserStoriesAsArray()[0][1]);
		assertEquals("title1", RequirementsManager.getInstance().getUserStoriesAsArray()[0][2]);
		assertEquals("", RequirementsManager.getInstance().getUserStoriesAsArray()[0][3]);
		assertEquals("1", RequirementsManager.getInstance().getUserStoriesAsArray()[1][0]);
		assertEquals("Submitted", RequirementsManager.getInstance().getUserStoriesAsArray()[1][1]);
		assertEquals("title2", RequirementsManager.getInstance().getUserStoriesAsArray()[1][2]);
		assertEquals("", RequirementsManager.getInstance().getUserStoriesAsArray()[1][3]);

	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.requirements_manager.model.manager.RequirementsManager#loadProject(java.lang.String)}.
	 */
	@Test
	void testLoadProject() {
		RequirementsManager.getInstance().createNewProject("New Project");
		RequirementsManager.getInstance().createNewProject("Newer Project");

		RequirementsManager.getInstance().loadProject("New Project");
		assertEquals("New Project", RequirementsManager.getInstance().currentProject.getProjectName());

		RequirementsManager.getInstance().loadProject("Newer Project");
		assertEquals("Newer Project", RequirementsManager.getInstance().currentProject.getProjectName());
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.requirements_manager.model.manager.RequirementsManager#getProjectName()}.
	 */
	@Test
	void testGetProjectName() {
		assertEquals(null, RequirementsManager.getInstance().getProjectName());

		RequirementsManager.getInstance().createNewProject("New Project");
		assertEquals("New Project", RequirementsManager.getInstance().getProjectName());
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.requirements_manager.model.manager.RequirementsManager#getProjectList()}.
	 */
	@Test
	void testGetProjectList() {
		RequirementsManager.getInstance().createNewProject("New Project");
		RequirementsManager.getInstance().createNewProject("Newer Project");

		String[] s = { "New Project", "Newer Project" };
		assertEquals(s[0], RequirementsManager.getInstance().getProjectList()[0]);
		assertEquals(s[1], RequirementsManager.getInstance().getProjectList()[1]);
	}

	/**
	 * Helper method to compare two files for the same contents
	 * 
	 * @param expFile expected output
	 * @param actFile actual output
	 */
	private void checkFiles(String expFile, String actFile) {
		try (Scanner expScanner = new Scanner(new File(expFile));
				Scanner actScanner = new Scanner(new File(actFile));) {

			while (expScanner.hasNextLine()) {
				assertEquals(expScanner.nextLine(), actScanner.nextLine());
			}

			expScanner.close();
			actScanner.close();
		} catch (IOException e) {
			fail("Error reading files.");
		}
	}
	
	

}
