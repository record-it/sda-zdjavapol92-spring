package pl.sda.springzdjavapol92.configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app.defaults")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppDefaults {
    private String username;
    private String password;
}
