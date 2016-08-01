package parkinglot;

/**
 * Created by mishrk3 on 7/20/2016.
 */
public class Slot {
	private final int id;
	private final int size;
	private boolean available;
	private Vehicle vehicle;

	public Slot(int id, int size) {
		this.id = id;
		this.size = size;
		available = true;
	}

	public void occupy(Vehicle v){
		this.vehicle = v;
		this.available = false;
	}

	public void release(){
		this.vehicle = null;
		this.available = true;
	}
}
