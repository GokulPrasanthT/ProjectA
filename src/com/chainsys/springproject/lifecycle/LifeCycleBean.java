package com.chainsys.springproject.lifecycle;

public class LifeCycleBean {
 public void print () {
	 System.out.println("Print Called ");
 }
 public LifeCycleBean() {
	 System.out.println("LifeCycleBean is Called ");
 }
 public void setup() {
     System.out.println("Starting...");
 }
 public void close() {
     System.out.println("Closing...");
 }
}
