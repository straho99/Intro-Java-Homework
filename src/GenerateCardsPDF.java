import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.awt.geom.Rectangle;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class GenerateCardsPDF {

	public static void main(String[] args) throws IOException,
			DocumentException {
		String[] faces = new String[4];
		faces[0] = "\u2663";
		faces[1] = "\u2666";
		faces[2] = "\u2665";
		faces[3] = "\u2660";
		// System.out.println(faces[0]);
		Document document = new Document(PageSize.A4, 50, 50, 50, 50);
		PdfWriter writer = PdfWriter.getInstance(document,
				new FileOutputStream("DeckOfCards.pdf"));
		document.open();
		BaseFont bf; 
		bf = BaseFont.createFont("/Library/Fonts/Arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
		PdfPTable cardsTable=new PdfPTable(8);
		for (int i = 2; i <= 14; i++) {
			//String newParagraph = "";
			for (int j = 0; j < 4; j++) {
				PdfPCell currentCell;
				String cellText;
				if (i == 11) {
					cellText= "J" + faces[j];
				} else if (i == 12) {
					cellText= "Q" + faces[j];					
				} else if (i == 13) {
					cellText= "K" + faces[j];					
				} else if (i == 14) {
					cellText= "A" + faces[j];					
				} else {
					cellText= i + faces[j];
				}
				
				if (j>=1 && j<=2) {
					currentCell=new PdfPCell(new Phrase(cellText, new Font(bf, 16, 1, BaseColor.RED)));
				}
				else {
					currentCell=new PdfPCell(new Phrase(cellText, new Font(bf, 16, 1, BaseColor.BLACK)));
				}	
				currentCell.setFixedHeight(60.0f);
				currentCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				currentCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cardsTable.addCell(currentCell);	
				PdfPCell emptyCell=currentCell=new PdfPCell(new Phrase("", new Font(bf, 16, 1, BaseColor.BLACK)));
				emptyCell.setBorder(Rectangle.OUT_LEFT);
				emptyCell.setBorder(Rectangle.OUT_RIGHT);
				cardsTable.addCell(emptyCell);
			}
			for (int k = 0; k < 8; k++) {
				PdfPCell emptyCell=new PdfPCell(new Phrase(" ", new Font(bf, 16, 1, BaseColor.BLACK)));
				emptyCell.setBorder(PdfPCell.NO_BORDER);
				cardsTable.addCell(emptyCell);
			}
		}
		document.add(cardsTable);
		document.close();
	}
}
