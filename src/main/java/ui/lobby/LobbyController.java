package ui.lobby;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.OverrunStyle;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ui.navigator.NavigationConstants;
import ui.navigator.Navigator;

import java.io.IOException;
import java.util.HashSet;

import static ui.Utils.getStage;

public class LobbyController {
    private final HashSet<String> playerNames = new HashSet<>();
    @FXML
    public Button addPlayerButton;
    @FXML
    private GridPane playerList;
    @FXML
    private TextField playerNameField;
    @FXML
    private Button startMatchButton;

    @FXML
    public void addPlayer() {
        String playerName = playerNameField.getText();
        if (playerName.isEmpty()) {
            return;
        }
        playerNames.add(playerName);

        Pane rowContainer = new Pane();
        rowContainer.setPadding(new javafx.geometry.Insets(20, 0, 20, 0));
        rowContainer.setPrefHeight(30);

        Label playerNameText = new Label(playerName);
        playerNameText.setFont(Font.font(20));
        playerNameText.setMaxWidth(140);
        playerNameText.setTextOverrun(OverrunStyle.ELLIPSIS);
        rowContainer.getChildren().add(playerNameText);
        playerNameText.relocate(0, 0);

        Button removePlayerButton = new Button("Remove");
        removePlayerButton.setStyle("-fx-font-size:14");
        rowContainer.getChildren().add(removePlayerButton);
        removePlayerButton.relocate(180, 0);

        removePlayerButton.setOnAction(event -> {
            playerNames.remove(playerName);
            playerList.getChildren().remove(rowContainer);
            startMatchButtonEnable();
        });

        playerList.addRow(playerList.getRowCount(), rowContainer);

        startMatchButtonEnable();

        playerNameField.clear();

        addPlayerButtonEnable();
    }

    @FXML
    public void returnToMainMenu(ActionEvent e) throws Exception {
        Navigator navigator = new Navigator();
        navigator.navigateTo(getStage(e), NavigationConstants.STARTING_MENU_FXML);
    }

    @FXML
    public void startMatch(ActionEvent e) throws IOException {
        Navigator navigator = new Navigator();
        navigator.navigateTo(getStage(e), NavigationConstants.MAIN_GAME_FXML);
    }

    @FXML
    public void onPlayerNameChange() {
        addPlayerButtonEnable();
    }

    private void startMatchButtonEnable() {
        startMatchButton.setDisable(playerNames.isEmpty());
    }

    private void addPlayerButtonEnable() {
        addPlayerButton.setDisable(playerNameField.getText().isEmpty() || playerNames.contains(playerNameField.getText()));
    }
}
