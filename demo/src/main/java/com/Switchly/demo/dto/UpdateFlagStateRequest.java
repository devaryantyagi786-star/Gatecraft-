
package com.Switchly.demo.dto;

import jakarta.validation.constraints.NotNull;

public record UpdateFlagStateRequest(
        @NotNull Boolean enabled
) {}
