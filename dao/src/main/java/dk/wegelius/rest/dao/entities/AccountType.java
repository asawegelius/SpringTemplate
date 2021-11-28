package dk.wegelius.rest.dao.entities;

import javax.persistence.*;

@Entity
@Table(name="account_types")
public class AccountType {
    @Id
    @Column(name="account_types_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long accountTypeId;

    @Column(name="account_types_name")
    private String name;
    @Column(name="account_types_description")
    private String description;
}
