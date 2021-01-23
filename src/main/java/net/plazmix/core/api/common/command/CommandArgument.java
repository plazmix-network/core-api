package net.plazmix.core.api.common.command;

import java.util.Collection;

/**
 * @author MasterCapeXD
 */
public interface CommandArgument extends ArgumentInfo {

    Collection<CommandArgument> getChilds();
}