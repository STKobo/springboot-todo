package com.example.springboottodo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.springboottodo.models.ToDoItem;
import com.example.springboottodo.repositories.ToDoItemRepository;

@Component
public class TodoItemDataLoader implements CommandLineRunner{
    
    private final Logger logger = LoggerFactory.getLogger(TodoItemDataLoader.class);

    @Autowired
    ToDoItemRepository todoItemRepository;

    @Override
    public void run(String...args) throws Exception {
        loadData();
    }

    private void loadData(){
        if(todoItemRepository.count()==0){
            ToDoItem todoItem1 = new ToDoItem("Faire les courses");
            ToDoItem todoItem2 = new ToDoItem("Faire la plonge");

            todoItemRepository.save(todoItem1);
            todoItemRepository.save(todoItem2);
        }
    }

    logger.info("Number of TodoItems: {}", todoItemRepository.count());
}
