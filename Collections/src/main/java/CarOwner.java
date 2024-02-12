import java.util.Objects;

public class CarOwner {
    private int id;
    private String name;
    private String lastName;

    public CarOwner(int id, String name, String lastName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,name,lastName);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }else if(obj == null || getClass() != obj.getClass()){
            return false;
        }else{
            CarOwner carOwner = (CarOwner) obj;
            return name.equals(carOwner.name) && id == carOwner.id && lastName.equals(carOwner.lastName);
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
