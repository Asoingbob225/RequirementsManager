/**
 * 
 */
package edu.ncsu.csc216.requirements_manager.model.command;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author stbeuav
 *
 */
class CommandTest {

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.requirements_manager.model.command.Command#Command(edu.ncsu.csc216.requirements_manager.model.command.Command.CommandValue, java.lang.String)}.
	 */
	@Test
	void testCommand() {
		Exception c1 = assertThrows(IllegalArgumentException.class, () -> new Command(null, "no command"));
		assertEquals("Invalid command", c1.getMessage());

		Exception c2 = assertThrows(IllegalArgumentException.class,
				() -> new Command(Command.CommandValue.BACKLOG, ""));
		assertEquals("Invalid command information", c2.getMessage());

		Exception c3 = assertThrows(IllegalArgumentException.class,
				() -> new Command(Command.CommandValue.REVIEW, "review command"));
		assertEquals("Invalid command information", c3.getMessage());

		Command c = assertDoesNotThrow(() -> new Command(Command.CommandValue.BACKLOG, "info"),
				"Should not throw exception");

		assertAll("Command",
				() -> assertEquals(Command.CommandValue.BACKLOG, c.getCommand(), "Invalid command"),
				() -> assertEquals("info", c.getCommandInformation(), "Invalid command information"));
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.requirements_manager.model.command.Command#getCommand()}.
	 */
	@Test
	void testGetCommand() {
		Command c = new Command(Command.CommandValue.BACKLOG, "info");
		assertEquals(Command.CommandValue.BACKLOG, c.getCommand());
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.requirements_manager.model.command.Command#getCommandInformation()}.
	 */
	@Test
	void testGetCommandInformation() {
		Command c = new Command(Command.CommandValue.BACKLOG, "info");
		assertEquals("info", c.getCommandInformation());

	}

}
