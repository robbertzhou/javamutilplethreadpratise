package sevensingledesignpattern.singlethreadexecution;

//这样保证获取两个资源的原子性
public class TablewarePair {
    private final Tableware leftTool;
    private final Tableware rightTool;

    public TablewarePair(Tableware leftTool,Tableware rightTool){
        this.leftTool = leftTool;
        this.rightTool = rightTool;
    }

    public Tableware getLeftTool(){
        return leftTool;
    }

    public Tableware getRightTool(){
        return rightTool;
    }
}
