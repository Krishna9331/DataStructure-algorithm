package parkinglot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mishrk3 on 7/20/2016.
 */
public class Lot {

	private static Lot lot = null;

	private static final int SMALL_SLOT = 10;
	private static final int COMPACT_SLOT = 10;
	private static final int LARGE_SLOT = 10;

	public Map<Integer, Slot> occupiedSlot;
	private List<Slot> smallSlot;
	private List<Slot> compactSlot;
	private List<Slot> largeSlot;

	private Lot() {
		smallSlot = new ArrayList<>();
		compactSlot = new ArrayList<>();
		largeSlot = new ArrayList<>();

		occupiedSlot = new HashMap<>();

		for (int i = 1; i < SMALL_SLOT; i++) {
			smallSlot.add(new Slot(i, 1));
		}
		for (int i = 1; i < COMPACT_SLOT; i++) {
			compactSlot.add(new Slot(i, 2));
		}
		for (int i = 1; i < LARGE_SLOT; i++) {
			largeSlot.add(new Slot(i, 3));
		}
	}

	public List<Slot> getSmallSlot() {
		return smallSlot;
	}

	public List<Slot> getCompactSlot() {
		return compactSlot;
	}

	public List<Slot> getLargeSlot() {
		return largeSlot;
	}

	public static synchronized Lot getInstance() {
		if (lot == null) {
			lot = new Lot();
		}
		return lot;
	}
}
