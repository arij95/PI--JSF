/*
    Animation For JavaFX.
*/

package tn.esprit.b1.esprit1718b1erp.app.client.animations;


import javafx.animation.*;
import javafx.scene.Node;
import javafx.util.Duration;


public class FadeInUpTransition extends ConfigAnimasi {
    
    public static final int DURATION1 = 20;
    public static final int DURATION2 = 500;
    
    @SuppressWarnings("deprecation")
    public FadeInUpTransition(final Node node) {
        super(
            node,
            TimelineBuilder.create()
                .keyFrames(
                    new KeyFrame(Duration.millis(0),    
                        new KeyValue(node.opacityProperty(), 0, WEB_EASE),
                        new KeyValue(node.translateYProperty(), DURATION1, WEB_EASE)
                    ),
                    new KeyFrame(Duration.millis(DURATION2),    
                        new KeyValue(node.opacityProperty(), 1, WEB_EASE),
                        new KeyValue(node.translateYProperty(), 0, WEB_EASE)
                    )
                )
                .build()
            );
        setCycleDuration(Duration.seconds(1));
        setDelay(Duration.seconds(0));
        node.toFront();
    }
}
