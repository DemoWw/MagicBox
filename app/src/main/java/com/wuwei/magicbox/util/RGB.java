package com.wuwei.magicbox.util;



/**
 * RGB颜色
 *
 * Created by tarena on 2017/9/5.
 */

public class RGB {

    private int color;

    private int red;

    private int green;

    private int blue;

    /**
     * ff--不透明，00--全透明
     * @param color e.g. 0xff00ff00
     */
    public RGB(int color) {

        this((color & 0x00ff0000) >> 16, (color & 0x0000ff00) >> 8, (color & 0x000000ff));
    }

    public RGB(int red, int green, int blue) {
        this.red = checkVal(red);
        this.green = checkVal(green);
        this.blue = checkVal(blue);
    }

    private int checkVal(int val) {
        if (val < 0) return 0;
        if (val > 255) return 255;
        return val;
    }

    public void setRed(int red) {
        this.red = checkVal(red);
    }

    public void setGreen(int green) {
        this.green = checkVal(green);
    }

    public void setBlue(int blue) {
        this.blue = checkVal(blue);
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    @Override
    public String toString() {
        return "RGB{" +
                "red=" + red +
                ", green=" + green +
                ", blue=" + blue +
                '}';
    }
}
