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
	public Project(String projectName) {

		if (projectName == null || projectName.length() == 0) {
			throw new IllegalArgumentException("Invalid project name");
		}

		userStories = new ArrayList<UserStory>();
		this.projectName = projectName;
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
	 * Returns the list of user stories
	 * 
	 * @return userStories the list of userStories
	 */
	public ArrayList<UserStory> getUserStories() {
		return userStories;
	}

	/**
	 * Sets the counter for the UserStory instances to the value of the maximum id
	 * in the list of UserStorys for the project + 1.
	 */
	public void setUserStoryId() {
		// add code here
		int maxId;

		if (userStories.size() == 0) {
			maxId = -1;
		} else {
			maxId = userStories.get(0).getId();
			for (int i = 0; i < userStories.size(); i++) {
				if (userStories.get(i).getId() > maxId) {
					maxId = userStories.get(i).getId();
				}
			}
		}
		UserStory.setCounter(maxId + 1);
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
	 * @throws IllegalArgumentException if a story already exists in the list with
	 *                                  the given id
	 */
	public int addUserStory(String title, String user, String action, String value) {
		UserStory u = new UserStory(title, user, action, value);
		
		if (userStories.size() == 0) {
			userStories.add(u);
		}

		else {
			for (int i = 0; i < userStories.size(); i++) {
				if (u.getId() == userStories.get(i).getId()) {
					throw new IllegalArgumentException("Story with id already exists");
				}
			}
			for (int i = 0; i < userStories.size(); i++) {
				if (u.getId() < userStories.get(i).getId()) {
					userStories.add(i, u);
					break;
				}
			}
			if (u.getId() > userStories.get(userStories.size() - 1).getId()) {
				userStories.add(u);
			}

		}
		return u.getId();
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

		if (userStories.size() == 0) {
			userStories.add(story);
		}

		else {
			for (int i = 0; i < userStories.size(); i++) {
				if (story.getId() == userStories.get(i).getId()) {
					throw new IllegalArgumentException("Story with id already exists");
				}
			}
			for (int i = 0; i < userStories.size(); i++) {
				if (story.getId() < userStories.get(i).getId()) {
					userStories.add(i, story);
					break;
				}
			}
			if (story.getId() > userStories.get(userStories.size() - 1).getId()) {
				userStories.add(story);
			}
		}
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
		for (int i = 0; i < userStories.size(); i++) {
			if (id == userStories.get(i).getId()) {
				return userStories.get(i);
			}
		}
		return null;
	}

	/**
	 * Removes the UserStory with the given id from the list.
	 * 
	 * @param id given id to match with the UserStory in the list
	 */
	public void deleteUserStoryById(int id) {
		for (int i = 0; i < userStories.size(); i++) {
			if (id == userStories.get(i).getId()) {
				userStories.remove(userStories.get(i));
			}
		}
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
		for (int i = 0; i < userStories.size(); i++) {
			if (id == userStories.get(i).getId()) {
				userStories.get(i).update(c);
			}
		}
	}

}
