/**
 * 
 */
package edu.ncsu.csc216.requirements_manager.model.user_story;

import edu.ncsu.csc216.requirements_manager.model.command.Command;

/**
 * @author yujim
 *
 */
public interface UserStoryState {
	

	default void updateState(Command command) {
		//add code here
	}
	
	default String getStateName() {
		return null;
	}
}
