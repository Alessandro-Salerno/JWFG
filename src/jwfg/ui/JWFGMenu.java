package jwfg.ui;

import geometry.Point3D;
import jwfg.instance.JWFGInstanceRequest;

import javax.swing.*;
import java.util.concurrent.atomic.AtomicReference;

public class JWFGMenu extends JFrame {
    public JWFGMenu() {
        super();
        this.setSize(376, 200);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("JWFG");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.deployComponents();
        this.setVisible(true);
    }

    private void deployComponents() {
        JWFGComboBox mode2d = new JWFGComboBox(new String[] { "Rectangle", "Square", "Circle" });
        this.add(mode2d);
        mode2d.setLocation(80, 8);
        mode2d.setSize(this.getWidth() - 96, 32);

        JWFGComboBox mode3d = new JWFGComboBox(new String[] { "Cube" });
        this.add(mode3d);
        mode3d.setLocation(mode2d.getLocation());
        mode3d.setSize(mode2d.getSize());
        mode3d.setVisible(false);

        AtomicReference<JWFGComboBox> targetMode = new AtomicReference<>(mode2d);

        JWFGComboBox modeBox = new JWFGComboBox(new String[] { "2D", "3D" });
        this.add(modeBox);
        modeBox.setLocation(8, 8);
        modeBox.setOnChangeHandler(() -> {
            if (modeBox.getSelectedItem().equals("2D")) {
                mode2d.setVisible(true);
                mode3d.setVisible(false);
                targetMode.set(mode2d);
            } else if (modeBox.getSelectedItem().equals("3D")) {
                mode2d.setVisible(false);
                mode3d.setVisible(true);
                targetMode.set(mode3d);
            }

            return null;
        });

        // Generate central panel
        JWFGVerticalPaddingPanel infoControlPanel = (JWFGVerticalPaddingPanel) this.add(new JWFGVerticalPaddingPanel(8));
        infoControlPanel.setSize(this.getWidth(), 76);
        infoControlPanel.setLocation(0, 48);

        // Generate two lines
        JWFGHorizontalPaddingPanel itemControlPanel  = (JWFGHorizontalPaddingPanel) infoControlPanel.add(new JWFGHorizontalPaddingPanel(8));
        JWFGHorizontalPaddingPanel viewportControlPanel  = (JWFGHorizontalPaddingPanel) infoControlPanel.add(new JWFGHorizontalPaddingPanel(8));

        // Generate item panel
        JWFGTextField xInput = (JWFGTextField) itemControlPanel.add(new JWFGTextField("X", "0"));
        JWFGTextField yInput = (JWFGTextField) itemControlPanel.add(new JWFGTextField("Y", "0"));
        JWFGTextField zInput = (JWFGTextField) itemControlPanel.add(new JWFGTextField("Z", "0"));
        JWFGTextField rotXInput = (JWFGTextField) itemControlPanel.add(new JWFGTextField("Rot X", "0"));
        JWFGTextField rotYInput = (JWFGTextField) itemControlPanel.add(new JWFGTextField("Rot Y", "0"));

        // Generate viewport panel
        JWFGTextField vxInput = (JWFGTextField) viewportControlPanel.add(new JWFGTextField("View X", "0"));
        JWFGTextField vyInput = (JWFGTextField) viewportControlPanel.add(new JWFGTextField("View Y", "0"));
        JWFGTextField vzInput = (JWFGTextField) viewportControlPanel.add(new JWFGTextField("View Z", "0"));
        JWFGTextField vrotXInput = (JWFGTextField) viewportControlPanel.add(new JWFGTextField("View Pitch", "0"));
        JWFGTextField vrotYInput = (JWFGTextField) viewportControlPanel.add(new JWFGTextField("View Yaw", "0"));

        this.add(new JWFGButton("Start", 8, this.getHeight() - 72, this.getWidth() - 24, 32, () -> {
            JWFGInstanceRequest req = new JWFGInstanceRequest(
                    targetMode.get().getSelectedItem().toString(),
                    new Point3D(Double.parseDouble(xInput.getText()),
                                Double.parseDouble(yInput.getText()),
                                Double.parseDouble(zInput.getText())),
                    new Point3D(Double.parseDouble(rotXInput.getText()),
                                Double.parseDouble(rotYInput.getText()),
                                0),
                    new Point3D(Double.parseDouble(vxInput.getText()),
                                Double.parseDouble(vyInput.getText()),
                                Double.parseDouble(vzInput.getText())),
                    new Point3D(Double.parseDouble(vrotXInput.getText()),
                                Double.parseDouble(vrotYInput.getText()),
                                0));


            System.out.println(req);
            return null;
        }));
    }
}
