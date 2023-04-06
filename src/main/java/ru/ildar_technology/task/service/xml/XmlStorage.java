package ru.ildar_technology.task.service.xml;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.ildar_technology.task.model.domain.City;
import ru.ildar_technology.task.model.domain.Distance;

import javax.xml.bind.annotation.*;
import java.util.List;
import java.util.Objects;

@XmlRootElement(name = "data_set")
@XmlSeeAlso({City.class, Distance.class})
@NoArgsConstructor
@AllArgsConstructor
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlStorage implements Storage {
    @XmlElementWrapper(name = "cities")
    @XmlElement(name = "city")
    private List<City> cityList;

    @XmlElementWrapper(name = "distances")
    @XmlElement(name = "distance")
    private List<Distance> distanceList;

    @Override
    public String toString() {
        return "XmlStorage{" +
                "cityList=" + cityList +
                ", distanceList=" + distanceList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        XmlStorage that = (XmlStorage) o;
        return Objects.equals(cityList, that.cityList) && Objects.equals(distanceList, that.distanceList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityList, distanceList);
    }
}
