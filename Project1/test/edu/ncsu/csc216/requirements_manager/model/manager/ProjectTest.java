/**
 * 
 */
package edu.ncsu.csc216.requirements_manager.model.manager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.requirements_manager.model.command.Command;
import edu.ncsu.csc216.requirements_manager.model.user_story.UserStory;

/**
 * @author stbeuav
 *
 */
class ProjectTest {
	
	/**
	 * Resets counter to 0 for use in other tests.
	 * 
	 * @throws Exception if any issues occur
	 */
	@BeforeEach
	public void setUp() throws Exception {
		// Reset the counter to 0 at the beginning of every test.
		UserStory.setCounter(0);
		
//		//Stories used for testing
//		UserStory u1 = new UserStory(5, "Working", "title1", "student", "action", "value", "High", "jyu34", null);
//		UserStory u2 = new UserStory(2, "Submitted", "title2", "student", "action", "value", null, null, null);
//		UserStory u3 = new UserStory(4, "Backlog", "title3", "student", "action", "value", "Medium", null, null);

	}


	/**
	 * Test method for {@link edu.ncsu.csc216.requirements_manager.model.manager.Project#Project(java.lang.String, java.util.ArrayList)}.
	 */
	@Test
	void testProject() {
		//fail("Not yet implemented");
		Project p = new Project("New Project");
		
		assertEquals(0, p.getUserStories().size());
		assertEquals("New Project", p.getProjectName(), "Invalid project name");
		
		Exception e1 = assertThrows(IllegalArgumentException.class, () -> new Project(null));
		assertEquals("Invalid project name", e1.getMessage());

		Exception e2 = assertThrows(IllegalArgumentException.class, () -> new Project(""));
		assertEquals("Invalid project name", e2.getMessage());
	}



	/**
	 * Test method for {@link edu.ncsu.csc216.requirements_manager.model.manager.Project#setUserStoryId()}.
	 */
	@Test
	void testSetUserStoryId() {
		//fail("Not yet implemented");
		Project p = new Project("New Project");
		p.addUserStory("title1", "student", "action", "value");
		p.addUserStory("title2", "student", "action", "value");
		p.addUserStory("title3", "student", "action", "value");
		
		int counter = 0;
		int maxId = 0;
		for (int i = 1; i < p.getUserStories().size(); i++) {
			if (p.getUserStories().get(i).getId() > p.getUserStories().get(i - 1).getId()) {
				maxId = p.getUserStories().get(i).getId();
			}
		}
		
		counter = maxId + 1;
		
		assertEquals(3, counter);
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.requirements_manager.model.manager.Project#addUserStory(java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	void testAddUserStoryStringStringStringString() {
		//fail("Not yet implemented");
		Project p = new Project("New Project");
		assertEquals(0, p.addUserStory("title1", "student", "action", "value"));
		assertEquals(1, p.addUserStory("title2", "student", "action", "value"));
		assertEquals(2, p.addUserStory("title3", "student", "action", "value"));

	}

	/**
	 * Test method for {@link edu.ncsu.csc216.requirements_manager.model.manager.Project#addUserStory(edu.ncsu.csc216.requirements_manager.model.user_story.UserStory)}.
	 */
	@Test
	void testAddUserStoryUserStory() {
		//fail("Not yet implemented");
		UserStory u1 = new UserStory("title1", "student", "action", "value");
		UserStory u2 = new UserStory("title2", "student", "action", "value");
		UserStory u3 = new UserStory("title3", "student", "action", "value");
		
		Project p = new Project("New Project");
		p.addUserStory(u1);
		p.addUserStory(u2);
		p.addUserStory(u3);
		
		assertEquals(0, u1.getId());
		assertEquals(1, u2.getId());
		assertEquals(2, u3.getId());
		
		UserStory u4 = new UserStory("title4", "student", "action", "value");
		u4.setId(2);
		Exception e1 = assertThrows(IllegalArgumentException.class, () -> p.addUserStory(u4));
		assertEquals("Story with id already exists", e1.getMessage());
		
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.requirements_manager.model.manager.Project#getUserStoryById(int)}.
	 */
	@Test
	void testGetUserStoryById() {
		//fail("Not yet implemented");
		Project p = new Project("New Project");
		p.addUserStory("title1", "student", "action", "value");
		p.addUserStory("title2", "student", "action", "value");
		p.addUserStory("title3", "student", "action", "value");
		
		assertEquals(p.getUserStoryById(0), p.getUserStories().get(0));
		assertEquals(p.getUserStoryById(1), p.getUserStories().get(1));
		assertEquals(p.getUserStoryById(2), p.getUserStories().get(2));
		assertEquals(p.getUserStoryById(5), null);
		
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.requirements_manager.model.manager.Project#deleteUserStoryById(int)}.
	 */
	@Test
	void testDeleteUserStoryById() {
		//fail("Not yet implemented");
		Project p = new Project("New Project");
		p.addUserStory("title1", "student", "action", "value");
		p.addUserStory("title2", "student", "action", "value");
		p.addUserStory("title3", "student", "action", "value");
		
		assertTrue(p.getUserStories().size() == 3);
		p.deleteUserStoryById(0);
		assertTrue(p.getUserStories().size() == 2);
		p.deleteUserStoryById(1);
		assertTrue(p.getUserStories().size() == 1);
		p.deleteUserStoryById(2);
		assertTrue(p.getUserStories().size() == 0);
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.requirements_manager.model.manager.Project#executeCommand(int, edu.ncsu.csc216.requirements_manager.model.command.Command)}.
	 */
	@Test
	void testExecuteCommand() {
		//fail("Not yet implemented");
		Project p = new Project("New Project");
		p.addUserStory("title1", "student", "action", "value");
		p.addUserStory("title2", "student", "action", "value");
		p.addUserStory("title3", "student", "action", "value");
		
		p.executeCommand(0, new Command(Command.CommandValue.BACKLOG, "Low"));
		assertTrue(p.getUserStories().get(0).currentState == p.getUserStories().get(0).backlogState);
		
		p.executeCommand(1, new Command(Command.CommandValue.REJECT, "Duplicate"));
		assertTrue(p.getUserStories().get(1).currentState == p.getUserStories().get(1).rejectedState);
		
		p.executeCommand(1, new Command(Command.CommandValue.RESUBMIT, null));
		assertTrue(p.getUserStories().get(1).currentState == p.getUserStories().get(1).submittedState);
		
		p.executeCommand(2, new Command(Command.CommandValue.BACKLOG, "Low"));
		assertTrue(p.getUserStories().get(2).currentState == p.getUserStories().get(2).backlogState);
		
		p.executeCommand(2, new Command(Command.CommandValue.ASSIGN, "jyu34"));
		assertTrue(p.getUserStories().get(2).currentState == p.getUserStories().get(2).workingState);
		
	}

}
