package com.mehdi.split.bean;

import com.mehdi.split.AbstractTriangleBean;

import static javax.swing.JSplitPane.HORIZONTAL_SPLIT;


public class RightTriangleBean extends AbstractTriangleBean {


    public RightTriangleBean(Integer height) {
        super(height);
    }

    @Override
    protected RightTriangleBean make(int newOrientation) {
        /**
         * the triangle is a multiplication 3,4,5 centimeter triangle with height 4*n
         */
        Integer triangleHeightFactor = height / 4;
        Integer base = triangleHeightFactor * 3;


        if (newOrientation == HORIZONTAL_SPLIT) {
            this.middleXPointInMatrix = height;
            this.leftXPointInMatrix = 0;
            this.rightXPointInMatrix = 0;

            this.middleYPointInMatrix = base;
            this.leftYPointInMatrix = 0;
            this.rightYPointInMatrix = 2 * base;



        } else {
            this.middleXPointInMatrix = base;
            this.leftXPointInMatrix = 0;
            this.rightXPointInMatrix = base * 2 ;

            this.middleYPointInMatrix = height;
            this.leftYPointInMatrix = 0;
            this.rightYPointInMatrix = 0;

        }
        return this;
    }
}