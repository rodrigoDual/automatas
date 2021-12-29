/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatas;

import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.text.Text;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

/**
 * IGU JavaFX con modelos tipo Autómata Celular.
 * @author blackzafiro
 */
public class Menus extends BorderPane {

    // TODO: Acomoda los elementos de la enumeración para que correspondan
    // a los autómatas que programaste.
    public enum TipoAutomata {
        AUTOMATA_1(new Automata()),     // TODO: sustituir por una clase hija.
        AUTOMATA_2(new AutomataUno());  // TODO: cambialo por una instancia de tu autómata.

        /**
         * Cada constante también tiene asociado el autómata correspondiente.
         */
        private final Automata automata;

        /**
         * Constructor.
         */
        TipoAutomata(Automata a) {
            automata = a;
        }

        public Automata getAutomata() {
            return automata;
        }
    }

    private Automata automataActual = null;
    private Text tPaso;

    /**
     * Crea la barra de menú que permitirá cambiar entre modelos de
     * autómatas.
     */
    Menus() {
        Menu menu = new Menu("Autómatas");
        EventHandler<ActionEvent> menuHandler = (event) -> {
            MenuItem target = (MenuItem)(event.getTarget());
            TipoAutomata a = (TipoAutomata)(target.getUserData());
            setAutomata(a);
        };

        // Agrega una opción por cada elemento en la enumeración TipoAutomata.
        for (TipoAutomata t : TipoAutomata.values()) {
            MenuItem menuItem = new MenuItem(t.toString());
            menuItem.setOnAction(menuHandler);
            menuItem.setUserData(t);
            menu.getItems().add(menuItem);
        }

        Button iniciar = new Button("Iniciar");
        iniciar.setOnAction(event -> automataActual.start());
        Button detener = new Button("Detener");
        detener.setOnAction(event -> automataActual.stop());
        // Barra inferior
        tPaso = new Text("0");
        ToolBar herramientas = new ToolBar(
            iniciar,
            detener,
            new Separator(),
            new Label("Paso"),
            tPaso
        );

        // Coloca los componentes utilizando los métodos heredados de BorderPane.
        setTop(new MenuBar(menu));
        setBottom(herramientas);

        // Inicia con el primer autómata por defecto.
        // TODO: Revisa el nombre si lo cambias.
        setAutomata(TipoAutomata.AUTOMATA_1);
    }

    /**
     * Asigna al autómata que se mostrará en pantalla.
     */
    void setAutomata(TipoAutomata a) {
        if(automataActual != null) {
            // Detiene la ejecución del autómata actual.
            automataActual.stop();
        }
        // Carga e inicia el autómata solicitado.
        automataActual = a.getAutomata();
        automataActual.setTextPaso(tPaso);
        setCenter(automataActual.getAutomataNode());
    }

}
