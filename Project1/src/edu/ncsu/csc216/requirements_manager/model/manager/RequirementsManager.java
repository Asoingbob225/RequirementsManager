/**
 * 
 */
package edu.ncsu.csc216.requirements_manager.model.manager;

import edu.ncsu.csc216.requirements_manager.model.command.Command;
import edu.ncsu.csc216.requirements_manager.model.user_story.UserStory;

/**
 * @author yujim
 *
 */
public class RequirementsManager {

	/**
	 * Constructs the requirements manager when called by the getInstance() method.
	 */
	private RequirementsManager() {
		// add code here
	}

	/**
	 * This method will check if the singleton for this class is null. If so, then
	 * it will call the private RequirementsManager() constructor to create the
	 * single instance of this class.
	 * 
	 * @return instance the singleton instance of the RequirementsManager class
	 */
	public static RequirementsManager getInstance() {
		return null;
	}

	/**
	 * Write the Project to the file specified by the parameter using the
	 * ProjectWriter class. If the currentProject is null or if there are no
	 * UserStorys in the currentProject an IllegalArgumentException should be
	 * thrown.
	 * 
	 * @param filename name of the file to write the project to
	 * @throws IllegalArgumentException if the currentProject is null or if there
	 *                                  are no UserStorys in the currentProject
	 */
	public void saveCurrentProjectToFile(String filename) {
		// add code here
	}

	/**
	 * Uses the ProjectReader to read the given fileName. The returned list of
	 * Projects are added to the projects field. The first project in the list
	 * returned from ProjectReader is made the currentProject.
	 * 
	 * @param filename name of the file to read from
	 */
	public void loadProjectsFromFile(String filename) {
		// add code here
	}

	/**
	 * Creates a new Project with the given name and adds it to the end of the
	 * projects list. The project is then loaded as the currentProject by calling
	 * the loadProject(String projectName) method. An IllegalArgumentException is
	 * thrown if the projectName parameter is null, empty string, or a duplicate of
	 * an existing project name (case-insensitive).
	 * 
	 * @param projectname name of the newly created project
	 * @throws IllegalArgumentException if projectName is null, an empty string, or
	 *                                  a duplicate of an already existing project
	 *                                  name (case-insensitive).
	 */
	public void createNewProject(String projectname) {
		// add code here
	}

	/**
	 * Returns a 2D Object array that is used to populate the UserStoryTableModel
	 * (inner class of the RequirementsManagerGUI.UserStoryListPanel) with
	 * information.
	 * 
	 * @return array 2D array used to populate the UserStoryTableModel with
	 *         information
	 */
	public String[][] getUserStoriesAsArray() {
		return null;
	}

	/**
	 * Returns the UserStory in the list with the given id. If there is no UserStory
	 * with that id, the method returns null.
	 * 
	 * @param id id to match with the UserStory in the list
	 * @return the UserStory with the matching id, or null if there are no matching
	 *         UserStories
	 */
	public UserStory getUserStoryById(int storyId) {
		return null;
	}

	/**
	 * Removes the UserStory with the given id from the list.
	 * 
	 * @param id given id to match with the UserStory in the list
	 */
	public void deleteUserStoryById(int storyId) {
		// add code here
	}

	/**
	 * Finds the UserStory with the given id and updates it by passing in the given
	 * Command.
	 * 
	 * @param id given id to match with the UserStory in the list
	 * @param c  command to give to the found UserStory
	 */
	public void executeCommand(int id, Command c) {
		// add code here
	}

	/**
	 * Creates a new UserStory with the given parameters in the submitted state and
	 * adds it to the project list
	 * 
	 * @param title  story's title
	 * @param user   story's user information
	 * @param action story's action information
	 * @param value  story's value information
	 */
	public void addUserStoryToProject(String title, String user, String action, String value) {
		// add code here
	}

	/**
	 * Finds the Project with the given name in the list, makes it the active or
	 * currentProject, and sets the user story id for that project so that any new
	 * UserStorys added to the project are created with the next correct id.
	 * 
	 * @param projectname name of project to find
	 */
	public void loadProject(String projectname) {
		// add code here
	}

	/**
	 * Returns the project name for the currentProject. If the currentProject is
	 * null, then null is returned.
	 * 
	 * @return returns the project name, or null if the name is null
	 */
	public String getProjectName() {
		return null;
	}

	/**
	 * Returns a String array of project names in the order they are listed in the
	 * projects list. This is used by the GUI to populate the project drop down.
	 * 
	 * @return names String array of project names as listed in the projects list
	 */
	public String[] getProjectList() {
		return null;
	}

	/**
	 * Sets the singleton to null
	 */
	protected void resetManager() {
		// add code here
	}

}
