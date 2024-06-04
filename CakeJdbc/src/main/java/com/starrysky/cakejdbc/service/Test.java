package com.starrysky.cakejdbc.service;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        while(true){
            Scanner cin = new Scanner(System.in);

            int op=cin.nextInt();
            if(op==1){
                addCake();
            }else if(op==2){
                removeCake();
            } else if (op == 3) {
                replaceCake();
            } else {
                findCake();
            }
        }
    }

    private static void findCake() {
        Scanner cin = new Scanner(System.in);
    }

    private static void replaceCake() {
        Scanner cin = new Scanner(System.in);
    }

    private static void removeCake() {
        Scanner cin = new Scanner(System.in);
    }

    private static void addCake() {
        Scanner cin = new Scanner(System.in);

        String id = cin.next();
        String name = cin.next();
        String price = cin.next();


    }
}
