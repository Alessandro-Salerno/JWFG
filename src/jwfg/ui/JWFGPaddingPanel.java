package jwfg.ui;

import java.awt.*;

public abstract class JWFGPaddingPanel extends Panel {
    private int padding;

    public JWFGPaddingPanel(int padding) {
        super();
        this.padding = padding;
    }

    public int getPadding() {
        return this.padding;
    }

    protected abstract int getRequiredSize();

    public void setPadding(int padding) {
        this.padding = padding;
    }

    protected abstract void setRequiredLocation(Component comp, int location);
    protected abstract void setRequiredSize(Component comp, int size);

    @Override
    protected void addImpl(Component comp, Object constraints, int index) {
        super.addImpl(comp, constraints, index);

        int available = this.getRequiredSize() - ((this.getComponentCount() + 2) * this.getPadding());
        int componentSize = available / this.getComponentCount();

        for (int ci = 0; ci < this.getComponentCount(); ci++) {
            Component cx = this.getComponent(ci);
            this.setRequiredLocation(cx, (ci + 1) * this.getPadding() + ci * componentSize);
            this.setRequiredSize(cx, componentSize);
        }
    }
}
