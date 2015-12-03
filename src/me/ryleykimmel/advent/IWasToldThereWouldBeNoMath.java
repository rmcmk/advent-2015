package me.ryleykimmel.advent;

import java.util.HashSet;
import java.util.Set;

import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.primitives.Ints;

public final class IWasToldThereWouldBeNoMath extends Day<Set<IWasToldThereWouldBeNoMath.Prism>> {

	public IWasToldThereWouldBeNoMath(String title) {
		super(title, new HashSet<>());
		init();
	}

	private void init() {
		FileUtil.readAllLines(title).stream().forEach(line -> input.add(new Prism(Splitter.on("x").
				splitToList(line).stream().mapToInt(Integer::parseInt).toArray())));
	}

	@Override
	public String getAnswer() {
		int neededWrappingPaper = input.stream().mapToInt(IWasToldThereWouldBeNoMath::neededWrappingPaper).sum();
		int neededRibbon = input.stream().mapToInt(IWasToldThereWouldBeNoMath::neededRibbon).sum();
		return neededWrappingPaper + ", " + neededRibbon;
	}

	private static int neededWrappingPaper(Prism prism) {
		return 2 * (prism.getTopArea() + prism.getSideArea() + prism.getFrontArea()) + prism.getSmallestSide();
	}

	private static int neededRibbon(Prism prism) {
		return 2 * (prism.getLength() + prism.getWidth() + prism.getHeight())
				- 2 * Ints.max(prism.getLength(), prism.getWidth(), prism.getHeight()) + prism.getVolume();
	}

	protected static final class Prism {
		private final int length;
		private final int width;
		private final int height;

		public Prism(int length, int width, int height) {
			this.length = length;
			this.width = width;
			this.height = height;
		}

		public Prism(int[] attrs) {
			Preconditions.checkNotNull(attrs, "attrs may not be null!");
			Preconditions.checkArgument(attrs.length == 3, "Invalid length " + attrs.length + " expected: 3");

			this.length = attrs[0];
			this.width = attrs[1];
			this.height = attrs[2];
		}

		public int getLength() {
			return length;
		}

		public int getWidth() {
			return width;
		}

		public int getHeight() {
			return height;
		}

		public int getTopArea() {
			return length * width;
		}

		public int getSideArea() {
			return width * height;
		}

		public int getFrontArea() {
			return length * height;
		}

		public int getSmallestSide() {
			return Ints.min(getTopArea(), getSideArea(), getFrontArea());
		}

		public int getVolume() {
			return length * width * height;
		}

	}

}