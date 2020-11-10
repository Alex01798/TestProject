import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


public class HelloWorld extends Application {
    @Override
    public void start(Stage stage) {
        String word = "Test";

        Pane root = new Pane();
        Scene scene = new Scene(root, 300, 250);
        scene.getStylesheets().add("stylesheet.css");
        stage.setTitle("Hello World!");
        stage.setScene(scene);
        stage.show();

        Text text1 = new Text("Enter Word");
        text1.setLayoutX(85); text1.setLayoutY(90);
        text1.getStyleClass().add("h1");
        root.getChildren().add(text1);

        TextField wordEnter = new TextField();
        wordEnter.setLayoutX(85); wordEnter.setLayoutY(100);
        root.getChildren().add(wordEnter);

        Button myButton = new Button("Submit");
        myButton.setPrefSize(65, 25);
        myButton.getStyleClass().add("funky_button");
        myButton.setWrapText(true);
        myButton.setLayoutX(85); myButton.setLayoutY(135);
        myButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Word saved");
                alert.showAndWait();
                System.out.println(wordEnter.getText());
            }
        });
        root.getChildren().add(myButton);




    }

    public class StageTwo {
        static Pane parent;
        public StageTwo(Pane theParent) {

            Stage stage = new Stage();
            parent = theParent;
            parent.setDisable(true);
            start(stage);

        }

        public void start(Stage stage) {

            Pane root = new Pane();
            Scene scene = new Scene(root, 1024, 768);
            stage.setTitle("This is another scene.");
            stage.setScene(scene);
            stage.setOnCloseRequest((WindowEvent we) -> closeStage(stage));
            stage.show();

        }

        public void closeStage(Stage stage) {

            parent.setDisable(false);
            stage.close();

        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
