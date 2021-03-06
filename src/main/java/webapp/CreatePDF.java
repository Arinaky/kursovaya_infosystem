package webapp;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Objects;
import java.util.stream.Stream;

// TODO: Auto-generated Javadoc
/**
 * The Class CreatePDF.
 * @author Shimanov K.A.
 */
public class CreatePDF {
	
	/** The times. */
	private BaseFont times = null;

	/**
	 * Gets the pdf path.
	 *
	 * @return the pdf path
	 */
	public static String getPdfPath() {
		return pdfPath;
	}

	/** The pdf path. */
	public static String pdfPath;

    /**
     * Creates the.
     *
     * @param fullName the full name
     * @param time_calc the time calc
     * @param date_calc the date calc
     * @param address_calc the address calc
     * @param clean_type_calc the clean type calc
     * @param clean_area_calc the clean area calc
     * @param price the price
     * @param clean_services the clean services
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void Create(String fullName, String time_calc, String date_calc, String address_calc, String clean_type_calc, String clean_area_calc, int price, HashSet<String> clean_services) throws IOException {
      	
    	Document document = new Document();
    	
    	String filepath = new File("").getCanonicalPath();
		String[] parsfilepath = filepath.split("/");
		
		int lengthpath = parsfilepath.length;
		StringBuilder abspath= new StringBuilder();
		for(int i=0;i<(lengthpath-1);i++) {
			abspath.append(parsfilepath[i]).append("/");
		}
		filepath=abspath + "/Check.pdf";
		pdfPath = filepath;
		String imagepath= Objects.requireNonNull(CreatePDF.class.getResource("/img/logo.png")).getPath();
		String fontpath = Objects.requireNonNull(CreatePDF.class.getResource("/fonts/times.ttf")).getPath();
    	
		try {	
			PdfWriter.getInstance(document, new FileOutputStream(filepath));
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}
					
		document.open(); 

		try {
			times = BaseFont.createFont(fontpath, "cp1251", BaseFont.EMBEDDED);
		} catch (DocumentException | IOException e) {
			e.printStackTrace();
		}
		
		Paragraph paragraph = new Paragraph();
	    paragraph.add(new Paragraph("?????? \"?????????? ??????????????\"", new Font(times,20)));
	    paragraph.add(new Paragraph(fullName + ", ?????? ?????????? ???? ???????????? " + address_calc, new Font(times,16)));
	    paragraph.add(new Paragraph("???????? ?? ?????????? ????????????: " + date_calc + time_calc, new Font(times,16)));
	    paragraph.add(new Paragraph("?????????????? ??????????????????: " + clean_area_calc, new Font(times,16)));
	    paragraph.add(new Paragraph("?????? ????????????: " + clean_type_calc, new Font(times,16)));
	    paragraph.add(new Paragraph("?????????? ????????????: " + price, new Font(times,20)));

		try {
			document.add(paragraph);
		} catch (DocumentException e1) {
			e1.printStackTrace();
		}
	    
		paragraph.clear();

	    Image img = null;
		try {
			img = Image.getInstance(imagepath);
		} catch (BadElementException | IOException e2) {
			e2.printStackTrace();
		}

		Objects.requireNonNull(img).setAbsolutePosition(450, 700);

		try {
				document.add(img);
		} catch (DocumentException e) {
				e.printStackTrace();
		}

		if (!clean_services.isEmpty())	{
			paragraph.clear();

			PdfPTable table = new PdfPTable(2);
			addHeader(table);
			for (String clean_service: clean_services) {
				if (clean_service != null) {
					addRows(table, clean_service, String.valueOf(CleanPrices.getClean_services_prices(clean_service)));
				}
			}

			try {
				document.add(table);
			} catch (DocumentException e) {
				e.printStackTrace();
			}
		}
	     
	    document.close(); 
	    
	    
    }
    

	/**
	 * Adds the rows.
	 *
	 * @param table the table
	 * @param cell1 the cell 1
	 * @param cell2 the cell 2
	 */
	private void addRows(PdfPTable table, String cell1, String cell2) {
		table.addCell((new Phrase(cell1, new Font(times,14))));
	    table.addCell((new Phrase(cell2, new Font(times,14))));
	}

	/**
	 * Adds the header.
	 *
	 * @param table the table
	 */
	private void addHeader(PdfPTable table) {
		Stream.of("???????????????????????????? ????????????", "????????").forEach(columnTitle -> {
        	PdfPCell header = new PdfPCell();
        	header.setBackgroundColor(BaseColor.LIGHT_GRAY);
        	header.setBorderWidth(2);
        	header.setPhrase(new Phrase(columnTitle, new Font(times,14)));
        	table.addCell(header);
		});
}


}
