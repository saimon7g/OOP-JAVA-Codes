public class League {
    private Match[] matches;
    private int matchCount;
    private int clubCount;
    private String name;
    private Club[] leagueClub= new Club[5];
    // add your variables here, if required

    public League() {
        // assume a league can have at most 5 clubs, add code for initialization accordingly
        clubCount = 0;
        matchCount = 0 ;
    }
    public void setName(String leagueName){
        this.name=leagueName;
    }

    public void addClub(Club x){
        leagueClub[clubCount]=x;
        clubCount++;

    }

    public void printLeagueInfo(){
        System.out.println("League : " + name);
        printClubs();
    }

    public void printClubs(){
        System.out.println("Clubs:");
        // print the name of the clubs of this league, each one on a line
        for(int i=0;i<clubCount;i++)
        {
            System.out.println(leagueClub[i].getName());
        }

    }

    public void scheduleMatches(){
        matchCount = (clubCount*(clubCount-1));
        matches = new Match[matchCount];
        int matchNo = 0;
        for (int i=0; i<clubCount; i++){
            for (int j=0; j<clubCount; j++){
                // check the constructor of the Match class and add your code here
                // note that there will be two matches between club A and club B
                // in the first match, club A will play as the home team and in the second match, as the away team
                if(i!=j) {
                    matches[matchNo]= new Match(matchNo,leagueClub[i],leagueClub[j]);
                    matchNo++;
                }
            }
        }
    }

    public void simulateMatches(){
        for (int i=0; i<matchCount; i++){
            matches[i].play();
        }
    }

    public void printMatches(){
        System.out.println("Matches:");
        for (int i=0; i<matchCount; i++){
            matches[i].showResult();
        }
    }

    public void showStandings(){
        // sort the clubs in descending order of points
        // note that, the sequence in which clubs were added to the league, should be unchanged
        // check the given sample output for clarification
        // (carefully observe the output of showStandings() followed by printLeagueInfo() method calls
        // you can use additional arrays if needed
        System.out.println("Sl. - Club - Points");

        int[] table1= new int[clubCount];
        int[] table2= new int[100];

        for(int i=0;i<clubCount;i++){
            table1[i]=leagueClub[i].getPoint();
        }
        for(int i=0;i<100;i++){
            table2[i]=0;
        }

        for(int i=0;i<clubCount-1;i++){
            for(int j=0;j<clubCount-1;j++){
                if(table1[j]<table1[j+1]){
                    int x=table1[j];
                    table1[j]=table1[j+1];
                    table1[j+1]=x;
                }
            }

        }

        for(int i=0;i<clubCount;i++){
            for(int j=0;j<clubCount;j++) {
                if((table1[i] == leagueClub[j].getPoint() )&& (table2[leagueClub[j].getId()] ==0 )) {
                    table2[leagueClub[j].getId()]=1;
                    System.out.print(i+1);
                    System.out.println(". "+ leagueClub[j].getName()+" "+ table1[i] );

                }
            }
        }

        // print the clubs in descending order of points
    }

    public void removeClub(Club x){
        int pos=0,i;
        for(i=0;i<clubCount;i++){
            if(leagueClub[i].getId() == x.getId()){
                pos=i;
                break;
            }
        }
            clubCount--;
            for(i=pos;i<clubCount;i++){
                leagueClub[i]=leagueClub[i+1];
            }

        }







    // add your methods here, if required
}

