package com.github.prasanthkv.asg.test.model;

/**
 *
 * @author prasanthkv
 */
public class Second {

    private int secondInt;
    private long oruLong;
    private String secondString;
    private boolean secondBoolean;
    private float secondFloat;
    private double secondDoble;

    public int getSecondInt() {
        return secondInt;
    }

    public void setSecondInt(int secondInt) {
        this.secondInt = secondInt;
    }

    public String getSecondString() {
        return secondString;
    }

    public void setSecondString(String secondString) {
        this.secondString = secondString;
    }

    public boolean isSecondBoolean() {
        return secondBoolean;
    }

    public void setSecondBoolean(boolean secondBoolean) {
        this.secondBoolean = secondBoolean;
    }

    public float getSecondFloat() {
        return secondFloat;
    }

    public void setSecondFloat(float secondFloat) {
        this.secondFloat = secondFloat;
    }

    public double getSecondDoble() {
        return secondDoble;
    }

    public void setSecondDoble(double secondDoble) {
        this.secondDoble = secondDoble;
    }

    /**
     * Get the value of oruLong
     *
     * @return the value of oruLong
     */
    public long getOruLong() {
        return oruLong;
    }

    /**
     * Set the value of oruLong
     *
     * @param oruLong new value of oruLong
     */
    public void setOruLong(long oruLong) {
        this.oruLong = oruLong;
    }

    @Override
    public String toString() {
        return "Second{" + "secondInt=" + secondInt + ", oruLong=" + oruLong + ", secondString=" + secondString + ", secondBoolean=" + secondBoolean + ", secondFloat=" + secondFloat + ", secondDoble=" + secondDoble + '}';
    }

}
