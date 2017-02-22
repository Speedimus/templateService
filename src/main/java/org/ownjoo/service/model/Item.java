package org.ownjoo.service.model;

import javax.validation.constraints.*;

public class Item
{
    @NotNull
    @Min(0)
    @Max(16)
    private final long id;

    @NotNull
    @Size(min=0, max=64)
    @Pattern(regexp = "^[a-zA-Z0-9 :]*"/*, message="Contains invalid characters..."*/)
    private final String content;

    public Item(long id, String content)
    {
        this.id = id;
        this.content = content;
    }

    public long getId()
    {
        return id;
    }

    public String getContent()
    {
        return content;
    }
}
