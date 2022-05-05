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

        //Every item : >90 conditons
        assertThat(scores,everyItem(greaterThan(90)));
        assertThat(scores,everyItem(lessThan(190)));

        //String related assert
        assertThat("",isEmptyString());
        assertThat(null,isEmptyOrNullString());

        //Arrays
        Integer[] marks={1,2,3};
        assertThat(marks,arrayWithSize(3));
        assertThat(marks,arrayContaining(1,2,3));
        assertThat(marks,arrayContainingInAnyOrder(1,3,2));


    }
}
