package com.dao;
import com.dao.ArtworkDao;
import com.exception.DatabaseConnectionException;
import com.model.Artwork;

import java.sql.Connection;

import com.util.DBUtil;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ArtworkDaoImpl implements ArtworkDao{

		public List<Artwork> fetchAllArtworks() throws SQLException, DatabaseConnectionException 
		{
			List<Artwork> list = new ArrayList<>();
			Connection conn = DBUtil.getdbConnect();

			String sql = "select * from artwork";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			ResultSet rst = pstmt.executeQuery();

			while (rst.next()) 
			{
				int id = rst.getInt("artwork_id");
				String title = rst.getString("title");
				String description = rst.getString("description");
				LocalDate date = rst.getDate("creation_date").toLocalDate();
				String medium = rst.getString("medium");
				String imageurl = rst.getString("image_url");
				double price = rst.getDouble("price");
				Artwork c = new Artwork(id, title, description, date, medium, imageurl, price);
				list.add(c);
			}

			DBUtil.dbClose();
			return (list);
		}
		

		@Override
		public void updateArtwork(int id, String field, String newVal) throws DatabaseConnectionException, SQLException {
			
			Connection conn = DBUtil.getdbConnect();

			String sql = "update artwork set "+field+"=? where artwork_id=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			if(field.equals("title"))
				pstmt.setString(1, field.valueOf(newVal));
			else
				pstmt.setString(1,newVal);
			
			pstmt.setInt(2, id);


			pstmt.executeUpdate();

			DBUtil.dbClose();
		}

		@Override
		public void deleteArtworkById(int id) throws SQLException, DatabaseConnectionException {
			
			Connection conn = DBUtil.getdbConnect();
			
			String sql = "delete * from artwork where artwork_id=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, id);

			pstmt.executeUpdate();


			DBUtil.dbClose();
			
		}

		@Override
		public void createArtwork(String title, String description, String date, String medium, String imageurl,
				double price) throws SQLException, DatabaseConnectionException {
			Connection conn = DBUtil.getdbConnect();

			String sql = "insert into artwork(title ,description,creation_date,medium,image_url,price) values(?,?,?,?,?,?,?,?)";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, title);
			pstmt.setString(2, description);
			pstmt.setDate(3, Date.valueOf(date));
			pstmt.setString(4, medium);
			pstmt.setString(5, imageurl);
			pstmt.setDouble(6, price);

			pstmt.executeUpdate();

			DBUtil.dbClose();

			
		}




		



	}



  

