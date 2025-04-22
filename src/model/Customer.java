/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author LAPTOP
 */
public class Customer {
    public String ccode;
    public String name;
    public String phone;

    public Customer() {
    }

    public Customer(String ccode, String name, String phone) {
        this.ccode = ccode;
        this.name = name;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" + "ccode=" + ccode + ", name=" + name + ", phone=" + phone + '}';
    }
    
}

