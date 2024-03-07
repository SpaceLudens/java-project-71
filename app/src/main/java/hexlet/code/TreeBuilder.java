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

        Set<String> keys = new TreeSet<>(map1.keySet());
        keys.addAll(map2.keySet());

        for (String key : keys) {
            Map<String, Object> mergeMap = new LinkedHashMap<>();
            Object oldValue = map1.get(key);
            Object newValue = map2.get(key);

            mergeMap.put("key", key);

            if (!map1.containsKey(key)) {
                mergeMap.put("oldValue", newValue);
                mergeMap.put("changes", "added");
            } else if (!map2.containsKey(key)) {
                mergeMap.put("oldValue", oldValue);
                mergeMap.put("changes", "removed");
            } else if (Objects.equals(oldValue, newValue)) {
                mergeMap.put("oldValue", oldValue);
            } else {
                mergeMap.put("oldValue", oldValue);
                mergeMap.put("newValue", newValue);
                mergeMap.put("changes", "updated");
            }
            result.add(mergeMap);
        }
        return result;
    }
}
