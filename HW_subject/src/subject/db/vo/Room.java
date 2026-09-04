package subject.db.vo;

public class Room {
	private int roomNo;
	private int capacity;
	public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	@Override
	public String toString() {
		return "Room [roomNo=" + roomNo + ", capacity=" + capacity + "]";
	}
	public Room(int roomNo, int capacity) {
		super();
		this.roomNo = roomNo;
		this.capacity = capacity;
	}

	
}
