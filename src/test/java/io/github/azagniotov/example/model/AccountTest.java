package io.github.azagniotov.example.model;

import io.github.azagniotov.example.config.JacksonConfig;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AccountTest {

    @Test
    public void whenDeSerializingUsingJsonCreator_thenCorrect() throws Exception {

        final String json = "{ \"id\":1, \"name\":\"Leanne Graham\", \"username\":\"Bret\", \"email\":\"Sincere@april.biz\", \"address\":{ \"street\":\"Kulas Light\", \"suite\":\"Apt. 556\", \"city\":\"Gwenborough\", \"zipcode\":\"92998-3874\", \"geo\":{ \"lat\":\"-37.3159\", \"lng\":\"81.1496\" } }, \"phone\":\"1-770-736-8031 x56442\", \"website\":\"hildegard.org\" }";

        final Account account = JacksonConfig.OBJECT_MAPPER
                .readerFor(Account.class)
                .readValue(json);

        assertEquals("Leanne Graham", account.getName());
        assertEquals("1-770-736-8031 x56442", account.getPhone());
    }
}