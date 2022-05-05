package com.in28minutes.mockito;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestMatcherTest {
    @Test
    public void test(){
        List<Integer> scores= Arrays.asList(99,100,101,105);
        //Score has 4 items
        assertThat(scores,hasSize(4));
        assertThat(scores,hasItems(99,100));
        //assertThat(scores,hasItems(103));

        //Every item : >90
        assertThat(scores,everyItem(greaterThan(90)));
        assertThat(scores,everyItem(lessThan(90)));

    }
}
