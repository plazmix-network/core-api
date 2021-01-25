package net.plazmix.core.api.service;

public abstract class AbstractService implements Service {

    protected boolean enabled;

    @Override
    public void enable() throws Exception {
        this.enabled = true;
    }

    @Override
    public void disable() throws Exception {
        this.enabled = false;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}