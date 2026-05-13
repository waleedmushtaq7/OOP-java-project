/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projecttt;

/**
 *
 * @author Hp
 */
class student extends person {

    private String feestatus;

    public student(int id, String name, int contact, String feestatus) {
        super(id, name, contact);
        this.feestatus = feestatus;
    }

    public String getfeestatus() {
        return feestatus;
    }

    public void setfeestatus(String feestatus) {
        this.feestatus = feestatus;
    }

    void display() {
        System.out.println("id: " + getid() +" name: " + getname() +" contact: " + getcontact() + " fee: " + feestatus);
    }
}
    
