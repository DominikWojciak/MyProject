package pl.coderslab.flat;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import pl.coderslab.category.Category;
import pl.coderslab.district.District;
import pl.coderslab.owner.Owner;


import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "flats")
public class Flat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 5, groups = {FlatValidationGroup.class, PropositionValidationGroup.class})
    @Column(name="mytitle")
    private String price;

    @NotEmpty(groups = FlatValidationGroup.class)
    @ManyToMany
    private List<Owner> owners;

    @Min(value = 1900, groups = FlatValidationGroup.class)
    @Max(value = 2030, groups = FlatValidationGroup.class)
    private int year;

    @Min(value = 1, groups = FlatValidationGroup.class)
    @Max(value = 15, groups = FlatValidationGroup.class)
    private int numberOfRooms;

    @Min(value = 0, groups = FlatValidationGroup.class)
    @Max(value = 50, groups = FlatValidationGroup.class)
    private int floor;

    @NotNull(groups = FlatValidationGroup.class)
    @ManyToOne
    private District district;

    @NotBlank(groups = PropositionValidationGroup.class)
    @Size(max = 600, groups = {FlatValidationGroup.class, PropositionValidationGroup.class})
    private String description;

    @Min(value = 2, groups = FlatValidationGroup.class)
    private double m2;

    private boolean proposition;

    @ManyToOne
    private Category category;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<Owner> getOwners() {
        return owners;
    }

    public void setOwners(List<Owner> owners) {
        this.owners = owners;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }
    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getM2() {
        return m2;
    }

    public void setM2(double m2) {
        this.m2 = m2;
    }

    public boolean isProposition() {
        return proposition;
    }

    public void setProposition(boolean proposition) {
        this.proposition = proposition;
    }

    @Override
    public String toString() {
        return "Flat{" +
                "id=" + id +
                ", price='" + price + '\'' +
                ", year=" + year +
                ", numberOfRooms=" + numberOfRooms +
                ", description='" + description + '\'' +
                '}';
    }
}
