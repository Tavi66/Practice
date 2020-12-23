package com.spring.annotations.q2;

import java.util.Date;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.bo.ProductBO;
import com.spring.domain.Product;



public class Main {
    public static void main(String[] args) throws ParseException, IOException {
        Logger log = Logger.getLogger("org.hibernate");
    	log.setLevel(Level.OFF);
		System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
		//Fill your code here
        Scanner sc = new Scanner(System.in);
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ProductBO prodBo = (ProductBO)context.getBean("productBo");
        
        List<Product> prodList = prodBo.otainProductList();
        System.out.println("Product List:");
        System.out.printf("%-5s%-25s%-15s%-25s%-15s\n","Id","Name", "Color", "Material", "Price");
        for(Product prod: prodList){
            System.out.println(prod);
        }
        System.out.println("Search Product by:");
        System.out.println("1.Name");
        System.out.println("2.Color");
        System.out.println("3.Material");
        String input = sc.nextLine();

        System.out.println("Enter the " + input +" to be search");
        String input2 = sc.nextLine();
        List<Product> foundProd = prodBo.otainProductBySearchType(input.toLowerCase(), input2);
        if(!foundProd.isEmpty()){
            System.out.printf("%-5s%-25s%-15s%-25s%-15s\n","Id","Name", "Color", "Material", "Price");
            for(Product prod: foundProd){
                System.out.println(prod);
            }
        } else {
            System.out.println("No product available");
        }
    }
}
