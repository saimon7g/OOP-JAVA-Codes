public class Club {
    private int id;
    private String name;
    private int points;
    // add your code here

    public Club() {
        name = "";
        points = 0;

    }

    public void setId(int id) {
        this.id=id;
    }

    public int getId(){
        return id;
    }

    public void setName( String clubName){
        this.name=clubName;
    }

    public String getName(){
        return name;
    }

    public void addPoint( int points){
        this.points+=points;
    }

    public int getPoint(){
        return points;
    }
    // add your code her
}
