package dk.wegelius.rest.dto.models;

public class CustomerType {
    private String type;
    private String description;

    public CustomerType() {}


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
