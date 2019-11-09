package sevensingledesignpattern.singlethreadexecution;

public class FlightSecurityTest {
    //旅客线程
    static class Passengers extends Thread{
        private String boardingPass ;
        private String idCard;
        private FlightSecurity flightSecurity;

        public Passengers(FlightSecurity flightSecurity,String boardingPass,String idCard){
            this.flightSecurity = flightSecurity;
            this.boardingPass = boardingPass;
            this.idCard = idCard;
        }

        @Override
        public void run() {
            while(true){
                flightSecurity.pass(boardingPass,idCard);
            }
        }
    }

    public static void main(String[] args){
        FlightSecurity flightSecurity = new FlightSecurity();
        Passengers p1 = new Passengers(flightSecurity,"AF001","Addd00");
        Passengers p2 = new Passengers(flightSecurity,"BC0001","BBBBBBB");
        Passengers p3 = new Passengers(flightSecurity,"C00001","CCCCCC");
        p1.start();
        p2.start();
        p3.start();
    }
}
