package com.mehdi.split;

import com.mehdi.split.bean.LeftTriangleBean;

import javax.swing.*;
import javax.swing.plaf.basic.BasicSplitPaneDivider;
import java.awt.*;

/**
 * Created by Mehdi Afsari on 7/24/16.
 */
public class BehinBasicSplitPaneDivider extends BasicSplitPaneDivider {

    private AbstractTriangleBean leftTriangleBean;
    private AbstractTriangleBean rightTriangleBean;
    private int oneTouchSize = 40;
    private int height;

    public BehinBasicSplitPaneDivider(BehinBasicSplitPanelUI ui, int orientation) {
        super(ui);
        this.orientation = orientation;
        this.leftTriangleBean = ui.getLeftTriangleBean().make(ui.getOrientation());
        this.rightTriangleBean = ui.getRightTriangleBean().make(ui.getOrientation());
        this.height = computeHeight();
        setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
    }

    private int computeHeight() {
        return ((LeftTriangleBean) leftTriangleBean).getJSplitPaneHeight();
    }

    @Override
    public int getDividerSize() {
        return height + 10;
    }

    @Override
    protected JButton createLeftOneTouchButton() {
        return new BehinCustomJSplitButton(true);
    }

    @Override
    protected JButton createRightOneTouchButton() {
        return new BehinCustomJSplitButton(false);
    }


    private class BehinCustomJSplitButton extends JButton {

        private boolean left;


        public BehinCustomJSplitButton(boolean isLeft) {
            this.left = isLeft;
            setMinimumSize(new Dimension(oneTouchSize, oneTouchSize));
            setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            setFocusPainted(false);
            setBorderPainted(false);
            setRequestFocusEnabled(false);

        }

        public boolean isFocusTraversable() {
            return false;
        }

        private int[] getTriangleXPoints(boolean left) {
            int[] xs;
            if (left) {
                xs = new int[]{leftTriangleBean.getMiddleXPointInMatrix(), leftTriangleBean.getLeftXPointInMatrix(), rightTriangleBean.getRightXPointInMatrix()};
            } else {
                xs = new int[]{rightTriangleBean.getMiddleXPointInMatrix(), rightTriangleBean.getLeftXPointInMatrix(), rightTriangleBean.getRightXPointInMatrix()};
            }
            return xs;
        }

        private int[] getTriangleYPoints(boolean left) {
            int[] ys;
            if (left) {
                ys = new int[]{leftTriangleBean.getMiddleYPointInMatrix(), leftTriangleBean.getLeftYPointInMatrix(), leftTriangleBean.getRightYPointInMatrix()};
            } else {
                ys = new int[]{rightTriangleBean.getMiddleYPointInMatrix(), rightTriangleBean.getLeftYPointInMatrix(), rightTriangleBean.getRightYPointInMatrix()};
            }

            return ys;
        }

        public void paint(Graphics g) {
            if (splitPane != null) {
                int distance = leftTriangleBean.buttonDistance();
                this.setSize(distance, distance);
                int[] xs = getTriangleXPoints(left);
                int[] ys = getTriangleYPoints(left);
                g.setColor(this.getBackground());

                if (left)
                    g.fillRect(0, 0, this.getWidth(),
                            this.getHeight());


                g.setColor(Color.black);
                g.fillPolygon(xs, ys, 3);

            }
        }
    }
}
