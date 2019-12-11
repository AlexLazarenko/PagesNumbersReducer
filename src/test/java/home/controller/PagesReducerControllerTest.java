package home.controller;

import home.utils.Utils;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class PagesReducerControllerTest {

    private PagesReducerController subject;
    @Mock
    private Utils utils;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        subject = new PagesReducerController();
    }

    @Test
    public void reduce() throws Exception {

        StringBuilder sBuilderActual = subject.reduce("2,7,3,1");
        assertThat(sBuilderActual.toString(), is("1-3,7"));
    }

}