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
	public static final String SUBMITTED_NAME = "Submitted";
	/** A constant string for the backlog state’s name **/
	public static final String BACKLOG_NAME = "Backlog";
	/** A constant string for the working state’s name **/
	public static final String WORKING_NAME = "Working";
	/** A constant string for the verifying state’s name **/
	public static final String VERIFYING_NAME = "Verifying";
	/** A constant string for the completed state’s name **/
	public static final String COMPLETED_NAME = "Completed";
	/** A constant string for the rejected state’s name **/
	public static final String REJECTED_NAME = "Rejected";
	/** A constant string for the priority of “High”. **/
	public static final String HIGH_PRIORITY = "High";
	/** A constant string for the priority of “Medium”. **/
	public static final String MEDIUM_PRIORITY = "Medium";
	/** A constant string for the priority of “Low”. **/
	public static final String LOW_PRIORITY = "Low";
	/** A constant string for the rejection reason of “Duplicate”. **/
	public static final String DUPLICATE_REJECTION = "Duplicate";
	/** A constant string for the rejection reason of “Inappropriate”. **/
	public static final String INAPPROPRIATE_REJECTION = "Inapropriate";
	/** A constant string for the rejection reason of “Infeasible”. **/
	public static final String INFEASIBLE_REJECTION = "Infeasible";

	/** static field for counter used to create storyId **/
	private static int counter = 0;
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

	public final UserStoryState submittedState = new SubmittedState();

	public final UserStoryState backlogState = new BacklogState();

	public final UserStoryState workingState = new WorkingState();

	public final UserStoryState verifyingState = new VerifyingState();

	public final UserStoryState completedState = new CompletedState();

	public final UserStoryState rejectedState = new RejectedState();

	public UserStoryState currentState = submittedState;

	/**
	 * Constructs a UserStory from the provided parameters. The storyId field is set
	 * to the value stored in UserStory.counter. The counter is then incremented
	 * using UserStory.incrementCounter(). A new UserStory starts in the submitted
	 * state. The priority, developerId, and rejectionReason are all null.
	 * 
	 * @param title  title of the story
	 * @param user   user information for the story
	 * @param action action information for the story
	 * @param value  value information for the story
	 * 
	 */
	public UserStory(String title, String user, String action, String value) {

		storyId = counter;
		incrementCounter();

		setTitle(title);
		setUser(user);
		setAction(action);
		setValue(value);

		setState(currentState.getStateName());

	}

	/**
	 * The fields of the UserStory are set to the parameter values after error
	 * checking. This constructor should be used in the ProjectReader class. This
	 * constructor checks the constraints on UserStory objects listed in [UC2].
	 * Additionally, if the incoming id is greater than the current value in
	 * UserStory.counter, then the UserStory.counter should be updated to the id + 1
	 * using the setCounter(id) method.
	 * 
	 * @param storyId         story's id
	 * @param state           story's state
	 * @param title           story's title
	 * @param user            story's user information
	 * @param action          story's action information
	 * @param value           story's value information
	 * @param priority        story's priority level
	 * @param developerId     story's assigned developer
	 * @param rejectionReason story's rejection reason
	 * 
	 */
	public UserStory(int storyId, String state, String title, String user, String action, String value, String priority,
			String developerId, String rejectionReason) {

		if (storyId > counter) {
			setCounter(storyId);
			counter++;
		}

		setId(storyId);
		setState(state);
		setTitle(title);
		setUser(user);
		setAction(action);
		setValue(value);
		setPriority(priority);
		setDeveloperId(developerId);
		setRejectionReason(rejectionReason);

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
	 * @throws IllegalArgumentException if id is less than 0
	 */
	public void setId(int storyId) {
		if (storyId < 0) {
			throw new IllegalArgumentException("Invalid id");
		}
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
	 * @throws IllegalArgumentException if state is null or length 0
	 */
	public void setState(String state) {
		if (state != submittedState.getStateName() && state != backlogState.getStateName()
				&& state != workingState.getStateName() && state != verifyingState.getStateName()
				&& state != completedState.getStateName() && state != rejectedState.getStateName()) {
			throw new IllegalArgumentException("Invalid state");
		}
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
	 * @throws IllegalArgumentException if title is null or length 0
	 */
	public void setTitle(String title) {
		if (title == null || title.length() == 0) {
			throw new IllegalArgumentException("Invalid title");
		}
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
	 * @throws IllegalArgumentException if user is null or length 0
	 */
	public void setUser(String user) {
		if (user == null || user.length() == 0) {
			throw new IllegalArgumentException("Invalid user");
		}
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
	 * @throws IllegalArgumentException if action is null or length 0
	 */
	public void setAction(String action) {
		if (action == null || action.length() == 0) {
			throw new IllegalArgumentException("Invalid action");
		}
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
	 * @throws IllegalArgumentException if value if null or length 0
	 */
	public void setValue(String value) {
		if (value == null || value.length() == 0) {
			throw new IllegalArgumentException("Invalid value");
		}
		this.value = value;
	}

	/**
	 * Return's the story's priority level.
	 * 
	 * @return story's priority level
	 * 
	 */
	public String getPriority() {
		return priority;
	}

	/**
	 * Sets the story's priority level.
	 * 
	 * @param priority story's priority level.
	 * @throws IllegalArgumentException if priority is not low, medium, or high
	 */
	public void setPriority(String priority) {
//		if (((currentState == backlogState || currentState == workingState || currentState == verifyingState || currentState == completedState) && (priority != HIGH_PRIORITY && priority != MEDIUM_PRIORITY && priority != LOW_PRIORITY))|| ((currentState == submittedState || currentState == rejectedState) && priority != null)) {
//			throw new IllegalArgumentException("Invalid priority");
//		}
		if (priority == null || (priority.equals(HIGH_PRIORITY) || priority.equals(MEDIUM_PRIORITY)
				|| priority.equals(LOW_PRIORITY))) {
			this.priority = priority;
		} else {
			throw new IllegalArgumentException("Invalid priority");
		}
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
	 * @throws IllegalArgumentException if developer id is null of length 0
	 */
	public void setDeveloperId(String developerId) {
		if (developerId == null || developerId.length() != 0) {
			this.developerId = developerId;
		} else {
			throw new IllegalArgumentException("Invalid developer id");
		}
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
	 * @throws IllegalArgumentException if rejection reason isn't one of duplicate,
	 *                                  inappropriate, or infeasible
	 */
	public void setRejectionReason(String rejectionReason) {
		if (rejectionReason == null || (rejectionReason.equals(DUPLICATE_REJECTION)
				|| rejectionReason.equals(INAPPROPRIATE_REJECTION) || rejectionReason.equals(INFEASIBLE_REJECTION))) {
			this.rejectionReason = rejectionReason;
		}
		else {
			throw new IllegalArgumentException("Invalid rejection reason");
		}
	}

	/**
	 * Increments the counter field used to assign the storyId
	 */
	public static void incrementCounter() {
		counter++;
	}

	/**
	 * Used by clients of UserStory to set the counter value to a given id number.
	 * 
	 * @param counter value used to assign a storyId
	 */
	public static void setCounter(int id) {
		counter = id;
	}

	/**
	 * Returns the string representation of the UserStory that is printed during
	 * file save operations.
	 * 
	 * @return String representation of UserStory
	 */
	public String toString() {
		return "* " + storyId + "," + state + "," + title + "," + priority + "," + developerId + "," + rejectionReason
				+ "\n" + "- " + user + "\n" + "- " + action + "\n" + "- " + value;

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
		if (currentState == submittedState) {
			submittedState.updateState(command);
		} else if (currentState == backlogState) {
			backlogState.updateState(command);
		} else if (currentState == workingState) {
			workingState.updateState(command);
		} else if (currentState == verifyingState) {
			verifyingState.updateState(command);
		} else if (currentState == completedState) {
			completedState.updateState(command);
		} else if (currentState == rejectedState) {
			rejectedState.updateState(command);
		}
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
	private final class SubmittedState implements UserStoryState {

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
			if (command.getCommand() == Command.CommandValue.BACKLOG) {
				setPriority(command.getCommandInformation());
				currentState = backlogState;
			}

			else if (command.getCommand() == Command.CommandValue.REJECT) {
				setRejectionReason(command.getCommandInformation());
				currentState = rejectedState;
			} else {
				throw new UnsupportedOperationException("Invalid command for user story state");
			}

		}

		/**
		 * Returns the name of the current state as a String.
		 * 
		 * @return the name of the current state as a String.
		 */
		public String getStateName() {
			return SUBMITTED_NAME;
		}
	}

	/**
	 * Final instance of the BacklogState inner class. The reference type is
	 * UserStoryState.
	 * 
	 * @author yujim
	 *
	 */
	private final class BacklogState implements UserStoryState {

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
			if (command.getCommand() == Command.CommandValue.ASSIGN) {
				setDeveloperId(command.getCommandInformation());
				currentState = workingState;
			} else if (command.getCommand() == Command.CommandValue.REJECT) {
				setRejectionReason(command.getCommandInformation());
				currentState = rejectedState;
			} else {
				throw new UnsupportedOperationException("Invalid command for user story state");
			}

		}

		/**
		 * Returns the name of the current state as a String.
		 * 
		 * @return the name of the current state as a String.
		 */
		public String getStateName() {
			return BACKLOG_NAME;
		}
	}

	/**
	 * Final instance of the WorkingState inner class. The reference type is
	 * UserStoryState.
	 * 
	 * @author yujim
	 *
	 */
	private final class WorkingState implements UserStoryState {

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
			if (command.getCommand() == Command.CommandValue.ASSIGN) {
				setDeveloperId(command.getCommandInformation());
				currentState = workingState;
			} else if (command.getCommand() == Command.CommandValue.REJECT) {
				setRejectionReason(command.getCommandInformation());
				currentState = rejectedState;
			} else if (command.getCommand() == Command.CommandValue.REOPEN) {
				currentState = backlogState;
			} else if (command.getCommand() == Command.CommandValue.REVIEW) {
				currentState = verifyingState;
			} else {
				throw new UnsupportedOperationException("Invalid command for user story state");
			}
		}

		/**
		 * Returns the name of the current state as a String.
		 * 
		 * @return the name of the current state as a String.
		 */
		public String getStateName() {
			return WORKING_NAME;
		}

	}

	/**
	 * Final instance of the VerifyingState inner class. The reference type is
	 * UserStoryState.
	 * 
	 * @author yujim
	 *
	 */
	private final class VerifyingState implements UserStoryState {

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
			if (command.getCommand() == Command.CommandValue.REOPEN) {
				currentState = workingState;
			} else if (command.getCommand() == Command.CommandValue.CONFIRM) {
				currentState = completedState;
			} else {
				throw new UnsupportedOperationException("Invalid command for user story state");
			}

		}

		/**
		 * Returns the name of the current state as a String.
		 * 
		 * @return the name of the current state as a String.
		 */
		public String getStateName() {
			return VERIFYING_NAME;
		}
	}

	/**
	 * Final instance of the CompletedState inner class. The reference type is
	 * UserStoryState.
	 * 
	 * @author yujim
	 *
	 */
	private final class CompletedState implements UserStoryState {

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
			if (command.getCommand() == Command.CommandValue.REOPEN) {
				currentState = workingState;
			} else {
				throw new UnsupportedOperationException("Invalid command for user story state");
			}
		}

		/**
		 * Returns the name of the current state as a String.
		 * 
		 * @return the name of the current state as a String.
		 */
		public String getStateName() {
			return COMPLETED_NAME;
		}
	}

	/**
	 * Final instance of the RejectedState inner class. The reference type is
	 * UserStoryState.
	 * 
	 * @author yujim
	 *
	 */
	private final class RejectedState implements UserStoryState {

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
			if (command.getCommand() == Command.CommandValue.RESUBMIT) {
				currentState = submittedState;
			} else {
				throw new UnsupportedOperationException("Invalid command for user story state");
			}
		}

		/**
		 * Returns the name of the current state as a String.
		 * 
		 * @return the name of the current state as a String.
		 */
		public String getStateName() {
			return REJECTED_NAME;
		}
	}

}
