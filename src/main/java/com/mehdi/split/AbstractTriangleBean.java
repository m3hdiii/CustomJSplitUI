package com.mehdi.split;

/**
 * Created by Afsari on 7/24/16.
 */
public abstract class AbstractTriangleBean {

    protected Integer middleXPointInMatrix;
    protected Integer leftXPointInMatrix;
    protected Integer rightXPointInMatrix;
    protected Integer middleYPointInMatrix;
    protected Integer leftYPointInMatrix;
    protected Integer rightYPointInMatrix;
    protected Integer height;

    public AbstractTriangleBean(Integer height) {
        if (height == null && height == 0.0) {
            try {
                throw new RuntimeException("You are not allowed to pass a null or 0 value argument as a height");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (height % 4 != 0) {
            try {
                throw new RuntimeException("your value must be a factor of number [ 4 ]");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        this.height = height;

    }

    protected abstract AbstractTriangleBean make(final int newOrientation);

    public Integer getMiddleXPointInMatrix() {
        return middleXPointInMatrix;
    }

    public Integer getLeftXPointInMatrix() {
        return leftXPointInMatrix;
    }

    public Integer getRightXPointInMatrix() {
        return rightXPointInMatrix;
    }

    public Integer getMiddleYPointInMatrix() {
        return middleYPointInMatrix;
    }

    public Integer getLeftYPointInMatrix() {
        return leftYPointInMatrix;
    }

    public Integer getRightYPointInMatrix() {
        return rightYPointInMatrix;
    }

    public Integer buttonDistance() {
        return 0;
    }
}
