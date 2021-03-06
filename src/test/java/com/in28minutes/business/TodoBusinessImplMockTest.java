package com.in28minutes.business;

import com.in28minutes.data.api.TodoService;
import com.in28minutes.data.api.TodoServiceStub;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class TodoBusinessImplMockTest {
    @Test
    public void testRetrieveTodosRelatedToSpring_usingAMock(){

        TodoService todoServiceMock = mock(TodoService.class);

        var todos= Arrays.asList("Learn Spring MVC","Learn Spring","Learn to Dance");

        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
        var filteredTodos=
                todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

        assertEquals(2,filteredTodos.size());

    }
//Here both test pass and we don't need real class , we just make mock class for our work

    @Test
    public void testRetrieveTodosRelatedToSpring_usingAMock2(){

        TodoService todoServiceMock = mock(TodoService.class);

        var todos= Arrays.<String>asList();

        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
        var filteredTodos=
                todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

        assertEquals(0,filteredTodos.size());

    }

    @Test
    public void testRetrieveTodosRelatedToSpring_usingBBD(){
        //Given
        TodoService todoServiceMock = mock(TodoService.class);
        var todos= Arrays.asList("Learn Spring MVC","Learn Spring","Learn to Dance");
        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        //When
        var filteredTodos=
                todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

        //Then
        assertEquals(2,filteredTodos.size());
        //or we can use matcher function
        //assertThat(filteredTodos.size(),is(2));
    }

}
