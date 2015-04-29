package com.miet.mp34.samoshchenko.lab2;

public class Main {
    public static void main(String[] args) {
        Liquid water=new Liquid("water",0);
        Liquid whisky=new Liquid("whisky",40);
        Liquid vodka=new Liquid("vodka",20);
        Solid lemon=new Solid("lemon");
        Solid orange=new Solid("orange");


        Coctail catty=new Coctail("Котейкина радость");
        catty.pourA(water, 0);
        catty.pourA(whisky, 300);
        catty.pourA(vodka, 500);
        catty.shakeup();
        catty.addA(lemon, 2);
        System.out.println(catty);

        Coctail julia=new Coctail("Юлия");
        julia.pourA(water, 200);
        julia.addA(orange, 4);
        julia.mixup();
        System.out.println(julia);
    }
}
