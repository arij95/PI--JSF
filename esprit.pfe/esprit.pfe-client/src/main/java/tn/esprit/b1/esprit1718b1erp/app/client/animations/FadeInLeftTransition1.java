package tn.esprit.b1.esprit1718b1erp.app.client.animations;


import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.TimelineBuilder;
import javafx.scene.Node;
import javafx.util.Duration;

@SuppressWarnings("deprecation")
public class FadeInLeftTransition1 extends ConfigAnimasi {
    public static final int DURATION1 = -20;
    public static final int DURATION2 = 700;
    public FadeInLeftTransition1(final Node node) {
        super(
            node,
            TimelineBuilder.create()
                .keyFrames(
                    new KeyFrame(Duration.millis(0),    
                        new KeyValue(node.opacityProperty(), 0, WEB_EASE),
                        new KeyValue(node.translateXProperty(), DURATION1, WEB_EASE)
                    ),
                    new KeyFrame(Duration.millis(DURATION2),    
                        new KeyValue(node.opacityProperty(), 1, WEB_EASE),
                        new KeyValue(node.translateXProperty(), 0, WEB_EASE)
                    )
                )
                .build()
            );
        setCycleDuration(Duration.seconds(1));
        setDelay(Duration.seconds(0));
    }
}
