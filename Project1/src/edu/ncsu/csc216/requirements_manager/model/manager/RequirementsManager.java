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
	
	private RequirementsManager() {
		//add code here
	}
	
	public static RequirementsManager getInstance() {
		return null;
	}
	
	public void saveCurrentProjectToFile(String filename) {
		//add code here
	}
	
	public void loadProjectsFromFile(String filename) {
		//add code here
	}
	
	public void createNewProject(String projectname) {
		//add code here
	}
	
	public String[][] getUserStoriesAsArray() {
		return null;
	}
	
	public UserStory getUserStoryById(int storyId) {
		return null;
	}
	
	public void executeCommand(int num, Command command) {
		//add code here
	}
	
	public void deleteUserStoryById(int storyId) {
		//add code here
	}
	
	public void addUserStoryToProject(String title, String user, String action, String value) {
		//add code here
	}
	
	public void loadProject(String projectname) {
		//add code here
	}
	
	public String getProjectName() {
		return null;
	}
	
	public String[] getProjectList() {
		return null;
	}
	
	protected void resetManager() {
		//add code here
	}

}
