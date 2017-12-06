package main.Tests;

import main.implement.CassandraConnection;

public class CassandraConnTests {
	
	public static void main(String args []) {	
		System.out.println("Start Program");
		CassandraConnection client=new CassandraConnection();
		System.out.println("Attempting connection with 192.168.24.45");
		client.connection("192.168.24.45", 9042,null);
		System.out.println("Successful connection with 192.168.24.45");
		System.out.println("Closing connection");
		client.close();
	}
	
}
