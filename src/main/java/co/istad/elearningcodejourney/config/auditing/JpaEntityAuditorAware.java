package co.istad.elearningcodejourney.config.auditing;

import org.jspecify.annotations.NullMarked;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;

import java.util.Optional;

@NullMarked
@Component
public class JpaEntityAuditorAware implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth == null || !auth.isAuthenticated()) {
            return Optional.of("SYSTEM");
        }

        if (auth instanceof JwtAuthenticationToken jwtAuth) {

            Jwt jwt = jwtAuth.getToken();

            // 👇 GET USERNAME (Keycloak standard)
            String username = jwt.getClaimAsString("preferred_username");

            if (username == null) {
                username = jwt.getSubject(); // fallback
            }

            return Optional.of(username);
        }

        return Optional.of("SYSTEM");
    }
}