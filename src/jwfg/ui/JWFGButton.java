package jwfg.ui;

import javax.swing.*;
import java.awt.*;

public class JWFGButton extends Button {
    public JWFGButton(String text) {
        super();
        this.setLabel(text);
        this.setBackground(new Color(48, 48, 48));
        this.setForeground(new Color(200, 200, 200));
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.setFont(new Font("Arial", Font.BOLD, 16));
        this.setVisible(true);
    }
}
