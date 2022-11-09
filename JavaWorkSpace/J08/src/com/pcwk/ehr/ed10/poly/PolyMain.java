package com.pcwk.ehr.ed10.poly;

public class PolyMain {

	public static void main(String[] args) {
		Lion lion = new Lion();
		ZooKeeper zk = new ZooKeeper();
		
		zk.feed(lion);
		
		Monkey m = new Monkey();
		zk.feed(m);
		
		Rabbit r = new Rabbit();
		zk.feed(r);
	}

}
