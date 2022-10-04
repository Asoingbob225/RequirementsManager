/**
 * 
 */
package edu.ncsu.csc216.requirements_manager.model.user_story;

import edu.ncsu.csc216.requirements_manager.model.command.Command;

/**
 * @author yujim
 *
 */
public class UserStory {
	public static final String SUBMITTED_NAME = "submitted";
	public static final String BACKLOG_NAME = "backlog";
	public static final String WORKING_NAME = "working";
	public static final String VERIFYING_NAME = "verifying";
	public static final String COMPLETED_NAME = "completed";
	public static final String REJECTED_NAME = "rejected";
	public static final String HIGH_PRIORITY = "high";
	public static final String MEDIUM_PRIORITY = "medium";
	public static final String LOW_PRIORITY = "low";
	public static final String DUPLICATE_REJECTION = "Duplicate";
	public static final String INNAPROPRIATE_REJECTION = "Innapropriate";
	public static final String INFEASIBLE_REJECTION = "Infeasible";
	
	private static final int counter = 0;
	private int storyId;
	private String title;
	private String user;
	private String action;
	private String value;
	private String priority;
	private String developerId;
	private String rejectionReason;
	
	
	public UserStory(String title, String user, String action, String value) {
		//add code here
	}
	
	public UserStory(int storyId, String title, String user, String action, String value, String priority, String developerId, String refectionReason) {
		//add code here
	}
	
	public int getId() {
		return storyId;
	}
	
	public void setId(int storyId) {
		this.storyId = storyId;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getAction() {
		return action;
	}
	
	public void setAction(String action) {
		this.action = action;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getPriority() {
		return priority;
	}
	
	public void setPriority(String priority) {
		this.priority = priority;
	}
	
	public String getDeveloperId() {
		return developerId;
	}
	
	public void setDeveloperId(String developerId) {
		this.developerId = developerId;
	}
	
	public String getRejectionReason() {
		return rejectionReason;
	}
	
	public void setRejectionReason(String rejectionReason) {
		this.rejectionReason = rejectionReason;
	}
	
	public static void incrementCounter() {
		//add code here
	}
	
	public static void setCounter(int counter) {
		//add code here
	}
	
	public String toString() {
		return null;
	}
	
	public void update(Command command) {
		//add code here
	}
	
	/**
	 * @author yujim
	 *
	 */
	private class SubmittedState implements UserStoryState {
		
		private SubmittedState() {
			//add code here
		}
		
		public void updateState(Command command) {
			//add code here
		}
		
		public String getStateName() {
			return null;
		}
	}
	
	/**
	 * @author yujim
	 *
	 */
	private class BacklogState implements UserStoryState {

		private BacklogState() {
			//add code here
		}
		
		public void updateState(Command command) {
			//add code here
		}
		
		public String getStateName() {
			return null;
		}
	}
	
	/**
	 * @author yujim
	 *
	 */
	private class WorkingState implements UserStoryState {
		
		private WorkingState() {
			//add code here
		}
		
		public void updateState(Command command) {
			//add code here
		}
		
		public String getStateName() {
			return null;
		}

	}
	
	/**
	 * @author yujim
	 *
	 */
	private class VerifyingState implements UserStoryState{

		private VerifyingState() {
			//add code here
		}
		
		public void updateState(Command command) {
			//add code here
		}
		
		public String getStateName() {
			return null;
		}
	}
	
	/**
	 * @author yujim
	 *
	 */
	private class CompletedState implements UserStoryState {

		private CompletedState() {
			//add code here
		}
		
		public void updateState(Command command) {
			//add code here
		}
		
		public String getStateName() {
			return null;
		}
	}
	
	/**
	 * @author yujim
	 *
	 */
	private class RejectedState implements UserStoryState {

		private RejectedState() {
			//add code here
		}
		
		public void updateState(Command command) {
			//add code here
		}
		
		public String getStateName() {
			return null;
		}
	}

	
	
	
	
	
	
}
