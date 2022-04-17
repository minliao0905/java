package com.ithem.first;
import interface01.GenericMyclass;
public class InterfaceGenericmyclass1 {
    public static void main(String[] args) {
    	GenericMyclass<String> my = new GenericMyclass<>();
    	my.print("abc");
    }
}
