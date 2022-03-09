package IAS.training.TrainingIAS.activity2.controllers;

import IAS.training.TrainingIAS.activity2.controllers.models.MaintenanceServiceDTO;
import IAS.training.TrainingIAS.activity2.controllers.models.MaintenanceServiceInput;
import IAS.training.TrainingIAS.activity2.domain.*;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
public class MaintenanceServiceController {

    @RequestMapping(value= "/services/{id}",method = RequestMethod.GET)
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
        return List.of();
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
