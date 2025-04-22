/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import controller.Linkedproject;
import Node.Node;

import file.ProductFileReader;

import java.util.Scanner;
import model.Products;
import java.awt.Choice;
import java.util.InputMismatchException;

/**
 *
 * @author kien3
 */
public class remove {

    public Node head, tail;
    String filess = "products.txt";
    Linkedproject pro = new Linkedproject();
    ProductFileReader a = new ProductFileReader();

    public remove() {
        a.readProductsFromFile(filess, pro);
    }

    public void select() {

        System.out.println("select 1 funtion:");

        Scanner v = new Scanner(System.in);
        do {

            System.out.println("1.display");
            System.out.println("2.Add bengin or ends");
            System.out.println("3.Search by pcode <-> serach by name <-> Search ordered by pcode ");
            System.out.println("4.Delete by pcode");
            System.out.println("5.Sort by pcode");
            System.out.println("6.Add before position k <-> delete position k");

            try {
                int choice = v.nextInt();
                v.nextLine();
                switch (choice) {
                    case 1:
                        Node k = pro.head;
                        while (k != null) {
                            System.out.println("products: " + k.data);
                            k = k.next;
                        }

                        break;

                    case 2:
                        addend();
                        break;
                    case 3:
                        System.out.println("Enter pcode or name :");
                        Scanner p = new Scanner(System.in);
                        String l = p.nextLine();
                        pro.sereach(pro, l);
                        break;
                    case 4:
                        System.out.println("Enter Pcode :");
                        Scanner z = new Scanner(System.in);
                        String i = z.nextLine();
                        Node deles = pro.sereach(pro, i);
                        pro.delete(deles);
                        pro.saveToFile(filess);
                        break;
                    case 5:

                        pro.sort();
                        Node ko = pro.head;
                        while (ko != null) {
                            System.out.println("products: " + ko.data);
                            ko = ko.next;
                        }
                        pro.saveToFile(filess);

                        break;

                    case 6:
                        addanddelePos();
                        break;

                }

            } catch (Exception e) {
                System.out.println("sai dinh dang hoac lua chon!");
                v.nextLine();
            }

        } while (true);

    }

    public void addend() {
        Scanner n = new Scanner(System.in);

        int choice = 0;
        do {
            System.out.println("1. addFirst");
            System.out.println("2. addLast");
            System.out.println("3.exit!");
            try {
                choice = n.nextInt();
                switch (choice) {

                    case 1:
                        Products add = a.insertData(pro);
                        if (add != null) {
                            pro.addFisrt(add);
                            pro.saveToFile(filess);
                        }
                        break;
                    case 2:
                        Products end = a.insertData(pro);
                        if (end != null) {
                            pro.addLast(end);
                            pro.saveToFile(filess);
                        }
                        break;
                    case 3:
                        return;

                    default:
                        throw new AssertionError();
                }

            } catch (Exception e) {
                System.out.println("sai dinh dang!");
                break;
            }

        } while (true);
    }

    public void addanddelePos() {
        Scanner y = new Scanner(System.in);
        do {
            System.out.println("1.Add before position k");
            System.out.println("2.delete position k");
            System.out.println("3.exit!");

            try {
                int choice = y.nextInt();
                switch (choice) {

                    case 1:
                        System.out.println("Enter position :");
                        Scanner o = new Scanner(System.in);
                        int n = o.nextInt();
                        o.nextLine();
                        System.out.println("enter product:");
                        Products s = a.insertData(pro);
                        pro.insertAfter(s, n);
                        pro.saveToFile(filess);
                        break;

                    case 2:
                        System.out.println("Enter positon :");
                        Scanner z = new Scanner(System.in);
                        int l = z.nextInt();

                        pro.deleteBypos(l);
                        pro.saveToFile(filess);

                        break;
                    case 3:
                        return;

                    default:
                        throw new AssertionError();
                }

            } catch (InputMismatchException e) {
                System.out.println("sai dinh dang!");
                break;
            }

        } while (true);

    }

}
