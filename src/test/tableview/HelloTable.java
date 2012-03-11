/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.tableview;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author tomo
 */
public class HelloTable extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Hello Table");
        final Group root = new Group();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        root.getChildren().add(getTableView());
        stage.show();
    }

    private static TableView getTableView() {
        TableView<Person> table = new TableView<Person>();
        getTableColumns(table);
        table.setItems(fetchDataFromServer());
        return table;
    }

    private static void getTableColumns(TableView<Person> tableView){
        TableColumn<Person, String>[] columns = null;
        TableColumn<Person, String> firstNameCol = new TableColumn<Person, String>("first name");
        firstNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        TableColumn<Person, String> lastNameCol = new TableColumn<Person, String>("last name");
        lastNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
        tableView.getColumns().addAll(firstNameCol, lastNameCol);
    }
    private static ObservableList<Person> fetchDataFromServer(){
        List<Person> list = new ArrayList<Person>();
        list.add(new Person("Duke1", "Java1"));
        list.add(new Person("Duke2", "Java2"));
        return FXCollections.observableList(list);
    }
    
    public static void main(String[] args){
        launch();
    }
}
