package jwfg.ui;

import java.awt.*;

public class JWFGHorizontalPaddingPanel extends JWFGPaddingPanel {
    public JWFGHorizontalPaddingPanel(int padding) {
        super(padding);
        this.setLayout(null);
        this.setVisible(true);
    }

    @Override
    protected int getRequiredSize() {
        return this.getWidth();
    }

    @Override
    protected void setRequiredLocation(Component comp, int location) {
        comp.setLocation(location, comp.getY());
    }

    @Override
    protected void setRequiredSize(Component comp, int size) {
        comp.setSize(size, this.getHeight());
    }
}
