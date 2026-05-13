package projecttt;

public class complaint {

    private int studentid;
    private int roomno;
    private String text;
    private String status;

    public complaint(int studentid,int roomno,String text) {

        this.studentid = studentid;
        this.roomno = roomno;
        this.text = text;
        this.status = "pending";
    }
    public int getstudentid() {
        return studentid;
    }

    public int getroomno() {
        return roomno;
    }

    public String gettext() {
        return text;
    }
    public String getstatus() {
        return status;
    }

    public void setstatus(String status) {
        this.status = status;
    }
    void resolve() {

        status = "resolved";
    }
    void display() {

       System.out.println("Student ID: " + studentid + " Room No: " + roomno + " Complaint: " + text + " Status: " + status);
    }
}