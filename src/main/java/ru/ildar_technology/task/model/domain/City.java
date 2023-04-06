package ru.ildar_technology.task.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.Objects;


@XmlRootElement(name = "city")
@XmlType(propOrder = {"name", "latitude", "longitude"})
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "latitude")
    private String latitude;
    @Column(name = "longitude")
    private String longitude;

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return id == city.id && Objects.equals(name, city.name) && Objects.equals(latitude, city.latitude) && Objects.equals(longitude, city.longitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, latitude, longitude);
    }
}
