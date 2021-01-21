package net.plazmix.core.api;

import net.plazmix.core.api.service.Service;

public interface CoreApi {

    <T extends Service> T getService(Class<T> serviceClass);

    <T extends Service> void registerService(Class<T> serviceClass, T serviceImpl, boolean autoEnable);

    Iterable<Service> getServices();
}
