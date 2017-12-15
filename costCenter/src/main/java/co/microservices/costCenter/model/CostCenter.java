package co.microservices.costCenter.model;

/**
 * Created by rafaellopez on 12/15/17.
 */
public class CostCenter {
    private String id;
    private String name;

    public CostCenter() {
    }

    public CostCenter(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CostCenter{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
