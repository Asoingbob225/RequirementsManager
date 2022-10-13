/**
 * 
 */
package edu.ncsu.csc216.requirements_manager.model.io;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;


import edu.ncsu.csc216.requirements_manager.model.manager.Project;


/**
 * @author stbeuav
 *
 */
class ProjectReaderTest {
	
	private final String validTestFile = "test-files/project1.txt";

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.requirements_manager.model.io.ProjectReader#readProjectFile(java.lang.String)}.
	 * @throws FileNotFoundException 
	 */
	@Test
	void testReadProjectFile() throws FileNotFoundException {
		//fail("Not yet implemented");
		//Valid Files

		try {
			ArrayList<Project> projects = ProjectReader.readProjectFile(validTestFile);
			//test size
			assertEquals(1, projects.size());
			
		} catch(FileNotFoundException e) {
			fail("Unexpected Failure reading " + validTestFile);
		}
				

				
				
				
	}
}


