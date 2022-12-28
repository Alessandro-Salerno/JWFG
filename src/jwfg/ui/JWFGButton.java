package jwfg.ui;

import jwfg.tools.Caller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Callable;

public class JWFGButton extends Button {
    private Callable<Void> onClickHandler;

    public JWFGButton(String text) {
        super();
        this.setSize(64, 32);
        this.setLabel(text);
        this.setBackground(new Color(200, 200, 200));
        this.setForeground(new Color(48, 48, 48));
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.setFont(new Font("Arial", Font.BOLD, 16));

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Caller<>(onClickHandler).call();
            }
        });

        this.setVisible(true);
    }

    public JWFGButton(String text, int x, int y) {
        this(text);
        this.setLocation(x, y);
    }

    public JWFGButton(String text, int x, int y, Callable<Void> handler) {
        this(text, x, y);
        this.setClickHandler(handler);
    }

    public JWFGButton(String text, int x, int y, int w, int h, Callable<Void> handler) {
        this(text, x, y, handler);
        this.setSize(w, h);
    }

    public void setClickHandler(Callable<Void> eventHandler) {
        this.onClickHandler = eventHandler;
    }
}
