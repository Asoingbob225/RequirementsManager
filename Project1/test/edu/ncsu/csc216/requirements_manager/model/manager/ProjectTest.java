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
	
	public static final UserStory u1 = new UserStory(5, "Working", "title1", "student", "action", "value", "High", "jyu34", null);
	public static final UserStory u2 = new UserStory(2, "Submitted", "title2", "student", "action", "value", null, null, null);
	public static final UserStory u3 = new UserStory(4, "Backlog", "title3", "student", "action", "value", "Medium", null, null);
	
	/**
	 * Resets counter to 0 for use in other tests.
	 * 
	 * @throws Exception if any issues occur
	 */
	@BeforeEach
	public void setUp() throws Exception {
		// Reset the counter to 0 at the beginning of every test.
		UserStory.setCounter(0);

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



	/*
	 * Test method for {@link edu.ncsu.csc216.requirements_manager.model.manager.Project#setUserStoryId()}.
	 */
	@Test
	void testSetUserStoryId() {

		
		Project p = new Project("New Project");
		p.addUserStory(u2);
		assertEquals(1, p.getUserStories().size());
		p.setUserStoryId();
		assertEquals(3, UserStory.counter);
		
		p.addUserStory(u1);
		p.setUserStoryId();
		assertEquals(6, UserStory.counter);
		
		p.addUserStory(u3);
		p.setUserStoryId();
		assertEquals(6, UserStory.counter);
		
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.requirements_manager.model.manager.Project#addUserStory(java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	void testAddUserStoryStringStringStringString() {
		
		Project p = new Project("New Project");
		
		p.addUserStory("title1", "student", "action", "value");
		assertEquals(1, p.getUserStories().size());
		assertEquals(0, p.getUserStories().get(0).getId());
		
		UserStory.setCounter(5);
		
		p.addUserStory("title2", "student", "action", "value");
		assertEquals(2, p.getUserStories().size());
		assertEquals(5, p.getUserStories().get(1).getId());
		
		UserStory.setCounter(2);
		
		p.addUserStory("title3", "student", "action", "value");
		assertEquals(3, p.getUserStories().size());
		assertEquals(2, p.getUserStories().get(1).getId());
		assertEquals(5, p.getUserStories().get(2).getId());
		
		UserStory.setCounter(0);
		assertThrows(IllegalArgumentException.class, () -> p.addUserStory("title1", "student", "action", "value"));

	}

	/**
	 * Test method for {@link edu.ncsu.csc216.requirements_manager.model.manager.Project#addUserStory(edu.ncsu.csc216.requirements_manager.model.user_story.UserStory)}.
	 */
	@Test
	void testAddUserStoryUserStory() {
		
		Project p = new Project("New Project");
		
		p.addUserStory(u1);
		assertEquals(1, p.getUserStories().size());
		assertEquals(5, p.getUserStories().get(0).getId());
		
		p.addUserStory(u2);
		assertEquals(2, p.getUserStories().size());
		assertEquals(2, p.getUserStories().get(0).getId());
				
		p.addUserStory(u3);
		assertEquals(3, p.getUserStories().size());
		assertEquals(2, p.getUserStories().get(0).getId());
		assertEquals(4, p.getUserStories().get(1).getId());
		assertEquals(5, p.getUserStories().get(2).getId());
		
		
		assertThrows(IllegalArgumentException.class, () -> p.addUserStory(u1));
		

		
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.requirements_manager.model.manager.Project#getUserStoryById(int)}.
	 */
	@Test
	void testGetUserStoryById() {
		
		Project p = new Project("New Project");
		p.addUserStory(u1);
		p.addUserStory(u2);
		p.addUserStory(u3);
		
		assertEquals(u1, p.getUserStoryById(5));
		assertEquals(u2, p.getUserStoryById(2));
		assertEquals(u3, p.getUserStoryById(4));
		assertEquals(p.getUserStoryById(9), null);
		
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.requirements_manager.model.manager.Project#deleteUserStoryById(int)}.
	 */
	@Test
	void testDeleteUserStoryById() {
		//fail("Not yet implemented");
		Project p = new Project("New Project");
		p.addUserStory(u1);
		p.addUserStory(u2);
		p.addUserStory(u3);
		
		
		
		assertTrue(p.getUserStories().size() == 3);
		p.deleteUserStoryById(5);
		assertTrue(p.getUserStories().size() == 2);
		p.deleteUserStoryById(2);
		assertTrue(p.getUserStories().size() == 1);
		p.deleteUserStoryById(4);
		assertTrue(p.getUserStories().size() == 0);
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.requirements_manager.model.manager.Project#executeCommand(int, edu.ncsu.csc216.requirements_manager.model.command.Command)}.
	 */
	@Test
	void testExecuteCommand() {
		//fail("Not yet implemented");
		Project p = new Project("New Project");
		p.addUserStory(u1);
		p.addUserStory(u2);
		p.addUserStory(u3);
		
		p.executeCommand(5, new Command(Command.CommandValue.ASSIGN, "jyu34"));
		assertTrue(p.getUserStories().get(2).currentState == p.getUserStories().get(2).workingState);
		
		p.executeCommand(2, new Command(Command.CommandValue.REJECT, "Duplicate"));
		assertTrue(p.getUserStories().get(0).currentState == p.getUserStories().get(0).rejectedState);
		
		p.executeCommand(2, new Command(Command.CommandValue.RESUBMIT, null));
		assertTrue(p.getUserStories().get(0).currentState == p.getUserStories().get(0).submittedState);
		
		p.executeCommand(4, new Command(Command.CommandValue.ASSIGN, "jyu34"));
		assertTrue(p.getUserStories().get(1).currentState == p.getUserStories().get(1).workingState);
		
		p.executeCommand(4, new Command(Command.CommandValue.REJECT, "Duplicate"));
		assertTrue(p.getUserStories().get(1).currentState == p.getUserStories().get(1).rejectedState);
		
	}

}
