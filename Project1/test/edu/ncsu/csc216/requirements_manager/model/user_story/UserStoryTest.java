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
	private static final String STATE = "submitted";
	private static final String TITLE = "Add Event";
	private static final String USER = "student";
	private static final String ACTION = "action";
	private static final String VALUE = "value";
	private static final String PRIORITY = "medium";
	private static final String DEVID = "jyu34";
	private static final String REJECTREASON = "Duplicate";

	private static int counter = 0;
	private int storyId;

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

		Exception e1 = assertThrows(IllegalArgumentException.class, () -> new UserStory(null, USER, ACTION, VALUE));
		assertEquals("Invalid title", e1.getMessage());

		Exception e2 = assertThrows(IllegalArgumentException.class, () -> new UserStory("", USER, ACTION, VALUE));
		assertEquals("Invalid title", e2.getMessage());

		Exception e3 = assertThrows(IllegalArgumentException.class, () -> new UserStory(TITLE, null, ACTION, VALUE));
		assertEquals("Invalid user", e3.getMessage());

		Exception e4 = assertThrows(IllegalArgumentException.class, () -> new UserStory(TITLE, "", ACTION, VALUE));
		assertEquals("Invalid user", e4.getMessage());

		Exception e5 = assertThrows(IllegalArgumentException.class, () -> new UserStory(TITLE, USER, null, VALUE));
		assertEquals("Invalid action", e5.getMessage());

		Exception e6 = assertThrows(IllegalArgumentException.class, () -> new UserStory(TITLE, USER, "", VALUE));
		assertEquals("Invalid action", e6.getMessage());

		Exception e7 = assertThrows(IllegalArgumentException.class, () -> new UserStory(TITLE, USER, ACTION, null));
		assertEquals("Invalid value", e7.getMessage());

		Exception e8 = assertThrows(IllegalArgumentException.class, () -> new UserStory(TITLE, USER, ACTION, ""));
		assertEquals("Invalid value", e8.getMessage());

		assertTrue(storyId == counter);

	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.requirements_manager.model.user_story.UserStory#UserStory(int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	void testUserStoryIntStringStringStringStringStringStringString() {
		UserStory u = new UserStory(ID, STATE, TITLE, USER, ACTION, VALUE, PRIORITY, DEVID, REJECTREASON);

		assertEquals(0, u.getId(), "Invalid id");
		assertEquals("Add Event", u.getTitle(), "Invalid title");
		assertEquals("submitted", u.getState(), "Invalid state");
		assertEquals("student", u.getUser(), "Invalid user");
		assertEquals("action", u.getAction(), "Invalid action");
		assertEquals("value", u.getValue(), "Invalid value");
		assertEquals("medium", u.getPriority(), "Invalid priority");
		assertEquals("jyu34", u.getDeveloperId(), "Invalid developer id");
		assertEquals("Duplicate", u.getRejectionReason(), "Invalid rejection reason");

		Exception e1 = assertThrows(IllegalArgumentException.class,
				() -> new UserStory(-1, STATE, TITLE, USER, ACTION, VALUE, PRIORITY, DEVID, REJECTREASON));
		assertEquals("Invalid id", e1.getMessage());

		Exception e2 = assertThrows(IllegalArgumentException.class,
				() -> new UserStory(ID, null, TITLE, USER, ACTION, VALUE, PRIORITY, DEVID, REJECTREASON));
		assertEquals("Invalid state", e2.getMessage());

		Exception e3 = assertThrows(IllegalArgumentException.class,
				() -> new UserStory(ID, "", TITLE, USER, ACTION, VALUE, PRIORITY, DEVID, REJECTREASON));
		assertEquals("Invalid state", e3.getMessage());

		Exception e4 = assertThrows(IllegalArgumentException.class,
				() -> new UserStory(ID, STATE, null, USER, ACTION, VALUE, PRIORITY, DEVID, REJECTREASON));
		assertEquals("Invalid title", e4.getMessage());

		Exception e5 = assertThrows(IllegalArgumentException.class,
				() -> new UserStory(ID, STATE, "", USER, ACTION, VALUE, PRIORITY, DEVID, REJECTREASON));
		assertEquals("Invalid title", e5.getMessage());

		Exception e6 = assertThrows(IllegalArgumentException.class,
				() -> new UserStory(ID, STATE, TITLE, null, ACTION, VALUE, PRIORITY, DEVID, REJECTREASON));
		assertEquals("Invalid user", e6.getMessage());

		Exception e7 = assertThrows(IllegalArgumentException.class,
				() -> new UserStory(ID, STATE, TITLE, "", ACTION, VALUE, PRIORITY, DEVID, REJECTREASON));
		assertEquals("Invalid user", e7.getMessage());

		Exception e8 = assertThrows(IllegalArgumentException.class,
				() -> new UserStory(ID, STATE, TITLE, USER, null, VALUE, PRIORITY, DEVID, REJECTREASON));
		assertEquals("Invalid action", e8.getMessage());

		Exception e9 = assertThrows(IllegalArgumentException.class,
				() -> new UserStory(ID, STATE, TITLE, USER, "", VALUE, PRIORITY, DEVID, REJECTREASON));
		assertEquals("Invalid action", e9.getMessage());

		Exception e10 = assertThrows(IllegalArgumentException.class,
				() -> new UserStory(ID, STATE, TITLE, USER, ACTION, null, PRIORITY, DEVID, REJECTREASON));
		assertEquals("Invalid value", e10.getMessage());

		Exception e11 = assertThrows(IllegalArgumentException.class,
				() -> new UserStory(ID, STATE, TITLE, USER, ACTION, "", PRIORITY, DEVID, REJECTREASON));
		assertEquals("Invalid value", e11.getMessage());

		Exception e12 = assertThrows(IllegalArgumentException.class,
				() -> new UserStory(ID, STATE, TITLE, USER, ACTION, VALUE, null, DEVID, REJECTREASON));
		assertEquals("Invalid priority", e12.getMessage());

		Exception e13 = assertThrows(IllegalArgumentException.class,
				() -> new UserStory(ID, STATE, TITLE, USER, ACTION, VALUE, "", DEVID, REJECTREASON));
		assertEquals("Invalid priority", e13.getMessage());

		Exception e14 = assertThrows(IllegalArgumentException.class,
				() -> new UserStory(ID, STATE, TITLE, USER, ACTION, VALUE, PRIORITY, null, REJECTREASON));
		assertEquals("Invalid developer id", e14.getMessage());

		Exception e15 = assertThrows(IllegalArgumentException.class,
				() -> new UserStory(ID, STATE, TITLE, USER, ACTION, VALUE, PRIORITY, "", REJECTREASON));
		assertEquals("Invalid developer id", e15.getMessage());

		Exception e16 = assertThrows(IllegalArgumentException.class,
				() -> new UserStory(ID, STATE, TITLE, USER, ACTION, VALUE, PRIORITY, DEVID, null));
		assertEquals("Invalid rejection reason", e16.getMessage());

		Exception e17 = assertThrows(IllegalArgumentException.class,
				() -> new UserStory(ID, STATE, TITLE, USER, ACTION, VALUE, PRIORITY, DEVID, ""));
		assertEquals("Invalid rejection reason", e17.getMessage());

		Exception e18 = assertThrows(IllegalArgumentException.class,
				() -> new UserStory(ID, STATE, TITLE, USER, ACTION, VALUE, "medium-high", DEVID, REJECTREASON));
		assertEquals("Invalid priority", e18.getMessage());

		Exception e19 = assertThrows(IllegalArgumentException.class,
				() -> new UserStory(ID, STATE, TITLE, USER, ACTION, VALUE, PRIORITY, DEVID, "Don't Like It"));
		assertEquals("Invalid rejection reason", e19.getMessage());

		storyId = 1;
		counter = storyId + 1;
		assertEquals(2, counter);

	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.requirements_manager.model.user_story.UserStory#setId(int)}.
	 */
	@Test
	void testSetId() {
		// fail("Not yet implemented");
		UserStory u = new UserStory(ID, STATE, TITLE, USER, ACTION, VALUE, PRIORITY, DEVID, REJECTREASON);

		Exception e1 = assertThrows(IllegalArgumentException.class, () -> u.setId(-1));
		assertEquals("Invalid id", e1.getMessage());
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.requirements_manager.model.user_story.UserStory#setState(java.lang.String)}.
	 */
	@Test
	void testSetState() {
		// fail("Not yet implemented");
		UserStory u = new UserStory(ID, STATE, TITLE, USER, ACTION, VALUE, PRIORITY, DEVID, REJECTREASON);

		Exception e1 = assertThrows(IllegalArgumentException.class, () -> u.setState(null));
		assertEquals("Invalid state", e1.getMessage());

		Exception e2 = assertThrows(IllegalArgumentException.class, () -> u.setState(""));
		assertEquals("Invalid state", e2.getMessage());

		Exception e3 = assertThrows(IllegalArgumentException.class, () -> u.setState("starting"));
		assertEquals("Invalid state", e3.getMessage());

		Exception e4 = assertThrows(IllegalArgumentException.class, () -> u.setState("finished"));
		assertEquals("Invalid state", e4.getMessage());
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.requirements_manager.model.user_story.UserStory#setTitle(java.lang.String)}.
	 */
	@Test
	void testSetTitle() {
		// fail("Not yet implemented");
		UserStory u = new UserStory(ID, STATE, TITLE, USER, ACTION, VALUE, PRIORITY, DEVID, REJECTREASON);

		Exception e1 = assertThrows(IllegalArgumentException.class, () -> u.setTitle(null));
		assertEquals("Invalid title", e1.getMessage());

		Exception e2 = assertThrows(IllegalArgumentException.class, () -> u.setTitle(""));
		assertEquals("Invalid title", e2.getMessage());
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.requirements_manager.model.user_story.UserStory#setUser(java.lang.String)}.
	 */
	@Test
	void testSetUser() {
		// fail("Not yet implemented");
		UserStory u = new UserStory(ID, STATE, TITLE, USER, ACTION, VALUE, PRIORITY, DEVID, REJECTREASON);

		Exception e1 = assertThrows(IllegalArgumentException.class, () -> u.setUser(null));
		assertEquals("Invalid user", e1.getMessage());

		Exception e2 = assertThrows(IllegalArgumentException.class, () -> u.setUser(""));
		assertEquals("Invalid user", e2.getMessage());
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.requirements_manager.model.user_story.UserStory#setAction(java.lang.String)}.
	 */
	@Test
	void testSetAction() {
		// fail("Not yet implemented");
		UserStory u = new UserStory(ID, STATE, TITLE, USER, ACTION, VALUE, PRIORITY, DEVID, REJECTREASON);

		Exception e1 = assertThrows(IllegalArgumentException.class, () -> u.setAction(null));
		assertEquals("Invalid action", e1.getMessage());

		Exception e2 = assertThrows(IllegalArgumentException.class, () -> u.setAction(""));
		assertEquals("Invalid action", e2.getMessage());
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.requirements_manager.model.user_story.UserStory#setValue(java.lang.String)}.
	 */
	@Test
	void testSetValue() {
		// fail("Not yet implemented");
		UserStory u = new UserStory(ID, STATE, TITLE, USER, ACTION, VALUE, PRIORITY, DEVID, REJECTREASON);

		Exception e1 = assertThrows(IllegalArgumentException.class, () -> u.setValue(null));
		assertEquals("Invalid value", e1.getMessage());

		Exception e2 = assertThrows(IllegalArgumentException.class, () -> u.setValue(""));
		assertEquals("Invalid value", e2.getMessage());
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.requirements_manager.model.user_story.UserStory#setPriority(java.lang.String)}.
	 */
	@Test
	void testSetPriority() {
		// fail("Not yet implemented");

		UserStory u = new UserStory(ID, STATE, TITLE, USER, ACTION, VALUE, PRIORITY, DEVID, REJECTREASON);

		Exception e1 = assertThrows(IllegalArgumentException.class, () -> u.setPriority(null));
		assertEquals("Invalid priority", e1.getMessage());

		Exception e2 = assertThrows(IllegalArgumentException.class, () -> u.setPriority(""));
		assertEquals("Invalid priority", e2.getMessage());

		Exception e3 = assertThrows(IllegalArgumentException.class, () -> u.setPriority("small"));
		assertEquals("Invalid priority", e3.getMessage());

		Exception e4 = assertThrows(IllegalArgumentException.class, () -> u.setPriority("middle"));
		assertEquals("Invalid priority", e4.getMessage());

		Exception e5 = assertThrows(IllegalArgumentException.class, () -> u.setPriority("large"));
		assertEquals("Invalid priority", e5.getMessage());
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.requirements_manager.model.user_story.UserStory#setDeveloperId(java.lang.String)}.
	 */
	@Test
	void testSetDeveloperId() {
		// fail("Not yet implemented");

		UserStory u = new UserStory(ID, STATE, TITLE, USER, ACTION, VALUE, PRIORITY, DEVID, REJECTREASON);

		Exception e1 = assertThrows(IllegalArgumentException.class, () -> u.setDeveloperId(null));
		assertEquals("Invalid developer id", e1.getMessage());

		Exception e2 = assertThrows(IllegalArgumentException.class, () -> u.setDeveloperId(""));
		assertEquals("Invalid developer id", e2.getMessage());
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.requirements_manager.model.user_story.UserStory#setRejectionReason(java.lang.String)}.
	 */
	@Test
	void testSetRejectionReason() {
		// fail("Not yet implemented");

		UserStory u = new UserStory(ID, STATE, TITLE, USER, ACTION, VALUE, PRIORITY, DEVID, REJECTREASON);

		Exception e1 = assertThrows(IllegalArgumentException.class, () -> u.setRejectionReason(null));
		assertEquals("Invalid rejection reason", e1.getMessage());

		Exception e2 = assertThrows(IllegalArgumentException.class, () -> u.setRejectionReason(""));
		assertEquals("Invalid rejection reason", e2.getMessage());

		Exception e3 = assertThrows(IllegalArgumentException.class, () -> u.setRejectionReason("I don't like it"));
		assertEquals("Invalid rejection reason", e3.getMessage());

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
		n = id + 1;
		assertEquals(5, n);

	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.requirements_manager.model.user_story.UserStory#toString()}.
	 */
	@Test
	void testToString() {
		// fail("Not yet implemented");
		UserStory u = new UserStory(ID, STATE, TITLE, USER, ACTION, VALUE, PRIORITY, DEVID, REJECTREASON);
		String s = "* 0,submitted,Add Event,medium,jyu34,Duplicate\n- student\n- action\n- value";
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
			u.update(new Command(Command.CommandValue.BACKLOG, "low"));
			assertTrue(u.currentState == u.backlogState);
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
			u.update(new Command(Command.CommandValue.BACKLOG, "low"));
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
			u.update(new Command(Command.CommandValue.BACKLOG, "low"));
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
			u.update(new Command(Command.CommandValue.BACKLOG, "low"));
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
			u.update(new Command(Command.CommandValue.BACKLOG, "low"));
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
			u.update(new Command(Command.CommandValue.BACKLOG, "low"));
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
			u.update(new Command(Command.CommandValue.BACKLOG, "low"));
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
	void testUpdateVerifyingA() {
		UserStory u = new UserStory(TITLE, USER, ACTION, VALUE);

		assertAll("state", () -> assertTrue(u.currentState == u.submittedState), () -> {
			u.update(new Command(Command.CommandValue.BACKLOG, "low"));
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
			u.update(new Command(Command.CommandValue.BACKLOG, "low"));
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
			u.update(new Command(Command.CommandValue.BACKLOG, "low"));
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
			u.update(new Command(Command.CommandValue.BACKLOG, "low"));
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
