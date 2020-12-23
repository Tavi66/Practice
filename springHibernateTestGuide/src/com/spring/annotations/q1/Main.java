package com.spring.annotations.q1;


import com.spring.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		Logger log = Logger.getLogger("org.hibernate");
		log.setLevel(Level.OFF);
		System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
		
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Address ad = (Address)context.getBean(Address.class);
        ContactDetail cd = (ContactDetail)context.getBean(ContactDetail.class);
	}

}

