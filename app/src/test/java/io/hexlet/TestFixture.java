package io.hexlet;

import java.util.Map;
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;

public class TestFixture {
    public static List<Map<String, Object>> getList() {
        List<Map<String, Object>> list = new ArrayList<>();
        List<Object> objectList = new ArrayList<>();
        TreeMap<String, Object> map = new TreeMap<>();
        objectList.add("a");
        objectList.add("b");
        objectList.add("c");
        map.put("key", "chars1");
        map.put("oldValue", objectList);
        list.add(map);
        map = new TreeMap<>();
        objectList = new ArrayList<>();
        objectList.add("d");
        objectList.add("e");
        objectList.add("f");
        map.put("key", "chars2");
        map.put("oldValue", objectList);
        map.put("newValue", false);
        map.put("changes", "updated");
        list.add(map);
        map = new TreeMap<>();
        map.put("key", "checked");
        map.put("oldValue", false);
        map.put("newValue", true);
        map.put("changes", "updated");
        list.add(map);
        map = new TreeMap<>();
        objectList = new ArrayList<>();
        objectList.add("value1");
        objectList.add("value2");
        map.put("key", "default");
        map.put("oldValue", null);
        map.put("newValue", objectList);
        map.put("changes", "updated");
        list.add(map);
        map = new TreeMap<>();
        map.put("key", "key1");
        map.put("oldValue", "value1");
        map.put("changes", "removed");
        list.add(map);
        map = new TreeMap<>();
        map.put("key", "key2");
        map.put("oldValue", "value2");
        map.put("changes", "added");
        list.add(map);
        return list;
    }
}
