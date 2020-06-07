/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.excel;

import com.aspose.cells.SaveFormat;
import com.aspose.cells.Workbook;
import java.util.logging.Level;
import java.util.logging.Logger;

public class toPDF {
    
    public void toPDF(String s, String k){
        try {
            Workbook workbook = new Workbook(s);

            // Save the document in PDF format
            workbook.save(k, SaveFormat.PDF);

            // Print message
            System.out.println("Excel to PDF conversion performed successfully.");

        } catch (Exception ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
