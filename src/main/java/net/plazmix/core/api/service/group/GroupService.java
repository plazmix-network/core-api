package net.plazmix.core.api.service.group;

import net.plazmix.core.api.service.Service;

import java.util.Collection;
import java.util.UUID;
import java.util.function.Supplier;

public interface GroupService extends Service {

    Group getUserGroup(UUID uuid);

    default Supplier<Group> supplyUserGroup(UUID uuid) {
        return () -> getUserGroup(uuid);
    }

    void setUserGroup(UUID uuid, Group group);

    Collection<String> getPermissions(Group group);

    GroupService addPermission(Group group, String permission);

    GroupService addPermissions(Group group, Collection<String> permissions);

    GroupService removePermission(Group group, String permission);

    GroupService removePermissions(Group group, Collection<String> permissions);

    GroupService clearPermissions(Group group);

    default boolean hasPermission(Group group, String permission) {
        return getPermissions(group).contains(permission);
    }
}
