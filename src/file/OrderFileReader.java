/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package file;

import controller.Linkedorder;
import controller.Linkedproject;
import controller.CustomerList;
import model.Order;
import Node.Node;
import model.Products;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class OrderFileReader {
    private Scanner scanner = new Scanner(System.in);

    // 3.1 Load data from file (orders.txt)
    public void readOrdersFromFile(String filePath, Linkedorder list) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length == 5) { 
                    try {
                        String pcode = parts[0].trim();
                        String ccode = parts[1].trim();
                        Date odate = sdf.parse(parts[2].trim());
                        Date sdate = parts[3].trim().equals("null") ? null : sdf.parse(parts[3].trim());
                        int quantity = Integer.parseInt(parts[4].trim());

                        Order order = new Order(pcode, ccode, odate, sdate, quantity);
                        list.addLast(order);

                    } catch (Exception e) {
                        System.out.println("Lỗi định dạng dòng: " + line);
                    }
                } else {
                    System.out.println("Dòng không đúng định dạng (phải có 5 phần): " + line);
                }
            }
            System.out.println("Đã load dữ liệu từ file " + filePath + " thành công.");
        } catch (Exception e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
        }
    }

    // 3.4 Save order list to file (orders.txt)
    public void saveOrdersToFile(String filePath, Linkedorder list) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            Node current = list.head;
            while (current != null) {
                Order order = (Order) current.data;
                writer.write(order.getPcode() + "," + order.getCcode() + "," +
                        order.getOdate() + "," + (order.getSdate() != null ? order.getSdate() : "null") + "," +
                        order.getQuantity());
                writer.newLine();
                current = current.getNext();
            }
            System.out.println("Danh sách đơn hàng đã lưu vào file.");
        } catch (Exception e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
        }
    }

    // 3.2 Order book (nhập dữ liệu và kiểm tra hợp lệ)
    public Order insertData(Linkedorder orderList, Linkedproject productList, CustomerList customerList) {
        try {
            System.out.println("Enter pcode:");
            String pcode = scanner.nextLine();

            System.out.println("Enter ccode:");
            String ccode = scanner.nextLine();

            System.out.println("Enter quantity:");
            int quantity = scanner.nextInt();
            scanner.nextLine();

            boolean valid = true;

            Node productNode = productList.sereach(productList, pcode); 
            Products product = (productNode != null) ? (Products) productNode.data : null;
            if (product == null) {
                System.out.println("pcode không tồn tại!");
                valid = false;
            }

            if (customerList.searchCcode(ccode) == null) {
                System.out.println("ccode không tồn tại!");
                valid = false;
            }

            if (quantity <= 0) {
                System.out.println("enter quantity must > 0");
                valid = false;
            } else if (product != null && quantity > product.getQuantity()) {
                System.out.println("enter quantity <= available quantity (" + product.getQuantity() + ")");
                valid = false;
            }

            if (valid) {
               Order order = new Order(pcode, ccode, new Date(), null, quantity);
                orderList.addFirst(order); 

                product.setQuantity(product.getQuantity() - quantity);
                product.setSaled(product.getSaled() + quantity);

                System.out.println("Đặt hàng thành công!");
                return order;
            }
        } catch (Exception e) {
            System.out.println("Lỗi: " + e);
        }
        return null;
    }
}