package me.ryleykimmel.advent;

public abstract class Day<T> {

	protected final String title;
	protected final T input;

	public Day(String title, T input) {
		this.title = title;
		this.input = input;
	}

	public abstract String getAnswer();

	public final String getTitle() {
		return title;
	}

	public final T getInput() {
		return input;
	}

}