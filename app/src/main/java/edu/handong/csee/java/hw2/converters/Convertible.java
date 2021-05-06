package edu.handong.csee.java.hw2.converters;

/**
 * This is interface for using methods setFromValue, getConveredValue and convert.
 */
public interface Convertible {
    /**
     * This is method for setting fromValue.
     * @param fromValue fromValue
     */
    public void setFromValue(double fromValue);
    /**
     * This is method for getting value.
     * @return value
     */
    public double getConvertedValue();
    /**
     * This is method for converting.
     */
    public void convert();

}