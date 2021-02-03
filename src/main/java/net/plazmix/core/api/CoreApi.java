package net.plazmix.core.api;

import net.plazmix.core.api.common.command.CommandArgumentBuilder;
import net.plazmix.core.api.common.command.CommandBuilder;
import net.plazmix.core.api.service.Service;

import java.util.List;
import java.util.logging.Logger;

/**
 * @author MasterCapeXD
 */
public interface CoreApi {

    <T extends Service> T getService(Class<T> serviceClass);

    <T extends Service> void registerService(Class<T> serviceClass, T serviceImpl, boolean autoEnable);

    Iterable<Service> getServices();

    Logger getLogger();

    CommandBuilder newCommand(String name);

    CommandBuilder newCommand(String holder, String name);

    CommandArgumentBuilder newCommandArgument(String name);

    String colorize(String str);

    List<String> colorize(List<String> stringList);
}
