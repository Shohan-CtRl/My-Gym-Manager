package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.*;
import java.util.Scanner;

import static sample.MyGymManager.theList;

public class Gui extends Application {
    //Creates table View.
    private TableView table = new TableView();
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Table View Sample");
        stage.setWidth(300);
        stage.setHeight(700);

        final Label label = new Label("Address Book");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);
        //Adds columns to table
        TableColumn firstNameCol = new TableColumn("M_Name");
        TableColumn lastNameCol = new TableColumn("M_ID");
        TableColumn emailCol = new TableColumn("Date");

        table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        //Creating the search functionality of GUI
        //Creating text field to take input value.
        TextField tf1 = new TextField("Search here");
        //Label to display output
        Label c_lb1 = new Label("");
        c_lb1.setMinSize(227,34);
        //2nd label to display output.
        Label c_lb2 = new Label("");
        c_lb1.setMinSize(227,34);
        //Button to search for input.
        Button btn = new Button("Search");
        btn.setOnAction(actionEvent -> {
                    //Overrides array with data values found in file.
                    FileInputStream fis = null;
                    int i = 0;
                    try {
                        fis = new FileInputStream("BinaryFile.txt");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    ObjectInputStream ois1 = null;
                    try {
                        ois1 = new ObjectInputStream(fis);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    boolean CreatingList = true;

                    while (CreatingList == true) {
                        try {
                            DefaultMember TempObject2 = ((DefaultMember) ois1.readObject());
                            if (TempObject2 != null) {


                                if (i < theList.length) {
                                    theList[i] = TempObject2;
                                    i++;
                                }
                            }
                            if (TempObject2 == null) {
                                CreatingList = false;
                            }
                        } catch (EOFException e) {
                            System.out.println("Completed reading object");
                            break;
                        } catch (ClassNotFoundException e) {
                            System.out.println("File not found...");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    Scanner sc = new Scanner(System.in);
                    String Search = tf1.getText();
                    int Countx;
                    for (Countx = 0; Countx <i; Countx++) {
                        System.out.println(""+tf1);
                        System.out.println(""+Search);
                        // Searching for and displaying found value.
                            if (theList[Countx].getMembershipNumber().equals(Search)) {
                                c_lb1.setText("Member Name: "+theList[Countx].getMemberName());
                                c_lb2.setText("Member Number: "+theList[Countx].getMembershipNumber());

                                break;
                            }


                    }
                });



        vbox.getChildren().addAll(label, table);
        vbox.getChildren().add(tf1);
        vbox.getChildren().add(c_lb1);
        vbox.getChildren().add(c_lb2);
        vbox.getChildren().add(btn);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }
}