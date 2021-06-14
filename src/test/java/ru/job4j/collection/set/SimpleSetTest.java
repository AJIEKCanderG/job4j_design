package ru.job4j.collection.set;

import org.junit.Test;
import ru.job4j.collection.SimpleArray;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class SimpleSetTest {

    @Test
    public void whenAddNonNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        assertTrue(set.contains(1));
        assertFalse(set.add(1));
    }

    @Test
    public void whenAddNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(null));
        assertTrue(set.contains(null));
        assertFalse(set.add(null));
    }

    @Test
    public void whenAddNonNullTwo() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        assertFalse(set.contains(2));
        assertFalse(set.add(1));
    }

    @Test
    public void whenAddNonNullZero() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(0));
        assertTrue(set.contains(0));
        assertTrue(set.add(1));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        Set<Integer> set = new SimpleSet<>();
        set.iterator().next();
    }
}