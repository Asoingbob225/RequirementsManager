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
	 */
	@Test
	void testReadProjectFile() {
		//fail("Not yet implemented");
		
		try {
			ArrayList<Project> project = ProjectReader.readProjectFile(validTestFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
