package edu.handong.csee.java.hw2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import edu.handong.csee.java.hw2.converters.*; // You will learn the import statement in L11.

/**
 * This is IntegratedConverter class for converting.
 */
public class IntegratedConverter {

    private double fromValue;
    /**
     * This is class for converting KM to M.
     */
    public class KMToMConverter implements Convertible{
        double value;
    /**
     * This is method for setting fromValue.
     * @param input fromValue
     */
        public void setFromValue(double input){
            fromValue = input;
        }
    /**
     * This is method for converting.
     */
        public void convert(){
            value = fromValue * 1000;
        }
    /**
     * This is method for getting value.
     * @return value
     */
        public double getConvertedValue(){
            return value;
        } 
    }
    /**
     * This is class for converting KM to MILE.
     */
    public class KMToMILEConverter implements Convertible{
        double value;
    /**
     * This is method for setting fromValue.
     * @param input fromValue
     */
        public void setFromValue(double input){
            fromValue = input;
        }
    /**
     * This is method for converting.
     */
        public void convert(){
            value = fromValue / 1.6;
        }
    /**
     * This is method for getting value.
     * @return value
     */
        public double getConvertedValue(){
            return value;
        } 
    }
    /**
     * This is class for converting MILE to KM.
     */
    public class MILEToKMConverter implements Convertible{
        double value;
    /**
     * This is method for setting fromValue.
     * @param input fromValue
     */
        public void setFromValue(double input){
            fromValue = input;
        }
    /**
     * This is method for converting.
     */
        public void convert(){
            value = fromValue * 1.6;
        }
    /**
     * This is method for getting value.
     * @return value
     */
        public double getConvertedValue(){
            return value;
        } 
    }
    /**
     * This is class for converting TON to G.
     */
    public class TONToGConverter implements Convertible{
        double value;
    /**
     * This is method for setting fromValue.
     * @param input fromValue
     */
        public void setFromValue(double input){
            fromValue = input;
        }
    /**
     * This is method for converting.
     */
        public void convert(){
            value = fromValue * 1000000;
        }
    /**
     * This is method for getting value.
     * @return value
     */
        public double getConvertedValue(){
            return value;
        } 
    }
    /**
     * This is class for converting TON to KG.
     */
    public class TONToKGConverter implements Convertible{
        double value;
    /**
     * This is method for setting fromValue.
     * @param input fromValue
     */
        public void setFromValue(double input){
            fromValue = input;
        }
    /**
     * This is method for converting.
     */
        public void convert(){
            value = fromValue * 1000;
        }
    /**
     * This is method for getting value.
     * @return value
     */
        public double getConvertedValue(){
            return value;
        } 
    }
    /**
     * This is class for converting all converter.
     */
    public class AllConverter{
        String origin;
        double fromVal;
    /**
     * This is method for setting fromValue.
     * @param input fromValue
     * @return this.fromVal
     */
        public AllConverter setFromValue(double input){
            this.fromVal = input;
            return this;
        }
    /**
     * This is method for setting originalMeasure.
     * @param or original measure
     * @return this.origin
     */
        public AllConverter setOriginalMeasure(String or){
            this.origin = or;
            return this;
        }
    /**
     * This is method for converting and printing.
     */
        public void convertAndPrintOut(){
            if (origin.equals("KM")){
                IntegratedConverter myAllKMMOut = new IntegratedConverter();
                IntegratedConverter.KMToMConverter myAllKMMIn = myAllKMMOut.new KMToMConverter();
                myAllKMMIn.setFromValue(fromVal);
                myAllKMMIn.convert();
                System.out.println(fromVal +" " + origin + " to " + myAllKMMIn.getConvertedValue() + " M");

                IntegratedConverter myAllKMMILEOut = new IntegratedConverter();
                IntegratedConverter.KMToMILEConverter myAllKMMILEIn = myAllKMMILEOut.new KMToMILEConverter();
                myAllKMMILEIn.setFromValue(fromVal);
                myAllKMMILEIn.convert();
                System.out.println(fromVal +" " + origin + " to " + myAllKMMILEIn.getConvertedValue() + " MILE");
            }
            else if(origin.equals("TON")){
                IntegratedConverter myAllTONKGOut = new IntegratedConverter();
                IntegratedConverter.TONToKGConverter myAllTONKGIn = myAllTONKGOut.new TONToKGConverter();
                myAllTONKGIn.setFromValue(fromVal);
                myAllTONKGIn.convert();
                System.out.println(fromVal +" " + origin + " to " + myAllTONKGIn.getConvertedValue() + " KG");

                IntegratedConverter myAllTONGOut = new IntegratedConverter();
                IntegratedConverter.TONToGConverter myAllTONGIn = myAllTONGOut.new TONToGConverter();
                myAllTONGIn.setFromValue(fromVal);
                myAllTONGIn.convert();
                System.out.println(fromVal +" " + origin + " to " + myAllTONGIn.getConvertedValue() + " G");
            } else{
                System.out.println("AllConverter cannot support the measure!");
            }
        }
    }

