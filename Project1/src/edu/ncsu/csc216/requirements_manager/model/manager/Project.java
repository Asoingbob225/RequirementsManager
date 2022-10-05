/**
 * 
 */
package edu.ncsu.csc216.requirements_manager.model.manager;

import java.util.ArrayList;

import edu.ncsu.csc216.requirements_manager.model.command.Command;
import edu.ncsu.csc216.requirements_manager.model.user_story.UserStory;

/**
 * Creates a project containing a project name and a list of user stories.
 * 
 * @author yujim
 *
 */
public class Project {

	/** the project's name **/
	private String projectName;

	/** a list of user stories **/
	private ArrayList<UserStory> userStories;

	/**
	 * Constructs a new project with a given project name and creates a new empty
	 * list of stories. An IllegalArgumentException is thrown if the projectName is
	 * null or an empty string.
	 * 
	 * @param projectName name of the project
	 * @throws IllegalArgumentException if projectName is null or an empty string
	 * 
	 */
	public Project(String projectName, ArrayList<UserStory> userStories) {
		this.projectName = projectName;
		this.userStories = userStories;
	}

	/**
	 * Returns the project name
	 * 
	 * @return projectName the project name
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * Sets the project name
	 * 
	 * @param projectName the project name
	 */
	private void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * Returns the list of user stories
	 * 
	 * @return userStories the list of userStories
	 */
	public ArrayList<UserStory> getUserStories() {
		return userStories;
	}

	/**
	 * Sets the list of UserStories
	 * 
	 * @param userStories the userStories to set
	 */
	public void setUserStories(ArrayList<UserStory> userStories) {
		this.userStories = userStories;
	}

	/**
	 * Sets the counter for the UserStory instances to the value of the maximum id
	 * in the list of UserStorys for the project + 1.
	 */
	public void setUserStoryId() {
		// add code here
	}

	/**
	 * Creates a new UserStory in the submitted state, adds it to the list in sorted
	 * order, and returns the id. If a story already exists with the given id, an
	 * IllegalArgumentException will be thrown.
	 * 
	 * @param title  story's title
	 * @param user   story's user information
	 * @param action story's action information
	 * @param value  story's value information
	 * @return id the id of the newly added user story
	 * @throws IllegalArgumentExceptino if a story already exists in the list with
	 *                                  the given id
	 */
	public int addUserStory(String title, String user, String action, String value) {
		return 0;
	}

	/**
	 * Adds the user story to the list in sorted order by id. The list will be
	 * maintained in sorted order, so you will be able to add a new story in order.
	 * If a story already exists with the given id, an IllegalArgumentException will
	 * be thrown.
	 * 
	 * @param story story to be added to the list
	 * @throws IllegalArgumentException if a story already exists in the list with
	 *                                  the given id
	 */
	public void addUserStory(UserStory story) {
		// add code here
	}

	/**
	 * Returns the UserStory in the list with the given id. If there is no UserStory
	 * with that id, the method returns null.
	 * 
	 * @param id id to match with the UserStory in the list
	 * @return the UserStory with the matching id, or null if there are no matching
	 *         UserStories
	 */
	public UserStory getUserStoryById(int id) {
		return null;
	}

	/**
	 * Removes the UserStory with the given id from the list.
	 * 
	 * @param id given id to match with the UserStory in the list
	 */
	public void deleteUserStoryById(int id) {
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

}
