package main.implement;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Host;
import com.datastax.driver.core.Metadata;
import com.datastax.driver.core.Session;

public class CassandraConnection {
	// Cassnadra cluster
	private Cluster cluster;
	// Cassnadra Session
	private Session session;
	


	public void connection(final String host,final int Portno,String keyspacename) {
		System.out.println("In Connect method");
		this.cluster=Cluster.builder().addContactPoint(host).withPort(Portno).build();
		// If Cassandra cluster secure with username and password
		
		//this.cluster=Cluster.builder().addContactPoint(host).withPort(Portno).withCredentials(username, password).build();
		//this.cluster=Cluster.builder().addContactPoint(host).withPort(Portno).
		final Metadata metadata=cluster.getMetadata();
		System.out.println("Connection for cassandra with Host : "+host+" and Port : "+Portno+" is successful");
		System.out.println("Connect with Cluster "+metadata.getClusterName());
		for (final Host host1 : metadata.getAllHosts()) {
			System.out.println("Datacenter:"+host1.getDatacenter()+" Host:"+host1.getAddress()+" Rack:"+host1.getRack());
		}
		if (keyspacename == "" || keyspacename == null) {
			session=cluster.connect();
		} else {
			// If you want to connect specific keyspace 
			session=cluster.connect(keyspacename);
		}
		System.out.println("Leaving Connect method");
	}
	
	public Session getSession() {
		System.out.println("in Get session method");
		return session;
	}
	
	public void close() {
		System.out.println("Closing session");
		session.close();
	}
}
