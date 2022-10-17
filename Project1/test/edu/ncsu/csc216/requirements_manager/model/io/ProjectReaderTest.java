/**
 * 
 */
package edu.ncsu.csc216.requirements_manager.model.io;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.requirements_manager.model.manager.Project;

/**
 * Tests the ProjectReader class
 * 
 * @author stbeuav
 *
 */
class ProjectReaderTest {

	/** Valid test file to read **/
	private final String validTestFile = "test-files/project1.txt";

	/** Invalid test file to read **/
	private final String invalidTestFile = "test-files/fakeproject1.txt";

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.requirements_manager.model.io.ProjectReader#readProjectFile(java.lang.String)}.
	 * 
	 */
	@Test
	void testReadProjectFile() {
		ArrayList<Project> projects = ProjectReader.readProjectFile(validTestFile);

		assertEquals(1, projects.size());
		assertEquals(6, projects.get(0).getUserStories().size());

		assertThrows(IllegalArgumentException.class, () -> ProjectReader.readProjectFile(invalidTestFile));
		
		ArrayList<Project> p = ProjectReader.readProjectFile("test-files/project5.txt");
		assertEquals(0, p.size());


	}
}
