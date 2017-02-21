package org.ownjoo.service.model;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import javax.validation.Valid;
import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.Validator;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class ItemTests
{
//    @Autowired  private Validator   validator;
    @Valid      private Item        item;
                private long        goodId      =   0;
                private long        badId       =   1;
                private String      goodContent =   "content";
                private String      badContent  =   "'><script>alert(0);</script><!--";

    @Before
    public void itemConstructor() throws Exception
    {
        item = new Item(this.goodId,this.goodContent);
    }

    @Test
    public void itemGetID()
    {
        assertEquals(item.getId(), this.goodId);
    }

    @Test
    public void itemGetContent()
    {
        assertEquals(item.getContent(), this.goodContent);
    }

    @Test//(expected=javax.validation.ValidationException.class)
    public void itemValidation()
    {
        item = new Item(this.badId, this.badContent);
    }
}
