package com.Test.SpringBoot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

	@Test
	void contextLoads() {
		Integer val = 100;
       switch(val) {
         case 10:
        	System.out.println("Orange");
         case 100:
        	System.out.println("Apple");
         case 200:
        	System.out.println("Apple");
         default:
        	System.out.println("String");
       }
       System.out.println("Ans: " + 9 + 1 + 2);
       System.out.println("Ans: " + (9 + 1) + 2);
    }
}
