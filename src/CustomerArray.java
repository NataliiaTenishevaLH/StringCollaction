import java.util.Arrays;
import java.util.Objects;

public class CustomerArray {
    private static int count;
    private Collection[]  customerArray;

    public CustomerArray() {

        customerArray = new Collection[10];
    }

    @Override
    public String toString() {
        return Arrays.toString(customerArray);
    }

    public String getValue(int index) {
        return this.customerArray[index].toString();
    }

    public void add(String value){

        this.customerArray[count] = new Collection(value, count);
         count++;

          if ( this.customerArray.length == count){
              Collection[]  newCustomerArray = new Collection[this.customerArray.length + (this.customerArray.length * 60 / 100)];
              System.arraycopy(this.customerArray, 0, newCustomerArray, 0, this.customerArray.length);
              customerArray = newCustomerArray;
          }
    }

    public int indexOf(Collection item){
        return item.getId();
    }

    public Collection get(int index){

        for(int i = 0; i < this.customerArray.length; i++){
            if(indexOf(this.customerArray[i]) == index) {
              return this.customerArray[i];
            }
        }
        return null;
    }

    public void delete(Collection item) {
        int index = indexOf(item);
        Collection[] newCustomerArray = new Collection[this.customerArray.length];
        System.arraycopy(this.customerArray, 0, newCustomerArray, 0, index);
        System.arraycopy(this.customerArray, index + 1, newCustomerArray, index, this.customerArray.length - index - 1);
        this.customerArray = newCustomerArray;
    }

    public boolean contains(String value){
        for (Collection element : this.customerArray){

        if (element == null){
            continue;
        }

        if (element.toString() == value){
                return true;
            }
        }
        return false;
    }

    public void  clear(){
        Arrays.fill(this.customerArray, null);
    }

    public int getSize(){
        return this.customerArray.length;
    }

    public boolean equals(Object o1, Object o2){
        if (o1 == o2) return true;
        if (o1 == null || o2 == null || o1.getClass() != o2.getClass()) return false;
        Collection item1 = (Collection) o1;
        Collection item2 = (Collection) o2;
        return Objects.equals(indexOf(item1), indexOf(item2));
    }

}
