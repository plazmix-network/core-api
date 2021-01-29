package net.plazmix.core.api.service.group;

import net.plazmix.core.api.common.util.CachedDataContainer;
import net.plazmix.core.api.service.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;

public interface GroupService extends Service, CachedDataContainer<PermissionData, UUID> {

    Optional<PermissionData> getPermissionData(UUID uuid);

    GroupService savePermissionData(PermissionData permissionData);

    GroupService removePermissionData(PermissionData permissionData);

    Collection<String> getPermissions(UUID uuid);

    default Supplier<Collection<String>> supplyPermissions(UUID uuid) {
        return () -> getPermissions(uuid);
    }

    GroupService addPermission(UUID uuid, String permission);

    GroupService removePermission(UUID uuid, String permission);

    GroupService addPermissions(UUID uuid, Collection<String> permissions);

    GroupService removePermissions(UUID uuid, Collection<String> permissions);

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
