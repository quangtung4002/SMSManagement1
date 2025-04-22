/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import controller.Linkedorder;
import controller.Linkedproject;
import controller.CustomerList;
import file.OrderFileReader;
import java.util.Scanner;


public class OrderMain {
    private Linkedorder ord;
    private Linkedproject productList;
    private CustomerList customerList;
    private OrderFileReader b;
    private String ordersFile = "orders.txt";

    public OrderMain(Linkedproject productList, CustomerList customerList) {
        this.productList = productList;
        this.customerList = customerList;
        this.ord = new Linkedorder(productList, customerList);
        this.b = new OrderFileReader();
        b.readOrdersFromFile(ordersFile, ord); 
    }

    public void select() {
        Scanner v = new Scanner(System.in);
        do {
            System.out.println("\nOrder List Functions:");
            System.out.println("1. Load data from file");
            System.out.println("2. Order book");
            System.out.println("3. Display data");
            System.out.println("4. Save order list to file");
            System.out.println("5. Sort by pcode + ccode");
            System.out.println("6. Ship order by pcode + ccode");
            System.out.println("0. Back to main menu");
            System.out.print("Choose an option: ");
            int choice = v.nextInt();
            v.nextLine();

            try {
                switch (choice) {
                    case 0:
                        return; 
                    case 1:
                        ord.clear();
                        b.readOrdersFromFile(ordersFile, ord);
                        ord.displayData();
                        break;
                    case 2:
                        b.insertData(ord, productList, customerList);
                        break;
                    case 3:
                        ord.displayData();
                        break;
                    case 4:
                        b.saveOrdersToFile(ordersFile, ord);
                        break;
                    case 5:
                        ord.sortByPcodeAndCcode();
                        break;
                    case 6:
                        System.out.print("Enter pcode: ");
                        String pcode = v.nextLine();
                        System.out.print("Enter ccode: ");
                        String ccode = v.nextLine();
                        ord.shipOrder(pcode, ccode);
                        break;
                    default:
                        System.out.println("Invalid option!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                v.nextLine();
            }
        } while (true);
    }
}
