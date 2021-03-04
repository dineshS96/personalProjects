package com.pdfExample;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class generatePDF {
	public static void main(String[] args) {
		String file_name = "C:\\PDF\\test.pdf";
		Document doc = new Document();
		try {
			PdfWriter.getInstance(doc, new FileOutputStream(file_name));
			doc.open();
			Paragraph para = new Paragraph("This is testing pdf");
			doc.add(para);

			PdfPTable table = new PdfPTable(3);
			PdfPCell c1 = new PdfPCell(new Phrase("Heading 1"));
			table.addCell(c1);

			PdfPCell c2 = new PdfPCell(new Phrase("Heading 2"));
			table.addCell(c2);

			PdfPCell c3 = new PdfPCell(new Phrase("Heading 3"));
			table.addCell(c3);
			// table.setHeaderRows(1);

			table.addCell("1.0");
			table.addCell("1.1");
			table.addCell("1.2");
			table.addCell("2.1");
			table.addCell("2.2");
			table.addCell("2.3");

			doc.add(table);
			
			
			//add image in pdf
			doc.add(Image.getInstance("C:\\Users\\dineshs\\Desktop\\notes.png"));
			doc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
