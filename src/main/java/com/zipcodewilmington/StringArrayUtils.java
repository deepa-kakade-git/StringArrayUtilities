package com.zipcodewilmington;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {
        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {

        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {
        int len = array.length;

        return array[len - 1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {

        return array[array.length - 2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
        //String str = value;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(value)) {
                return true;
            }

        }

        return false;
    }


    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
        String[] arr = new String[array.length];

        for (int i = array.length - 1, j = 0; i >= 0; i--, j++) {
            // for (int j =0 ; j< array.length; j++){

            arr[j] = array[i];

        }
        return arr;
    }


    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {
        int start = 0;
        int end = array.length - 1;

        while (start < end) {
            if (!array[start].equals(array[end])) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {
//
        boolean[] visited = new boolean[26]; // checks if each letter has been visited or not

        int count = 0; // Count of distinct letters visited

        for (String str : array) {
            for (char c : str.toCharArray()) {
                if (Character.isLetter(c)) {
                    int index = Character.toLowerCase(c) - 'a';
                    if (!visited[index]) {
                        visited[index] = true;
                        count++;
                    }
                }
            }
        }

        return count == 26;
    }


    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        int counter = 0;
        for (String s : array) {
            if (s.contains(value)) {
                counter++;
            }

        }
        return counter;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (!Objects.equals(array[i], valueToRemove)) {
                arr.add(array[i]);
            }

        }
        return arr.toArray(new String[0]);

    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        if (array.length == 0) {
            return new String[0];
        }

        StringBuilder sb = new StringBuilder();
        sb.append(array[0]);

        for (int i = 1; i < array.length; i++) {
            if (!array[i].equals(array[i - 1])) {
                sb.append(" ").append(array[i]);
            }
        }

        return sb.toString().split(" ");
    }


    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        //declares a new arraylist called packedList to store consecutive duplicates
        ArrayList<String> packedList = new ArrayList<>();
        if (array.length == 0){
            return new String[0]; //if array is empty this method returns empty array
        }
        StringBuilder currentStringBuilder = new StringBuilder(array[0]);
        //above line declares currentStrigBuilder thats assigned the value of first index element of array

        for (int i =1 ; i < array.length; i++){
            if (array[i].equals(array[i -1])) {
                currentStringBuilder.append(array[i]);
            } else {
                packedList.add(currentStringBuilder.toString());
                currentStringBuilder = new StringBuilder(array[i]);
            }

        }
        packedList.add(currentStringBuilder.toString());
        //After the loop ends, it adds the string representation of the currentStringBuilder to the packedList.
        return packedList.toArray(new String[0]);
    }

}


