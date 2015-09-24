package ru.sa2.appfx;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import ru.sa2.appfx.model.Person;
import ru.sa2.appfx.view.PersonOverviewController;

import java.io.IOException;

/**
 * http://code.makery.ch/library/javafx-8-tutorial/ru/part3/
 */

public class MainApp extends Application {

    private BorderPane root;

    /**
     * The data as an observable list of Persons.
     */
    private ObservableList<Person> personData = FXCollections.observableArrayList();

    /**
     * Constructor
     */
    public MainApp() {
        // Add some sample data
        personData.add(new Person("Hans", "Muster"));
        personData.add(new Person("Ruth", "Mueller"));
        personData.add(new Person("Heinz", "Kurz"));
        personData.add(new Person("Cornelia", "Meier"));
        personData.add(new Person("Werner", "Meyer"));
        personData.add(new Person("Lydia", "Kunz"));
        personData.add(new Person("Anna", "Best"));
        personData.add(new Person("Stefan", "Meier"));
        personData.add(new Person("Martin", "Mueller"));
    }

    /**
     * Returns the data as an observable list of Persons.
     * @return
     */
    public ObservableList<Person> getPersonData() {
        return personData;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        root = FXMLLoader.load(getClass().getResource("view/RootLayout.fxml"));
        primaryStage.setTitle("AddressApp");
        primaryStage.setScene(new Scene(root));
//        primaryStage.setAlwaysOnTop(true);
        primaryStage.show();

        showPersonOverview();
    }

    public void showPersonOverview() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/PersonOverview.fxml"));
        AnchorPane personOverview = loader.load();
        root.setCenter(personOverview);

        PersonOverviewController controller = loader.getController();
        controller.setMainApp(this);
    }

    public static void main(String[] args) {
        launch(args);
    }

}