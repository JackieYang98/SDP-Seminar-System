package com.sdpseminarsystem.nametag;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sdpseminarsystem.vo.Attendee;

/**
 * Provides function to create an attendees name tag PDF file.
 * <p>
 * iText (version 5.5.12) is used for creating the file.
 * 
 * @author Leo Lee
 * @since 1.0
 * @see com.itextpdf.text
 */
public final class NameTag {
    
    private NameTag() {}
    
    /**
     * Creates an attendees name tag file using the specific file path and name of
     * the given list of attendees.
     * 
     * @param filePath  complete file path with file name
     * @param attendees list of attendees to be used to creating name tag file
     * @throws DocumentException     if an iText error occurs.
     * @throws FileNotFoundException if the path provided by {@code filePath} is a
     *                               directory without file name, does not exist but
     *                               cannot be created, or cannot be opened for any
     *                               other reason.
     * @throws NullPointerException  if {@code filePath} and/or {@code attendees} is
     *                               {@code null}.
     * @throws SecurityException     if {@code filePath} gives a path which does not
     *                               permit the named directory and all necessary
     *                               parent directories to be created; or writing
     *                               access to the file is denied.
     * @see com.sdpseminarsystem.servlet.NameTagServlet
     * @see com.sdpseminarsystem.vo.Attendee
     */
    public static void makeFile(String filePath, List<Attendee> attendees)
            throws DocumentException, FileNotFoundException {
        File file = new File(filePath);
        file.getParentFile().mkdirs();
        
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(filePath));
        
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);
        table.setWidths(new float[] { 1, 1 });
        
        for (Attendee attendee : attendees) {
            String name = attendee.getAttendeeFirstName() + " " + attendee.getAttendeeLastName();
            table.addCell(getPDFCell(name));
        }
        if (attendees.size() % 2 == 1) {
            PdfPCell blankCell = new PdfPCell();
            blankCell.setBorder(PdfPCell.NO_BORDER);
            table.addCell(blankCell);
        }
        
        document.open();
        document.add(table);
        document.close();
    }
    
    private static PdfPCell getPDFCell(String name) {
        Paragraph para = new Paragraph(name, new Font(FontFamily.HELVETICA , 40));
        PdfPCell cell = new PdfPCell(para);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setMinimumHeight(110);
        cell.setBorder(PdfPCell.NO_BORDER);
        cell.setCellEvent(new RoundedBorder());
        return cell;
    }
}
