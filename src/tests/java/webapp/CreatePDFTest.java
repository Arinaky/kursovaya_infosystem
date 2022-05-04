package webapp;

import java.io.IOException;
import java.util.HashSet;

import static org.junit.Assert.*;

public class CreatePDFTest {

    @org.junit.Test
    public void create() throws IOException {
        HashSet<String> services = new HashSet<>();
        services.add("Полировка полов");
        CreatePDF docGen = new CreatePDF();
        String firstPath = docGen.getPdfPath();
        docGen.Create("FullName", "Time", "Date", "Address", "CleanType", "CleanArea", 1, services);
        assertTrue(firstPath != docGen.getPdfPath());

    }
}