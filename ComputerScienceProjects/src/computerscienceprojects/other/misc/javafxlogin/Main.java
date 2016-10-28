/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.other.misc.javafxlogin;

import com.sun.org.apache.xml.internal.security.utils.Base64;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
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

        int vpos = 0;
        int hpos = 0;

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

        Label usernameLabel = new Label("Username: ");
        grid.add(usernameLabel, hpos++, vpos);          // 0,1

        TextField usernameField = new TextField();
        grid.add(usernameField, hpos--, vpos++);        // 1,1
        usernameField.setPrefWidth(250);

        Label passwordLabel = new Label("Password: ");
        grid.add(passwordLabel, hpos++, vpos);          // 0,2

        PasswordField passwordField = new PasswordField();
        grid.add(passwordField, hpos--, vpos++);        // 1,2
        passwordField.setPrefWidth(250);

        HBox hbtnRegister = new HBox(10);
        hbtnRegister.setAlignment(Pos.BOTTOM_RIGHT);

        HBox hbtnLogin = new HBox(10);
        hbtnLogin.setAlignment(Pos.BOTTOM_RIGHT);

        Button register = new Button();
        register.setText("Register");
        register.setOnAction((ActionEvent event) -> {

            feedback.setFill(Color.FIREBRICK);
            String text = register(usernameField.getText(),
                    passwordField.getText());
            feedback.setText(text);
        });

        Button login = new Button();
        login.setText("Login");
        login.setOnAction((ActionEvent event) -> {

            feedback.setFill(Color.FIREBRICK);
            String text = login(usernameField.getText(),
                    passwordField.getText());
            feedback.setText(text);
        });

        hbtnRegister.getChildren().add(register);
        hbtnLogin.getChildren().add(login);

        grid.add(hbtnRegister, hpos++, vpos);           // 0,3
        grid.add(hbtnLogin, hpos, vpos++);              // 1,3
        grid.add(feedback, hpos--, vpos++);             // 1,4

        Scene scene = new Scene(grid, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private static String register(String username, String password) {

        if (username.equals("") || password.equals("")) {

            return "Username or password must not be blank.";
        }
        try {

            PrintWriter writer;
            Scanner scanner;
            File f = new File("database.txt");
            try {
                scanner = new Scanner(f);
                while(scanner.hasNextLine()) {
                    
                    if(username.equals(scanner.nextLine().split(":")[0])){
                        
                        return "Username taken.";
                    }
                }
            } catch (FileNotFoundException e) {

                try {
                    new FileWriter(f).close();
                } catch (IOException ex) {
                    return "Could not create file.";
                }
            }
            FileWriter fw = new FileWriter(f, true);
            writer = new PrintWriter(fw);
            writer.println(username + ":" + hash(password));
            writer.close();
            return "Register successful.";
        } catch (IOException e) {

            return "Could not create file.";
        }
    }

    private static String login(String username, String password) {

        String user;
        String passhash;
        Scanner scanner;
        File f = new File("database.txt");
        try {
            scanner = new Scanner(f);
        } catch (FileNotFoundException e) {

            try {
                new FileWriter(f).close();
            } catch (IOException ex) {
                return "Could not create file.";
            }
            return "Incorrect username or password.";
        }

        while (scanner.hasNextLine()) {

            String[] s = scanner.nextLine().split(":");
            if (s[0].equalsIgnoreCase(username)) {

                if (s[1].equals(hash(password))) {

                    scanner.close();
                    return "Login Successful!";
                }
            }
        }
        scanner.close();
        return "Incorrect username or password.";
    }

    private static String hash(String s) {

        try {

            byte[] b = s.getBytes("UTF-8");
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(b);
            return Base64.encode(hash);
        } catch (Exception e) {
            return "Hashing Error";
        }
    }

    private String hash(String s, String salt) {

        return hash(s + salt);
    }
}
