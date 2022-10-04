/**
 * 
 */
package edu.ncsu.csc216.requirements_manager.model.manager;

import java.util.List;

import edu.ncsu.csc216.requirements_manager.model.command.Command;
import edu.ncsu.csc216.requirements_manager.model.user_story.UserStory;

/**
 * @author yujim
 *
 */
public class Project {
	
	private String projectName;
	
	public Project(String projectName) {
		//add code here
	}
	
	public String getProjectName(String projectName) {
		return projectName;
	}
	
	private void setProjectName() {
		this.projectName = projectName;
	}
	
	public void setUserStoryId() {
		//add code here
	}
	
	public int addUserStory(String title, String user, String action, String value) {
		return 0;
	}
	
	public void addUserStory(UserStory story) {
		//add code here
	}
	
	public List<UserStory> getUserStories() {
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

}
