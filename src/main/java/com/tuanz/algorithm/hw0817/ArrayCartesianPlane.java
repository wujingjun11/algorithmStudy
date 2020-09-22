package com.tuanz.algorithm.hw0817;

/**
 * 用数组实现的二维笛卡尔平面。每个（x，y）坐标可以
 * 持有一个<T>类型的项目。
 */

/**
 * A 2D cartesian plane implemented as with an array. Each (x,y) coordinate can
 * hold a single item of type <T>.
 *
 * @param <T> The type of element held in the data structure
 */
public class ArrayCartesianPlane<T> implements CartesianPlane<T> {

    //二位数组
    private T[][] data;
    //the min value of x
    private int minimumX;
    //the max value of x
    private int maximumX;
    //the min value of y
    private int minimumY;
    //the max value of y
    private int maximumY;

    /**
     * Constructs a new ArrayCartesianPlane object with given minimum and
     * maximum bounds.
     *
     * Note that these bounds are allowed to be negative.
     *
     * @param minimumX A new minimum bound for the x values of
     *         elements.
     * @param maximumX A new maximum bound for the x values of
     *         elements.
     * @param minimumY A new minimum bound for the y values of
     *         elements.
     * @param maximumY A new maximum bound for the y values of
     *         elements.
     * @throws IllegalArgumentException if the x minimum is greater
     *         than the x maximum (and resp. with y min/max)
     */
    public ArrayCartesianPlane(int minimumX, int maximumX, int minimumY,
            int maximumY) throws IllegalArgumentException {
        // 构造方法
        if ((minimumX > maximumX) || (minimumY > maximumY)) {
            throw new IllegalArgumentException("minimum is greater than the maximum ");
        }

        this.maximumX = maximumX;
        this.minimumX = minimumX;
        this.maximumY = maximumY;
        this.minimumY = minimumY;

        data = (T[][]) new Object
                [maximumX - minimumX + 1][maximumY - minimumY + 1];
    }

    @Override
    public void add(int x, int y, T element) throws IllegalArgumentException {
        if (!outOfBounds(x, y)) {
            throw new IllegalArgumentException();
        }
        data[x - minimumX][y - minimumY] = element;
    }

    @Override
    public T get(int x, int y) throws IndexOutOfBoundsException {
        if (!outOfBounds(x, y)) {
            throw new IndexOutOfBoundsException();
        }
        return data[x - minimumX][y - minimumY];
    }

    @Override
    public boolean remove(int x, int y) throws IndexOutOfBoundsException {
        if (data[x - minimumX][y - minimumY] == null) {
            return false;
        }
        data[x - minimumX][y - minimumY] = null;
        return true;
    }

    @Override
    public void clear() {
        data = (T[][]) new Object
                [maximumX - minimumX + 1][maximumY - minimumY + 1];
    }

    @Override
    public void resize(int newMinimumX, int newMaximumX, int newMinimumY, int newMaximumY) throws IllegalArgumentException {

        if ((newMinimumX > newMaximumX) || (newMinimumY > newMaximumY)) {
            throw new IllegalArgumentException("minimum is greater than the maximum ");
        }
        //定义一个新的数组
        T[][] newPlane = (T[][]) new Object
                [newMaximumX - newMinimumX + 1][newMaximumY - newMinimumY + 1];

        //遍历数组
        for (int i = 0; i <= maximumX - minimumX; i++) {
            for (int j = 0; j <= maximumY - minimumY; j++) {
                //二维数组的值不为空
                if (data[i][j] != null) {
                    //根据相对位置插入到新数组
                    if ((i + minimumX >= newMinimumX) &&
                            (i + minimumX <= newMaximumX) &&
                            (j + minimumY >= newMinimumY) &&
                            (j + minimumY <= newMaximumY)) {
                        newPlane[i + minimumX - newMinimumX]
                                [j + minimumY - newMinimumY] = data[i][j];
                    } else {
                        throw new IllegalArgumentException("an element would be lost after this resizing operation");
                    }
                }
            }
        }
        data = newPlane;
        this.maximumX = newMaximumX;
        this.minimumX = newMinimumX;
        this.maximumY = newMaximumY;
        this.minimumY = newMinimumY;
    }

    /**
     * 判断 矩阵的边界 是否越界
     * @param x
     * @param y
     * @return
     */
    private boolean outOfBounds(int x, int y) {
        return (minimumX <= x) && (x <= maximumX) && (minimumY <= y)
                && (y <= maximumY);
    }
}

