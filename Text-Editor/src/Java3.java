/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package javaclass;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author USER
 */
public class Java3 {
    
    public static void main(String[] args){
        System.out.println("Please enter an amount");
        Scanner in = new Scanner(System.in);
        //Declare the variable
        int a;
        
        //Read the variable from std
        a = in.nextInt();
        
        try {
            System.out.println(UserDefinedException(a));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    private static String UserDefinedException(int amount) throws Exception{
          String message;
          if(amount <= 0){
              throw new Exception("Invalid Amount");
          }
          else{
              message = "Amount Deposited";
          }
          return message;
    }

}

