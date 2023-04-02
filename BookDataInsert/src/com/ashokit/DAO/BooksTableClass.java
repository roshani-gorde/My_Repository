package com.ashokit.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.ashokit.DTO.BookDTO;
import com.ashokit.util.ConnectionFactory;

public class BooksTableClass {
	Connection con=null;

	public boolean insertBooksData(BookDTO dto) {
		int count = 0;
		try {
			String insert_query = "insert into Books values(?,?,?)";
			con = ConnectionFactory.getDBConnection();
			PreparedStatement ps = con.prepareStatement(insert_query);
			ps.setInt(1, dto.getBookId());
			ps.setString(2, dto.getBookName());
			ps.setDouble(3, dto.getBookPrice());

			count = ps.executeUpdate();
			System.out.println("Data Inserted");
			System.out.println("Record Updated- " + count);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count > 0;
	}
	
	public ArrayList<BookDTO> findUser(){
		ArrayList<BookDTO> al=new ArrayList<BookDTO>();
		BookDTO dto=new BookDTO();
		
		return null;
		
	}
}
