package me.ryleykimmel.advent;

import java.util.HashSet;
import java.util.Set;

import com.google.common.collect.ImmutableSet;

public final class AdventOfCode {

	private final Set<Day<?>> days = new HashSet<>();

	public void init() {
		days.add(new NotQuiteLisp("Day 1 - Not Quite Lisp"));
		days.add(new IWasToldThereWouldBeNoMath("Day 2 - I Was Told There Would Be No Math"));
		days.add(new PerfectlySphericalHousesInAVacuum("Day 3 - Perfectly Spherical Houses in a Vacuum"));
	}

	public static void main(String[] args) {
		AdventOfCode adventOfCode = new AdventOfCode();
		adventOfCode.init();

		for (Day<?> day : adventOfCode.getDays()) {
			System.out.println(day.getTitle() + " - " + day.getAnswer());
		}
	}

	public Set<Day<?>> getDays() {
		return days;
	}

}