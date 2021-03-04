package com.pdfExample.Dynamic;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class pdfDynamic {
	public static void main(String[] args) throws FileNotFoundException, DocumentException, SQLException {
		String file = "C:\\PDF\\WithDB\\Dynamic.pdf";
		Document doc = new Document();
		PdfWriter.getInstance(doc, new FileOutputStream(file));
		doc.open();
		DBConnection dbConnection = new DBConnection();
		Connection connection = dbConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "select * from question";
		ps = connection.prepareStatement(query);
		rs = ps.executeQuery(query);
		while (rs.next()) {
			Paragraph para = new Paragraph(rs.getString("question_id") + " " + rs.getString("question"));
			doc.add(para);
			doc.add(new Paragraph(" "));
		}
	doc.close();}
	
}
