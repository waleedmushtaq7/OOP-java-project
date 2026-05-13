package projecttt;

public class room {

    private int roomno;
    private int capacity;
    private String status;

    private student[] occupants;
    private int count;

    public room(int roomno, int capacity) {
        this.roomno = roomno;
        this.capacity = capacity;
        this.status = "available";

        occupants = new student[capacity];
        count = 0;
    }

    public int getroomno() {
        return roomno;
    }

    public int getcapacity() {
        return capacity;
    }

    public String getstatus() {
        return status;
    }

    public void setstatus(String status) {
        this.status = status;
    }

    public student[] getoccupants() {
        return occupants;
    }

    public void addstudent(student s) {

        for (int i = 0; i < capacity; i++) {

            if (occupants[i] == null) {
                occupants[i] = s;
                count++;
                status = "occupied";
                System.out.println("student assigned to room");
                return;
            }
        }

    }

    public void removestudent(int id) {

        for (int i = 0; i < capacity; i++) {

            if (occupants[i] != null &&occupants[i].getid() == id) {
                occupants[i] = null;
                count--;
            if (count == 0) {
                status = "available";
            } else {
                status = "occupied";
}
                System.out.println("student removed from room");
                return;
            }
        }

        System.out.println("student not found in this room");
    }
  public int getcount(){
        return count;
    }
    void display() {

        System.out.println("room: " + roomno + " ,capacity: " + capacity + " ,occupied: " + count + " ,status:" + status);
        for (int i = 0; i < capacity; i++) {
            if (occupants[i] != null) {
                System.out.println("id: " + occupants[i].getid() + " ,name: " + occupants[i].getname());
            }
        }
    }
}