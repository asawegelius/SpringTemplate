package dk.wegelius.rest.dao.entities;

import javax.persistence.*;

@Entity
@Table(name="customer_types")
public class CustomerTypeEntity {

    @Id
    @Column(name="customer_types_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long customerTypeId;
    @Column(name="customer_types_name")
    private String name;
    @Column(name="customer_types_description")
    private String description;

    public long getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(long customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
