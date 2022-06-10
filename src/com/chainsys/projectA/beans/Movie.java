package com.chainsys.projectA.beans;

public class Movie {
	public String title;
	public String director;

	public Movie(String filmtitle, String filmdirector) {
		// this.title=title; // this. title is global variable , and title is a local
		// variable
		title = filmtitle; // This is similar to this.titleflimtitle, but using tis. prefix is not
							// compulsory
		director = filmdirector; // this is similar to thi.director but using this.prefix is. is compulsory
		// as there are no local variables by name title, r dirctor so , here they will
		// implicitly refer to global variable
		// note : if title and director not glbally declare then it will be undeclared
		// variable cannot be resolved to a variable.
		// if the parameter names are similar to the global variable
		// than there is an ambiguity between the local variable (parameter) and alobal
		// variable
		// hence this. prefix is used for refering the global variable
		// title=tltle will be referring local variable on both side f the = operator
		// (x=x) self assigning
         System.out.println(title);
         System.out.println(director);
	}
}
