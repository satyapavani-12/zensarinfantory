package com.twitter.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.twitter.entity.TwitterEmployee;

public class TwitterDAO  implements TwitterDAOInterface
{

	public static TwitterDAOInterface createObject() {
		// TODO Auto-generated method stub
		return new TwitterDAO();
	}

	@Override
	public int createProfileDAO(TwitterEmployee tw) {
		// TODO Auto-generated method stub
		int i=0;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","Zensar123");
			PreparedStatement ps=con.prepareStatement("insert into twitteremployee values(?,?,?,?)");
			ps.setString(1, tw.getName());
			ps.setString(2, tw.getPass());
			ps.setString(3,tw.getEmail());
			ps.setString(4, tw.getAddress());
			i=ps.executeUpdate();
	}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
        return i;
}
}
