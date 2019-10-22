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
        System.out.println(customerArray.getSize());
        customerArray.add("Eleven");
        System.out.println(customerArray.getSize());
        System.out.println(customerArray.equals(customerArray.get(1), customerArray.get(1)));
        System.out.println(customerArray.equals(customerArray.get(1), customerArray.get(2)));
        System.out.println(customerArray.get(1));
        customerArray.delete(customerArray.get(1));
        System.out.println(customerArray.toString());
        System.out.println((customerArray.contains("Six"))? "Array contains Six": "Array doesn't contain Six");
        customerArray.clear();
        System.out.println(customerArray.toString());
    }
}
