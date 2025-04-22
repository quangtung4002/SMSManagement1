/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import Node.CustomerNode;
import model.Customer;
/**
 *
 * @author LAPTOP
 */
public class CustomerList {

    public CustomerNode head, tail;

    public CustomerList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    public void clear() {
        head = tail = null;
    }

    public void addLast(Customer x) {
        CustomerNode q = new CustomerNode(x);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        tail.next = q;
        tail = q;
    }

    public void visit(CustomerNode p) {
        if (p != null) {
            System.out.println(p.infor + " ");
        }
    }

    public void traverse() {
        CustomerNode p = head;
        while(p != null){
            visit(p);
            p = p.next;
        }
    }
    
    public void addMany(String[] c, String[] n, String[] p){
        int amount = c.length;
        for(int i = 0; i < amount; i++){
            addLast(new Customer(c[i], n[i], p[i]));
        }
    }
    
    public CustomerNode searchCcode(String code){
        CustomerNode t = head;
        while(t != null){
            if( t.infor.ccode.equalsIgnoreCase(code)) return t;
            t = t.next;
        }
        return null;
    }
    public CustomerNode searchName(String name){
        CustomerNode t = head;
        while(t != null){
            if( t.infor.name.equalsIgnoreCase(name)) return t;
            t = t.next;
        }
        return null;
    }
    
    public void removeFirst() {
        if (isEmpty()) {
            return;
        }
        head = head.next;
        if (head == null) {
            tail = null;
        }
    }
    public void remove(CustomerNode q) {
        if (isEmpty() || q == null) {
            return;
        }
        if (q == head) {
            removeFirst();
            return;
        }
        CustomerNode f = head;
        while (f != null && f.next != q) {
            f = f.next;
        }
        if (f == null) {
            return; ///q ko có trong danh sách
        }
        f.next = q.next;
        q.next = null;
        if (f.next == null) {
            tail = f;
        }
    }
    
    public void remove(String code) {
        CustomerNode q = searchCcode(code);
        remove(q);
    }
    
    public void searchUnshippedOrdersByCcode(String ccode) {
        System.out.println("Check OrderList for unshipped orders with customer code: " + ccode);
    }

    public boolean isValidPhone(String phone) {
        for (int i = 0; i < phone.length(); i++)
            if (!Character.isDigit(phone.charAt(i))) return false;
        return true;
    }

    public boolean isDuplicate(String ccode, String phone) {
        CustomerNode curr = head;
        while (curr != null) {
            if (curr.infor.ccode.equalsIgnoreCase(ccode) || curr.infor.phone.equals(phone))
                return true;
            curr = curr.next;
        }
        return false;
    }    
    
}
