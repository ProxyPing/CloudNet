package eu.cloudnetservice.cloudnet.v2.master.module.model;

public final class CloudModuleAuthor {

    private final String name;
    private final String role;

    public CloudModuleAuthor(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }
}
