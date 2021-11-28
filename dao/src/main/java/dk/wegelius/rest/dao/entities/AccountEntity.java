package dk.wegelius.rest.dao.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="accounts")
public class AccountEntity {
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
    private CustomerEntity customer;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_account_types", referencedColumnName = "account_types_id")
    private AccountTypeEntity type;

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

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public AccountTypeEntity getType() {
        return type;
    }

    public void setType(AccountTypeEntity type) {
        this.type = type;
    }
}
