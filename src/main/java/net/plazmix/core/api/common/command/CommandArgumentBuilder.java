package net.plazmix.core.api.common.command;

/**
 * @author MasterCapeXD
 */
public interface CommandArgumentBuilder
        extends CommandElementBuilder<CommandArgumentBuilder, CommandArgument> {

    CommandArgumentBuilder addChild(CommandArgumentBuilder child);
}