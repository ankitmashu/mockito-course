package com.in28minutes.business;

import com.in28minutes.data.api.TodoService;
import com.in28minutes.data.api.TodoServiceStub;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TodoBusinessImplStubTest {
    @Test
    public void testRetrieveTodosRelatedToSpring_usingAStub(){
        TodoService todoServiceStub = new TodoServiceStub();
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);
        var filteredTodos=
                todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
        assertEquals(2,filteredTodos.size());

    }
//Second test failed because in Stub we use real class so we need to change logic in our class
    //we need to return empty value from class to get correct result
    @Test
    public void testRetrieveTodosRelatedToSpring_usingAStub2(){
        TodoService todoServiceStub = new TodoServiceStub();
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);
        var filteredTodos=
                todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
        assertEquals(0,filteredTodos.size());

    }

}
