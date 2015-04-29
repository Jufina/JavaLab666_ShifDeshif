package com.miet.mp34.samoshchenko.lab2;

import java.util.*;

public class Coctail {
    private String name;
    List<Item> creation;

    public Coctail(String name) {
        this.name = name;
        creation=new ArrayList<Item>();
    }
    public String getName() {
        return name;
    }

    private class Item {
        private Actions act;
        private Ingredient ingr;
        private int cnt;
        public Item(Actions act, Ingredient ingr, int cnt) {
            this.act=act;
            this.ingr=ingr;
            this.cnt=cnt;
        }
        public Item(Actions act) {
            this.act=act;
            this.ingr=null;
            this.cnt=0;
        }
        public Ingredient getIngr() {
            return ingr;
        }
        public Actions getAct() {
            return act;
        }
        public int getCnt() {
            return cnt;
        }
        public String toString() {
            if(ingr != null) {
                return act + " " + cnt + " " + ingr;
            }
            else {
                return act+" up";
            }
        }
    }

    private enum Actions {pour, mix, shake, add}

    public int calculateStrength() {
        double alchPart=0;
        double all=0;
        for(Item x:creation) {
            if(x.getAct() == Actions.pour)  {
                Liquid ing=(Liquid)x.getIngr();
                alchPart+=(double)ing.getStrength()/100*x.getCnt();
                all+=x.getCnt();
            }
        }
        return (int)(alchPart/all*100);
    }

    public void pourA(Liquid ingr, int cnt) {
        Item a=new Item(Actions.pour, ingr, cnt);
        creation.add(a);
        // Добавить новый пункт "Налить"
    }
    public void mixup() {
        Item a=new Item(Actions.mix);
        creation.add(a);
        // Добавить новый пункт "Размешать"
    }
    public void shakeup() {
        Item a=new Item(Actions.shake);
        creation.add(a);
        // Добавить новый пункт "Взболтать"
    }
    public void addA(Solid ingr, int cnt) {
        Item a=new Item(Actions.add, ingr, cnt );
        creation.add(a);
        //Добавить новый пункт "Добавить ЧТО-ТО"
    }

    public String toString() {
        String str="";
        if(calculateStrength()==0) {
            System.out.print("Безалкогольный коктейль ");
        }
        else {
            System.out.print("Алкогольный коктейль (крепость - " + calculateStrength() + "%) ");
        }
        System.out.println("\""+getName()+"\"");
        for(Item x: creation) {
            str+=x.toString()+"\n";
        }
        return str;
    }
}
/*
pour - Налить
mix - Размешать
shake - Взболтать
add - Добавить
*/

