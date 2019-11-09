package sevensingledesignpattern.singlethreadexecution;

public class FlightSecurity {
    private int count = 0;
    //登机牌
    private String boardingPass = "null";
    //身份证号
    private String idCard = "null";

    public synchronized void pass(String boardingPass,String idCard){
        this.boardingPass = boardingPass;
        this.idCard = idCard;
        this.count++;
        check();
    }

    private void check(){
        System.out.println(this.count);
        if(boardingPass.charAt(0)!=idCard.charAt(0)){
            throw new RuntimeException("===exception===" + toString());
        }
    }

    @Override
    public String toString() {
        return "The " + count +" passenger,boardingPass=[" + this.boardingPass + "],idCard=[" + idCard+"]";
    }
}
