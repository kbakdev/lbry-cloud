package lbrys;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@ConfigurationProperties(prefix="lbry.discount")
@Data
public class DiscountCodeProps {

    private Map<String, Integer> codes = new HashMap<>();

}