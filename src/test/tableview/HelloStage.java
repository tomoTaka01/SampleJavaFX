/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.tableview;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author tomo
 */
public class HelloStage {
    public Stage createStage(){
        Stage stage = new Stage();
        stage.setTitle("Hello App");
        stage.setScene(getScence());
        return stage;
    }

    private Scene getScence() {
        BorderPane layout = new BorderPane();
        layout.setTop(getTop());
        layout.setBottom(getBottom());
        layout.setLeft(getLeft());
        layout.setRight(getRight());
        layout.setCenter(getCenter());        
        final Group root = new Group();        
        Scene scene = new Scene(root);
        root.getChildren().add(layout);
        scene.getStylesheets().add("default.css");
        return scene;
    }
    
    private Node getTop() {
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setPadding(new Insets(10, 10, 10, 50));
        hBox.setStyle("-fx-background-color: darkcyan;");
        hBox.getChildren().addAll(getLabel());
        return hBox;
    }
    private Label getLabel() {
        final Label label = new Label("Zoom Label");
        label.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                setZoomOn(label);
            }
        });
        label.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                setZoomOff(label);
            }
        });
        return label;
    }
    
    private Node getBottom() {
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.BASELINE_RIGHT);
        hBox.setPadding(new Insets(10, 50, 10, 10));
        hBox.getChildren().add(getExitButton());
        return hBox;
    }
    private Button getExitButton(){
        Button button = new Button("exit");
        button.setPrefSize(50, 20);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {                
                exitWindow(t);
            }
        });
        return button;
    }
    
    private Node getLeft() {
        Group group = new Group();
        Label label = new Label("");
        label.setMinWidth(50);
        group.getChildren().add(label);
        return group;
    }

    private Node getRight() {
        Group group = new Group();
        Label label = new Label("");
        label.setMinWidth(50);
        group.getChildren().add(label);
        return group;
    }
    
    private Node getCenter() {
        TableView<Person> table = new TableView<>();
        getTableColumns(table);
        table.setItems(fetchDataFromServer());
        return table;
    }

    private void getTableColumns(TableView<Person> tableView){
        TableColumn<Person, String> firstNameCol = new TableColumn<>("first name");
        firstNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        firstNameCol.setMinWidth(100);
        TableColumn<Person, String> lastNameCol = new TableColumn<>("last name");
        lastNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
        lastNameCol.setMinWidth(100);
        TableColumn<Person, String> emailCol = new TableColumn<>("Email");
        emailCol.setCellValueFactory(new PropertyValueFactory<Person, String>("email"));
        emailCol.setMinWidth(200);
        tableView.getColumns().addAll(firstNameCol, lastNameCol, emailCol);
    }

    private ObservableList<Person> fetchDataFromServer(){
        List<Person> list = new ArrayList<>();
        list.add(new Person("Duke1", "Java1", "email1@my.company.com"));
        list.add(new Person("Duke2", "Java2", "email2@my.company.com"));
        return FXCollections.observableList(list);
    }
    
    private void setZoomOn(Label label){
        label.setScaleX(1.5);
        label.setScaleY(1.5);
    }
    private void setZoomOff(Label label){
        label.setScaleX(1);
        label.setScaleY(1);
    }
    private void exitWindow(ActionEvent t){
        System.exit(0);
    }
    
}
