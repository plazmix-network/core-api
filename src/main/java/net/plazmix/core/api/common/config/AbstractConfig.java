package net.plazmix.core.api.common.config;

import com.google.common.base.Preconditions;
import net.plazmix.core.api.Core;

import java.io.File;
import java.io.IOException;

public abstract class AbstractConfig<T> implements Config<T> {

    protected final File file;
    protected T config;

    protected AbstractConfig(File folder, String fileName) {
        this.file = new File(folder + File.separator + fileName);
    }

    protected AbstractConfig(File file) {
        this.file = file;
    }

    @Override
    public String getName() {
        return file.getName();
    }

    @Override
    public T unwrap() {
        Preconditions.checkState(config != null, "Configuration is not loaded!");
        return config;
    }

    @Override
    public boolean exists() {
        return file.exists();
    }

    @Override
    public Config<T> create() {
        if (!exists())
            try {
                file.createNewFile();
            } catch (IOException e) {
                Core.getApi().getLogger().warning("Unable to create this file! Details: " + e.getMessage());
            }
        return this;
    }

    @Override
    public void delete() {
        if (exists())
            file.delete();
    }
}
