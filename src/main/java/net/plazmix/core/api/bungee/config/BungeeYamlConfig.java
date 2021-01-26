package net.plazmix.core.api.bungee.config;

import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
import net.plazmix.core.api.Core;
import net.plazmix.core.api.common.config.AbstractConfig;
import net.plazmix.core.api.common.config.Config;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class BungeeYamlConfig extends AbstractConfig<Configuration> {

    public BungeeYamlConfig(File folder, String fileName) {
        super(folder, fileName + ".yml");
    }

    public BungeeYamlConfig(File file) {
        super(file);
        Preconditions.checkArgument(file.getName().endsWith(".yml"), "File is not in a YAML format!");
    }

    @Override
    public Config<Configuration> load() {
        Preconditions.checkState(exists(), "File not exists!");
        try {
            this.config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
        } catch (IOException e) {
            Core.getApi().getLogger().severe("Error while loading data from file! Details: " + e.getMessage());
        }
        return this;
    }

    @Override
    public Config<Configuration> save() {
        try {
            ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, this.file);
        } catch (IOException e) {
            Core.getApi().getLogger().severe("Unable to save data to file! Details: " + e.getMessage());
        }
        return this;
    }

    @Override
    public Object getObject(String path) {
        return this.config.get(path);
    }

    @Override
    public Object getObject(String path, Object def) {
        return this.config.get(path, def);
    }

    @Override
    public List<String> getStringList(String path) {
        return this.config.getStringList(path);
    }

    @Override
    public String getString(String path) {
        return this.config.getString(path);
    }

    @Override
    public String getString(String path, String def) {
        return this.config.getString(path, def);
    }

    @Override
    public long getLong(String path) {
        return this.config.getLong(path);
    }

    @Override
    public long getLong(String path, long def) {
        return this.config.getLong(path, def);
    }

    @Override
    public int getInt(String path) {
        return this.config.getInt(path);
    }

    @Override
    public int getInt(String path, int def) {
        return this.config.getInt(path, def);
    }

    @Override
    public boolean getBoolean(String path) {
        return this.config.getBoolean(path);
    }

    @Override
    public boolean getBoolean(String path, boolean def) {
        return this.config.getBoolean(path, def);
    }

    @Override
    public Collection<String> getKeys(String path) {
        return path.isEmpty() ? this.config.getKeys() : validateSectionKeys(path);
    }

    private Collection<String> validateSectionKeys(String path) {
        Configuration section = this.config.getSection(path);
        if (section == null)
            return Sets.newHashSet();
        return section.getKeys();
    }
}
