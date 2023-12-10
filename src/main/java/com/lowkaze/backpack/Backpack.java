package com.lowkaze.backpack;

import java.util.ArrayList;
import java.util.Iterator;

public class Backpack extends ArrayList<Item> {
    private final String EMPTY_BACKPACK_MESSAGE = "Your backpack is empty.";
    private final String ITEM_NOT_FOUND_MESSAGE = "The item doesn't exist.";

    @Override
    public Item get(int index) {
        if (isEmpty()) {
            throw new EmptyBackpackException(EMPTY_BACKPACK_MESSAGE);
        }

        try {
            return super.get(index);
        } catch (IndexOutOfBoundsException e) {
            throw new ItemNotFoundException(ITEM_NOT_FOUND_MESSAGE);
        }
    }

    @Override
    public Item remove(int index) {
        if (isEmpty()) {
            throw new EmptyBackpackException(EMPTY_BACKPACK_MESSAGE);
        }

        try {
            return super.remove(index);
        } catch (IndexOutOfBoundsException e) {
            throw new ItemNotFoundException(ITEM_NOT_FOUND_MESSAGE);
        }
    }

    @Override
    public Iterator<Item> iterator() {
        if (isEmpty()) {
            throw new EmptyBackpackException(EMPTY_BACKPACK_MESSAGE);
        }

        return super.iterator();
    }
}
