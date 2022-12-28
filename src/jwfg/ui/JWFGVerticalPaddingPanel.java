package jwfg.ui;

import java.awt.*;

public class JWFGVerticalPaddingPanel extends JWFGPaddingPanel {
    public JWFGVerticalPaddingPanel(int padding) {
        super(padding);
        this.setLayout(null);
        this.setVisible(true);
    }

    @Override
    protected int getRequiredSize() {
        return this.getHeight();
    }

    @Override
    protected void setRequiredLocation(Component comp, int location) {
        comp.setLocation(comp.getX(), location);
    }

    @Override
    protected void setRequiredSize(Component comp, int size) {
        comp.setSize(this.getWidth(), size);
    }
}
