package ru.job4j.io;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.net.URL;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        URL path = ClassLoader.getSystemResource("pair_without_comment.properties");
        Config config = new Config(path.getPath());
        config.load();
        assertThat(config.value("name"), is("Petr Arsentev"));
        assertThat(config.value("surname"), is(Matchers.nullValue()));
    }

    @Test
    public void whenPairWithComment() {
        URL path = ClassLoader.getSystemResource("pair_with_comment.properties");
        Config config = new Config(path.getPath());
        config.load();
        assertThat(config.value("name"), is("Petr Arsentev"));
    }
}