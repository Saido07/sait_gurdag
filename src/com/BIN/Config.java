/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BIN;

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
    
}
