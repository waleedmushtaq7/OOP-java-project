package projecttt;

import java.util.Scanner;
import java.io.*;

public class Hostel {

  public static void updateroomfile(room[] rooms, int roomcount) throws IOException {

    File f = new File("room.txt");
    FileWriter fw = new FileWriter(f);

    for (int i = 0; i < roomcount; i++) {

        fw.write("Room # " + rooms[i].getroomno() + ", Capacity: " + rooms[i].getcapacity() + ", Occupants id:  ");

        for (int j = 0; j < rooms[i].getcapacity(); j++) {

            if (rooms[i].getoccupants()[j] != null) {
                fw.write(rooms[i].getoccupants()[j].getid() + " ");
            }
                 }

        fw.write("\n");
    }

    fw.close();
}

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);

        student[] students = new student[50];
        room[] rooms = new room[20];
        complaint[] complaints = new complaint[50];

        int studentcount = 0;
        int roomcount = 0;
        int complaintcount = 0;

        int choice;

        do {

            System.out.println("\nHOSTEL MANAGEMENT SYSTEM");
            System.out.println("\nPress 1 to add student");
            System.out.println("Press 2 to show students");
            System.out.println("Press 3 to add room");
            System.out.println("Press 4 to show rooms");
            System.out.println("Press 5 to assign student to room");
            System.out.println("Press 6 to remove student from room");
            System.out.println("Press 7 to add complaint");
            System.out.println("Press 8 to show complaints");
            System.out.println("Press 0 to exit");

            choice = in.nextInt();
            in.nextLine();

            switch (choice) {

                case 1:
                        
                     System.out.print("Id: ");
                     int id = in.nextInt();
                     in.nextLine(); 
                     
                     int exists = 0;
                     
                     for (int i = 0; i < studentcount; i++) {
                         if (students[i].getid() == id) {
                             exists = 1;
                             break;
                         }
                     }

                     if (exists == 1) {
                         System.out.println("Student already exists with this id");
                         break;
                     }
                     else{
                     System.out.print("Name: ");
                     String name = in.nextLine();  

                     System.out.print("Contact: ");
                     int contact = in.nextInt();
                     in.nextLine();

                     System.out.print("Fee status: ");
                     String fee = in.nextLine();

                    students[studentcount] = new student(id, name, contact, fee);
                    studentcount++;

                    System.out.println("Student added");

                    File f1 = new File("Student.txt");

                    if (!f1.exists()) 
                        f1.createNewFile();
                    
                    FileWriter fw1 = new FileWriter(f1, true);

                    fw1.write("ID# " + id + ", Name: " + name + " ,Contact: " + contact + ", Fee Status: " + fee + "\n");

                    fw1.close();
                     }
                    break;

                case 2:

                    for (int i = 0; i < studentcount; i++) {
                        students[i].display();
                    }

                    try {

                        File f2 = new File("student.txt");
                        FileReader fr1 = new FileReader(f2);

                        int c1;

                        System.out.println("\nFile Data:\n");

                        while ((c1 = fr1.read()) != -1) {
                            System.out.print((char) c1);
                        }

                        fr1.close();

                    } catch (Exception e) {
                        System.out.println("No students added");
                    }

                    break;

                case 3:

                    System.out.print("Room no: ");
                    int rno = in.nextInt();
                    in.nextLine();

                    System.out.print("Capacity: ");
                    int cap = in.nextInt();
                    in.nextLine();

                    room r = new room(rno, cap);
                    rooms[roomcount] = r;
                    roomcount++;

                    System.out.println("Room added");

                    updateroomfile(rooms, roomcount);

                    break;

                case 4:

                    try {

                        for (int i = 0; i < roomcount; i++) {
                            rooms[i].display();
                        }

                        File f4 = new File("room.txt");
                        FileReader fr2 = new FileReader(f4);

                        int c2;

                        System.out.println("\nFile Data:\n");

                        while ((c2 = fr2.read()) != -1) {
                            
                            System.out.print((char) c2);
                        }

                        fr2.close();

                    } catch (Exception e) {
                        System.out.println("No rooms added");
                    }

                    break;

                case 5:

                     System.out.print("Student id: ");
                    int sid = in.nextInt();

                    System.out.print("Room no: ");
                    int roomno = in.nextInt();

                    in.nextLine();

                    student st = null;
                    room rm = null;

                    for (int i = 0; i < studentcount; i++) {
                        if (students[i].getid() == sid) {
                            st = students[i];
                            break;
                        }
                    }
                    for (int i = 0; i < roomcount; i++) {
                        if (rooms[i].getroomno() == roomno) {
                            rm = rooms[i];
                            break;
                        }
                    }
                     if (st == null) {
                        System.out.println("Student not found");
                        break;
                    }

                    if (rm == null) {
                        System.out.println("Room not found");
                        break;
                    }

                    int alreadyinroom = 0;

                    for (int i = 0; i < rm.getcapacity(); i++) {
                        
                        
                        if (rm.getoccupants()[i] != null && rm.getoccupants()[i].getid() == sid) {
                            alreadyinroom = 1;
                            break;
                        }
                    }

                    if (alreadyinroom == 1) {
                        System.out.println("Student already assigned to this room");
                        break;
                    }

                    int inanotherroom = 0;

                    for (int i = 0; i < roomcount; i++) {
                        room temp = rooms[i];

                        for (int j = 0; j < temp.getcapacity(); j++) {
                            if (temp.getoccupants()[j] != null &&temp.getoccupants()[j].getid() == sid) {

                                inanotherroom = 1;
                                break;
                            }
                        }
                        if (inanotherroom == 1) break;
                    }
                    if (inanotherroom == 1) {
                        System.out.println("Student already assigned to another room");
                        break;
                                        }
                    int occupied = 0;

                    for (int i = 0; i < rm.getcapacity(); i++) {
                        if (rm.getoccupants()[i] != null) {
                            occupied++;
                        }
                    }

                    if (occupied >= rm.getcapacity()) {
                        System.out.println("Room is full. Cannot assign student.");
                        break;
}
                    rm.addstudent(st);
                    updateroomfile(rooms, roomcount);

                    File f5 = new File("assignments.txt");
                    if (!f5.exists()) 
                        f5.createNewFile();

                    FileWriter fw3 = new FileWriter(f5, true);
                    fw3.write("Student ID: " + sid + " assigned to Room: " + roomno + "\n");
                    fw3.close();

                    System.out.println("Student assigned successfully");

                    break;
                case 6:

                    System.out.print("Room no: ");
                    int rno2 = in.nextInt();

                    System.out.print("Sudent id: ");
                    int sid2 = in.nextInt();

                    in.nextLine();

                    room rm2 = null;

                    for (int i = 0; i < roomcount; i++) {
                        if (rooms[i].getroomno() == rno2) {
                            rm2 = rooms[i];
                            break;
                        }
                    }
                    if (rm2 == null) {
                        System.out.println("Room not found");
                    } else {
                        rm2.removestudent(sid2);
                        updateroomfile(rooms, roomcount);

                        File f6 = new File("removed.txt");
                        if (!f6.exists()) f6.createNewFile();

                        FileWriter fw4 = new FileWriter(f6, true);

                        fw4.write("Student ID: " + sid2 + " removed from Room:" + rno2 + "\n");

                        fw4.close();
                    }

                    break;

                case 7:

                    System.out.print("Student id: ");
                    int sid3 = in.nextInt();
                    in.nextLine();

                    student st3 = null;

                    for (int i = 0; i < studentcount; i++) {
                        if (students[i].getid() == sid3) {
                            st3 = students[i];
                            break;
                        }
                    }
                    if (st3 == null) {
                        System.out.println("Sudent not found");
                        break;
                    }

                    System.out.print("Room no: ");
                    int rno3 = in.nextInt();
                    in.nextLine();

                    room rm3 = null;

                    for (int i = 0; i < roomcount; i++) {
                        if (rooms[i].getroomno() == rno3) {
                            rm3 = rooms[i];
                            break;
                        }
                    }

                    if (rm3 == null) {
                        System.out.println("Room not found");
                        break;
                    }


                    int found = 0;

                    for (int i = 0; i < rm3.getcapacity(); i++) {
                        if (rm3.getoccupants()[i] != null && rm3.getoccupants()[i].getid() == sid3) {
                            found = 1;
                            break;
                        }
                    }

                    if (found == 0) {
                        System.out.println("student not assigned to this room");
                        break;
                    }
                    
                    System.out.print("complaint: ");
                    String text = in.nextLine();

                    complaints[complaintcount] = new complaint(sid3, rno3, text);
                    complaintcount++;

                    System.out.println("Complaint added");

                    File f7 = new File("complaints.txt");
                    if
                        (!f7.exists()) {
                        
                        f7.createNewFile();
                    }
                    FileWriter fw5 = new FileWriter(f7, true);

                    fw5.write("Student ID: " + sid3 + " Room No: " + rno3 + " Complaint: " + text + "\n");

                    fw5.close();

                    break;

                case 8:

                    for (int i = 0; i < complaintcount; i++) {
                        complaints[i].display();
                    }
                    try {

                        File f8 = new File("complaints.txt");
                        FileReader fr3 = new FileReader(f8);

                        int c3;

                        System.out.println("\nFile Data:\n");

                        while ((c3 = fr3.read()) != -1) {
                            System.out.print((char) c3);
                        }

                        fr3.close();

                    } catch (Exception e) {
                        System.out.println("No complaint data");
                    }

                    for (int i = 0; i < roomcount; i++) {

                        int found1 = 0;

                        for (int j = 0; j < complaintcount; j++) {

                            if (rooms[i].getroomno() == complaints[j].getroomno()) {
                                found1 = 1;
                            }
                        }

                        if (found1 == 1) {
                            System.out.println("Room " + rooms[i].getroomno() + " has complaint");
                        }
                    }
                    break;
                case 0:
                    System.out.println("Program ended");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 0);

        in.close();
    }
}