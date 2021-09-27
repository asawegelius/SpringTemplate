package dk.wegelius.rest.dao.entities;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name="reservation")
public class Reservation {
    @Id
    @Column(name = "RESERVATION_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long reservationId;

    @Column(name = "RES_DATE")
    private Date reservationDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "GUEST_ID", referencedColumnName = "GUEST_ID")
    private Guest guest;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ROOM_ID", referencedColumnName = "ROOM_ID")
    private Room room;

    public long getReservationId() {
        return reservationId;
    }

    public void setReservationId(long reservationId) {
        this.reservationId = reservationId;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}

