package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        String ortaMetin = "ilginizi çekebilir" ;
        String altMetin = "Vade süresi" ;
        System.out.println(ortaMetin);

        int vade = 12 ;
        double dolarDun = 18.14;
        double dolarBugun=18.14;
        boolean dolarDustuMu = false ;
        String okYonu = "";
        if (dolarDun < dolarBugun) {
            okYonu = "up.svg";
            System.out.println(okYonu);
        }
            else if (dolarBugun < dolarDun) {
                okYonu = "down.svg";
                System.out.println(okYonu);
            }
            else {
            okYonu = "equal.svg";
            System.out.println(okYonu);
        }
         String[] krediler = {"hızlı kredi","maaşını Halkbanktan","mutlu emekli"} ;
            for (int  i = 0 ; i < krediler.length; i++) {
                System.out.println(krediler[i]) ;
            }







    }










    }
