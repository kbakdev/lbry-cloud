package lbrys.web;
// tag::validated[]
// tag::notValidated[]
// end::notValidated[]
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

//tag::notValidated[]
//end::notValidated[]
//tag::notValidated[]

@Component
@ConfigurationProperties(prefix="lbry.orders")
@Data
// end::notValidated[]
@Validated
//tag::notValidated[]
public class OrderProps {

    //end::notValidated[]
    @Min(value=5, message="must be between 5 and 25")
    @Max(value=25, message="must be between 5 and 25")
//tag::notValidated[]
    private int pageSize = 20;

}
//end::notValidated[]
//end::validated[]
