package com.sdpseminarsystem.nametag;

import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPCellEvent;
import com.itextpdf.text.pdf.PdfPTable;

/**
 * Class implements {@code PdfPCellEvent} to provide rounder rectangle border
 * for cells in the table.
 * 
 * @author Leo Lee
 * @since 1.0
 * @see NameTag
 */
public class RoundedBorder implements PdfPCellEvent {
    
    @Override
    public void cellLayout(PdfPCell cell, Rectangle position, PdfContentByte[] canvases) {
        PdfContentByte cb = canvases[PdfPTable.BACKGROUNDCANVAS];
        cb.roundRectangle(position.getLeft(), position.getBottom(), position.getWidth() - 5, position.getHeight() - 5,
                10);
        cb.stroke();
    }
    
}
