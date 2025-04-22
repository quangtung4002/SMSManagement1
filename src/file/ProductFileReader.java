package file;

import controller.Linkedproject;
import Node.Node;

import java.io.*;
import java.util.*;
import model.*;

public class ProductFileReader {

    protected Node head, tail;
    private Scanner can = new Scanner(System.in);

    public List<Products> readProductsFromFile(String filePath, Linkedproject list){
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length == 8) {
                    try {
                        String pcode = parts[0];
                        String name = parts[1];
                        String maker = parts[2];
                        String unit = parts[3];
                        String category = parts[4];
                        int quantity = Integer.parseInt(parts[5]);
                        int saled = Integer.parseInt(parts[6]);
                        double price = Double.parseDouble(parts[7]);

                        Products product = new Products(pcode, name, maker, unit, category, quantity, saled, price);
                        list.addLast(product);

                    } catch (NumberFormatException e) {
                        System.out.println("Lỗi định dạng số: " + line);
                    }

                }
            }

        } catch (IOException e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
        }
        return null;

    }


    public Products insertData(Linkedproject m ) {
         
        try {
            System.out.println("Enter pcode:");
            String pcode = can.nextLine();
           
            System.out.println("Enter name:");
            String name = can.nextLine();

            System.out.println("Enter market:");
            String market = can.nextLine();
            
            System.out.println("Enter unit:");
            String unit = can.nextLine();
            
            System.out.println("Enter catergory:");
            String catergory = can.nextLine();
            
            System.out.println("Enter quality:");
            int quality = can.nextInt();
            can.nextLine();

            System.out.println("Enter sale:");
            int sale = can.nextInt();
            can.nextLine();
            
            System.out.println("Enter price:");
            double price = can.nextDouble();
            can.nextLine();
            Boolean vali = true;

            Node no = m.head;
            while (no != null) {
                Products p = (Products) no.data;
                if (p.getPcode().equals(pcode)) {
                    System.out.println("pcode da ton tai!");
                    vali = false;
                    break;
                }
                no = no.next;
            }

            if (quality <= 0) {
                System.out.println("enter quality must > 0");
                vali = false;

            }
            if (sale >= quality) {
                System.out.println("enter sale <= quality");
                vali = false;

            }

            if (vali) {
                Products a = new Products(pcode, name, market, unit, catergory, quality, sale, price);
                System.out.println("them san pham thanh cong!");

                return a;

            }

        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        return null;

    }

}
