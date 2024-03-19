package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.model.CustomerModel;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.util.DBUtil;

public class CustomerDao {
	DBUtil db=new DBUtil();
	java.sql.Connection conn;
	public List<CustomerModel>fetchAll()
	{
		conn=db.dbConnect();
		List<CustomerModel>list=new ArrayList<>();
		String sql="select * from customer";
		
		try {
		java.sql.PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rst=pstmt.executeQuery();
		
		
			while(rst.next())
			{
				int customerId=rst.getInt("customer_id");
				String username=rst.getString("username");
				String password=rst.getString("password");
				String email=rst.getString("email");
				String firstName=rst.getString("first_name");
				String lastName=rst.getString("last_name");
				Date dateOfBirth=rst.getDate("date_of_birth");
				String profilePic=rst.getString("profile_pic");
				String favouriteArtwork=rst.getNString("favourite_artwork");
				CustomerModel c=new CustomerModel();
				c.setCustomerId(customerId);
				c.setPassword(password);
				c.setEmail(email);
				c.setFirstName(firstName);
				c.setFirstName(lastName);
				c.setDateOfBirth(dateOfBirth);
				c.setProfilePic(profilePic);
				c.setFavouriteArtwork(favouriteArtwork);
				list.add(c);
				
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
			db.dbClose();
		
		return list;
	}

}
