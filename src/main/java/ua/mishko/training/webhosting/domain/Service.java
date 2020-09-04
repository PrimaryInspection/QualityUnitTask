package ua.mishko.training.webhosting.domain;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "service")
public class Service implements Serializable {

    private static final long serialVersionUID = -37552617527052947L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "variation_id")
    private Variation variationId;

    public Service() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Variation getVariationId() {
        return variationId;
    }

    public void setVariationId(Variation variationId) {
        this.variationId = variationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Service)) return false;
        Service service = (Service) o;
        return getId().equals(service.getId()) &&
                getName().equals(service.getName()) &&
                getVariationId().equals(service.getVariationId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getVariationId());
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", variationId=" + variationId +
                '}';
    }
}
