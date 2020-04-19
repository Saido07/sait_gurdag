/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BIN;

import fxmlController.leftSceneAdminLoginController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;

/**
 *
 * @author sait_
 */
public class Config {
    
    public static void AnchorPaneConst(Region region, double left, double right, double top, double bottom) {
        AnchorPane.setBottomAnchor(region,bottom);
        AnchorPane.setLeftAnchor(region,left);
        AnchorPane.setRightAnchor(region,right);
        AnchorPane.setTopAnchor(region,top);
    }
    
    
    public static void Loader(Region region, String url) {
        
        FXMLLoader fxmlLoader = new FXMLLoader(region.getClass().getResource(url));
        fxmlLoader.setRoot(region);
        fxmlLoader.setController(region);
        try {
            fxmlLoader.load();
        } catch (IOException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   
    
}
