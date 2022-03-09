package IAS.training.TrainingIAS.activity2.domain;

import org.apache.commons.lang3.Validate;
import org.joda.time.LocalDateTime;

public class MaintenanceServiceStartDate {
    private final String startDate;

    public MaintenanceServiceStartDate(String startDate){
        Validate.notNull(startDate, "start date can no be null");
        Validate.isTrue(LocalDateTime.parse(startDate).isBefore(LocalDateTime.now()), "start date can not be in the future");
        this.startDate = startDate;
    }

    public String getStartDate() {
        return startDate;
    }

    @Override
    public String toString() {
        return startDate;
    }
}
