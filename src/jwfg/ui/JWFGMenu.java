package jwfg.ui;

import javax.swing.*;
import java.awt.*;

public class JWFGMenu extends JFrame {
    public JWFGMenu() {
        super();
        this.setSize(400, 200);
        this.setLocationRelativeTo(null);
        this.setBackground(new Color(32, 32, 32));
        this.setResizable(false);
        this.setTitle("JWFG");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
