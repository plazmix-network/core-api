package net.plazmix.core.api.spigot.config;

import com.google.common.base.Preconditions;
import net.plazmix.core.api.Core;
import net.plazmix.core.api.common.config.AbstractConfig;
import net.plazmix.core.api.common.config.Config;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

/**
 * @author MasterCapeXD
 */
public class SpigotYamlConfig extends AbstractConfig<YamlConfiguration> {

    public SpigotYamlConfig(File folder, String fileName) {
        super(folder, fileName + ".yml");
    }

    public SpigotYamlConfig(File file) {
        super(file);
        Preconditions.checkArgument(file.getName().endsWith(".yml"), "File is not in a YAML format!");
    }

    @Override
    public Config<YamlConfiguration> load() {
        Preconditions.checkState(exists(), "File not exists!");
        if (config == null)
            this.config = YamlConfiguration.loadConfiguration(file);
        else {
            try {
                this.config.load(file);
            } catch (FileNotFoundException e) {
                Core.getApi().getLogger().warning("File not found! Details: " + e.getMessage());
            } catch (IOException e) {
                Core.getApi().getLogger().severe("Error while loading data from file! Details: " + e.getMessage());
            } catch (InvalidConfigurationException e) {
                Core.getApi().getLogger().warning("Unable to load data from file! Details: " + e.getMessage());
            }
        }
        return this;
    }

    @Override
    public Config<YamlConfiguration> save() {
        try {
            this.config.save(file);
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
        return path.isEmpty() ? this.config.getKeys(false) : this.config.getConfigurationSection(path).getKeys(false);
    }
}
