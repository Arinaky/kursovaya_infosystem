package webapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

public class CreatePDF {
	
	private BaseFont times = null;

	public static String getPdfPath() {
		return pdfPath;
	}

	public static String pdfPath;

    public void Create(String fullName, String time_calc, String date_calc, String address_calc, String clean_type_calc,
    		String clean_area_calc, int price) throws IOException {
      	
    	Document document = new Document();
    	
    	String filepath = new File("").getCanonicalPath();
		String[] parsfilepath = filepath.split("/");
		
		int lengthpath = parsfilepath.length;
		String abspath=""; 
		for(int i=0;i<(lengthpath-1);i++) {
			abspath=abspath+parsfilepath[i]+"/";
		}
		filepath=abspath + "webapps/WebApp/Check.pdf";
		pdfPath = filepath;
		String imagepath= CreatePDF.class.getResource("/img/logo.png").getPath();
		String fontpath = CreatePDF.class.getResource("/fonts/times.ttf").getPath();
    	
		try {	
			PdfWriter.getInstance(document, new FileOutputStream(filepath));
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}
					
		document.open(); 
		
		//BaseFont times = null;
		try {
			times = BaseFont.createFont(fontpath, "cp1251", BaseFont.EMBEDDED);
		} catch (DocumentException | IOException e) {
			e.printStackTrace();
		}
		
		Paragraph paragraph = new Paragraph();
	    paragraph.add(new Paragraph("ООО \"Кошка Клининг\"", new Font(times,20)));
	    paragraph.add(new Paragraph(fullName + ", ваш заказ по адресу " + address_calc, new Font(times,16)));
	    paragraph.add(new Paragraph("Дата и время уборки: " + date_calc + time_calc, new Font(times,16)));
	    paragraph.add(new Paragraph("Площадь помещения: " + clean_area_calc, new Font(times,16)));
	    paragraph.add(new Paragraph("Тип уборки: " + clean_type_calc, new Font(times,16)));
	    paragraph.add(new Paragraph("Сумма заказа: " + Integer.toString(price), new Font(times,20)));

		try {
			document.add(paragraph);
		} catch (DocumentException e1) {
			e1.printStackTrace();
		}
	    
		paragraph.clear();
		
	    

	    Image img = null;
		try {
			img = Image.getInstance(imagepath);

		} catch (BadElementException e2) {

			e2.printStackTrace();
		} catch (MalformedURLException e2) {

			e2.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}

		img.setAbsolutePosition(400, 800);

		try {
				document.add(img);
		} catch (DocumentException e) {
				e.printStackTrace();
		}

		
	    /*

		 paragraph.clear();
		 paragraph.add(new Paragraph(string_pdf3, new Font(times,14)));
		 
		 try {
				document.add(paragraph);
			} catch (DocumentException e1) {
				e1.printStackTrace();
			}
	    

		 PdfPTable table = new PdfPTable(4); 
		 addHeader(table);
		 addRows(table);
		 
		 try {
			document.add(table);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	     */
	     
	    document.close(); 
	    
	    
    }
    
/*
private void addRows(PdfPTable table) {
		
		String cell1 = Calc.NumberGet;
		String cell2 = Calc.GroupGet;
		String cell3 = Calc.FIOGet;
		String cell4 = Calc.PointsGet;
				
		table.addCell((new Phrase(cell1, new Font(times,14))));
	    table.addCell((new Phrase(cell2, new Font(times,14))));
	    table.addCell((new Phrase(cell3, new Font(times,14))));
	    table.addCell((new Phrase(cell4, new Font(times,14))));
		
	}

private void addHeader(PdfPTable table) {
	Stream.of("Номер", "Группа", "ФИО", "Оценка")
      .forEach(columnTitle -> {
        PdfPCell header = new PdfPCell();
        header.setBackgroundColor(BaseColor.LIGHT_GRAY);
        header.setBorderWidth(2);
        header.setPhrase(new Phrase(columnTitle, new Font(times,14)));
        table.addCell(header);
    });
}

*/
}
