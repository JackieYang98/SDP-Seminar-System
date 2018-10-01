package com.sdpseminarsystem.nametag;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sdpseminarsystem.vo.Attendee;

public class NameTag {
	public static void makeFile(String filePath, List<Attendee> attendees) throws FileNotFoundException, DocumentException {
		File file = new File(filePath);
		file.getParentFile().mkdirs();

		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream(filePath));

		PdfPTable table = new PdfPTable(2);
		table.setWidthPercentage(100);
		table.setWidths(new float[] {1, 1});

		for(Attendee attendee : attendees) {
			String name = attendee.getAttendeeFirstName() + " " + attendee.getAttendeeLastName();
			table.addCell(getPDFCell(name));
		}
		if(attendees.size() % 2 == 1) {
			PdfPCell blankCell = new PdfPCell();
			blankCell.setBorder(PdfPCell.NO_BORDER);
			table.addCell(blankCell);
		}

		document.open();
		document.add(table);
		document.close();
	}

	public static PdfPCell getPDFCell(String name) {
		PdfPCell cell = new PdfPCell(new Paragraph(name));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setMinimumHeight(110);
		cell.setBorder(PdfPCell.NO_BORDER);
		cell.setCellEvent(new RoundedBorder());
		return cell;
	}
}

