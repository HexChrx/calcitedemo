package com.study.calcitedemo.memory;

import com.google.common.collect.Lists;
import org.apache.calcite.linq4j.Enumerator;

import java.util.List;
import java.util.Map;

public class MemEnumerator<E> implements Enumerator<E> {
    private List<Map<String, Object>> list = Lists.newLinkedList();
    private int index = -1;
    private E e;

    public MemEnumerator(List<Map<String, Object>> list) {
        this.list = list;
    }

    @Override
    public E current() {
        return e;
    }

    @Override
    public boolean moveNext() {
        if (index + 1 >= list.size()) {
            return false;
        }
        e = (E)list.get(++index).values().toArray();
        return true;
    }

    @Override
    public void reset() {
        index = 0;
        e = null;
    }

    @Override
    public void close() {

    }
}
