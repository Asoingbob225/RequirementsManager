/**
 * 
 */
package edu.ncsu.csc216.requirements_manager.model.user_story;

import edu.ncsu.csc216.requirements_manager.model.command.Command;

/**
 * Represents a user story managed by the Requirements Manager system.
 * 
 * @author yujim
 *
 */
public class UserStory {

	/** A constant string for the submitted state’s name **/
	public static final String SUBMITTED_NAME = "submitted";
	/** A constant string for the backlog state’s name **/
	public static final String BACKLOG_NAME = "backlog";
	/** A constant string for the working state’s name **/
	public static final String WORKING_NAME = "working";
	/** A constant string for the verifying state’s name **/
	public static final String VERIFYING_NAME = "verifying";
	/** A constant string for the completed state’s name **/
	public static final String COMPLETED_NAME = "completed";
	/** A constant string for the rejected state’s name **/
	public static final String REJECTED_NAME = "rejected";
	/** A constant string for the priority of “High”. **/
	public static final String HIGH_PRIORITY = "high";
	/** A constant string for the priority of “Medium”. **/
	public static final String MEDIUM_PRIORITY = "medium";
	/** A constant string for the priority of “Low”. **/
	public static final String LOW_PRIORITY = "low";
	/** A constant string for the rejection reason of “Duplicate”. **/
	public static final String DUPLICATE_REJECTION = "Duplicate";
	/** A constant string for the rejection reason of “Inappropriate”. **/
	public static final String INNAPROPRIATE_REJECTION = "Inapropriate";
	/** A constant string for the rejection reason of “Infeasible”. **/
	public static final String INFEASIBLE_REJECTION = "Infeasible";

	/** static field for counter used to create storyId **/
	private static final int COUNTER = 0;
	/** Unique id for an user story */
	private int storyId;
	/** Current state for the user story of type UserStoryState */
	private String state;
	/** Title of the user story as provided by the user on creation */
	private String title;
	/** The user information for a story (As a) **/
	private String user;
	/** The action information for a story (I want to) **/
	private String action;
	/** The value information for a story (So I can) **/
	private String value;
	/** The user story’s priority **/
	private String priority;
	/** The user story’s assigned developer **/
	private String developerId;
	/** The user story’s rejection reason **/
	private String rejectionReason;

	/**
	 * Constructs a UserStory from the provided parameters. If any of the parameters
	 * are null or empty strings, then an IllegalArgumentException is thrown. The
	 * storyId field is set to the value stored in UserStory.counter. The counter is
	 * then incremented using UserStory.incrementCounter(). A new UserStory starts
	 * in the submitted state. The priority, developerId, and rejectionReason are
	 * all null.
	 * 
	 * @param title  title of the story
	 * @param user   user information for the story
	 * @param action action information for the story
	 * @param value  value information for the story
	 * @throws IllegalArgumentException if any of the parameters are null or empty
	 *                                  strings.
	 * 
	 */
	public UserStory(String title, String user, String action, String value) {
		// add code here
	}

	/**
	 * The fields of the UserStory are set to the parameter values after error
	 * checking. This constructor should be used in the ProjectReader class. You may
	 * find it useful to create private setter methods to set the fields for
	 * UserStory. This constructor checks the constraints on UserStory objects
	 * listed in [UC2]. Additionally, if the incoming id is greater than the current
	 * value in UserStory.counter, then the UserStory.counter should be updated to
	 * the id + 1 using the setCounter(id) method. Note that if there is an issue
	 * with any of the parameters, an IllegalArgumentException should be thrown.
	 * 
	 * @param storyId         story's id
	 * @param title           story's title
	 * @param user            story's user information
	 * @param action          story's action information
	 * @param value           story's value information
	 * @param priority        story's priority level
	 * @param developerId     story's assigned developer
	 * @param rejectionReason story's rejection reason
	 * @throws IllegalArgumentException when there is an issue with any of the
	 *                                  parameters
	 * 
	 */
	public UserStory(int storyId, String title, String user, String action, String value, String priority,
			String developerId, String rejectionReason) {
		// add code here
	}

	/**
	 * Return's the story's id.
	 * 
	 * @return story's id
	 */
	public int getId() {
		return storyId;
	}

	/**
	 * Sets the story's id.
	 * 
	 * @param storyId story's id.
	 */
	public void setId(int storyId) {
		this.storyId = storyId;
	}

	/**
	 * Return's the story's state.
	 * 
	 * @return story's state
	 */
	public String getState() {
		return state;
	}

