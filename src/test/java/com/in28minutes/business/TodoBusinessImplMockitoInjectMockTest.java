package com.in28minutes.business;

import com.in28minutes.data.api.TodoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplMockitoInjectMockTest {
    @Mock
    TodoService todoServiceMock;
    @InjectMocks
    TodoBusinessImpl todoBusinessImpl;

    //This annotation removes below line of code
   // TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

    /*@Captor
    ArgumentCaptor<String> stringArgumentCaptor;*/
    @Test
    public void testRetrieveTodosRelatedToSpring_usingAMock(){

        var todos= Arrays.asList("Learn Spring MVC","Learn Spring","Learn to Dance");
        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
        var filteredTodos=
                todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

        assertEquals(2,filteredTodos.size());

    }
//Here both test pass and we don't need real class , we just make mock class for our work

    @Test
    public void testRetrieveTodosRelatedToSpring_usingAMock2(){

        var todos= Arrays.<String>asList();

        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);

        var filteredTodos=
                todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

        assertEquals(0,filteredTodos.size());
    }

    //Below test is with BBD
    @Test
    public void testRetrieveTodosRelatedToSpring_usingBBD(){
        //Given
        var todos= Arrays.asList("Learn Spring MVC","Learn Spring","Learn to Dance");
        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

        //When
        var filteredTodos=
                todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

        //Then
        assertEquals(2,filteredTodos.size());
        //or we can use matcher function
        //assertThat(filteredTodos.size(),is(2));
    }

}
