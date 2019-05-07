package tn.esprit.b1.esprit1718b1erp.app.client.animations;


import javafx.animation.*;
import javafx.scene.Node;
import javafx.util.Duration;

public class FadeInTransition extends ConfigAnimasi {
    public static final int DURATION1 = 1000;
    public static final int DURATION2 = 2;
    public static final float DURATION3 = 0.2f;
    
    @SuppressWarnings("deprecation")
    public FadeInTransition(final Node node) {
        super(
            node,
            TimelineBuilder.create()
                .keyFrames(
                    new KeyFrame(Duration.millis(0),    new KeyValue(node.opacityProperty(), 0, WEB_EASE)),
                    new KeyFrame(Duration.millis(DURATION1),  new KeyValue(node.opacityProperty(), 1, WEB_EASE))
                )
                .build()
            );
        setCycleDuration(Duration.seconds(DURATION2));
        setDelay(Duration.seconds(DURATION3));
        
    }
}