    /**
     * This is a main method.
     * @param args to user's input
     */
    public static void main(String[] args) {

        IntegratedConverter myConverter = new IntegratedConverter();

        myConverter.run(args);

    }

    /**
     * This is a run method.
     * @param args to get user's input
     */
    private void run(String[] args) {

        fromValue = Double.parseDouble(args[0]);
        String originalMeasure = Util.getUppercaseString(args[1]);
        String targetMeasure = Util.getUppercaseString(args[2]);

        if(!targetMeasure.equals("ALL")) {

            String converterName = "edu.handong.csee.java.hw2.converters." + originalMeasure + "To" + targetMeasure + "Converter";
            String outClassName = "edu.handong.csee.java.hw2.IntegratedConverter";

            if (originalMeasure.equals("KM")){
                if (targetMeasure.equals("M")){
                    converterName = "edu.handong.csee.java.hw2.IntegratedConverter$" + originalMeasure + "To" + targetMeasure + "Converter";
                }
                else if (targetMeasure.equals("MILE")){
                    converterName = "edu.handong.csee.java.hw2.IntegratedConverter$" + originalMeasure + "To" + targetMeasure + "Converter";
                }
            }
            else if (originalMeasure.equals("MILE")){
                if (targetMeasure.equals("KM")){
                    converterName = "edu.handong.csee.java.hw2.IntegratedConverter$" + originalMeasure + "To" + targetMeasure + "Converter";
                }
            }
            else if (originalMeasure.equals("TON")){
                if (targetMeasure.equals("G")){
                    converterName = "edu.handong.csee.java.hw2.IntegratedConverter$" + originalMeasure + "To" + targetMeasure + "Converter";
                }
                else if (targetMeasure.equals("KG")){
                    converterName = "edu.handong.csee.java.hw2.IntegratedConverter$" + originalMeasure + "To" + targetMeasure + "Converter";
                }
            }

            // You will learn about the try-catch block and Exception in L19
            try {
                Class<?> outClass = (Class<?>) Class.forName(outClassName);
                Constructor<?> constructorOut = (Constructor<?>) outClass.getConstructor();
                Object outClassInstance = constructorOut.newInstance();

                // Advanced Java feature: Reflection (it lets us use classes with their String class names.)
                // (JC does not teach this topic as it is advanced one but you can study by yourself!!)
                // https://www.oracle.com/technical-resources/articles/java/javareflection.html
                Class<?> converterClass = (Class<?>) Class.forName(converterName);
                Constructor<?> constructor = (Constructor<?>) converterClass.getConstructor(outClass);
                Convertible myConverter = (Convertible) constructor.newInstance(outClassInstance);

                myConverter.setFromValue(fromValue);
                myConverter.convert();
                System.out.println(fromValue + " " + originalMeasure + " is " + myConverter.getConvertedValue() + " " + targetMeasure + "!");

            } catch(ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                converterName = "edu.handong.csee.java.hw2.converters." + originalMeasure + "To" + targetMeasure + "Converter";
                System.out.println("The converter (" + converterName + ") for " + originalMeasure + " to " + targetMeasure + " does not exist!!");
            }

        } else {

            AllConverter myAllConverter = new AllConverter();
            // When your method returns `this' in methods of AllConverter, you can call them in this way (method chaining).
            // Think/understand how and why this work. Study and search for Method chaining
            // https://stackoverflow.com/questions/21180269/how-to-achieve-method-chaining-in-java
            // https://www.geeksforgeeks.org/method-chaining-in-java-with-examples/#:~:text=Method%20Chaining%20is%20the%20practice,with%20a%20(dot.).
            myAllConverter.setFromValue(fromValue).setOriginalMeasure(originalMeasure).convertAndPrintOut();
        }
    }
}