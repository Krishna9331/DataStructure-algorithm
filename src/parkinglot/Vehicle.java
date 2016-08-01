package parkinglot;

/**
 * Created by mishrk3 on 7/20/2016.
 */
public class Vehicle {

	private final int size;
	private final int licence;
	private boolean status;
	private Lot lot;

	public Vehicle(int size) {
		this.size = size;
		this.licence = this.hashCode();
		lot = lot.getInstance();
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	private Slot findSlot() {
		Slot slot;
		switch (this.size) {
		case 1:
			slot = lot.getSmallSlot().remove(0);
		case 2:
			slot = lot.getCompactSlot().remove(0);
		case 3:
			slot = lot.getSmallSlot().remove(0);
		default:
			slot = null;
		}
		return slot;
	}

	public void park() {
		Slot slot = findSlot();
		if (slot != null) {
			lot.occupiedSlot.put(this.licence, slot);
			slot.occupy(this);
		}
	}

	public void leave() {
		Slot slot = lot.occupiedSlot.remove(this.licence);
		slot.release();
		switch (this.size) {
		case 1:
			lot.getSmallSlot().add(slot);
		case 2:
			lot.getCompactSlot().add(slot);
		case 3:
			lot.getLargeSlot().add(slot);
		}
	}
}
