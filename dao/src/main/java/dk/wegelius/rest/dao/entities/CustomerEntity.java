package dk.wegelius.rest.dao.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="customers")
public class CustomerEntity {
    @Id
    @Column(name="customers_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long customerId;
    @Column(name="customers_firstname")
    private String firstName;
    @Column(name="customers_lastname")
    private String lastName;
    @Column(name="customers_phone")
    private String phoneNumber;
    @Column(name="customers_email")
    private String emailAddress;
    @Column(name="customers_startdate")
    private Date startDate;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_customer_types", referencedColumnName = "customer_types_id")
    private CustomerTypeEntity customerType;

    public CustomerTypeEntity getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerTypeEntity customerType) {
        this.customerType = customerType;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
