package main.Tests;

import main.implement.CassandraConnection;

public class CassandraConnTests {
	
	public static void main(String args []) {	
		System.out.println("Start Program");
		CassandraConnection client=new CassandraConnection();
		//System.out.println("Attempting connection with Specified IP and Port");
		client.connection(IP , Port,null);
		System.out.println("Successful connection with Specified IP and Port");
		System.out.println("Closing connection");
		client.close();
	}
	
}
