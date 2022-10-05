/**
 * 
 */
package edu.ncsu.csc216.requirements_manager.model.command;

/**
 * This class creates objects that encapsulate user actions (or transitions)
 * that cause the state of a UserStory to update.
 * 
 * @author yujim
 *
 */
public class Command {

	/**
	 * Enumeration of possible command values that can cause transitions in the FSM.
	 * 
	 * @author yujim
	 */
	public enum CommandValue {
		BACKLOG, ASSIGN, REVIEW, CONFIRM, REOPEN, REJECT, RESUBMIT
	}

	/** Command that causes state transitions in the FSM **/
	private CommandValue command;
	/** The information of a command **/
	private String commandInformation;

	/**
	 * Creates a command using the provided parameters. An IllegalArgumentException
	 * is thrown when there is a null CommandValue parameter, when there is a
	 * CommandValue of BACKLOG, ASSIGN, or REJECT with a null or empty string
	 * commandInformation, and when there is a CommandValue of REVIEW, CONFIRM,
	 * REOPEN, or RESUBMIT and a non-null commandInformation
	 * 
	 * @param command
	 * @param commandInformation
	 * @throws IllegalArgumentException when there is a null CommandValue parameter,
	 *                                  when there is a CommandValue of BACKLOG,
	 *                                  ASSIGN, or REJECT with a null or empty
	 *                                  string commandInformation, and when there is
	 *                                  a CommandValue of REVIEW, CONFIRM, REOPEN,
	 *                                  or RESUBMIT and a non-null
	 *                                  commandInformation
	 */
	public Command(CommandValue command, String commandInformation) {
		// add code here;
	}

	/**
	 * returns the command value
	 * @return command the command value
	 */
	public CommandValue getCommand() {
		return command;
	}

	/**
	 * returns the command value's information
	 * @return commandInformation the command value's information
	 */
	public String getCommandInformation() {
		return commandInformation;
	}
}
