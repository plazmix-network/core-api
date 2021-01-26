package net.plazmix.core.api.service.economy;

import lombok.Data;

@Data
public class ConversionInfo {

    private final ConversionResult result;
    private final Currency from, to;
    private final int sum;
}
