package com.mehdi.split;

import com.mehdi.split.bean.LeftTriangleBean;
import com.mehdi.split.bean.RightTriangleBean;

import javax.swing.plaf.basic.BasicSplitPaneUI;

/**
 * Created by Afsari on 7/24/16.
 */
public class BehinBasicSplitPanelUI extends BasicSplitPaneUI {

    private AbstractTriangleBean leftTriangleBean;
    private AbstractTriangleBean rightTriangleBean;

    public BehinBasicSplitPanelUI(Integer height, JSplitOrientation orientation) {
        setOrientation(orientation == JSplitOrientation.HORIZONTAL_SPLIT ? 1 : 0);

        this.leftTriangleBean = new LeftTriangleBean(height);
        this.rightTriangleBean = new RightTriangleBean(height);
    }

    public BehinBasicSplitPaneDivider createDefaultDivider() {
        return new BehinBasicSplitPaneDivider(this);
    }

    public AbstractTriangleBean getLeftTriangleBean() {
        return leftTriangleBean;
    }

    public AbstractTriangleBean getRightTriangleBean() {
        return rightTriangleBean;
    }
}