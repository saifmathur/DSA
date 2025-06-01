package CollectionsStreamsMultiThreading;

public class DesignPatterns {

    //singleton pattern
    //factory pattern
    // builder pattern
    // strategy pattern


    public static class Singleton {
        private static Singleton instance;

        private Singleton() {
            // private constructor to prevent instantiation
        }

        public static synchronized Singleton getInstance() {
            if (instance == null) {
                instance = new Singleton();
            }
            return instance;
        }
    }


    public static class Factory {

        interface Shape {
            String draw();
        }


        public static class Circle implements Shape {

            @Override
            public String draw() {
                return "Drawing a Circle";
            }
        }

        public static class Square implements Shape {

            @Override
            public String draw() {
                return "Drawing a Square";
            }
        }

        static class ShapeFactory {
            public static Shape getShape(String shapeType) {
                if (shapeType == null) {
                    return null;
                }
                if (shapeType.equalsIgnoreCase("CIRCLE")) {
                    return new Circle();
                } else if (shapeType.equalsIgnoreCase("SQUARE")) {
                    return new Square();
                }
                return null;
            }
        }


    }

    public static class Builder {
        public static class User {
            private String name;
            private int age;

            private User(UserBuilder builder) {
                this.name = builder.name;
                this.age = builder.age;
            }

            public static class UserBuilder {
                private String name;
                private int age;

                public UserBuilder setName(String name) {
                    this.name = name;
                    return this;
                }

                public UserBuilder setAge(int age) {
                    this.age = age;
                    return this;
                }

                public User build() {
                    return new User(this);
                }
            }
        }

        User user = new User.UserBuilder()
                .setName("John Doe")
                .setAge(30)
                .build();
    }

    static class StrategyPattern {
        interface PaymentStrategy {
            void pay(int amount);
        }

        static class CreditCardPayment implements PaymentStrategy {
            @Override
            public void pay(int amount) {
                System.out.println("Paid " + amount + " using Credit Card.");
            }
        }
        static class PayPalPayment implements PaymentStrategy {
            @Override
            public void pay(int amount) {
                System.out.println("Paid " + amount + " using PayPal.");
            }
        }

        static class PaymentContext {
            private PaymentStrategy strategy;

            public void setPaymentStrategy(PaymentStrategy strategy) {
                this.strategy = strategy;
            }

            public void executePayment(int amount) {
                if (strategy != null) {
                    strategy.pay(amount);
                } else {
                    System.out.println("No payment strategy set.");
                }
            }
        }
    }
}
