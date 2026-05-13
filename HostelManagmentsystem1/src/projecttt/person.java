/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projecttt;

/**
 *
 * @author Hp
 */
abstract class person {

    private int id;
    private String name;
    private int contact;

    public person(int id, String name, int contact) {
        this.id = id;
        this.name = name;
        this.contact = contact;
    }

    public int getid() {
        return id;
    }

    public String getname() {
        return name;
    }

    public int getcontact() {
        return contact;
    }

    public void setid(int id) {
        this.id = id;
    }

    public void setname(String name) {
        this.name = name;
    }

    public void setcontact(int contact) {
        this.contact = contact;
    }

    abstract void display();
}
    

