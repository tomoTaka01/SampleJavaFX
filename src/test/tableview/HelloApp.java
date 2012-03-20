/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.tableview;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author tomo
 */
public class HelloApp extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        HelloStage helloStage = new HelloStage();
        Stage s= helloStage.createStage();
        s.show();        
//        stage.show();
    }

    public static void main(String[] args){
        launch();
    }
}
