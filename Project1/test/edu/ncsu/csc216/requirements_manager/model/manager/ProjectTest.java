/**
 * 
 */
package edu.ncsu.csc216.requirements_manager.model.manager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.requirements_manager.model.user_story.UserStory;

/**
 * @author stbeuav
 *
 */
class ProjectTest {

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
		UserStory u1 = new UserStory("title1", "student", "action", "value");
		UserStory u2 = new UserStory("title2", "student", "action", "value");
		UserStory u3 = new UserStory("title3", "student", "action", "value");
		
		Project p = new Project("New Project");
		p.addUserStory(u1);
		p.addUserStory(u2);
		p.addUserStory(u3);
		
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
//		assertEquals(1, p.addUserStory("title2", "student", "action", "value"));
//		assertEquals(2, p.addUserStory("title3", "student", "action", "value"));
		
		
		
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.requirements_manager.model.manager.Project#addUserStory(edu.ncsu.csc216.requirements_manager.model.user_story.UserStory)}.
	 */
	@Test
	void testAddUserStoryUserStory() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.requirements_manager.model.manager.Project#getUserStoryById(int)}.
	 */
	@Test
	void testGetUserStoryById() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.requirements_manager.model.manager.Project#deleteUserStoryById(int)}.
	 */
	@Test
	void testDeleteUserStoryById() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.requirements_manager.model.manager.Project#executeCommand(int, edu.ncsu.csc216.requirements_manager.model.command.Command)}.
	 */
	@Test
	void testExecuteCommand() {
		fail("Not yet implemented");
	}

}