	/**
	 * Sets the story's state.
	 * 
	 * @param state story's state.
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Return's the story's title.
	 * 
	 * @return story's title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the story's title.
	 * 
	 * @param title story's title.
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Return's the story's user information.
	 * 
	 * @return story's user information
	 */
	public String getUser() {
		return user;
	}

	/**
	 * Sets the story's user information.
	 * 
	 * @param user story's user information.
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * Return's the story's action information.
	 * 
	 * @return story's action information
	 */
	public String getAction() {
		return action;
	}

	/**
	 * Sets the story's action information.
	 * 
	 * @param action story's action information.
	 */
	public void setAction(String action) {
		this.action = action;
	}

	/**
	 * Return's the story's value information.
	 * 
	 * @return story's value information
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Sets the story's value information.
	 * 
	 * @param value story's value information.
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * Return's the story's priority level.
	 * 
	 * @return story's priority level
	 */
	public String getPriority() {
		return priority;
	}

	/**
	 * Sets the story's priority level.
	 * 
	 * @param priority story's level.
	 */
	public void setPriority(String priority) {
		this.priority = priority;
	}

	/**
	 * Return's the story's assigned developer's id.
	 * 
	 * @return story's developer's id
	 */
	public String getDeveloperId() {
		return developerId;
	}

	/**
	 * Sets the story's developer's id.
	 * 
	 * @param developerId story's developer's id.
	 */
	public void setDeveloperId(String developerId) {
		this.developerId = developerId;
	}

	/**
	 * Return's the story's rejection reason.
	 * 
	 * @return story's rejection reason
	 */
	public String getRejectionReason() {
		return rejectionReason;
	}

	/**
	 * Sets the story's rejection reason.
	 * 
	 * @param rejectionReason story's rejection reason.
	 */
	public void setRejectionReason(String rejectionReason) {
		this.rejectionReason = rejectionReason;
	}

	/**
	 * Increments the counter field used to assign the storyId
	 */
	public static void incrementCounter() {
		// add code here
	}

	/**
	 * Used by clients of UserStory to set the counter value to a given number.
	 * 
	 * @param counter value used to assign a storyId
	 */
	public static void setCounter(int counter) {
		// add code here
	}

	/**
	 * Returns the string representation of the UserStory that is printed during
	 * file save operations.
	 * 
	 * @return String representation of UserStory
	 */
	public String toString() {
		return null;
	}

	/**
	 * Drives the finite state machine by delegating to the current state’s
	 * updateState(Command) method. throws an UnsupportedOperationException if the
	 * current state determines that the transition, as encapsulated by the Command,
	 * is not appropriate for the FSM.
	 * 
	 * @param command Command used for specific state transitions.
	 * @throws UnsupportedOperationException if the current state determines that
	 *                                       the transition is not appropriate for
	 *                                       the FSM
	 */
	public void update(Command command) {
		// add code here
	}

	/**
	 * Interface for states in the UserStory State Pattern. All concrete user story
	 * states must implement the UserStoryState interface. The UserStoryState
	 * interface should be a private interface of the UserStory class.
	 * 
	 * @author Dr. Sarah Heckman
	 */
	private interface UserStoryState {

		/**
		 * Update the UserStory based on the given Command. An
		 * UnsupportedOperationException is thrown if the Command is not a valid action
		 * for the given state.
		 * 
		 * @param command Command describing the action that will update the UserStory's
		 *                state.
		 * @throws UnsupportedOperationException if the Command is not a valid action
		 *                                       for the given state.
		 */
		void updateState(Command command);

		/**
		 * Returns the name of the current state as a String.
		 * 
		 * @return the name of the current state as a String.
		 */
		String getStateName();

	}

	/**
	 * Final instance of the SubmittedState inner class. The reference type is
	 * UserStoryState
	 * 
	 * @author yujim
	 *
	 */
	private class SubmittedState implements UserStoryState {

		/**
		 * Constructs the submitted state for a story.
		 */
		private SubmittedState() {
			// add code here
		}

		/**
		 * Update the UserStory based on the given Command. An
		 * UnsupportedOperationException is thrown if the Command is not a valid action
		 * for the given state.
		 * 
		 * @param command Command describing the action that will update the UserStory's
		 *                state.
		 * @throws UnsupportedOperationException if the Command is not a valid action
		 *                                       for the given state.
		 */
		public void updateState(Command command) {
			// add code here
		}

