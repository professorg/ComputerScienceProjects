/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.other.misc.javafxlogin;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author gvandomelen19
 */
public class Main extends Application {
    
    public static void main(String[] args) {
        
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        primaryStage.setTitle("Login");
        
        int vpos=0;
        int hpos=0;
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));
        
        Text title = new Text();
        title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        title.setText("Welcome");
        
        grid.add(title, hpos, vpos++, 2, 1);            // 0,0
        
        final Text feedback = new Text();
        
        HBox hbtn = new HBox(10);
        hbtn.setAlignment(Pos.BOTTOM_RIGHT);
        
        Label usernameLabel = new Label("Username: ");
        grid.add(usernameLabel, hpos++, vpos);          // 0,1
        
        TextField usernameField = new TextField();
        grid.add(usernameField, hpos--, vpos++);        // 1,1
        
        Label passwordLabel = new Label("Password: ");
        grid.add(passwordLabel, hpos++, vpos);          // 0,2
        
        TextField passwordField = new TextField();
        grid.add(passwordField, hpos--, vpos++);        // 1,2
        
        Button submit = new Button();
        submit.setText("Login");
        submit.setOnAction((ActionEvent event) -> {
            
            feedback.setFill(Color.FIREBRICK);
            feedback.setText("Hello, world!");
        });
        
        hbtn.getChildren().add(submit);                 // 0,3
        
        grid.add(hbtn, ++hpos, vpos++);                 // 1,4
        grid.add(feedback, hpos--, vpos++);             // 1,5
        
        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
}
