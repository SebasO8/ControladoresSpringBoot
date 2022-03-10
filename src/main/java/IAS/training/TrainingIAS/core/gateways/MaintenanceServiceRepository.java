package IAS.training.TrainingIAS.core.gateways;

import IAS.training.TrainingIAS.core.domain.MaintenanceService;
import IAS.training.TrainingIAS.core.domain.MaintenanceServiceId;
import IAS.training.TrainingIAS.shared.domain.PageQuery;

import java.util.List;
import java.util.Optional;

public interface MaintenanceServiceRepository {
    List<MaintenanceService> query(PageQuery pageQuery);

    Optional<MaintenanceService> get(MaintenanceServiceId maintenanceServiceId);

    void store(MaintenanceService service);
}
