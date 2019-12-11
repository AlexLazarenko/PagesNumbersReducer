package home.utils;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.*;

public class UtilsTest {

    Utils utils = new Utils();

    @Test
    public void findNumbers() {
        String[] arrayExpected = {"2", "7", "3", "1"};
        String dataGiven = "2,7,3,1";
        String[] arrayActual = utils.findNumbers(dataGiven);
        assertArrayEquals("Unexpected data", arrayExpected, arrayActual);
    }

    @Test(expected = NullPointerException.class)
    public void findNumbersAssertNull() {
        String dataGiven = null;
        String[] arrayActual = utils.findNumbers(dataGiven);
        assertNull("Data not null", dataGiven);
    }

    @Test
    public void makeList() {
        List<String> dataGiven = new ArrayList<String>();
        dataGiven.add("2");
        dataGiven.add("7");
        dataGiven.add("3");
        dataGiven.add("1");
        List<Integer> listExpected = Arrays.asList(2, 7, 3, 1);
        List<Integer> listActual = utils.makeList(dataGiven);
        assertEquals("Unexpected data", listExpected, listActual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void makeListIllegalArgumentException() {
        List<String> dataGiven = new ArrayList<String>();
        dataGiven.add("2");
        dataGiven.add("0");
        dataGiven.add("3");
        dataGiven.add("1");
        List<Integer> listExpected = Arrays.asList(2, 0, 3, 1);
        List<Integer> listActual = utils.makeList(dataGiven);
        assertEquals("Unexpected data", listExpected, listActual);
    }

    @Test
    public void makeListNumberFormatException() {
        List<String> dataGiven = new ArrayList<String>();
        dataGiven.add("2");
        dataGiven.add("z");
        dataGiven.add("3");
        dataGiven.add("1");
        try {
            List<Integer> listActual = utils.makeList(dataGiven);
            // fail("Expected NumberFormatException");
        } catch (NumberFormatException e) {
            assertThat(e.getMessage(), containsString("z"));
        }
    }

    @Test
    public void sBuilder() {
        Set<Integer> dataGiven = new TreeSet<>();
        dataGiven.add(2);
        dataGiven.add(7);
        dataGiven.add(3);
        dataGiven.add(1);
        StringBuilder sBuilderExpected = new StringBuilder();
        sBuilderExpected.append("1-2-3,7");
        StringBuilder sBuilderActual = utils.sBuilder(dataGiven);
        assertEquals("Unexpected data", sBuilderExpected.toString(), sBuilderActual.toString());

    }

    @Test
    public void numbersReducer() {
        StringBuilder sBuilderGiven = new StringBuilder();
        sBuilderGiven.append("1-2-3,7");
        StringBuilder sBuilderExpected = new StringBuilder();
        sBuilderExpected.append("1-3,7");
        StringBuilder sBuilderActual = utils.numbersReducer(sBuilderGiven);
        assertEquals("Unexpected data", sBuilderExpected.toString(), sBuilderActual.toString());
    }

    @Test
    public void numbersReducer2() {
        StringBuilder sBuilderGiven = new StringBuilder();
        sBuilderGiven.append("1-2-3-4,7,8,11-12-13,17");
        StringBuilder sBuilderExpected = new StringBuilder();
        sBuilderExpected.append("1-4,7,8,11-13,17");
        StringBuilder sBuilderActual = utils.numbersReducer(sBuilderGiven);
        assertEquals("Unexpected data", sBuilderExpected.toString(), sBuilderActual.toString());
    }

    @Test
    public void numbersReducer3() {
        StringBuilder sBuilderGiven = new StringBuilder();
        sBuilderGiven.append("1,3-4-5-6-7,9,11-12,17");
        StringBuilder sBuilderExpected = new StringBuilder();
        sBuilderExpected.append("1,3-7,9,11,12,17");
        StringBuilder sBuilderActual = utils.numbersReducer(sBuilderGiven);
        assertEquals("Unexpected data", sBuilderExpected.toString(), sBuilderActual.toString());
    }

    @Test
    public void reduce() {
        String dataGiven = "2,7,3,1";
        StringBuilder sBuilderExpected = new StringBuilder();
        sBuilderExpected.append("1-3,7");
        StringBuilder sBuilderActual = utils.reduce(dataGiven);
        assertEquals("Unexpected data", sBuilderExpected.toString(), sBuilderActual.toString());
    }
}
