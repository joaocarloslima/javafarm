package br.com.joaocarloslima;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class Controller implements Initializable {

    // private Fazenda fazenda = new Fazenda();
    private List<ImageView> imageTerrenos = new ArrayList<>();
    private int sleepTime = 3000;

    @FXML
    GridPane grid;
    @FXML
    ToggleButton botaoBatata;
    @FXML
    ToggleButton botaoCenoura;
    @FXML
    ToggleButton botaoMorango;
    @FXML
    ToggleButton botaoColher;
    @FXML
    ProgressBar ocupacaoDoCeleiro;
    @FXML
    CheckBox ckbAcelerar;

    // public void atualizar() {
    //     botaoBatata.setText("Batata x " + fazenda.getCeleiro().getQtdeBatatas());
    //     botaoCenoura.setText("Cenoura x " + fazenda.getCeleiro().getQtdeCenouras());
    //     botaoMorango.setText("Morango x " + fazenda.getCeleiro().getQtdeMorangos());
    //     ocupacaoDoCeleiro.setProgress(fazenda.getCeleiro().getOcupacao());

    //     for (int x = 0; x < 13; x++) {
    //         for (int y = 0; y < 13; y++) {
    //             Terreno terreno = fazenda.getTerreno(x, y);
    //             ImageView imageView = imageTerrenos.get(x * 13 + y);
    //             if (terreno.getBatata() != null) {
    //                 imageView.setImage(new Image(getClass().getResourceAsStream(terreno.getBatata().getImagem())));
    //             } else if (terreno.getCenoura() != null) {
    //                 imageView.setImage(new Image(getClass().getResourceAsStream(terreno.getCenoura().getImagem())));
    //             } else if (terreno.getMorango() != null) {
    //                 imageView.setImage(new Image(getClass().getResourceAsStream(terreno.getMorango().getImagem())));
    //             } else {
    //                 imageView.setImage(null);
    //             }
    //         }
    //     }
    // }

    // public void ciclo() {
    //     for (int x = 0; x < 13; x++) {
    //         for (int y = 0; y < 13; y++) {
    //             Terreno terreno = fazenda.getTerreno(x, y);
    //             if (terreno.getBatata() != null) {
    //                 terreno.getBatata().crescer();
    //             } else if (terreno.getCenoura() != null) {
    //                 terreno.getCenoura().crescer();
    //             } else if (terreno.getMorango() != null) {
    //                 terreno.getMorango().crescer();
    //             }
    //         }
    //     }
    //     atualizar();
    // }

    public void acelerar() {
        if (ckbAcelerar.isSelected()) {
            sleepTime = 1000;
        } else {
            sleepTime = 3000;
        }
    }

    // public void clockThread() {
    //     Thread thread = new Thread(() -> {
    //         while (true) {
    //             try {
    //                 Thread.sleep(sleepTime);
    //                 Platform.runLater(() -> ciclo());
    //                 atualizar();
    //             } catch (InterruptedException e) {
    //                 e.printStackTrace();
    //             }
    //         }
    //     });
    //     thread.setDaemon(true);
    //     thread.start();
    // }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        for (int x = 0; x < 13; x++) {
            for (int y = 0; y < 13; y++) {
                ImageView imageView = new ImageView();
                imageView.setFitHeight(50);
                imageView.setFitWidth(50);
                grid.add(imageView, x, y);
                imageTerrenos.add(imageView);
            }
        }

        grid.setOnMouseClicked(e -> {
            int x = (int) (e.getX() / 50);
            int y = (int) (e.getY() / 50);

            try{
                // if (botaoCenoura.isSelected())
                //     fazenda.plantarCenoura(x, y);
                // if (botaoBatata.isSelected())
                //     fazenda.plantarBatata(x, y);
                // if (botaoMorango.isSelected())
                //     fazenda.plantarMorango(x, y);
                // if (botaoColher.isSelected())
                //     fazenda.colher(x, y);
    
                // atualizar();

            }catch(Exception ex){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText(ex.getMessage());
                alert.showAndWait();
            }

        });

        // atualizar();
        // clockThread();

    }

}
