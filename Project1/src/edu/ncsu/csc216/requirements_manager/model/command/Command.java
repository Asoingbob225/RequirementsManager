/**
 * 
 */
package edu.ncsu.csc216.requirements_manager.model.command;

/**
 * @author yujim
 *
 */
public class Command {
	
	/** Comments go here */
	public enum CommandValue { BACKLOG, ASSIGN, REVIEW, CONFIRM, REOPEN, REJECT, RESUBMIT }

	private CommandValue command;
	private String commandInformation;
	
	
	public Command(CommandValue value, String command) {
		//add code here;
	}
	
	public CommandValue getCommand() {
		return null;
	}
	
	public String getCommandInformation() {
		return null;
	}
}
