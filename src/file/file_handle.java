/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import controller.CustomerList;
import Node.CustomerNode;
import model.Customer;
/**
 *
 * @author LAPTOP
 */
public class file_handle {
    public static controller.CustomerList loadCustomerListFromFile(String filename) throws Exception {
        controller.CustomerList list = new controller.CustomerList();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split("\\|");
            if (parts.length == 3) {
                String ccode = parts[0].trim();
                String name = parts[1].trim();
                String phone = parts[2].trim();
                list.addLast(new model.Customer(ccode, name, phone));
            }
        }
        br.close();
        return list;
    }

    public static void saveCustomerListToFile(controller.CustomerList list, String filename) throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
        Node.CustomerNode current = list.head;
        while (current != null) {
            bw.write(current.infor.ccode + " | " + current.infor.name + " | " + current.infor.phone);
            bw.newLine();
            current = current.next;
        }
        bw.close();
    }    
}
