import java.util.Objects;

public class Collection {

    private String value;
    private int id;

    public Collection(){

    }

    public Collection(String value, int id){
        this.value = value;
        this.id = id;
      }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Collection collection = (Collection) o;
        return Objects.equals(id, collection.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.id);
    }

    @Override
    public String toString() {
        return this.value;
    }

    public int getId(){
        return this.id;
    }

    }
