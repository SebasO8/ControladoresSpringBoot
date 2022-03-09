package IAS.training.TrainingIAS.activity2.domain;

import org.apache.commons.lang3.Validate;

import java.time.LocalDateTime;

public class MaintenanceServiceFinalDate {

    private final String finalDate;

    public MaintenanceServiceFinalDate(String finalDate){
        Validate.notNull(finalDate, "final date can no be null");
        Validate.isTrue(LocalDateTime.parse(finalDate).isBefore(LocalDateTime.now()), "final date can not be in the future");
        this.finalDate = finalDate;
    }

    public String getFinalDate() {
        return finalDate;
    }

    @Override
    public String toString() {
        return finalDate;
    }
}
