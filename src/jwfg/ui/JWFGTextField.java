package jwfg.ui;

import java.awt.*;

public class JWFGTextField extends Panel {
    private final Label label;
    private final TextField textField;

    public JWFGTextField(String label, String defaultValue) {
        super();
        this.setSize(64, 26);
        this.setLayout(null);

        this.label = new Label(label);
        this.label.setSize(64, 8);
        this.label.setLocation(0, 0);
        this.label.setAlignment(Label.CENTER);
        this.add(this.label);
        this.label.setVisible(true);

        this.textField = new TextField(defaultValue);
        this.textField.setSize(64, 16);
        this.textField.setLocation(0, this.label.getLocation().y + this.label.getSize().height + 2);
        this.add(this.textField);
        this.textField.setVisible(true);

        this.setVisible(true);
    }

    public String getLabel() {
        return this.label.getText();
    }

    public String getText() {
        return this.textField.getText();
    }

    public void setLabel(String label) {
        this.label.setText(label);
    }

    public void setText(String text) {
        this.textField.setText(text);
    }

    @Override
    public void setSize(Dimension d) {
        super.setSize(1, 1);
    }

    @Override
    public void setSize(int width, int height) {
        super.setSize(width, height);
        if (this.label != null) this.label.setSize(width, this.label.getHeight());
        if (this.textField != null) this.textField.setSize(width, this.textField.getHeight());
    }
}
