package com.study.calcitedemo.csv;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableTable;
import com.google.common.io.Resources;
import org.apache.calcite.util.Source;
import org.apache.calcite.util.Sources;
import org.apache.calcite.schema.Table;
import org.apache.calcite.schema.impl.AbstractSchema;

import java.net.URL;
import java.util.Map;
import java.util.Objects;


public class CsvSchema extends AbstractSchema {

    private Map<String, Table> tableMap;

    private final String dataFile;

    public CsvSchema(String dataFile) {
        this.dataFile = dataFile;
    }

    @Override
    protected Map<String, Table> getTableMap() {
        URL url = Resources.getResource(dataFile);
        Source source = Sources.of(url);
        if (Objects.isNull(tableMap)) {
            final ImmutableMap.Builder<String, Table> builder = ImmutableMap.builder();
            builder.put(this.dataFile.split("\\.")[0], new CsvTable(source));
            tableMap = builder.build();
        }
        return tableMap;
    }
}
