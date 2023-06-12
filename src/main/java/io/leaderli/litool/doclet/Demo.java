package io.leaderli.litool.doclet;

import java.util.HashMap;
import java.util.Map;

public class Demo {

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    /**
     * aaa
     * @see  Map
     */
    private Map<String, String> map = new HashMap<>();
}
