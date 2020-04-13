/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

//119 doldurulması gereken alan ve 2 tik atılalık alan var.
        
public class Excel {
    
    private static final String dosyaAdi =(String) "ad";
    String a=(String) System.getProperty("user.name");
    private static final String FILE_NAME = "FR_02_MT.xlsx";  //kullandığı dosya, bu dosya üzerinde değişiklik yapmıyor, değişiklik yapınca alttaki konuma kaydediyor.
    private static final String newFileName = System.getProperty("user.home") + "/Desktop/" + dosyaAdi + ".xlsx"; //yeni oluşturup kaydettiği dosya
    
    public static void main(int satir, int sutun, String y) throws IOException {  // satir hangi satıra, sütün hangi sütuna ve y de ne yazacağını belirliyor.
        FileInputStream inputStream = new FileInputStream(new File(FILE_NAME));
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        int rowNum=satir;
        int colNum=sutun;
        Row row = sheet.getRow(rowNum);
        Cell cell = row.createCell(colNum);
        cell.setCellValue((String) y);
        
        
        try {
            FileOutputStream outputStream = new FileOutputStream(newFileName);
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
    
}
