public class RailwayCounter {

    private String name;
    private String place;
    private int amount;

    public RailwayCounter(String name, String place, int amount) {
        this.name = name;
        this.place = place;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public static void main(String[] args) throws InterruptedException{

        RailwayCounter booking1=new RailwayCounter("Hari","Central",100);
        RailwayCounter booking2=new RailwayCounter("Abhi","Arakonam",300);
        RailwayCounter booking3=new RailwayCounter("Gopi","Tirutani",400);

        Runnable counter1= () -> {

            System.out.println("Counter1 Name : "+booking1.getName());
            System.out.println("Counter1 Place : "+booking1.getPlace());
            System.out.println("Counter1 Amount : "+booking1.getAmount());
        };
        Thread railwayCounter1=new Thread(counter1);

        Runnable counter2=new Runnable() {
            @Override
            public void run() {

                System.out.println("Counter2 Name : "+booking2.name);
                System.out.println("Counter2 Place : "+booking2.place);
                System.out.println("Counter2 Amount : "+booking2.amount);
            }
        };
        Thread railwayCounter2=new Thread(counter2);

        Runnable counter3=new Runnable() {
            @Override
            public void run() {

                System.out.println("Counter3 Name : "+booking3.name);
                System.out.println("Counter3 Place : "+booking3.place);
                System.out.println("Counter3 Amount : "+booking3.amount);
            }
        };
        Thread railwayCounter3=new Thread(counter3);

      //  railwayCounter3.setPriority(Thread.MAX_PRIORITY);

        railwayCounter1.start();
        if (railwayCounter1.isAlive()){
            System.out.println("Counter 1 Busy");
        }
        railwayCounter2.start();
        if (railwayCounter2.isAlive()){
            System.out.println("Counter 2 Busy");
        }
        railwayCounter3.start();
        if (railwayCounter3.isAlive()){
            System.out.println("Counter 3 Busy");
        }
        railwayCounter1.join();
        railwayCounter2.join();
        railwayCounter3.join();
        if (railwayCounter1.isAlive()){
            System.out.println("Counter 1 Busy");
        }else {
            System.out.println("Counter 1 Free");
        }
        if (railwayCounter2.isAlive()){
            System.out.println("Counter 2 Busy");
        }else {
            System.out.println("Counter 2 Free");
        }
        if (railwayCounter3.isAlive()){
            System.out.println("Counter 3 Busy");
        }else {
            System.out.println("Counter 3 Free");
        }
    }


}