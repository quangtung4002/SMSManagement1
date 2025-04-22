/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Node.Node;
import model.Order;
import model.Products;
import model.Customer;
import java.util.Date;

public class Linkedorder {
    public Node head, tail;
    private Linkedproject productList;
    private CustomerList customerList;

    public Linkedorder(Linkedproject productList, CustomerList customerList) {
        this.head = null;
        this.tail = null;
        this.productList = productList;
        this.customerList = customerList;
    }

    public Linkedorder() {
    }

    boolean isEmpty() {
        return (head == null);
    }

    public void clear() {
        head = tail = null;
    }

    public void addLast(Order o) {
        if (isEmpty()) {
            head = tail = new Node(o);
        } else {
            Node q = new Node(o);
            tail.next = q;
            tail = q;
        }
    }

    public void addFirst(Order o) {
        if (isEmpty()) {
            head = tail = new Node(o);
        } else {
            Node l = new Node(o);
            l.next = head;
            head = l;
        }
    }
    
    public void visit(Node p) {
        Order order = (Order) p.data;
        Node productNode = productList.sereach(productList, order.getPcode());

        Products product = (productNode != null) ? (Products) productNode.data : null;
        double total = product != null ? product.getPrice() * order.getQuantity() : 0;
        System.out.println(order.getPcode() + "," + order.getCcode() + "," +
                order.getOdate() + "," + (order.getSdate() != null ? order.getSdate() : "null") + "," +
                order.getQuantity() + "," + total);
    }

    public String traverse() {
        Node p = head;
        while (p != null) {
            visit(p);
            p = p.next;
        }
        System.out.println();
        return null;
    }

    // 3.3 Display data
    public void displayData() {
        if (isEmpty()) {
            System.out.println("Order list is empty!");
           return;
        }

        System.out.println("Order List:");
        System.out.println("pcode,ccode,odate,sdate,quantity,total");
        traverse();
    }

    // 3.5 Sort by pcode + ccode
    public void sortByPcodeAndCcode() {
        if (head == null || head.getNext() == null) return;

        int size = 0;
        Node current = head;
        while (current != null) {
            size++;
            current = current.getNext();
        }

        Order[] orders = new Order[size];
        current = head;
        for (int i = 0; i < size; i++) {
            orders[i] = (Order) current.data;
            current = current.getNext();
        }

        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                String pcode1 = orders[j].getPcode();
                String pcode2 = orders[j + 1].getPcode();
                int compare = pcode2.compareTo(pcode1); 
                if (compare == 0) {
                    String ccode1 = orders[j].getCcode();
                    String ccode2 = orders[j + 1].getCcode();
                    compare = ccode2.compareTo(ccode1); 
                }
                if (compare > 0) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }

        head = tail = null;
        for (int i = 0; i < size; i++) {
            addLast(orders[i]);
        }

        displayData();
    }

    // 3.6 Ship order by pcode + ccode
    public void shipOrder(String pcode, String ccode) {
        Node current = head;
        while (current != null) {
            Order order = (Order) current.data;
            if (order.getPcode().equals(pcode) && order.getCcode().equals(ccode)) {
                if (order.getSdate() == null) {
                    order.setSdate(new Date());
                    System.out.println("Order shipped successfully!");
                    return;
                } else {
                    System.out.println("Order already shipped!");
                    return;
                }
            }
            current = current.getNext();
        }
        System.out.println("Order not found or already shipped!");
    }
}
