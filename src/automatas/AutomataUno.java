/*
 * Autómatas
 */
package automatas;

import javafx.animation.AnimationTimer;
import javafx.scene.Parent;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 *
 * @author blackzafiro
 */
public class AutomataUno extends Automata {
    
    public AutomataUno() {
    	super();  // Llama al contructor de la clase padre.
        Rectangle rec = new Rectangle(0, 230, 800, 20);
        rec.setStroke(Color.RED);
        rec.setFill(Color.BLUE);
        root.getChildren().add(rec);
    }

    @Override
    public void handle(long now) {
    	super.handle(now);
    	text.setText("Uno Tiempo " + now);
    }
    
}
