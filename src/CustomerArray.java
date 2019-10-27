import java.util.Arrays;
import java.util.Objects;

public class CustomerArray {
    private static int count = 0;
    private String[]  customerArray;

    public CustomerArray() {

        customerArray = new String[10];
    }

    private void refactoringCustomerArray(int length){
        String[]  newCustomerArray = new String[length];
        System.arraycopy(this.customerArray, 0, newCustomerArray, 0, this.customerArray.length);
        this.customerArray = newCustomerArray;
    }

    private void refactoringCustomerArray(int index, boolean moveItemLeft){
        String[]  newCustomerArray =  new String[this.customerArray.length];
        System.arraycopy(this.customerArray, 0, newCustomerArray, 0, this.customerArray.length);
        System.arraycopy(this.customerArray, index + 1, newCustomerArray, index, this.customerArray.length - index - 1);
        this.customerArray = newCustomerArray;
    }

    private void refactoringCustomerArray(int length, int countDeleted){
        String[]  newCustomerArray = new String[length];
        System.arraycopy(this.customerArray, 0, newCustomerArray, 0, (this.customerArray.length - countDeleted));
        this.customerArray = newCustomerArray;
    }

     //Узнать размер коллекции
    public int getSize(){
        return this.customerArray.length;
    }

    //Добавлять
    public boolean add(String value){
        if ( count == (this.customerArray.length - 1)){
            refactoringCustomerArray(this.customerArray.length + (this.customerArray.length * 60 / 100));
         }

         try {
            this.customerArray[count] = value;
            count++;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean contains(String value){
        for (String element : this.customerArray){
            if (element == null){
                continue;
            }
            if (element == value){
                return true;
            }
        }
        return false;
    }

    //Удалять
    public boolean delete(int index) {

        if (index > count) {
            return false;
        }

        refactoringCustomerArray(index, true);
         return true;
    }

    public boolean delete(String value){

        if (!contains(value)){
            return false;
        }

        for(int i = 0; i < this.customerArray.length; i++){
            if (customerArray[i].toString() == value) {
                refactoringCustomerArray(i, true);
                return true;
            }
        }
        return false;
    }

    //Доставать по индексу
    public String getByIndex(int index){

        if (index > count) {
            return null;
        }

        for(int i = 0; i < this.customerArray.length; i++){
            if(indexOf(this.customerArray[i]) == index) {
                return this.customerArray[i];
            }
        }
        return null;
    }

      //Находить индекс элемента
      public int indexOf(String value){
        for(int i = 0; i < this.customerArray.length; i++){
            if((this.customerArray[i].toString()) == value) {
                return i;
            }
        }
        return 0;
    }

    //Метод очистить
    public boolean  clear(){
        try {
            Arrays.fill(this.customerArray, null);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    //Проверять на равенство двух коллекций
    public boolean equals(Object o){
       if (o == null) return false;
       if (getClass() != o.getClass()) return false;
       CustomerArray anotherCustomerArray = (CustomerArray) o;
       if (this.getSize() != anotherCustomerArray.getSize()) return false;
       for(String element : customerArray){
            if (element == null){
              continue;
            };
            if (!anotherCustomerArray.contains(element)){
                return false;
           }
       }
        return true;
    }

    //Метод trim
    public boolean trim(){
        int countDeleted = 0;
        for(int i = 0; i < this.customerArray.length; i++){
             if (customerArray[i] == null) {
                 countDeleted++;
             }
        }

        try {
            refactoringCustomerArray(this.customerArray.length - countDeleted, countDeleted);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    @Override
    public String toString() {
        return Arrays.toString(customerArray);
    }

}
