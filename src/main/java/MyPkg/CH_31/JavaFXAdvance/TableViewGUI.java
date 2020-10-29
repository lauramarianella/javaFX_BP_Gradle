/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPkg.CH_31.JavaFXAdvance;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author laura
 */
public class TableViewGUI extends Application {
    @Override
    public void start(Stage stage){
        TableView<Person> tableView = new TableView<>();
        
        TableColumn<Person,String> firstNameCol = new TableColumn<>("First Name");
        firstNameCol.setCellValueFactory(new PropertyValueFactory("firstName"));
        
        TableColumn<Person,String> lastNameCol = new TableColumn<>("Last Name");
        lastNameCol.setCellValueFactory(new PropertyValueFactory("lastName"));
        
        TableColumn<Person,String> emailCol = new TableColumn<>("Email");
        emailCol.setCellValueFactory(new PropertyValueFactory("email"));
        
        if(true){
            tableView.getColumns().add(firstNameCol);
            tableView.getColumns().add(lastNameCol);
            tableView.getColumns().add(emailCol);
        }else{
            tableView.getColumns().setAll(firstNameCol, lastNameCol, emailCol);
        }
        
        if(true){
            tableView.getItems().add(new Person("John", "Doe","1@myemail.com"));
            tableView.getItems().add(new Person("Jane", "Deer", "2@myemail.com"));
            tableView.getItems().add(new Person("Dina", "Kam", "3@myemail.com"));
            tableView.getItems().add(new Person("Carla", "B", "4@myemail.com"));
            tableView.getItems().add(new Person("Sly", "Chan", "5@myemail.com"));
            tableView.setPrefHeight(180);
            tableView.setPrefWidth(260);
        }else{
            tableView.setItems(getData());
        }
        
        emailCol.setVisible(true);
        
        Scene scene = new Scene(new AnchorPane(tableView),300,500);
        stage.setTitle("Table GUI");
        if(false) scene.getStylesheets().add(getClass().getResource("stylesTableView.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
    public ObservableList<Person> getData(){
        ObservableList<Person> olData = FXCollections.observableArrayList(
            new Person("Jacob", "Smith", "3@myemail.com"),
            new Person("Isabella", "Johnson", "4@myemail.com"),
            new Person("Ethan", "Williams", "5@myemail.com"),
            new Person("Emma", "Jones", "6@myemail.com"),
            new Person("Michael", "Brown", "7@myemail.com")
        );
        olData.add(new Person("Jaques", "Terrien", "8@myemail.com"));
        
        return olData;
    }
}