		/**
		 * Returns the name of the current state as a String.
		 * 
		 * @return the name of the current state as a String.
		 */
		public String getStateName() {
			return null;
		}
	}

	/**
	 * Final instance of the BacklogState inner class. The reference type is
	 * UserStoryState.
	 * 
	 * @author yujim
	 *
	 */
	private class BacklogState implements UserStoryState {

		/**
		 * Constructs the backlog state for a story.
		 */
		private BacklogState() {
			// add code here
		}

		/**
		 * Update the UserStory based on the given Command. An
		 * UnsupportedOperationException is thrown if the Command is not a valid action
		 * for the given state.
		 * 
		 * @param command Command describing the action that will update the UserStory's
		 *                state.
		 * @throws UnsupportedOperationException if the Command is not a valid action
		 *                                       for the given state.
		 */
		public void updateState(Command command) {
			// add code here
		}

		/**
		 * Returns the name of the current state as a String.
		 * 
		 * @return the name of the current state as a String.
		 */
		public String getStateName() {
			return null;
		}
	}

	/**
	 * Final instance of the WorkingState inner class. The reference type is
	 * UserStoryState.
	 * 
	 * @author yujim
	 *
	 */
	private class WorkingState implements UserStoryState {

		/**
		 * Constructs the working state for a story.
		 */
		private WorkingState() {
			// add code here
		}

		/**
		 * Update the UserStory based on the given Command. An
		 * UnsupportedOperationException is thrown if the Command is not a valid action
		 * for the given state.
		 * 
		 * @param command Command describing the action that will update the UserStory's
		 *                state.
		 * @throws UnsupportedOperationException if the Command is not a valid action
		 *                                       for the given state.
		 */
		public void updateState(Command command) {
			// add code here
		}

		/**
		 * Returns the name of the current state as a String.
		 * 
		 * @return the name of the current state as a String.
		 */
		public String getStateName() {
			return null;
		}

	}

	/**
	 * Final instance of the VerifyingState inner class. The reference type is
	 * UserStoryState.
	 * 
	 * @author yujim
	 *
	 */
	private class VerifyingState implements UserStoryState {

		/**
		 * Constructs the verifying state for a story.
		 */
		private VerifyingState() {
			// add code here
		}

		/**
		 * Update the UserStory based on the given Command. An
		 * UnsupportedOperationException is thrown if the Command is not a valid action
		 * for the given state.
		 * 
		 * @param command Command describing the action that will update the UserStory's
		 *                state.
		 * @throws UnsupportedOperationException if the Command is not a valid action
		 *                                       for the given state.
		 */
		public void updateState(Command command) {
			// add code here
		}

		/**
		 * Returns the name of the current state as a String.
		 * 
		 * @return the name of the current state as a String.
		 */
		public String getStateName() {
			return null;
		}
	}

	/**
	 * Final instance of the CompletedState inner class. The reference type is
	 * UserStoryState.
	 * 
	 * @author yujim
	 *
	 */
	private class CompletedState implements UserStoryState {

		/**
		 * Constructs the completed state for a story.
		 */
		private CompletedState() {
			// add code here
		}

		/**
		 * Update the UserStory based on the given Command. An
		 * UnsupportedOperationException is thrown if the Command is not a valid action
		 * for the given state.
		 * 
		 * @param command Command describing the action that will update the UserStory's
		 *                state.
		 * @throws UnsupportedOperationException if the Command is not a valid action
		 *                                       for the given state.
		 */
		public void updateState(Command command) {
			// add code here
		}

		/**
		 * Returns the name of the current state as a String.
		 * 
		 * @return the name of the current state as a String.
		 */
		public String getStateName() {
			return null;
		}
	}

	/**
	 * Final instance of the RejectedState inner class. The reference type is
	 * UserStoryState.
	 * 
	 * @author yujim
	 *
	 */
	private class RejectedState implements UserStoryState {

		/**
		 * Constructs the rejected state for a story.
		 */
		private RejectedState() {
			// add code here
		}

		/**
		 * Update the UserStory based on the given Command. An
		 * UnsupportedOperationException is thrown if the Command is not a valid action
		 * for the given state.
		 * 
		 * @param command Command describing the action that will update the UserStory's
		 *                state.
		 * @throws UnsupportedOperationException if the Command is not a valid action
		 *                                       for the given state.
		 */
		public void updateState(Command command) {
			// add code here
		}

		/**
		 * Returns the name of the current state as a String.
		 * 
		 * @return the name of the current state as a String.
		 */
		public String getStateName() {
			return null;
		}
	}

}
