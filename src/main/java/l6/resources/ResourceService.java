package l6.resources;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Cole S' Offe on 14.05.2017.
 */
public class ResourceService {
    public final Map<String, TestResource> resourceMap;

    public ResourceService() {
        resourceMap = new HashMap<>();
    }

    public void addNewResource (String path, TestResource testResource) {
        resourceMap.put(path, testResource);
    }
}
