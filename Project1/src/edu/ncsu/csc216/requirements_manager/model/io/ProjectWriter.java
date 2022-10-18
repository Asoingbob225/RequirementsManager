/**
 * 
 */
package edu.ncsu.csc216.requirements_manager.model.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import edu.ncsu.csc216.requirements_manager.model.manager.Project;

/**
 * Writes given projects to a new file specified by a file name.
 * 
 * @author yujim
 *
 */
public class ProjectWriter {
	/**
	 * Receives a String with the file name to write to and a Project to write to
	 * file. If there are any errors or exceptions, an IllegalArgumentException is
	 * thrown with the message 'Unable to save file.'
	 * 
	 * @param filename name of the file to write to
	 * @param project  the project to write to the file 
	 * @throws IllegalArgumentException if there are any errors or exception in
	 *                                  writing to and saving the file
	 */
	public static void writeProjectToFile(String filename, Project project) {
		PrintStream fileWriter;
		try {
			fileWriter = new PrintStream(new FileOutputStream(filename, true));
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Unable to save file");
		} 
		
		fileWriter.println("# " + project.getProjectName());
		
		for (int i = 0; i < project.getUserStories().size(); i++) {
			fileWriter.println(project.getUserStories().get(i).toString());
		}

		fileWriter.close();
	}

}
