package api.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Bin {


    @Id
    @GeneratedValue
    private Long id;

    private Long latitude;

    private Long longitude;

    private String city;

    private String description;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Set<BIN_TYPE> bin_type;

    public Bin() {

    }

    public Long getId() {
        return id;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLatitude() {
        return latitude;
    }

    public void setLatitude(Long latitude) {
        this.latitude = latitude;
    }

    public Long getLongitude() {
        return longitude;
    }

    public void setLongitude(Long longitude) {
        this.longitude = longitude;
    }

    public Set<BIN_TYPE> getBin_type() {
        return bin_type;
    }

    public void setBin_type(Set<BIN_TYPE> bin_type) {
        this.bin_type = bin_type;
    }
}
