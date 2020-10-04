package sample;

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.shape.Box;
import javafx.scene.text.TextAlignment;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;
/**
 * Det är ett tärningsspel med grafiskt användar utseende. Man kan välja att skriva
 * in namnen i rutorna och sedan trycka sätt namn då ändras Player 1 och player 2 till de namnen man valt. Sen
 * när man trycker spela så genereras det nya nummer varje gång man trycker och skrivs ut i vinnar rutan vem som
 * hade högst värde.*/

public class Main extends Application  {
    Controller controller = new Controller();



    TextField tf1;
    TextField tf2;
    TextField tf3;



    public static void main(String[] args) {
        launch(args);

    }

    public void start(Stage stage) {

        //gird layout för fönstret
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(12);
        grid.setAlignment(Pos.CENTER);
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setHalignment(HPos.LEFT);
        grid.getColumnConstraints().add(column1);

        ColumnConstraints column2 = new ColumnConstraints();
        column2.setHalignment(HPos.LEFT);
        grid.getColumnConstraints().add(column2);

        stage.setTitle("Tärnings Spel");

        FlowPane rootNode = new FlowPane(grid);

        rootNode.setAlignment(Pos.CENTER); // centrerar scenen så den är mitten på fönstret
        Scene nyScen = new Scene(rootNode, 1000, 300); //anger storlek på fönstret
        nyScen.getStylesheets().add("stylesheet.css"); //Hämtar css
        stage.setScene(nyScen);


        Label heading = new Label("Tärnings spel!"); //sätter rubriken
        heading.setId("heading"); // ger heading ett id så man kan använda css för att ändra stylingen

        Label playerOne = new Label("Player One");
        Label playerTwo = new Label("Player Two");

        //Ger värden för att kunna styla i css
        playerOne.setId("player");
        playerTwo.setId("player");

        Label winner = new Label("Vinnare: ");
        winner.setId("player");

        tf1 = new TextField(); // Skapar ett textfield för att kunna skriva in namn men också skriva ut resultat
        tf1.setPrefColumnCount(15);

        tf2 = new TextField(); // Skapar ett textfield för att kunna skriva in namn men också skriva ut resultat
        tf2.setPrefColumnCount(15);
        tf1.setId("textruta"); //ger ett id för att kunna styla i css
        tf2.setId("textruta");

        tf3 = new TextField(); // Skapar ett textfield för att kunna skriva in namn men också skriva ut resultat
        tf3.setPrefColumnCount(15);
        tf3.setId("textruta");

    Button btn = new Button("Spela"); //skapar en ny knapp
    Button btn2 = new Button("Sätt namn"); //skapar en ny knapp
    btn.setId("btn");
    btn2.setId("btn");

/**Denna eventhandler gör att varje gång man trycker på knappen spela så körs spelet, alltså det skrivs ut två nya tal
 * för varje spelare och if satsen kollar vem av spelarna som fick högst värde och skriver ut detta i vinnare rutan.*/

        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    int player1 = controller.tossDicePlayer1();
                    int player2 = controller.tossDicePlayer2();
                   // controller.printOutput();
                    tf1.setText(Integer.toString(player1));
                    tf2.setText(Integer.toString(player2));

                    if (player1 > player2) {
                        tf3.setText(Integer.toString(player1));
                    } else {
                        tf3.setText(Integer.toString(player2));
                    }
                }

            };
            btn.setOnAction(event);
 /**Denna eventhandler gör så att om man väljer att skriva in namn och trycker på knappen sätt namn så
  * ändras player 1 och player 2 till de namn man valt att skriva in. Man kan ändra namnen när som helst
  * under spelets gång.*/
        EventHandler<ActionEvent> ae = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {

                playerOne.setText(tf1.getText());
                playerTwo.setText(tf2.getText());

            }
        };

        btn2.setOnAction(ae);
        rootNode.getChildren().addAll(heading,playerOne,playerTwo,tf1,tf2,tf3,btn,btn2);
        //Skapar vart allt ska finnas i gridet i fönstret.
        grid.add(heading,0,0);
        grid.add(playerOne, 0, 1);
        grid.add(playerTwo, 2, 1);
        grid.add(tf1, 0, 2);
        grid.add(tf2, 2, 2);
        grid.add(btn, 0, 3);
        grid.add(btn2, 2, 3);
        grid.add(winner, 0, 4);
        grid.add(tf3, 0, 5);
        stage.show();

    }

}