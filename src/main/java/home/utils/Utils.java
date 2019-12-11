package home.utils;

import java.util.*;

public class Utils {
    public String[] findNumbers(String a) { //make string array from string
        if (a==null) {throw new NullPointerException("data is null");
        } else {
        String[] array = a.split(",+");
        return array;}
    }

    public List<Integer> makeList(List<String> store) { //make integer list from string list by parseInt
        List<Integer> list = new ArrayList<Integer>();
        for (int n = 0; n < store.size(); n++) {
            try {
                list.add(Integer.parseInt(store.get(n)));
                if (list.get(n) <= 0) {
                    throw new IllegalArgumentException("Pages must bee whole positive numbers");
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return null;
            }
        }
        return list;
    }

    public Set<Integer> makeTreeSet(List<Integer> list) { //make Integer TreeSet from List to sort and ignore replications
        Set<Integer> set = new TreeSet<Integer>(list);
        return set;
    }

    public StringBuilder sBuilder(Set<Integer> set) { //make sorted string by StringBuilder with necessary marking
        List<Integer> list = new ArrayList<>(set);
        StringBuilder sBuilder = new StringBuilder();
        int store = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != (store + 1)) {
                if (list.get(i) == list.get(0)) {
                    sBuilder.append(list.get(i));
                } else {
                    sBuilder.append("," + list.get(i));
                    store = list.get(i);
                }
            } else {
                sBuilder.append("-" + list.get(i));
                store = list.get(i);
            }
        }
        return sBuilder;
    }

    public StringBuilder numbersReducer(StringBuilder sBuilder) { //reduce numbers by marking
        StringBuilder str = new StringBuilder();
        String[] array = sBuilder.toString().split(",+");//split sBuilder by ","(making string array)
        for (int i = 0; i < array.length; i++) {
            String[] store = array[i].split("-");//split string array elements by "-" to reduce sequence elements
            if (store.length > 2) {
                if (array[i] == array[0]) {
                    str.append(store[0] + "-" + store[store.length - 1]);
                } else {
                    str.append("," + store[0] + "-" + store[store.length - 1]);
                }
            }
            if (store.length == 2) {
                if (array[i] == array[0]) {
                    str.append(store[0] + "," + store[store.length - 1]);
                } else {
                    str.append("," + store[0] + "," + store[store.length - 1]);
                }
            }
            if (store.length < 2) {
                if (array[i] == array[0]) {
                    str.append(store[0]);
                } else {
                    str.append("," + store[0]);
                }
            }
        }
            return str;
        }

    public StringBuilder reduce(String a) { //final function that using all methods
        StringBuilder str=numbersReducer(sBuilder(makeTreeSet(makeList(Arrays.asList(findNumbers(a))))));
        return str;
    }
    }
