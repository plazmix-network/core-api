package net.plazmix.core.api.common.config;

import com.google.common.collect.Maps;
import net.plazmix.core.api.Core;

import java.util.List;
import java.util.Map;

public class LocaleConfig {

    private final Map<String, String> strings = Maps.newHashMap();
    private final Map<String, List<String>> lists = Maps.newHashMap();

    public LocaleConfig(Config<?> config) {
        config.load();

        for (String key : config.getKeys("")) {
            String str = config.getString(key);
            if (str == null) {
                List<String> list = config.getStringList(key);
                if (list != null)
                    lists.put(key, Core.getApi().colorize(list));
            } else
                strings.put(key, Core.getApi().colorize(str));
        }
    }

    public String getMessage(String key) {
        return strings.get(key);
    }

    public List<String> getMessages(String key) {
        return lists.get(key);
    }
}
