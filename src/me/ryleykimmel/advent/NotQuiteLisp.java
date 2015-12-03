package me.ryleykimmel.advent;

public final class NotQuiteLisp extends Day<String> {

	private static final int BASEMENT_FLOOR_ID = -1;

	public NotQuiteLisp(String title) {
		super(title, FileUtil.readInput(title));
	}

	@Override
	public String getAnswer() {
		int floor = 0, basement = 0;
		boolean enteredBasement = false;

		for (int index = 0, length = input.length(); index < length; index++) {
			char character = input.charAt(index);

			if (character == '(') {
				floor++;
			} else if (character == ')') {
				floor--;
			}

			if (floor == BASEMENT_FLOOR_ID && !enteredBasement) {
				basement = index + 1;
				enteredBasement = true;
			}
		}

		return floor + ", " + basement;
	}

}