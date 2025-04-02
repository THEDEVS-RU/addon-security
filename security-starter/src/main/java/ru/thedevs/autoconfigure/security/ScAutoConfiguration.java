package ru.thedevs.autoconfigure.security;

import ru.thedevs.security.ScConfiguration;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Import;

@AutoConfiguration
@Import({ScConfiguration.class})
public class ScAutoConfiguration {
}

