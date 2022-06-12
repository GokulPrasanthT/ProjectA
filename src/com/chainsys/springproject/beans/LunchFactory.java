package com.chainsys.springproject.beans;

public class LunchFactory {
	
    public Lunch createNonvegSouthIndianLunch() {
        Starter s1 = new Chicken();
        s1.name = "Honeychicken";
        MainCourse m = new SouthIndian();
        m.name = "Rice";

        Dessert d = new Cakes();
        d.name = "ChocoBrownie";
        Lunch l = new Lunch(s1, m, d);
        return l;
    }

    public Lunch createVegSouthIndianLunch() {
        Starter s1 = new Vegroll();
        s1.name = "Cabbageroll";
        MainCourse m = new SouthIndian();
        m.name = "Rice";
        Dessert d = new Icecream();
        d.name = "Falooda";
        Lunch l = new Lunch(s1, m, d);
        return l;
    }

    public Lunch createNorthIndianLunch() {
        Starter s1 = new Soup();
        s1.name = "Sweetcorn";
        MainCourse m = new NorthIndian();
        m.name = "Chappatti";
        Dessert d = new Sweets();
        d.name = "Rasagulla";
        Lunch l = new Lunch(s1, m, d);
        return l;
    }

    public Lunch createChineseIndianLunch() {
        Starter s1 = new Vegroll();
        s1.name = "Springroll";
        MainCourse m = new Chinese();
        m.name = "Noodles";
        Dessert d = new Icecream();
        d.name = "Snake";
        Lunch l = new Lunch(s1, m, d);
        return l;
    }
}