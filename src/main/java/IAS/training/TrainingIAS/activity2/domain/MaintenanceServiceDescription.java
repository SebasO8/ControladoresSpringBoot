package IAS.training.TrainingIAS.activity2.domain;

import org.apache.commons.lang3.Validate;

public class MaintenanceServiceDescription {
    private final String description;

    public MaintenanceServiceDescription(String description) {
        Validate.notBlank(description, "Description can not be blank");
        Validate.isTrue(description.trim().length() < 512, "description can not be longer than 512 characters");
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
}
