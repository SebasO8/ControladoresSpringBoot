package IAS.training.TrainingIAS.infrastructure.gateways.models;

import IAS.training.TrainingIAS.core.domain.*;

public class MaintenanceServiceDBO {
    private String id;
    private String startDate;
    private String finalDate;
    private String description;

    public MaintenanceServiceDBO(String id, String startDate, String finalDate, String description) {
        this.id = id;
        this.startDate = startDate;
        this.finalDate = finalDate;
        this.description = description;
    }

    public MaintenanceServiceDBO() {
    }

    public MaintenanceService toDomain(){
        return new MaintenanceService(
                new MaintenanceServiceId(id),
                new MaintenanceServiceStartDate(startDate),
                new MaintenanceServiceFinalDate(finalDate),
                new MaintenanceServiceDescription(description)
        );
    }

    public static MaintenanceServiceDBO fromDomain(MaintenanceService service){
        return new MaintenanceServiceDBO(
                service.getId().toString(),
                service.getStartDate().toString(),
                service.getFinalDate().toString(),
                service.getDescription().toString()
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
