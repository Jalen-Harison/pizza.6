import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Slice_o_Heaven {

    private String orderID;
    private double orderTotal;
    public String storeName;
    public String storeAdddress;
    public String storeEmail;
    public long storePhone;
    public String storeMenu;
    public String pizzaIngredients;
    public double pizzaPrice;
    public String sides;
    public String drinks;


    public static final String DEF_ORDER_ID = "DEF-SOH-099";
    public static final String DEF_PIZZA_INGREDIENTS = "Mozzarella Cheese";
    public static final double DEF_ORDER_TOTAL = 15.00;

    
    public Slice_o_Heaven() {
        this.orderID = DEF_ORDER_ID;
        this.pizzaIngredients = DEF_PIZZA_INGREDIENTS;
        this.orderTotal = DEF_ORDER_TOTAL;
        this.sides = "";
        this.drinks = "";
    }

    
    public Slice_o_Heaven(String orderID, String pizzaIngredients, double orderTotal) {
        this.orderID = orderID;
        this.pizzaIngredients = pizzaIngredients;
        this.orderTotal = orderTotal;
    }
    
    public String getOrderID() {
        return orderID;
    }

    
    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    
    public double getOrderTotal() {
        return orderTotal;
    }

    
    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    
    public void takeOrder() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter three ingredients for your pizza (use spaces to separate ingredients):");
        String ingredients = sc.nextLine();

        
        String ing1 = ingredients[0];
        String ing2 = ingredients[1];
        String ing3 = ingredients[2];

        System.out.println("Enter size of pizza (Small, Medium, Large):");
        String pizzaSize = sc.nextLine();

        System.out.println("Do you want extra cheese (Y/N):");
        String extraCheese = sc.nextLine();

        System.out.println("Enter one side dish (Calzone, Garlic bread, None):");
        String sideDish = sc.nextLine();

        System.out.println("Enter drinks (Cold Coffee, Cocoa drink, Coke, None):");
        String drinks = sc.nextLine();

        System.out.println("Would you like the chance to pay only half for your order? (Y/N):");
        String wantDiscount = sc.nextLine();

        if(wantDiscount.equalsIgnoreCase("Y")){
            isItYourBirthday();
        }else{
            makeCardPayment();
        }


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Order is ready for pickup!");
        }

        System.out.println("Your order is ready!");
        printReceipt();
    }

    
    private void printReceipt() {
        System.out.println("--- Receipt ---");
        System.out.println("Order ID: " + orderID);
        System.out.println("Pizza Ingredients: " + pizzaIngredients);
        System.out.println("Order Total: " + orderTotal);
    }

    
    public void processCardPayment(long cardNumber, String expiryDate, int cvv) {
        String cardLength = Long.toString(cardNumber);
        if (cardLength.length() == 14) {
            System.out.println("Card accepted");
        } else {
            System.out.println("Invalid card");
        }

        long firstCardDigit = Long.parseLong(cardNumber.substring(0, 1));

        long blacklistedNumber = 12345678901234L;
        if (cardNumber == blacklistedNumber){
            System.out.println("Card is blacklisted. Please use another card");
        }

        long lastFourDigits = Long.parseLong(cardNumber.substring(cardNumber.length() - 4));

        String cardNumberToDisplay = cardNumber.charAt(0) + cardNumber.substring(1, cardNumber.length() - 4).replaceAll(".", "*") + cardNumber.substring(cardNumber.length() - 4);
        System.out.println("Display Card Number: " + cardNumberToDisplay);
    }
       public calculateAge(Date birthdate) {
         Date now = new Date();
         long diff = now.getTime() - birthdate.getTime();
         return (int) (diff / (1000 * 60 * 60 * 24 * 365.242199));
       }
    
      public void isItYourBirthday(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your birthday(yyyy-MM-dd):");
        String birthdaydate = sc.nextLine();
         

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birthdate;
        try {
            birthdate = sdf.parse(birthdateStr);
            int age = calculateAge(birthdate);

            if (age < 18 && sdf.format(new Date()).equals(sdf.format(birthdate))) {
                System.out.println("Congratulations! You pay only half the price for your order");
                orderTotal /= 2;
            } else {
                System.out.println("Too bad! You do not meet the conditions to get our 50% discount");
            }
       }

       public void makeCardPayment(){
        Scanner sc =new Scannner(System.in);


        System.out.println("Please enter your card number:");
        long cardNumber = sc.nextLong();

        System.out.println("Please enter the card's expiry date (format: yyyy-MM):");
        String expiryDate = sc.next();

        System.out.println("Please enter the card's cvv number:");
        int cvv = sc.nextInt();

        processCardPayment(cardNumber, expiryDate, cvv);

       }

    public void specialOfTheDay(String pizzaOfTheDay, String sideOfTheDay, String specialPrice) {
        String info = "Today's Special - Pizza: " + pizzaOfTheDay + ", Side: " + sideOfTheDay + ", Price: " + specialPrice;
        System.out.println(info);
    }
}