package com.tsystems.autotestuni.basic;

public class BasicExceptions {

    /**
     * Write a method which calculates the number {@code 1 / parameter},
     * where the parameter is passed as an argument.
     *
     * @param parameter a value from 0 to 1000
     * @return value (1 / parameter)
     * @throws AssertionError if the parameter less than 0
     * @throws IllegalArgumentException if the parameter more than 1000
     * @throws ArithmeticException if the parameter is 0
     */
    public static int thousandToParameter(int parameter)
            throws AssertionError, IllegalArgumentException, ArithmeticException {
        throw new UnsupportedOperationException("Not implemented yet");
    }


    /**
     * Write a method which applies an array of strings and one position.
     * The string in the specified position should be converted to double.
     *
     * If position is out of array bounds, the method should write "There is no such position in the passed array".
     * If a string in the position cannot be converted to double, the method should write
     *   "The string in the specified position cannot be converted to double".
     * In any results the method should write "Method has finished its job" in addition.
     *
     * The method shouldn't throw any exception!
     *
     * @param strings array of strings
     * @param position index of the string which should be converted to double
     * @return double value if string was converted correctly or {@code Double.NaN} if not
     */
    public static double convertStringToDoubleInPosition(String[] strings, int position) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
