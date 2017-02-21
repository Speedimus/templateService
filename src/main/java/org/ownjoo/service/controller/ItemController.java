package org.ownjoo.service.controller;

import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import org.ownjoo.service.model.Item;
import javax.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolation;

@RestController
public class ItemController
{
    @Autowired
    Validator validator;

    private static final String template = "Content received: %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/item")
    public Item getItem(@RequestParam(value="content", defaultValue="[empty]") String content)
    {
        Item itemReturn = new Item(counter.incrementAndGet(), String.format(template, content));
        Set<ConstraintViolation<Item>> violations = validator.validate(itemReturn);
        if(violations.size() > 0)
        {
            System.out.println(violations.toString() + "\r\nFailed string: " + content);
            itemReturn = new Item(0, "Validation error...");
        }
        return itemReturn;
    }
}
