package org.ownjoo.service.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.ownjoo.service.model.Item;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController
{
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/item")
    public Item greeting(@RequestParam(value="name", defaultValue="World") String name)
    {
        return new Item(counter.incrementAndGet(), String.format(template, name));
    }
}
