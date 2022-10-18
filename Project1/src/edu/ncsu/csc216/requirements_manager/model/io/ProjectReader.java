/**
 * 
 */
package edu.ncsu.csc216.requirements_manager.model.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

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
	 * IllegalArgumentException with the message 'Unable to load file.' Any invalid
	 * user stories or projects (i.e., they cannot be constructed, information is
	 * missing, or there is too much info for the item) are ignored.
	 * 
	 * @param filename name of file to read from
	 * @return projects a list of projects read from the given file
	 * @throws FileNotFoundException    if file is not found
	 * @throws IllegalArgumentException if the file does not exist
	 */
	public static ArrayList<Project> readProjectFile(String filename) {

		ArrayList<Project> projects = new ArrayList<Project>();
		Scanner fileReader;
		try {
			fileReader = new Scanner(new FileInputStream(filename)); // Create a file scanner to read the file

		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Unable to load file.");

		}

		String fileString = "";

		while (fileReader.hasNextLine()) {
			fileString += fileReader.nextLine() + "\n";

		}
		fileReader.close();

		Scanner n = new Scanner(fileString);
		n.useDelimiter("\\r?\\n?[#]");

		while (n.hasNext()) {
			try {
				projects.add(processProject(n.next()));
			} catch (Exception e) {
				n.close();
				return projects;
			}
		}

		n.close();

		return projects;
	}

	/**
	 * Processes the projects read from the file based on the project name
	 * 
	 * @param line project string
	 * @return project the processed project
	 */
	private static Project processProject(String line) {
		Scanner n = new Scanner(line);
		String projectName = n.nextLine().trim();
		Project project = new Project(projectName);
		n.useDelimiter("\\r?\\n?[*]");

		while (n.hasNext()) {
			try {
				project.addUserStory(processUserStory(n.next()));
			} catch (Exception e) {
				n.close();
				// throw new IllegalArgumentException("Invalid file");
			}
		}

		n.close();

		return project;
	}

	/**
	 * Processes the user stories read from the file based on the story's title
	 * 
	 * @param line UserStory string
	 * @return story the processed UserStory
	 */
	private static UserStory processUserStory(String line) {

		Scanner n = new Scanner(line);

		Scanner m = new Scanner(n.nextLine());
		m.useDelimiter(",");

		String id = "";
		String state = "";
		String title = "";
		String priority = null;
		String devId = null;
		String reject = null;

		id = m.next().trim();
		state = m.next().trim();
		title = m.next().trim();
		if (m.hasNext()) {
			if ("Rejected".equals(state)) {
				reject = m.next().trim();
			} else {
				priority = m.next().trim();
				if (m.hasNext()) {
					devId = m.next().trim();
				}
			}
		}

		n.useDelimiter("\\r?\\n?[-]");

		String user = "";
		String action = "";
		String value = "";

		user = n.next().trim();
		action = n.next().trim();
		value = n.next().trim();

		if (user == null || action == null || value == null) {
			m.close();
			n.close();
			throw new IllegalArgumentException("Invalid file");
		}

		UserStory story = new UserStory(Integer.parseInt(id), state, title, user, action, value, priority, devId,
				reject);

		m.close();
		n.close();

		return story;
	}
}
