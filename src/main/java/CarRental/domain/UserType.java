package CarRental.domain;

public enum UserType {
    ADMIN("Admin"),
    CLIENT("Client"),
    GUEST("Guest");

    private final String label;

    UserType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
