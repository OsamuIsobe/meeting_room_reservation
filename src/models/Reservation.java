package models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity

@NamedQueries({
    @NamedQuery(
            name = "getAllReservations",
            query = "SELECT r FROM Reservation AS r ORDER BY r.id DESC"
            )
})

@Table(name = "reservations")
public class Reservation {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "room_id", nullable = false)
    private String room_id;

    @Column(name = "reserve_time", nullable = false)
    private Timestamp reserve_time;

    @Column(name = "name", nullable = false)
    private String name;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    public Timestamp getReserve_time() {
        return reserve_time;
    }
    public void setReserve_time(Timestamp reserve_time) {
        this.reserve_time = reserve_time;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}