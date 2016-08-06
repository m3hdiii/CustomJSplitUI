package com.mehdi.split.bean;

import com.mehdi.split.AbstractTriangleBean;

import static javax.swing.JSplitPane.HORIZONTAL_SPLIT;

/**
 * Created by Afsari on 7/24/16.
 */
public class LeftTriangleBean extends AbstractTriangleBean {

    private Integer orientation;
    private Integer jSplitPaneHeight;
    private Integer triangleWidth;

    public LeftTriangleBean(Integer height) {
        super(height);
    }


    @Override
    protected LeftTriangleBean make(int newOrientation) {

        this.orientation = newOrientation;

        /**
         * the triangle is a multiplication 3,4,5 centimeter triangle with height 4*n
         */
        Integer triangleHeightFactor = height / 4;
        Integer base = triangleHeightFactor * 3;

        if (orientation == HORIZONTAL_SPLIT) {
            this.middleXPointInMatrix = 0;
            this.leftXPointInMatrix = height;
            this.rightXPointInMatrix = height;

            this.middleYPointInMatrix = base;
            this.leftYPointInMatrix = 0;
            this.rightYPointInMatrix = base * 2;

            jSplitPaneHeight = base * 2;
            triangleWidth = height;
        } else {
            this.middleXPointInMatrix = base;
            this.leftXPointInMatrix = 0;
            this.rightXPointInMatrix = base * 2;

            this.middleYPointInMatrix = 0;
            this.leftYPointInMatrix = height;
            this.rightYPointInMatrix = height;

            jSplitPaneHeight = height;
            triangleWidth = base * 2;
        }

        return this;
    }

    @Override
    public Integer buttonDistance() {

        Integer buttonDistance;
        if (orientation == HORIZONTAL_SPLIT) {
            buttonDistance = rightXPointInMatrix - middleXPointInMatrix;
            if (buttonDistance < 0) {
                buttonDistance = -buttonDistance;
            }
        } else {
            buttonDistance = 2 * (rightXPointInMatrix - middleXPointInMatrix);
            if (buttonDistance < 0) {
                buttonDistance = -buttonDistance;
            }
        }
        return buttonDistance;
    }

    public Integer getHeight() {
        return jSplitPaneHeight;
    }

    public Integer getWidth(){
        return triangleWidth;
    }
}
