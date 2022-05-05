package webapp;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Objects;

import static org.junit.Assert.*;

public class CreatePDFTest {

    @Test
    public void create() throws IOException, DocumentException {
        HashSet<String> services = new HashSet<>();
        services.add("Полировка полов");
        CreatePDF docGen = new CreatePDF();
        SQLConnect.Connect();
        CleanPrices.initCleanPrices();
        String firstPath = getPdfPath();
        Create("FullName", "Time", "Date", "Address", "CleanType", "CleanArea", 1, services);
        assertNotEquals(firstPath, getPdfPath());
    }

    public static String getPdfPath() {
        return pdfPath;
    }

    public static String pdfPath;

    private BaseFont times = null;

    public void Create(String fullName, String time_calc, String date_calc, String address_calc, String clean_type_calc, String clean_area_calc, int price, HashSet<String> clean_services) throws IOException, DocumentException {

        Document document = new Document();

        String filepath = new File("").getCanonicalPath();
        String[] parsfilepath = filepath.split("/");

        int lengthpath = parsfilepath.length;
        StringBuilder abspath= new StringBuilder();
        for(int i=0;i<(lengthpath-1);i++) {
            abspath.append(parsfilepath[i]).append("/");
        }
        filepath=abspath + "Check.pdf";
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
        paragraph.add(new Paragraph("ООО \"Кошка Клининг\"", new Font(times,20)));
        paragraph.add(new Paragraph(fullName + ", ваш заказ по адресу " + address_calc, new Font(times,16)));
        paragraph.add(new Paragraph("Дата и время уборки: " + date_calc + time_calc, new Font(times,16)));
        paragraph.add(new Paragraph("Площадь помещения: " + clean_area_calc, new Font(times,16)));
        paragraph.add(new Paragraph("Тип уборки: " + clean_type_calc, new Font(times,16)));
        paragraph.add(new Paragraph("Сумма заказа: " + price, new Font(times,20)));
        document.add(paragraph);
        paragraph.clear();
        document.close();


    }

}