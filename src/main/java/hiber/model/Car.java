package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue
    private long id;
    private String model;
    private int series;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
            CascadeType.REFRESH}, mappedBy = "car")
    private User user;

    public Car() {
    }


    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return " Car " +
                " id " + id +
                " model " + model +
                " series " + series;
    }
}
