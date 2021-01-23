package net.plazmix.core.api.common.command;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author MasterCapeXD
 */
public interface CommandElement {

    String getName();

    String[] getAliases();

    String getDescription();

    String getPermission();

    Function<CommandSender, String> getPermissionMessageApplier();

    Function<CommandSender, String> getWrongSenderMessageApplier();

    BiConsumer<CommandSender, String[]> getExecutor();

    BiFunction<CommandSender, String[], List<String>> getTabCompleter();
}