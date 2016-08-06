package com.mehdi.test;

import com.mehdi.split.BehinBasicSplitPanelUI;
import com.mehdi.split.JSplitOrientation;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Afsari on 7/23/16.
 */
public class TestSplitter extends JPanel {

    private JPanel panel1;
    private JPanel panel2;
    private JSplitPane splitter;


    private TestSplitter() {
        initComponent();
    }

    private void initComponent() {
        JButton btn1 = new JButton("Hello");
        JButton btn2 = new JButton("Bye");
        panel1 = new JPanel();
        panel1.add(btn1);

        panel2 = new JPanel();
        panel2.add(btn2);

        splitter = new JSplitPane(JSplitPane.VERTICAL_SPLIT, panel1, panel2);
        splitter.setDividerSize(40);
        splitter.setDividerLocation(30);
        splitter.setResizeWeight(1);
        splitter.setToolTipText("");
//        splitter.setSize(20, 20);
        splitter.setOneTouchExpandable(true);

        splitter.setUI(new BehinBasicSplitPanelUI(12, JSplitOrientation.VERTICAL_SPLIT));

        splitter.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        LayoutManager layout = new BorderLayout();
        setLayout(layout);
        add(splitter, BorderLayout.CENTER);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestSplitter());
                frame.setSize(500, 500);
                frame.setVisible(true);
            }
        });
    }
}
