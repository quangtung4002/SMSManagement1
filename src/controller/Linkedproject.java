/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Node.Node;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import model.Products;

/**
 *
 * @author kien3
 */
public class Linkedproject {

    public Node head, tail;

    /**
     *
     */
    boolean isEmpty() {
        return (head == null);
    }

    public void clear() {
        head = tail = null;
    }

    public void addLast(Products p) {
        if (isEmpty()) {
            head = tail = new Node(p);

        } else {
            Node q = new Node(p);
            tail.next = q;
            tail = q;

        }
    }

    public void visit(Node p) {
        System.out.println(p.data + " ");

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

    public void addFisrt(Products o) {
        if (isEmpty()) {
            head = tail = new Node(o);

        } else {
            Node l = new Node(o);
            l.next = head;
            head = l;

        }

    }

    public Node sereach(Linkedproject a, String u) {
        Node p = a.head;
        while (p.next != null) {
            Products k = (Products) p.data;
            if (k.getPcode().equals(u) || k.getName().equals(u)) {
                System.out.println(" tim thay :" + p.data);
                return p;
            }
            p = p.next;

        }
        System.out.println(" ko tim thay");
        return null;

    }

    public void delete(Node p) {
        if (head == null || p == null) {
            return;
        }
        if (p == head) {
            System.out.println("da xoa node:" + p.data);
            head = head.next;
            return;

        }
        Node pre = head;
        while (pre != null && pre.next != p) {
            pre = pre.next;
        }
        if (pre == null) {
            System.out.println("khong tim thay!");
            return;
        } else {
            pre.next = p.next;
            System.out.println("da xoa node:" + p.data);
        }

    }

    public void deleteBypos(int p) {
        Node r = head;
        if (p < 1) {
            return;
        }
        int count = 1;
        while (r != null) {

            if (count == p) {
                delete(r);

            }

            r = r.next;
            count++;
        }

    }

    public void insertAfter(Products x, int k) {
        if (k <= 0 || head == null) {
            addFisrt(x);
            return;
        }
        Node j = head;
        int pos = 1;
        while (j != null && pos < k) {
            j = j.next;
            pos++;
        }
        if (j.next == null) {
            addLast(x);
            return;
        } else {
            Node newNode = new Node(x);
            newNode.next = j.next;
            j.next = newNode;

        }

    }

    public void sort() {
        if (head == null || head.next == null) {
            return;
        }
        boolean vali;
        do {
            Node ne = head;
            vali = false;
            while (ne != null && ne.next != null) {
                Products t = (Products) ne.data;
                Products l = (Products) ne.next.data;

                if (t.getPcode().compareTo(l.getPcode()) > 0) {
                    Products temp = t;
                    ne.data = l;
                    ne.next.data = temp;
                    vali = true;
                }

                ne = ne.next;
            }

        } while (vali);
        System.out.println("da xap xep!");
    }

    public void saveToFile(String filePath) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            Node p = head;
            while (p != null) {
                Products prod = (Products) p.data;
                bw.write(prod.getPcode() + "," + prod.getName() + "," + prod.getMaker() + ","
                        + prod.getUnit() + "," + prod.getCategory() + "," + prod.getQuantity() + ","
                        + prod.getSaled() + "," + prod.getPrice());
                bw.newLine();
                p = p.next;
            }
            System.out.println("da cap nhat danh sach txt!");
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
        }
    }

}
