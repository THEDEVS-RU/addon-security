package dev.qubik.autoconfigure.security;

import dev.qubik.security.ScConfiguration;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Import;

@AutoConfiguration
@Import({ScConfiguration.class})
public class ScAutoConfiguration {
}

