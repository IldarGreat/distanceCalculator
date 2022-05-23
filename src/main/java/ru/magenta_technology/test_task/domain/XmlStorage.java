package ru.magenta_technology.test_task.domain;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "data_set")
@XmlSeeAlso({City.class, Distance.class})
public class XmlStorage implements Storage{
    private List<City> cityList;
    private List<Distance> distanceList;

    public XmlStorage() {
    }

    public XmlStorage(List<City> cityList, List<Distance> distanceList) {
        this.cityList = cityList;
        this.distanceList = distanceList;
    }

    @XmlElementWrapper(name = "cities")
    @XmlElement(name = "city")
    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }

    @XmlElementWrapper(name = "distances")
    @XmlElement(name = "distance")
    public List<Distance> getDistanceList() {
        return distanceList;
    }

    public void setDistanceList(List<Distance> distanceList) {
        this.distanceList = distanceList;
    }

    @Override
    public String toString() {
        return "XmlStorage{" +
                "cityList=" + cityList +
                ", distanceList=" + distanceList +
                '}';
    }
}
