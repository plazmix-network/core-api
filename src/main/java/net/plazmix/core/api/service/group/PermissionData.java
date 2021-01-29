package net.plazmix.core.api.service.group;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collection;
import java.util.UUID;

@Data(staticConstructor = "of")
@AllArgsConstructor(staticName = "of")
public class PermissionData {

    private final UUID uniqueId;
    private final Collection<String> permissions;
    private volatile Group group;
}
