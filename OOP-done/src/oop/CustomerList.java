package oop;
import java.util.Scanner;
import java.util.Vector;

public class CustomerList {
    Scanner sc = new Scanner(System.in);
    private Vector<Person> cl;
    public Vector<Person> getCl() {
        return cl;
    }
    public CustomerList() {
        this.cl = new Vector<>();
    }
    public CustomerList(Vector<Person> cl) {
        this.cl = new Vector<>();
        this.cl.addAll(cl);
    }  
    public void insert(Person copy) {
        cl.add(copy);
    }
    public void insert() {
        Person newCustomer;
         newCustomer = new Customer();
        
        newCustomer.getInformation();
        cl.add(newCustomer);
    }
    public void select() {
        String id;
        System.out.print("Enter id to search: ");
        id = sc.nextLine();
        select(id);
    }
    public void select(String id) {
        boolean flag = false;
        for (Person i : cl) {
            if (i.getId().equals(id)) {
                i.showInformation();
                flag = true;
            }
        }
        if (flag == false) {
            System.out.println("Not found");
        }
    }
    public int selectId(String id) {
        for (Person i : cl) {
            if (i.getId().equals(id)) {
                return cl.indexOf(i);
            }
        }
        return -1;
    }
    public void delete() {
        String id;
        System.out.print("Enter id to delete: ");
        id = sc.nextLine();
        delete(id);
    }
    public void delete(String id) {
        for (Person i : cl) {
            if (i.getId().equals(id)) {
                cl.remove(i);
                System.out.println("Deletion complete");
                return;
            }
        }
    }
    public void update() {
        String id;
        System.out.print("Enter id to update: ");
        id = sc.nextLine();
        update(id);
    }
    public void update(String id) {
        for (Person i : cl) {
            if (i.getId().equals(id)) {
                i.getInformation();
                return;
            }
        }
    }
    public void display() {
        cl.forEach((action) -> action.showInformation());
    }
    @Override
    public String toString() {
        String tmp = "";
        for (Person i : cl) {
            tmp = tmp + i.toStringForWriteFile() + "\n";
        }
        return tmp;
    }
}
