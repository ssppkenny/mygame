package controllers;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

public class InputController {
	private Event _event;
	private static InputController _controller;

	private InputController() {

	}

	public static InputController getInstance() {
		if (_controller != null) {
			return _controller;
		} else {
			_controller = new InputController();
			return _controller;
		}
	}

	private List<Integer[]> findNbors(Event ev, int cx, int cy) {
		List<Integer[]> neighbors = new ArrayList<>();
		switch (ev) {
		case MOUSE_DOWN:
			handleMouseDown(cx, cy, neighbors);
			break;
		case KEY_LEFT:
			handleKeyLeft(cx, cy, neighbors);
			break;
		case KEY_RIGHT:
			handleKeyRight(cx, cy, neighbors);
			break;
		case KEY_UP:
			handleKeyUp(cx, cy, neighbors);
			break;
		case KEY_DOWN:
			handleKeyDown(cx, cy, neighbors);
			break;
		case KEY_S:
			handleKeyS(cx, cy, neighbors);
			break;
		default:
			handleUnknown(cx, cy, neighbors);
			break;
		}

		return neighbors;

	}

	private void handleKeyS(int cx, int cy, List<Integer[]> neighbors) {
		_event = Event.KEY_S;
	}

	private void handleUnknown(int cx, int cy, List<Integer[]> neighbors) {
		_event = Event.UNKNOWN;
	}

	private void handleKeyDown(int cx, int cy, List<Integer[]> neighbors) {
		if (cy - 1 > -1) {
			neighbors.add(new Integer[] { cx, cy - 1 });
		}
		_event = Event.KEY_DOWN;
	}

	private void handleKeyUp(int cx, int cy, List<Integer[]> neighbors) {
		if (cy + 1 < 4) {
			neighbors.add(new Integer[] { cx, cy + 1 });
		}
	}

	private void handleKeyRight(int cx, int cy, List<Integer[]> neighbors) {
		if (cx - 1 > -1) {
			neighbors.add(new Integer[] { cx - 1, cy });
		}
		_event = Event.KEY_RIGHT;
	}

	private void handleKeyLeft(int cx, int cy, List<Integer[]> neighbors) {
		if (cx + 1 < 4) {
			neighbors.add(new Integer[] { cx + 1, cy });
		}
		_event = Event.KEY_LEFT;
	}

	private void handleMouseDown(int cx, int cy, List<Integer[]> neighbors) {
		if (cx + 1 < 4)
			neighbors.add(new Integer[] { cx + 1, cy });
		if (cx - 1 > -1)
			neighbors.add(new Integer[] { cx - 1, cy });
		if (cy + 1 < 4)
			neighbors.add(new Integer[] { cx, cy + 1 });
		if (cy - 1 > -1)
			neighbors.add(new Integer[] { cx, cy - 1 });
		_event = Event.MOUSE_DOWN;
	}

	public List<Integer[]> dispatch(GameContainer container, Input input,
			int cx, int cy) {
		List<Integer[]> neighbors = new ArrayList<>();
		if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
			neighbors = findNbors(Event.MOUSE_DOWN, cx, cy);
		} else if (input.isKeyPressed(Input.KEY_LEFT)) {
			neighbors = findNbors(Event.KEY_LEFT, cx, cy);
		} else if (input.isKeyPressed(Input.KEY_RIGHT)) {
			neighbors = findNbors(Event.KEY_RIGHT, cx, cy);
		} else if (input.isKeyPressed(Input.KEY_UP)) {
			neighbors = findNbors(Event.KEY_UP, cx, cy);
		} else if (input.isKeyPressed(Input.KEY_DOWN)) {
			neighbors = findNbors(Event.KEY_DOWN, cx, cy);
		} else if (input.isKeyPressed(Input.KEY_S)) {
			neighbors = findNbors(Event.KEY_S, cx, cy);
		} else if (input.isKeyPressed(Input.KEY_ESCAPE)) {
			container.exit();
		}
		return neighbors;
	}

	public Event getEvent() {
		return _event;
	}

	public void setEvent(Event event) {
		_event = event;
	}

}
