public class Main {

    public  static void main(String args[]){
  CustomerArray customerArray = new CustomerArray();
        customerArray.add("One");
        customerArray.add("Two");
        customerArray.add("Three");
        customerArray.add("Four");
        customerArray.add("Five");
        customerArray.add("Six");
        customerArray.add("Seven");
        customerArray.add("Nine");
        customerArray.add("Ten");

       System.out.println(customerArray.indexOf("Nine"));
       System.out.println(customerArray.getSize());
        customerArray.add("Eleven");
        System.out.println(customerArray.getSize());
        System.out.println(customerArray.getByIndex(1));
        customerArray.deleteByIndex(1);
        customerArray.deleteByValue("Four");
        System.out.println(customerArray.toString());
        System.out.println((customerArray.contains("Six"))? "Array contains Six": "Array doesn't contain Six");
        System.out.println( customerArray.equals( customerArray));
        CustomerArray customerArray1 = new CustomerArray();
        System.out.println( customerArray.equals( customerArray1));
        customerArray.trim();
        System.out.println(customerArray.toString());
        customerArray.clear();
        System.out.println(customerArray.toString());
    }
}
