package tn.esprit.b1.esprit1718b1erp.app.client.animations;

import javafx.scene.control.TextField;

/**
 * Created by pedro_000 on 12/5/13.
 */
public class MetroTextFieldSkin extends TextFieldWithButtonSkin {
    public MetroTextFieldSkin(TextField textField) {
        super(textField);
    }

    @Override
    protected void rightButtonPressed() {
        getSkinnable().setText("");
    }

}