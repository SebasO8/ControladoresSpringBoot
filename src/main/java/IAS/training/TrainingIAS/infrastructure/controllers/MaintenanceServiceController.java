package IAS.training.TrainingIAS.infrastructure.controllers;

import IAS.training.TrainingIAS.core.gateways.MaintenanceServiceRepository;
import IAS.training.TrainingIAS.infrastructure.controllers.models.MaintenanceServiceDTO;
import IAS.training.TrainingIAS.infrastructure.controllers.models.MaintenanceServiceInput;
import IAS.training.TrainingIAS.core.domain.*;
import IAS.training.TrainingIAS.shared.domain.Limit;
import IAS.training.TrainingIAS.shared.domain.PageQuery;
import IAS.training.TrainingIAS.shared.domain.Skip;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class MaintenanceServiceController {
    private final MaintenanceServiceRepository maintenanceServiceRepository;

    public MaintenanceServiceController(MaintenanceServiceRepository maintenanceServiceRepository) {
        this.maintenanceServiceRepository = maintenanceServiceRepository;
    }

    @RequestMapping(value= "/services/{id}", method = RequestMethod.GET)
    public MaintenanceServiceDTO getService(
            @PathVariable("id") String serviceId
    ){
        return new MaintenanceServiceDTO(
                serviceId,
                "2019-09-07T-15:50+00",
                "2019-09-07T-15:50+00",
                "this is the description"
        );
    }

    @RequestMapping(value = "/services", method = RequestMethod.GET)
    public List<MaintenanceServiceDTO> listServices(
            @RequestParam(name = "skip", defaultValue = "0") Integer skip,
            @RequestParam(name = "limit", defaultValue = "50") Integer limit
    ){
        PageQuery pageQuery = new PageQuery(
                new Skip(skip),
                new Limit(limit)
        );
        List<MaintenanceService> services = maintenanceServiceRepository.query(pageQuery);

        List<MaintenanceServiceDTO> result = new ArrayList<>();
        for (MaintenanceService service : services){
            MaintenanceServiceDTO dto = MaintenanceServiceDTO.fromDomain(service);
            result.add(dto);
        }
        return  result;
    }


    @RequestMapping(value = "/create/products", method = RequestMethod.POST)
    public MaintenanceServiceDTO createService(
            @RequestBody MaintenanceServiceInput serviceInput
    ){
        MaintenanceService service = new MaintenanceService(
                new MaintenanceServiceId(UUID.randomUUID().toString()),
                new MaintenanceServiceStartDate(serviceInput.getStartDate()),
                new MaintenanceServiceFinalDate(serviceInput.getFinalDate()),
                new MaintenanceServiceDescription(serviceInput.getDescription())
        );
        return MaintenanceServiceDTO.fromDomain(service);
    }
}
