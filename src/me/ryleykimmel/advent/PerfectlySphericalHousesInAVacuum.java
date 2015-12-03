package me.ryleykimmel.advent;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

public final class PerfectlySphericalHousesInAVacuum extends Day<String> {

	public PerfectlySphericalHousesInAVacuum(String title) {
		super(title, FileUtil.readInput(title));
	}

	private int visitedPoints(boolean robot) {
		Set<Point> visited = new HashSet<>();
		visited.add(new Point(0, 0));

		Point santaLocation = new Point(0, 0);
		Point robotLocation = new Point(0, 0);

		for (int index = 0, length = input.length(); index < length; index++) {
			Point next = getNext(input.charAt(index));
			Point point = !robot || index % 2 == 0 ? santaLocation : robotLocation;
			point.translate(next.x, next.y);
			visited.add(point.getLocation());
		}

		return visited.size();
	}

	private Point getNext(char character) {
		int x = 0, y = 0;
		switch (character) {
		case '>':
			x++;
			break;
		case '^':
			y++;
			break;
		case '<':
			x--;
			break;
		case 'v':
			y--;
			break;
		}
		return new Point(x, y);
	}

	@Override
	public String getAnswer() {
		return visitedPoints(false) + ", " + visitedPoints(true);
	}

}