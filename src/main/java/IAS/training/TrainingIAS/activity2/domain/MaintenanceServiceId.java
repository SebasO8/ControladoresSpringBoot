package IAS.training.TrainingIAS.activity2.domain;

import org.apache.commons.lang3.Validate;

public class MaintenanceServiceId {
    private final String value;

   public MaintenanceServiceId (String value){
       Validate.notBlank(value, "Maintenance service id can not be blank");
       Validate.isTrue(value.length() == 36 , "Maintenance service should have 36 characters");
       this.value = value;
   }

   public String getValue() {
       return value;
   }

    @Override
    public String toString() {
        return value;
    }

}
