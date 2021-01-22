package net.plazmix.core.api.common.command;

/**
 * @author MasterCapeXD
 */
public interface CommandBuilder
        extends CommandElementBuilder<CommandBuilder, Command> {

    CommandBuilder addArgument(CommandArgumentBuilder argumentBuilder);
}