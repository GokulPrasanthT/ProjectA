package com.chainsys.projectA.beans;

public class Dessert {
	public String name;
}
	class Icecream extends Dessert{
		public Icecream() {
			name="Vennila";
		}
	}
	class Sweets extends Dessert{
		public Sweets() {
			name="Vennila";
		}
		
	}
	class Cakes extends Dessert{
		public Cakes() {
			name="Vennila";
		}
		public Cakes(String name)
		{
			this.name=name;
		}
	}

