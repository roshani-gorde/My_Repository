
package com.ashokit.BookServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ashokit.DAO.BooksTableClass;
import com.ashokit.DTO.BookDTO;
@WebServlet("/bookservlet")
public class BooksServletClass extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		//capturing data from form
		
		
		int boId=Integer.parseInt(req.getParameter("bookId"));
		String boName = req.getParameter("bookName");
		double boPrice=Double.parseDouble(req.getParameter("bookPrice"));
		
		//setting values to DTO class fields
		BookDTO dto=new BookDTO();
		dto.setBookId(boId);
		dto.setBookName(boName);
		dto.setBookPrice(boPrice);
		
		//call  BooksTableClass dao class method and pass parameter 
		BooksTableClass books=new BooksTableClass();
		boolean status = books.insertBooksData(dto);
		//send response to client
		try {
			PrintWriter pw = res.getWriter();
			if(status) {
				pw.append("Record Inserted");
			}else {
				pw.append("Record Insertion Failed");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		
	}

}
