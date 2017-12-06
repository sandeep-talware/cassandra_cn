package main.implement;

import java.util.ArrayList;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;

public class CassandraFetchOperation {
	CassandraConnection Casscn;
	Session session;
	String query;
	
	public ResultSet Fetching(String host,int port,String keyspacename,ArrayList<String> ls,String tablename,String Filter) {
		ResultSet rs =null;
		Casscn=new CassandraConnection();
		Casscn.connection(host, port,keyspacename);
		if(ls==null)
		{
			query="SELECT * FROM "+tablename+" WHERE "+Filter;
		}
		else
		{
			StringBuilder list=new StringBuilder();
			for (String col : ls) {
				list.append(col.toCharArray()+",");
			}
			query="SELECT "+list.toString()+" FROM "+tablename+" WHERE "+Filter;
		}
		session=Casscn.getSession();
		rs= session.execute(query);
		return rs;
	}
}
