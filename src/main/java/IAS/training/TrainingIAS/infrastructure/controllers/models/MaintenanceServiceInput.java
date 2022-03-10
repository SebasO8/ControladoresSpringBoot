package IAS.training.TrainingIAS.infrastructure.controllers.models;

public class MaintenanceServiceInput {
    private String startDate;
    private String finalDate;
    private String description;

    public MaintenanceServiceInput(String startDate, String finalDate, String description) {
        this.startDate = startDate;
        this.finalDate = finalDate;
        this.description = description;
    }

    public MaintenanceServiceInput() {
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(String finalDate) {
        this.finalDate = finalDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
