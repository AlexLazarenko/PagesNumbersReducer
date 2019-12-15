package home.utils;

import java.util.*;

/**
 * This utils class that contains all necessary methods
 */
public class Utils {
    /**
     * Format string to String[] array, expected input
     * format:"7,9,3,1,2,10"
     *
     * @param inputData
     * @return inputData String[] array
     */
    public String[] makeStringArrayFromReceivedData(String inputData) {
        return inputData.split(",+");
    }

    /**
     * Format String[] array to List<String>
     *
     * @param stringArrayFromReceivedData
     * @return List<String> stringListFromReceivedData
     */
    public List<String> makeStringList(String[] stringArrayFromReceivedData) {
        return Arrays.asList(stringArrayFromReceivedData);
    }

    /**
     * make List<Integer> from List<String> by parseInt
     *
     * @param stringListFromReceivedData
     * @return List<Integer> intListFromReceivedData
     * @throws IllegalArgumentException when input data is <= 0
     * @throws NumberFormatException    on Integer.parseInt() when input incorrect data
     */
    public List<Integer> makeIntListToSortLater(List<String> stringListFromReceivedData) {
        List<Integer> intListFromReceivedData = new ArrayList<>();
        for (int n = 0; n < stringListFromReceivedData.size(); n++) {
            try {
                intListFromReceivedData.add(Integer.parseInt(stringListFromReceivedData.get(n)));
                if (intListFromReceivedData.get(n) <= 0) {
                    throw new IllegalArgumentException("Pages must bee whole positive numbers");
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return null;
            }
        }
        return intListFromReceivedData;
    }

    /**
     * make Integer TreeSet from  List<Integer> to sort and ignore replications
     *
     * @param intListFromReceivedData
     * @return Set<Integer> sortedIntegerSetFromReceivedData
     */
    public Set<Integer> makeSortedSet(List<Integer> intListFromReceivedData) {
        return new TreeSet<>(intListFromReceivedData);
    }

    /**
     * make sorted string by StringBuilder with necessary marking
     *
     * @param sortedIntegerSetFromReceivedData
     * @return StringBuilder formedData
     */
    public StringBuilder makingMarkingWithStringBuilder(Set<Integer> sortedIntegerSetFromReceivedData) {
        List<Integer> sortedList = new ArrayList<>(sortedIntegerSetFromReceivedData);
        StringBuilder formedData = new StringBuilder();
        int store = sortedList.get(0);
        for (int i = 0; i < sortedList.size(); i++) {
            if (sortedList.get(i) != (store + 1)) {
                if (sortedList.get(i).equals(sortedList.get(0))) {
                    formedData.append(sortedList.get(i));
                } else {
                    formedData.append(",");
                    formedData.append(sortedList.get(i));
                    store = sortedList.get(i);
                }
            } else {
                formedData.append("-");
                formedData.append(sortedList.get(i));
                store = sortedList.get(i);
            }
        }
        return formedData;
    }

    /**
     * Format data using marking
     *
     * @param formedData
     * @return StringBuilder resultData
     */
    public StringBuilder formDataUsingMarking(StringBuilder formedData) {
        StringBuilder resultData = new StringBuilder();
        String[] formedDataArray = formedData.toString().split(",+");//split formedData by ","(making string array)
        for (int i = 0; i < formedDataArray.length; i++) {
            String[] store = formedDataArray[i].split("-");//split string array(formedDataArray) elements by "-" to reduce sequence elements
            if (store.length > 2) {
                if (formedDataArray[i].equals(formedDataArray[0])) {
                    resultData.append(store[0]);
                    resultData.append("-");
                    resultData.append(store[store.length - 1]);
                } else {
                    resultData.append(",");
                    resultData.append(store[0]);
                    resultData.append("-");
                    resultData.append(store[store.length - 1]);
                }
            }
            if (store.length == 2) {
                if (formedDataArray[i].equals(formedDataArray[0])) {
                    resultData.append(store[0]);
                    resultData.append(",");
                    resultData.append(store[store.length - 1]);
                } else {
                    resultData.append(",");
                    resultData.append(store[0]);
                    resultData.append(",");
                    resultData.append(store[store.length - 1]);
                }
            }
            if (store.length < 2) {
                if (formedDataArray[i].equals(formedDataArray[0])) {
                    resultData.append(store[0]);
                } else {
                    resultData.append(",");
                    resultData.append(store[0]);
                }
            }
        }
        return resultData;
    }

    /**
     * This method call all necessary methods to realize logic
     */
    public StringBuilder reduceIgnoringReplications(String input) { //final function that using all methods
        return formDataUsingMarking(makingMarkingWithStringBuilder(makeSortedSet(makeIntListToSortLater(makeStringList(makeStringArrayFromReceivedData(input))))));
    }
}
