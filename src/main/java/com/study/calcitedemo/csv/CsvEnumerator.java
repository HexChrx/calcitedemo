package com.study.calcitedemo.csv;

import org.apache.calcite.linq4j.Enumerator;
import org.apache.calcite.util.Source;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Objects;


public class CsvEnumerator<E> implements Enumerator {
    private E current;
    private BufferedReader reader;

    public CsvEnumerator(Source source) {
        try {
            this.reader = new BufferedReader(source.reader());
            this.reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public E current() {
        return current;
    }

    @Override
    public boolean moveNext() {
        try {
            String line = reader.readLine();
            if (Objects.isNull(line)) {
                return false;
            }
            current = (E) line.split(",");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public void reset() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void close() {

    }
}
