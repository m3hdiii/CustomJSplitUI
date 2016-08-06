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
    private int triangleHeight;
    private int triangleWidth;

    public BehinBasicSplitPaneDivider(BehinBasicSplitPanelUI ui, int orientation) {
        super(ui);
        this.orientation = orientation;
        this.leftTriangleBean = ui.getLeftTriangleBean().make(ui.getOrientation());
        this.rightTriangleBean = ui.getRightTriangleBean().make(ui.getOrientation());
        this.triangleHeight = computeHeight();
        triangleWidth = computeWidth();
        setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
    }

    private int computeHeight() {
        return ((LeftTriangleBean) leftTriangleBean).getHeight();
    }

    private int computeWidth() {
        return ((LeftTriangleBean) leftTriangleBean).getWidth();
    }

    @Override
    public int getDividerSize() {
        return triangleHeight + 3;
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
            setMinimumSize(new Dimension(triangleWidth, triangleHeight));
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
                this.setSize(triangleWidth, triangleHeight);
                int[] xs = getTriangleXPoints(left);
                int[] ys = getTriangleYPoints(left);
                g.setColor(this.getBackground());

                if (left)
                    g.fillRect(0, 0, this.getWidth(),
                            this.getHeight());
                else
                    this.setBounds(triangleHeight + 1, 1, triangleWidth, triangleHeight);

                g.setColor(Color.black);
                g.fillPolygon(xs, ys, 3);
            }
        }
    }
}
