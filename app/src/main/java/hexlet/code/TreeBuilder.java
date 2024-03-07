package hexlet.code;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class TreeBuilder {
    public static List<Map<String, Object>> treeBuilder(Map<String, Object> map1, Map<String, Object> map2) {
        List<Map<String, Object>> result = new ArrayList<>();

        Set<String> keys = new TreeSet<>();
        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());

        for (String key : keys) {
            Map<String, Object> mergeMap = new LinkedHashMap<>();
            if (!map1.containsKey(key)) {
                mergeMap.put("key", key);
                mergeMap.put("oldValue", map2.get(key));
                mergeMap.put("changes", "added");
                result.add(mergeMap);
            } else if (!map2.containsKey(key)) {
                mergeMap.put("key", key);
                mergeMap.put("oldValue", map1.get(key));
                mergeMap.put("changes", "removed");
                result.add(mergeMap);
            } else if (Objects.equals(map1.get(key), map2.get(key))) {
                mergeMap.put("key", key);
                mergeMap.put("oldValue", map1.get(key));
                result.add(mergeMap);
            } else {
                mergeMap.put("key", key);
                mergeMap.put("oldValue", map1.get(key));
                mergeMap.put("newValue", map2.get(key));
                mergeMap.put("changes", "updated");
                result.add(mergeMap);
            }
        }
        return result;
    }
}
