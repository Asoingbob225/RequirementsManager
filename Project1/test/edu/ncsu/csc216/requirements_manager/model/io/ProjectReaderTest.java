/**
 * 
 */
package edu.ncsu.csc216.requirements_manager.model.io;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.pack_scheduler.io.StudentRecordIO;
import edu.ncsu.csc216.pack_scheduler.user.Student;
import edu.ncsu.csc216.requirements_manager.model.manager.Project;
import edu.ncsu.csc217.collections.list.SortedList;


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


