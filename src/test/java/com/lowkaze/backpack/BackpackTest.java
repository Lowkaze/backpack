package com.lowkaze.backpack;

import org.junit.Test;

public class BackpackTest {
    @Test(expected = EmptyBackpackException.class)
    public void cannotRemoveItemIfIsEmpty() {
        Backpack backpack = new Backpack();

        backpack.remove(0);
    }

    @Test(expected = EmptyBackpackException.class)
    public void cannotGetItemIfIsEmpty() {
        Backpack backpack = new Backpack();

        backpack.get(0);
    }

    @Test(expected = ItemNotFoundException.class)
    public void cannotRemoveItemThatDoesNotExists() {
        Backpack backpack = new Backpack();

        backpack.add(new Item("Test"));
        backpack.remove(1);
    }

    @Test(expected = ItemNotFoundException.class)
    public void cannotGetItemThatDoesNotExists() {
        Backpack backpack = new Backpack();

        backpack.add(new Item("Test"));
        backpack.get(1);
    }

    @SuppressWarnings("unused")
    @Test(expected = EmptyBackpackException.class)
    public void cannotIterateIfIsEmpty() {
        Backpack items = new Backpack();

        for (Item item : items) {
        }
    }
}
