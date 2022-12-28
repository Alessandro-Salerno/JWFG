package jwfg.ui;

import jwfg.tools.Caller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Callable;

public class JWFGComboBox extends JComboBox<String> {
    private Callable<Void> onChangeHandler;

    public JWFGComboBox(String[] items) {
        super(items);
        this.setForeground(new Color(32, 32, 32));
        this.setBackground(new Color(200, 200, 200));
        this.setBorder(null);
        this.setSize(64, 32);
        this.setEditable(false);

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Caller<>(onChangeHandler).call();
            }
        });

        this.setVisible(true);
    }

    public JWFGComboBox(String[] items, int x, int y, Callable<Void> onChangeHandler) {
        this(items);
        this.setLocation(x, y);
        this.setOnChangeHandler(onChangeHandler);
    }

    public JWFGComboBox(String[] items, int x, int y, int w, int h, Callable<Void> onChangeHandler) {
        this(items, x, y, onChangeHandler);
        this.setSize(w, h);
    }

    public void setOnChangeHandler(Callable<Void> onChangeHandler) {
        this.onChangeHandler = onChangeHandler;
    }
}
