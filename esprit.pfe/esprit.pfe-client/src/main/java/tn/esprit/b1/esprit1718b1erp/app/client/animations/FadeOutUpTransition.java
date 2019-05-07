/*
    Animation For JavaFX
*/

package tn.esprit.b1.esprit1718b1erp.app.client.animations;

import javafx.animation.*;
import javafx.scene.Node;
import javafx.util.Duration;


@SuppressWarnings("deprecation")
public class FadeOutUpTransition extends ConfigAnimasi {
    
    public static final int DURATION1 = 50;
    public static final int DURATION2 = 500;
    public static final int DURATION3 = -10;
    
    public FadeOutUpTransition(final Node node) {
        super(node,
                TimelineBuilder.create()
                        .keyFrames(
                                new KeyFrame(Duration.millis(DURATION1), new KeyValue(node.opacityProperty(), 1, WEB_EASE),
                                        new KeyValue(node.translateYProperty(), 0, WEB_EASE)),
                                new KeyFrame(Duration.millis(DURATION2), new KeyValue(node.opacityProperty(), 0, WEB_EASE),
                                        new KeyValue(node.translateYProperty(), DURATION3, WEB_EASE)))
                        .build());
        setCycleDuration(Duration.seconds(1));
        setDelay(Duration.seconds(0));
    }

    @Override
    protected void stopping() {
        super.stopping();
        node.setTranslateY(0);
        // restore default
        node.toBack();
    }
}
