package com.chainsys.springproject.beans;

public class Actor {

		private int id;
		private String name;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		public void print() {
			System.out.println(this.id);
			System.out.println(this.name);

		}
		public Actor() {
			System.out.println("Actor Object Created " + hashCode());
		}
	}


