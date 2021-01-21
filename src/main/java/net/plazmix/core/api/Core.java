package net.plazmix.core.api;

import com.google.common.base.Preconditions;
import lombok.Getter;

public class Core {

    @Getter
    private static Core instance;
    @Getter
    private static CoreApi api;

    public static void init() {
        Preconditions.checkState(instance == null, "Core is already initialized!");
        instance = new Core();
    }
}
