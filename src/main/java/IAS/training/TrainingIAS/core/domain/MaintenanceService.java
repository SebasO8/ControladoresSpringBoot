package IAS.training.TrainingIAS.core.domain;

import org.apache.commons.lang3.Validate;
import org.joda.time.LocalDateTime;

public class MaintenanceService {
    private final MaintenanceServiceId id;
    private final MaintenanceServiceStartDate startDate;
    private final MaintenanceServiceFinalDate finalDate;
    private final MaintenanceServiceDescription description;

    public MaintenanceService(
            MaintenanceServiceId id,
            MaintenanceServiceStartDate startDate,
            MaintenanceServiceFinalDate finalDate,
            MaintenanceServiceDescription description) {
        this.id = Validate.notNull(id, "Maintenance service id can not be null.");
        this.startDate = Validate.notNull(startDate, "Start date can not be null.");
        this.finalDate = Validate.notNull(finalDate, "Final date can not be null.");
        Validate.isTrue(LocalDateTime.parse(finalDate.getFinalDate()).isAfter(LocalDateTime.parse(startDate.getStartDate())),
                "final date can no be before of start date");
        this.description = Validate.notNull(description, "Description can not be null.");
    }

    public MaintenanceServiceId getId() {
        return id;
    }

    public MaintenanceServiceStartDate getStartDate() {
        return startDate;
    }

    public MaintenanceServiceFinalDate getFinalDate() {
        return finalDate;
    }

    public MaintenanceServiceDescription getDescription() {
        return description;
    }
}
