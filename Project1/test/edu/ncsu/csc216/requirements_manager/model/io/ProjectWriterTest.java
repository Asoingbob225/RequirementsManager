/**
 * 
 */
package edu.ncsu.csc216.requirements_manager.model.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.requirements_manager.model.manager.Project;
import edu.ncsu.csc216.requirements_manager.model.user_story.UserStory;

/**
 * @author stbeuav
 *
 */
class ProjectWriterTest {

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.requirements_manager.model.io.ProjectWriter#writeProjectToFile(java.lang.String, edu.ncsu.csc216.requirements_manager.model.manager.Project)}.
	 */
	@Test
	void testWriteProjectToFile() {
		//fail("Not yet implemented");
		
		UserStory u1 = new UserStory(0, "Working", "title1", "student", "action", "value", "High", "jyu34", null);
		UserStory u2 = new UserStory(1, "Submitted", "title2", "student", "action", "value", null, null, null);
		UserStory u3 = new UserStory(2, "Backlog", "title3", "student", "action", "value", "Medium", null, null);
		
		Project p = new Project("New Project");
		p.addUserStory(u1);
		p.addUserStory(u2);
		p.addUserStory(u3);
		
		try {
			ProjectWriter.writeProjectToFile("test-files/actual_project1.txt", p);
		} catch (IOException e) {
			fail("Cannot write to course records file");
		}
		checkFiles("test-files/expected_project1.txt", "test-files/actual_project1.txt");

	}
	
	/**
	 * Helper method to compare two files for the same contents
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
