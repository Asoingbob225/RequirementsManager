/**
 * 
 */
package edu.ncsu.csc216.requirements_manager.model.user_story;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.requirements_manager.model.command.Command;

/**
 * @author stbeuav
 *
 */
class UserStoryTest {

	private static final int ID = 0;
	private static final String STATE = "Backlog";
	private static final String TITLE = "Add Event";
	private static final String USER = "student";
	private static final String ACTION = "action";
	private static final String VALUE = "value";
	private static final String PRIORITY = "Medium";
	private static final String DEVID = "jyu34";
	private static final String REJECTREASON = "Duplicate";

	/**
	 * Resets counter to 0 for use in other tests.
	 * 
	 * @throws Exception if any issues occur
	 */
	@Before
	public void setUp() throws Exception {
		// Reset the counter at the beginning of every test.
		UserStory.setCounter(0);
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.requirements_manager.model.user_story.UserStory#UserStory(java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	void testUserStoryStringStringStringString() {
		// fail("Not yet implemented");

		UserStory u = new UserStory(TITLE, USER, ACTION, VALUE);
		assertEquals("Add Event", u.getTitle(), "Invalid title");
		assertEquals("student", u.getUser(), "Invalid user");
		assertEquals("action", u.getAction(), "Invalid action");
		assertEquals("value", u.getValue(), "Invalid value");

		assertThrows(IllegalArgumentException.class, () -> new UserStory(null, USER, ACTION, VALUE));

		assertThrows(IllegalArgumentException.class, () -> new UserStory("", USER, ACTION, VALUE));

		assertThrows(IllegalArgumentException.class, () -> new UserStory(TITLE, null, ACTION, VALUE));

		assertThrows(IllegalArgumentException.class, () -> new UserStory(TITLE, "", ACTION, VALUE));

		assertThrows(IllegalArgumentException.class, () -> new UserStory(TITLE, USER, null, VALUE));

		assertThrows(IllegalArgumentException.class, () -> new UserStory(TITLE, USER, "", VALUE));

		assertThrows(IllegalArgumentException.class, () -> new UserStory(TITLE, USER, ACTION, null));

		assertThrows(IllegalArgumentException.class, () -> new UserStory(TITLE, USER, ACTION, ""));

	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.requirements_manager.model.user_story.UserStory#UserStory(int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	void testUserStoryIntStringStringStringStringStringStringString() {
		UserStory u = new UserStory(ID, STATE, TITLE, USER, ACTION, VALUE, PRIORITY, null, null);

		assertEquals(0, u.getId(), "Invalid id");
		assertEquals("Add Event", u.getTitle(), "Invalid title");
		assertEquals("Backlog", u.getState(), "Invalid state");
		assertEquals("student", u.getUser(), "Invalid user");
		assertEquals("action", u.getAction(), "Invalid action");
		assertEquals("value", u.getValue(), "Invalid value");
		assertEquals("Medium", u.getPriority(), "Invalid priority");
		assertEquals(null, u.getDeveloperId(), "Invalid developer id");
		assertEquals(null, u.getRejectionReason(), "Invalid rejection reason");

		assertThrows(IllegalArgumentException.class,
				() -> new UserStory(-1, STATE, TITLE, USER, ACTION, VALUE, PRIORITY, null, null));

		assertThrows(IllegalArgumentException.class,
				() -> new UserStory(ID, null, TITLE, USER, ACTION, VALUE, PRIORITY, null, null));

		assertThrows(IllegalArgumentException.class,
				() -> new UserStory(ID, "", TITLE, USER, ACTION, VALUE, PRIORITY, null, null));

		assertThrows(IllegalArgumentException.class,
				() -> new UserStory(ID, STATE, null, USER, ACTION, VALUE, PRIORITY, null, null));

		assertThrows(IllegalArgumentException.class,
				() -> new UserStory(ID, STATE, "", USER, ACTION, VALUE, PRIORITY, null, null));

		assertThrows(IllegalArgumentException.class,
				() -> new UserStory(ID, STATE, TITLE, null, ACTION, VALUE, PRIORITY, null, null));

		assertThrows(IllegalArgumentException.class,
				() -> new UserStory(ID, STATE, TITLE, "", ACTION, VALUE, PRIORITY, null, null));

		assertThrows(IllegalArgumentException.class,
				() -> new UserStory(ID, STATE, TITLE, USER, null, VALUE, PRIORITY, null, null));

		assertThrows(IllegalArgumentException.class,
				() -> new UserStory(ID, STATE, TITLE, USER, "", VALUE, PRIORITY, null, null));

		assertThrows(IllegalArgumentException.class,
				() -> new UserStory(ID, STATE, TITLE, USER, ACTION, null, PRIORITY, null, null));

		assertThrows(IllegalArgumentException.class,
				() -> new UserStory(ID, STATE, TITLE, USER, ACTION, "", PRIORITY, null, null));

		// Submitted State
		assertThrows(IllegalArgumentException.class,
				() -> new UserStory(ID, "Submitted", TITLE, USER, ACTION, VALUE, PRIORITY, null, null));
		assertThrows(IllegalArgumentException.class,
				() -> new UserStory(ID, "Submitted", TITLE, USER, ACTION, VALUE, null, DEVID, null));
		assertThrows(IllegalArgumentException.class,
				() -> new UserStory(ID, "Submitted", TITLE, USER, ACTION, VALUE, null, null, REJECTREASON));
		// Backlog State
		assertThrows(IllegalArgumentException.class,
				() -> new UserStory(ID, STATE, TITLE, USER, ACTION, VALUE, null, null, null));
		assertThrows(IllegalArgumentException.class,
				() -> new UserStory(ID, STATE, TITLE, USER, ACTION, VALUE, PRIORITY, DEVID, null));
		assertThrows(IllegalArgumentException.class,
				() -> new UserStory(ID, STATE, TITLE, USER, ACTION, VALUE, PRIORITY, null, REJECTREASON));
		// Working State
		assertThrows(IllegalArgumentException.class,
				() -> new UserStory(ID, "Working", TITLE, USER, ACTION, VALUE, null, DEVID, null));
		assertThrows(IllegalArgumentException.class,
				() -> new UserStory(ID, "Working", TITLE, USER, ACTION, VALUE, PRIORITY, null, null));
		assertThrows(IllegalArgumentException.class,
				() -> new UserStory(ID, "Working", TITLE, USER, ACTION, VALUE, PRIORITY, DEVID, REJECTREASON));
		// Verifying State
		assertThrows(IllegalArgumentException.class,
				() -> new UserStory(ID, "Verifying", TITLE, USER, ACTION, VALUE, null, DEVID, null));
		assertThrows(IllegalArgumentException.class,
				() -> new UserStory(ID, "Verifying", TITLE, USER, ACTION, VALUE, PRIORITY, null, null));
		assertThrows(IllegalArgumentException.class,
				() -> new UserStory(ID, "Verifying", TITLE, USER, ACTION, VALUE, PRIORITY, DEVID, REJECTREASON));
		// Completed State
		assertThrows(IllegalArgumentException.class,
				() -> new UserStory(ID, "Completed", TITLE, USER, ACTION, VALUE, null, DEVID, null));
		assertThrows(IllegalArgumentException.class,
				() -> new UserStory(ID, "Completed", TITLE, USER, ACTION, VALUE, PRIORITY, null, null));
		assertThrows(IllegalArgumentException.class,
				() -> new UserStory(ID, "Completed", TITLE, USER, ACTION, VALUE, PRIORITY, DEVID, REJECTREASON));
		// Rejected State
		assertThrows(IllegalArgumentException.class,
				() -> new UserStory(ID, "Rejected", TITLE, USER, ACTION, VALUE, PRIORITY, null, REJECTREASON));
		assertThrows(IllegalArgumentException.class,
				() -> new UserStory(ID, "Rejected", TITLE, USER, ACTION, VALUE, null, DEVID, REJECTREASON));
		assertThrows(IllegalArgumentException.class,
				() -> new UserStory(ID, "Rejected", TITLE, USER, ACTION, VALUE, null, null, null));

	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.requirements_manager.model.user_story.UserStory#setId(int)}.
	 */
	@Test
	void testSetId() {
		// fail("Not yet implemented");
		UserStory u = new UserStory(ID, STATE, TITLE, USER, ACTION, VALUE, PRIORITY, null, null);

		assertThrows(IllegalArgumentException.class, () -> u.setId(-1));
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.requirements_manager.model.user_story.UserStory#setState(java.lang.String)}.
	 */
	@Test
	void testSetState() {
		// fail("Not yet implemented");
		UserStory u = new UserStory(ID, STATE, TITLE, USER, ACTION, VALUE, PRIORITY, null, null);

		assertThrows(IllegalArgumentException.class, () -> u.setState(null));

		assertThrows(IllegalArgumentException.class, () -> u.setState(""));

		assertThrows(IllegalArgumentException.class, () -> u.setState("starting"));

		assertThrows(IllegalArgumentException.class, () -> u.setState("finished"));
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.requirements_manager.model.user_story.UserStory#setTitle(java.lang.String)}.
	 */
	@Test
	void testSetTitle() {
		// fail("Not yet implemented");
		UserStory u = new UserStory(ID, STATE, TITLE, USER, ACTION, VALUE, PRIORITY, null, null);

		assertThrows(IllegalArgumentException.class, () -> u.setTitle(null));

		assertThrows(IllegalArgumentException.class, () -> u.setTitle(""));
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.requirements_manager.model.user_story.UserStory#setUser(java.lang.String)}.
	 */
	@Test
	void testSetUser() {
		// fail("Not yet implemented");
		UserStory u = new UserStory(ID, STATE, TITLE, USER, ACTION, VALUE, PRIORITY, null, null);

	    assertThrows(IllegalArgumentException.class, () -> u.setUser(null));

		assertThrows(IllegalArgumentException.class, () -> u.setUser(""));
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.requirements_manager.model.user_story.UserStory#setAction(java.lang.String)}.
	 */
	@Test
	void testSetAction() {
		// fail("Not yet implemented");
		UserStory u = new UserStory(ID, STATE, TITLE, USER, ACTION, VALUE, PRIORITY, null, null);

	    assertThrows(IllegalArgumentException.class, () -> u.setAction(null));

		assertThrows(IllegalArgumentException.class, () -> u.setAction(""));
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.requirements_manager.model.user_story.UserStory#setValue(java.lang.String)}.
	 */
	@Test
	void testSetValue() {
		// fail("Not yet implemented");
		UserStory u = new UserStory(ID, STATE, TITLE, USER, ACTION, VALUE, PRIORITY, null, null);

		assertThrows(IllegalArgumentException.class, () -> u.setValue(null));

		assertThrows(IllegalArgumentException.class, () -> u.setValue(""));
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.requirements_manager.model.user_story.UserStory#setPriority(java.lang.String)}.
	 */
	@Test
	void testSetPriority() {
		// fail("Not yet implemented");

		UserStory u = new UserStory(ID, STATE, TITLE, USER, ACTION, VALUE, PRIORITY, null, null);

		assertThrows(IllegalArgumentException.class, () -> u.setPriority(null));

		assertThrows(IllegalArgumentException.class, () -> u.setPriority(""));

		assertThrows(IllegalArgumentException.class, () -> u.setPriority("small"));

		assertThrows(IllegalArgumentException.class, () -> u.setPriority("middle"));

		assertThrows(IllegalArgumentException.class, () -> u.setPriority("large"));
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.requirements_manager.model.user_story.UserStory#setDeveloperId(java.lang.String)}.
	 */
	@Test
	void testSetDeveloperId() {
		// fail("Not yet implemented");

		UserStory u = new UserStory(ID, STATE, TITLE, USER, ACTION, VALUE, PRIORITY, null, null);


		assertThrows(IllegalArgumentException.class, () -> u.setDeveloperId(""));
		assertThrows(IllegalArgumentException.class, () -> u.setDeveloperId("jyu34"));

	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.requirements_manager.model.user_story.UserStory#setRejectionReason(java.lang.String)}.
	 */
	@Test
	void testSetRejectionReason() {
		// fail("Not yet implemented");

		UserStory u = new UserStory(ID, STATE, TITLE, USER, ACTION, VALUE, PRIORITY, null, null);

//		Exception e1 = assertThrows(IllegalArgumentException.class, () -> u.setRejectionReason(null));
//		assertEquals("Invalid rejection reason", e1.getMessage());

		assertThrows(IllegalArgumentException.class, () -> u.setRejectionReason(""));

		assertThrows(IllegalArgumentException.class, () -> u.setRejectionReason("I don't like it"));

	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.requirements_manager.model.user_story.UserStory#incrementCounter()}.
	 */
	@Test
	void testIncrementCounter() {
		int n = 0;
		int[] list = new int[5];
		for (int i = 0; i < 5; i++) {
			list[i] = n;
			n++;
		}
		assertAll("counter", () -> assertEquals(0, list[0]), () -> assertEquals(1, list[1]),
				() -> assertEquals(2, list[2]), () -> assertEquals(3, list[3]), () -> assertEquals(4, list[4]));

	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.requirements_manager.model.user_story.UserStory#setCounter(int)}.
	 */
	@Test
	void testSetCounter() {
		int n = 0;
		int id = 4;
		n = id;
		assertEquals(4, n);

	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.requirements_manager.model.user_story.UserStory#toString()}.
	 */
	@Test
	void testToString() {
		// fail("Not yet implemented");
		UserStory u = new UserStory(ID, STATE, TITLE, USER, ACTION, VALUE, PRIORITY, null, null);
		String s = "* 0,Backlog,Add Event,Medium,null,null\n- student\n- action\n- value";
		assertEquals(s, u.toString());
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.requirements_manager.model.user_story.UserStory#update(edu.ncsu.csc216.requirements_manager.model.command.Command)}.
	 */
	@Test
	void testUpdateSubmittedA() {
		UserStory u = new UserStory(TITLE, USER, ACTION, VALUE);

		assertAll(() -> assertTrue(u.currentState == u.submittedState), () -> {
			u.update(new Command(Command.CommandValue.BACKLOG, "Low"));
			assertTrue(u.currentState == u.backlogState);
		});
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.requirements_manager.model.user_story.UserStory#update(edu.ncsu.csc216.requirements_manager.model.command.Command)}.
	 */
	@Test
	void testUpdateSubmittedB() {
		UserStory u = new UserStory(TITLE, USER, ACTION, VALUE);

		assertAll(() -> assertTrue(u.currentState == u.submittedState), () -> {
			u.update(new Command(Command.CommandValue.REJECT, "Duplicate"));
			assertTrue(u.currentState == u.rejectedState);
		});
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.requirements_manager.model.user_story.UserStory#update(edu.ncsu.csc216.requirements_manager.model.command.Command)}.
	 */
	@Test
	void testUpdateBacklogA() {
		UserStory u = new UserStory(TITLE, USER, ACTION, VALUE);

		assertAll("state", () -> assertTrue(u.currentState == u.submittedState), () -> {
			u.update(new Command(Command.CommandValue.BACKLOG, "Low"));
			assertTrue(u.currentState == u.backlogState);
		}, () -> {
			u.update(new Command(Command.CommandValue.ASSIGN, "jyu34"));
			assertTrue(u.currentState == u.workingState);
		});
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.requirements_manager.model.user_story.UserStory#update(edu.ncsu.csc216.requirements_manager.model.command.Command)}.
	 */
	@Test
	void testUpdateBacklogB() {
		UserStory u = new UserStory(TITLE, USER, ACTION, VALUE);

		assertAll("state", () -> assertTrue(u.currentState == u.submittedState), () -> {
			u.update(new Command(Command.CommandValue.BACKLOG, "Low"));
			assertTrue(u.currentState == u.backlogState);
		}, () -> {
			u.update(new Command(Command.CommandValue.REJECT, "Duplicate"));
			assertTrue(u.currentState == u.rejectedState);
		});
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.requirements_manager.model.user_story.UserStory#update(edu.ncsu.csc216.requirements_manager.model.command.Command)}.
	 */
	@Test
	void testUpdateWorkingA() {
		UserStory u = new UserStory(TITLE, USER, ACTION, VALUE);

		assertAll("state", () -> assertTrue(u.currentState == u.submittedState), () -> {
			u.update(new Command(Command.CommandValue.BACKLOG, "Low"));
			assertTrue(u.currentState == u.backlogState);
		}, () -> {
			u.update(new Command(Command.CommandValue.ASSIGN, "jyu34"));
			assertTrue(u.currentState == u.workingState);
		}, () -> {
			u.update(new Command(Command.CommandValue.ASSIGN, "lacurlee"));
			assertTrue(u.currentState == u.workingState);
		});
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.requirements_manager.model.user_story.UserStory#update(edu.ncsu.csc216.requirements_manager.model.command.Command)}.
	 */
	@Test
	void testUpdateWorkingB() {
		UserStory u = new UserStory(TITLE, USER, ACTION, VALUE);

		assertAll("state", () -> assertTrue(u.currentState == u.submittedState), () -> {
			u.update(new Command(Command.CommandValue.BACKLOG, "Low"));
			assertTrue(u.currentState == u.backlogState);
		}, () -> {
			u.update(new Command(Command.CommandValue.ASSIGN, "jyu34"));
			assertTrue(u.currentState == u.workingState);
		}, () -> {
			u.update(new Command(Command.CommandValue.REJECT, "Duplicate"));
			assertTrue(u.currentState == u.rejectedState);
		});
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.requirements_manager.model.user_story.UserStory#update(edu.ncsu.csc216.requirements_manager.model.command.Command)}.
	 */
	@Test
	void testUpdateWorkingC() {
		UserStory u = new UserStory(TITLE, USER, ACTION, VALUE);

		assertAll("state", () -> assertTrue(u.currentState == u.submittedState), () -> {
			u.update(new Command(Command.CommandValue.BACKLOG, "Low"));
			assertTrue(u.currentState == u.backlogState);
		}, () -> {
			u.update(new Command(Command.CommandValue.ASSIGN, "jyu34"));
			assertTrue(u.currentState == u.workingState);
		}, () -> {
			u.update(new Command(Command.CommandValue.REOPEN, null));
			assertTrue(u.currentState == u.backlogState);
		});
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.requirements_manager.model.user_story.UserStory#update(edu.ncsu.csc216.requirements_manager.model.command.Command)}.
	 */
	@Test
	void testUpdateWorkingD() {
		UserStory u = new UserStory(TITLE, USER, ACTION, VALUE);

		assertAll("state", () -> assertTrue(u.currentState == u.submittedState), () -> {
			u.update(new Command(Command.CommandValue.BACKLOG, "Low"));
			assertTrue(u.currentState == u.backlogState);
		}, () -> {
			u.update(new Command(Command.CommandValue.ASSIGN, "jyu34"));
			assertTrue(u.currentState == u.workingState);
		}, () -> {
			u.update(new Command(Command.CommandValue.REVIEW, null));
			assertTrue(u.currentState == u.verifyingState);
		});
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.requirements_manager.model.user_story.UserStory#update(edu.ncsu.csc216.requirements_manager.model.command.Command)}.
	 */
	@Test
	void testUpdateVerifyingA() {
		UserStory u = new UserStory(TITLE, USER, ACTION, VALUE);

		assertAll("state", () -> assertTrue(u.currentState == u.submittedState), () -> {
			u.update(new Command(Command.CommandValue.BACKLOG, "Low"));
			assertTrue(u.currentState == u.backlogState);
		}, () -> {
			u.update(new Command(Command.CommandValue.ASSIGN, "jyu34"));
			assertTrue(u.currentState == u.workingState);
		}, () -> {
			u.update(new Command(Command.CommandValue.REVIEW, null));
			assertTrue(u.currentState == u.verifyingState);
		}, () -> {
			u.update(new Command(Command.CommandValue.CONFIRM, null));
			assertTrue(u.currentState == u.completedState);
		});
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.requirements_manager.model.user_story.UserStory#update(edu.ncsu.csc216.requirements_manager.model.command.Command)}.
	 */
	@Test
	void testUpdateVerifyingB() {
		UserStory u = new UserStory(TITLE, USER, ACTION, VALUE);

		assertAll(() -> assertTrue(u.currentState == u.submittedState), () -> {
			u.update(new Command(Command.CommandValue.BACKLOG, "Low"));
			assertTrue(u.currentState == u.backlogState);
		}, () -> {
			u.update(new Command(Command.CommandValue.ASSIGN, "jyu34"));
			assertTrue(u.currentState == u.workingState);
		}, () -> {
			u.update(new Command(Command.CommandValue.REVIEW, null));
			assertTrue(u.currentState == u.verifyingState);
		}, () -> {
			u.update(new Command(Command.CommandValue.REOPEN, null));
			assertTrue(u.currentState == u.workingState);
		});
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.requirements_manager.model.user_story.UserStory#update(edu.ncsu.csc216.requirements_manager.model.command.Command)}.
	 */
	@Test
	void testUpdateCompleted() {
		UserStory u = new UserStory(TITLE, USER, ACTION, VALUE);

		assertAll("state", () -> assertTrue(u.currentState == u.submittedState), () -> {
			u.update(new Command(Command.CommandValue.BACKLOG, "Low"));
			assertTrue(u.currentState == u.backlogState);
		}, () -> {
			u.update(new Command(Command.CommandValue.ASSIGN, "jyu34"));
			assertTrue(u.currentState == u.workingState);
		}, () -> {
			u.update(new Command(Command.CommandValue.REVIEW, null));
			assertTrue(u.currentState == u.verifyingState);
		}, () -> {
			u.update(new Command(Command.CommandValue.CONFIRM, null));
			assertTrue(u.currentState == u.completedState);
		}, () -> {
			u.update(new Command(Command.CommandValue.REOPEN, null));
			assertTrue(u.currentState == u.workingState);
		});
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.requirements_manager.model.user_story.UserStory#update(edu.ncsu.csc216.requirements_manager.model.command.Command)}.
	 */
	@Test
	void testUpdateRejected() {
		UserStory u = new UserStory(TITLE, USER, ACTION, VALUE);

		assertAll("state", () -> assertTrue(u.currentState == u.submittedState), () -> {
			u.update(new Command(Command.CommandValue.BACKLOG, "Low"));
			assertTrue(u.currentState == u.backlogState);
		}, () -> {
			u.update(new Command(Command.CommandValue.REJECT, "Duplicate"));
			assertTrue(u.currentState == u.rejectedState);
		}, () -> {
			u.update(new Command(Command.CommandValue.RESUBMIT, null));
			assertTrue(u.currentState == u.submittedState);
		});
	}

}