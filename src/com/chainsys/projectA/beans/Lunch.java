package com.chainsys.projectA.beans;

public class Lunch {
public Starter entree;
public MainCourse mainfood;
public Dessert sweets;
// Constructor Based Dependency injection
public Lunch(Starter s,MainCourse m,Dessert d) {
	System.out.println("Lunch is Ready");
	entree=s;
	mainfood=m;
	sweets=d;
}
public void serve() {
	System.out.println(entree.name);
	System.out.println(mainfood.name);
	System.out.println(sweets.name);
}
}
/*
*Lunch
*Starter,Chicken,Soup,Vegroll
*MainCurse, SouthIndian,NorthIndian,Chinese
*Dessert, Icecream,Sweets,
*/