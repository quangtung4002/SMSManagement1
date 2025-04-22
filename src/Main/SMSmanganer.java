/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;
import controller.Linkedorder;
import controller.CustomerList;
import controller.Linkedproject;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import model.Customer;
import model.Products;

/**
 *
 * @author kien3
 */
public class SMSmanganer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        remove m = new remove();
        Scanner r = new Scanner(System.in);
        
        Linkedproject productList = new Linkedproject();
        CustomerList customerList = new CustomerList();
        loadProducts(productList);
        OrderMain orderManager = new OrderMain(productList, customerList);
        Scanner sc = new Scanner(System.in);
        do {

            System.out.println("1.Product");
            System.out.println("2.Customer");
            System.out.println("3.Order");
            try {

                int choice = r.nextInt();
                r.nextLine();
                switch (choice) {

                    case 1:
                        m.select();
                        break;
                    case 2:
                        
                        break;
                    case 3:
                        orderManager.select();
                        break;
                    default:
                        throw new AssertionError();
                }

            } catch (Exception e) {
                System.out.println("lua tron lai!");
                r.nextLine();
            }

        } while (true);
    }
    private static void loadProducts(Linkedproject productList) {
        try (BufferedReader reader = new BufferedReader(new FileReader("products.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 8) {
                    try {
                        String pcode = parts[0].trim();
                        String name = parts[1].trim();
                        String maker = parts[2].trim();
                        String unit = parts[3].trim();
                        String category = parts[4].trim();
                        int quantity = Integer.parseInt(parts[5].trim());
                        int saled = Integer.parseInt(parts[6].trim());
                        double price = Double.parseDouble(parts[7].trim());

                        Products product = new Products(pcode, name, maker, unit, category, quantity, saled, price);
                        productList.addLast(product);
                    } catch (NumberFormatException e) {
                        System.out.println("Lỗi định dạng số: " + line);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Lỗi đọc file products.txt: " + e.getMessage());
        }
    }
    
    private static void loadCustomers(CustomerList customerList) {
        try (BufferedReader reader = new BufferedReader(new FileReader("customers.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    try {
                        String ccode = parts[0].trim();
                        String name = parts[1].trim();
                        String phone = parts[2].trim();

                        Customer customer = new Customer(ccode, name, phone);
                        customerList.addLast(customer);
                    } catch (Exception e) {
                        System.out.println("Lỗi định dạng dòng: " + line);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Lỗi đọc file customers.txt: " + e.getMessage());
        }
    }
}
