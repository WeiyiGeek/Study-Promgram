package com.weiyigeek.main.maven;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main ( String[] args )
    {
        System.out.println ( "Hello World! , " + new App().sayHello() );
    }

    
    public String sayHello() {
        return "Hello Maven!";
    }
}
