package com.nt.test;

import com.nt.domain.Employee;

public class ClassLoadingBasics {

	public static void main(String[] args)throws Exception {

        Class c1=Class.forName("java.util.Date");
        System.out.println("c1 data"+c1+" c1 class name::"+c1.getClass());
        
        String s1=new String("hello");
        Class c2=s1.getClass();
        System.out.println("c2 data"+c2+" c2 class name::"+c2.getClass());
        
        Class c3=Integer.class;
        Class c4=Employee.class;
        System.out.println("c3 data"+c3+" c3 class name::"+c3.getClass());
        System.out.println("c4 data"+c4+" c4 class name::"+c4.getClass());
	}//main
}//class
