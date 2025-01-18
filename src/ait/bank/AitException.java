/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ait.bank;

/**
 *
 * @author suraj
 */
public class AitException extends Exception {
    
    public  AitException(String errorMessage){
        super(errorMessage);
        System.out.println(errorMessage);
    }

}
