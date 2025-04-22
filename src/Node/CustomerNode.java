/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Node;
import model.Customer;
/**
 *
 * @author LAPTOP
 */
public class CustomerNode {
    public Customer infor;
    public CustomerNode next;

    public CustomerNode(Customer x, CustomerNode p) {
        this.infor = x;
        this.next = p;
    }
    
    public CustomerNode(Customer x){
        this(x,null);
    }
    
}
