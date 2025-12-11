package de.seuhd.campuscoffee.domain.model.objects;

import java.time.LocalDateTime;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import lombok.Builder;

/**
 * Domain record that stores a review for a point of sale.
 * Reviews are approved once they received a configurable number of approvals.
 * 
 * @param id            the unique identifier; null when the review has not been created yet
 * @param createdAt     timestamp set on Review creation
 * @param updatedAt     timestamp set on Review creation and update
 * @param pos           the reviewed POS; never null when the review has been created
 * @param author        the author of the review; never null when the review has been created
 * @param review        the review text; never null and never empty
 * @param approvalCount amount of approvals; never null
 * @param approved      true or false; not present when creating a new review
 */
@Builder(toBuilder = true)
public record Review(
        @Nullable Long id, // null when the review has not been created yet
        @Nullable LocalDateTime createdAt, // set on Review creation
        @Nullable LocalDateTime updatedAt, // set on Review creation and update
        @NonNull Pos pos,
        @NonNull User author,
        @NonNull String review,
        @NonNull Integer approvalCount, // is updated by the domain module
        @NonNull Boolean approved // is determined by the domain module
) implements DomainModel<Long> {
    @Override
    public Long getId() {
        return id;
    }
}