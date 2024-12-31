package Service;

import Model.Customer;

import java.util.HashMap;
import java.util.Map;

public class CustomerService {
    Map<Integer, Customer> customerMap = new HashMap<>();

    public void addCustomer() {
        customerMap.put(1, new Customer(1, "Nguyen Van A"));
        customerMap.put(2, new Customer(2, "Tran Thi B"));
        customerMap.put(3, new Customer(3, "Le Van C"));
        customerMap.put(4, new Customer(4, "Pham Thi D"));
        customerMap.put(5, new Customer(5, "Hoang Van E"));
    }
    public void getAllCustomer() {
        String leftAlignFormat = "| %-15s | %-4d |%n";

        System.out.format("+-----------------+------+%n");
        System.out.format("| Column name     | ID   |%n");
        System.out.format("+-----------------+------+%n");
        for (Customer value : customerMap.values()) {
            System.out.format(leftAlignFormat, value.getCustomerName() , value.getIdCustomer());
        }
        System.out.format("+-----------------+------+%n");
    };
    public Customer getCustomerById(int id) {
        return customerMap.get(id);
    }
    }


