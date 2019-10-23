import java.util.Arrays;
import java.util.Objects;

public class CustomerArray {
    private static int count;
    private String[]  customerArray;

    public CustomerArray() {

        customerArray = new String[10];
    }

    @Override
    public String toString() {
        return Arrays.toString(customerArray);
    }

    public String getValue(int index) {
        return this.customerArray[index].toString();
    }

    /* Если индекс будет больше размерности массива данных
     в методе add после того как запись вставлена проверяется
     длина массива со значением счетчика, который возрастает на 1 после каждого добавления.
     Если счетчик достиг длины массива создается новый массив копированием из предыдущего с увеличенной длиной.
    */
    public void add(String value){

        this.customerArray[count] = value;
         count++;

          if ( this.customerArray.length == count){
              String[]  newCustomerArray = new String[this.customerArray.length + (this.customerArray.length * 60 / 100)];
              System.arraycopy(this.customerArray, 0, newCustomerArray, 0, this.customerArray.length);
              customerArray = newCustomerArray;
          }
    }

    public int indexOf(String item){
        for(int i = 0; i < this.customerArray.length; i++){
            if((this.customerArray[i]) == item) {
                return i;
            }
        }
        return 0;
    }

    public String get(int index){

        for(int i = 0; i < this.customerArray.length; i++){
            if(indexOf(this.customerArray[i]) == index) {
              return this.customerArray[i];
            }
        }
        return null;
    }

    public void delete(String item) {
        int index = indexOf(item);
        String[] newCustomerArray = new String[this.customerArray.length];
        System.arraycopy(this.customerArray, 0, newCustomerArray, 0, index);
        System.arraycopy(this.customerArray, index + 1, newCustomerArray, index, this.customerArray.length - index - 1);
        this.customerArray = newCustomerArray;
    }

    public boolean contains(String value){
        for (String element : this.customerArray){

        if (element == null){
            continue;
        }

        if (element.toString() == value){
                return true;
            }
        }
        return false;
    }

    //Метод очистить
    public void  clear(){
        Arrays.fill(this.customerArray, null);
    }

    public int getSize(){
        return this.customerArray.length;
    }

    public boolean equals(String o1, String o2){
        if (o1 == o2) return true;
        if (o1 == null || o2 == null || o1.getClass() != o2.getClass()) return false;
        String item1 = (String) o1;
        String item2 = (String) o2;
        return Objects.equals(item1, item2);
    }

}
