package IAS.training.TrainingIAS.activity2.controllers.models;

import IAS.training.TrainingIAS.activity2.domain.MaintenanceService;

public class MaintenanceServiceDTO {
    private String id;
    private String startDate;
    private String finalDate;
    private String description;

    public MaintenanceServiceDTO(String id, String startDate, String finalDate, String description) {
        this.id = id;
        this.startDate = startDate;
        this.finalDate = finalDate;
        this.description = description;
    }

    public MaintenanceServiceDTO() {
    }

    public static MaintenanceServiceDTO fromDomain(MaintenanceService maintenanceService){
        return new MaintenanceServiceDTO(
                maintenanceService.getId().toString(),
                maintenanceService.getStartDate().toString(),
                maintenanceService.getFinalDate().toString(),
                maintenanceService.getDescription().toString()
        );
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
