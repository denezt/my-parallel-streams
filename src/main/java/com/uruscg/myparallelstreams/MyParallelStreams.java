/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uruscg.myparallelstreams;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author denezt
 */
public class MyParallelStreams {

    public static void main(String[] args) {

        List<Customer> customerList = Arrays.asList(new Customer("Adam", "Eves", "Adam Delivery Co."),
                new Customer("Jean", "Claude", ""),
                new Customer("Regina", "Hampton", ""),
                new Customer("Pippi", "Lapaul", "")
        );

        customerList.stream().filter(c -> !c.getCompanyName().isEmpty())
                .limit(99)
                .forEach(cus -> System.out.println(cus.getFirstname() + " " + cus.getLastname()));
        
        customerList.stream().parallel().filter(c -> !c.getCompanyName().isEmpty())
                .limit(99)
                .forEach(cus -> System.out.println(cus.getFirstname() + " " + cus.getLastname()));

        customerList.parallelStream().filter(c -> !c.getCompanyName().isEmpty())
                .limit(99)
                .forEach(cus -> System.out.println(cus.getFirstname() + " " + cus.getLastname()));    
    }

}
