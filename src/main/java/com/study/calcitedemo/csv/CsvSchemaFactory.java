package com.study.calcitedemo.csv;

import org.apache.calcite.schema.Schema;
import org.apache.calcite.schema.SchemaFactory;
import org.apache.calcite.schema.SchemaPlus;

import java.util.Map;


/**
 * @author ruixiang.crx
 * @date 2021/4/14
 */
public class CsvSchemaFactory implements SchemaFactory {
    @Override
    public Schema create(SchemaPlus parentSchema, String name, Map<String, Object> operand) {
        return new CsvSchema(String.valueOf(operand.get("dataFile")));
    }
}
