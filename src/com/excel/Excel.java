package com.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Workbook;
        
public class Excel {
    private static Workbook workbook;
    private static FileOutputStream outputStream;
    private static final String dosyaAdi =(String) "ad";
    String a=(String) System.getProperty("user.name");
    private static final String FILE_NAME = "FR_02_MT.xlsx";  //kullandığı dosya, bu dosya üzerinde değişiklik yapmıyor, değişiklik yapınca alttaki konuma kaydediyor.
    private static final String newFileName = System.getProperty("user.home") + "/Desktop/" + dosyaAdi + ".xlsx"; //yeni oluşturup kaydettiği dosya
    private static final String newFileNamePDF = System.getProperty("user.home") + "/Desktop/" + dosyaAdi + ".pdf";
    
    public static void doInBackground() throws IOException {  // satir hangi satıra, sütün hangi sütuna ve y de ne yazacağını belirliyor.
        FileInputStream inputStream = new FileInputStream(new File(FILE_NAME));
        workbook = WorkbookFactory.create(inputStream);  
        
        
    }
    
    public void finallyE(){
        try { 
            outputStream = new FileOutputStream(newFileName);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
            System.out.println("Yeni Excel Dosyası Oluşturuldu");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void finallyPDF(){
      
        finallyE();
        toPDF t = new toPDF();
        t.toPDF(newFileName, newFileNamePDF);
    }
    
    public void writeE(int satir, int sutun, String y){
        
        Sheet sheet = workbook.getSheetAt(0);
        int rowNum=satir;
        int colNum=sutun;
        CellStyle style = workbook.createCellStyle();
        Row row = sheet.getRow(rowNum);
        Cell eski = row.getCell(colNum);
        style.setBorderBottom(eski.getCellStyle().getBorderBottom());
        style.setBorderLeft(eski.getCellStyle().getBorderLeft());
        style.setBorderRight(eski.getCellStyle().getBorderRight());
        style.setBorderTop(eski.getCellStyle().getBorderTop());
        
        Cell cell = row.createCell(colNum);
        Font font = workbook.createFont();  
        font.setFontHeightInPoints((short)9);
        style.setFont(font);
        cell.setCellStyle(style);    
        cell.getCellStyle().setVerticalAlignment(VerticalAlignment.CENTER);
        cell.getCellStyle().setAlignment(HorizontalAlignment.CENTER);
        cell.setCellValue((String) y);
    }
    
    private static PrintService findPrintService(String printerName) {
        PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);
        for (PrintService printService : printServices) {
            if (printService.getName().trim().equals(printerName)) {
                return printService;
            }
        }
        return null;
    }
    
}
