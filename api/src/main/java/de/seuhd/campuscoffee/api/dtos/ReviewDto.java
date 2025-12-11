package de.seuhd.campuscoffee.api.dtos;

import java.time.LocalDateTime;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import de.seuhd.campuscoffee.domain.model.objects.Pos;
import de.seuhd.campuscoffee.domain.model.objects.User;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

/**
 * DTO record for POS metadata.
 */
@Builder(toBuilder = true)
public record ReviewDto (
    @Nullable Long id,
    @Nullable LocalDateTime createdAt,
    @Nullable LocalDateTime updatedAt,
    @NonNull Pos pos,
    @NonNull User author,

    @NotBlank(message = "Review cannot be empty.")
    @NonNull String review,
    
    @NonNull Integer approvalCount,
    @NonNull Boolean approved
) implements Dto<Long> {
    @Override
    public @Nullable Long getId() {
        return id;
    }
}
