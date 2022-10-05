/**
 * 
 */
package edu.ncsu.csc216.requirements_manager.model.io;

import java.util.ArrayList;

import edu.ncsu.csc216.requirements_manager.model.manager.Project;
import edu.ncsu.csc216.requirements_manager.model.user_story.UserStory;

/**
 * Reads in and processes the project file for projects (based on the project
 * name) and user stories (based on story title).
 * 
 * @author yujim
 *
 */
public class ProjectReader {
	/**
	 * Receives a String with the file name to read from. If the file cannot be
	 * loaded because it doesn’t exist, the method will throw an
	 * IllegalArgumentException with the message “Unable to load file.” Any invalid
	 * user stories or projects (i.e., they cannot be constructed, information is
	 * missing, or there is too much info for the item) are ignored.
	 * 
	 * @param filename name of file to read from
	 * @return projects a list of projects read from the given file
	 * @throws IllegalArgumentException if the file does not exist
	 */
	public static ArrayList<Project> readProjectFile(String filename) {
		return null;
	}

	/**
	 * Processes the projects read from the file based on the project name
	 * @param projectname name of the project
	 * @return project the processed project
	 */
	private static Project processProject(String projectName) {
		return null;
	}

	/**
	 * Processes the user stories read from the file based on the story's title
	 * @param title story's title
	 * @return userStory the processed UserStory
	 */
	private static UserStory processUserStory(String title) {
		return null;
	}
}
