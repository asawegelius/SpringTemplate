package dk.wegelius.rest.dao.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="accounts")
public class Account {
    @Id
    @Column(name="accounts_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long accountId;

    @Column(name="accounts_name")
    private String accountName;
    @Column(name="accounts_date_opened")
    private Date accountOpened;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customers_id", referencedColumnName = "customers_id")
    private Customer customer;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_types_id", referencedColumnName = "account_types_id")
    private AccountType type;

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Date getAccountOpened() {
        return accountOpened;
    }

    public void setAccountOpened(Date accountOpened) {
        this.accountOpened = accountOpened;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }
}
