public class FactoryMethodTest {

    public static void main(String[] args) {

        DocumentFactory pdfFactory = new PdfFactory();
        pdfFactory.openDocument();

        DocumentFactory wordFactory = new WordFactory();
        wordFactory.openDocument();

        DocumentFactory excelFactory = new ExcelFactory();
        excelFactory.openDocument();
    }
}
