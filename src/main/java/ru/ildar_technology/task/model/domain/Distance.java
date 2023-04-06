package ru.ildar_technology.task.model.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;


@XmlRootElement(name = "distance")
@XmlType(propOrder = {"fromCity", "toCity", "distance"})
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Distance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private long id;
    @OneToOne
    @JoinColumn(name = "from_city")
    private City fromCity;
    @OneToOne
    @JoinColumn(name = "to_city")
    private City toCity;
    @Column(name = "distance")
    private double distance;


    public Distance(City fromCity, City toCity, double distance) {
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Distance{" +
                "id=" + id +
                ", fromCity=" + fromCity +
                ", toCity=" + toCity +
                ", distance=" + distance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Distance distance1 = (Distance) o;
        return id == distance1.id && Double.compare(distance1.distance, distance) == 0 && Objects.equals(fromCity, distance1.fromCity) && Objects.equals(toCity, distance1.toCity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fromCity, toCity, distance);
    }
}
