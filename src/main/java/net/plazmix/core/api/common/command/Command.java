package net.plazmix.core.api.common.command;

/**
 * @author MasterCapeXD
 */
public interface Command extends CommandElement {

    String getCommandHolder();

    void register();
}