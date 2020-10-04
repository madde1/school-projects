package sample;
import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;

public class Main extends Application {

    CheckBox cdSmartPhone;
    CheckBox cdTablet;
    CheckBox cdNotebook;
    CheckBox cdDesktop;

    Label response;
    Label selected;

    String computers;

    public static void main(String[] args){
        launch(args);
    }
    public void start(Stage myStage){
        myStage.setTitle("Demostrate Check Boxes");

        FlowPane rootNode = new FlowPane(Orientation.VERTICAL,10,10);

        rootNode.setAlignment(Pos.CENTER);

        Scene myScene = new Scene(rootNode, 230, 200);

        myStage.setScene(myScene);

        Label heading = new Label("What computers do you own?");

        response = new Label("");

        selected = new Label("");

        cdSmartPhone = new CheckBox("SmartPhone");
        cdTablet = new CheckBox("Tablet");
        cdNotebook = new CheckBox("Notebook");
        cdDesktop = new CheckBox("Desktop");

        cdSmartPhone.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
                if(cdSmartPhone.isSelected())
                response.setText("SmartPhone was just Selected");
                else
                    response.setText("SmartPhone was just cleared");

                showAll();
            }
        });

        cdTablet.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                if(cdTablet.isSelected())
                    response.setText("Tablet was just selected.");
                else
                    response.setText("Tablet was just cleared.");

                showAll();
            }
        });
        cdNotebook.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                if(cdNotebook.isSelected())
                    response.setText("Notebook was just selected.");
                else
                    response.setText("Notebook was just cleared.");

                showAll();
            }
        });
        cdDesktop.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                if(cdDesktop.isSelected())
                    response.setText("Desktop was just selected.");
                else
                    response.setText("Desktop was just cleared.");

                showAll();
            }
        });

        rootNode.getChildren().addAll(heading,cdSmartPhone,cdTablet,
                cdNotebook,cdDesktop,response,selected);

        myStage.show();
        showAll();
    }
    void showAll(){
        computers = "";
        if (cdSmartPhone.isSelected()) computers ="SmartPhone";
        if (cdTablet.isSelected()) computers = "Tablet";
        if (cdNotebook.isSelected()) computers = "Notebook";
        if (cdDesktop.isSelected()) computers = "Desktop";

        selected.setText("Computers selected: " + computers);
    }
}
