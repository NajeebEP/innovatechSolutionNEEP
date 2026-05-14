package cl.duoc.innovatech.bff.domain;

// Roles defined in the Keycloak realm `innovatech` (see CLAUDE.md §5).
// Spring MVC binds query/path params to enum values by name automatically.
public enum UserRole {
    PM,
    DEV,
    DIR
}
