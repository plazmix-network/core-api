package net.plazmix.core.api.service.channel;

import net.plazmix.core.api.service.Service;

import java.util.Optional;

public interface ChannelService extends Service {

    Channel createChannel(String name);

    Optional<Channel> getChannel(String name);

    void deleteChannel(String name, boolean dropData);
}
