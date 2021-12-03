import java.io.Serializable;

public class Item implements Serializable {

    private static final long serialVersionUID = 2L;

    private int id;
    private String description;
    private double cost;

    public Item(int id, String description, double cost){
        this.id=id;
        this.description=description;
        this.cost=cost;
    }

    private int getId(){
        return this.id;
    }

    private String getDescription(){
        return this.description;
    }

    private double getCost(){
        return this.cost;
    }

    @Override
    public String toString(){
        return "\n" + "Id: " + id +"; description: " + description + "; cost: " + cost ;
    }
}
