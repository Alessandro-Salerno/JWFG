package jwfg.ui;

import java.awt.*;

public class JWFGBoxPaddingPanel extends JWFGPaddingPanel {
    public JWFGBoxPaddingPanel(int padding) {
        super(padding);
        this.setLayout(null);
        this.setVisible(true);
    }

    @Override
    protected int getRequiredSize() {
        return 0;
    }

    @Override
    protected void setRequiredLocation(Component comp, int location) {
        comp.setLocation(location, location);
    }

    @Override
    protected void setRequiredSize(Component comp, int size) {
        comp.setSize(this.getWidth() - (this.getPadding() * 2),
                this.getHeight() - (this.getPadding() * 2));
    }

    @Override
    protected void addImpl(Component comp, Object constraints, int index) {
        if (this.getComponentCount() >= 1) return;
        super.addImpl(comp, constraints, index);

        this.setRequiredLocation(comp, this.getPadding());
        this.setRequiredSize(comp, 0);
    }
}
