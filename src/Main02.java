import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main02 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String brStr = br.readLine();
        int H = Integer.parseInt(brStr.split(" ")[0]);
        int W = Integer.parseInt(brStr.split(" ")[1]);
        String[][] field = new String[H + 2][W + 2];
        for(int i = 0; i < field.length; i++) {
            if(i != 0 && i != field.length) {
                brStr = br.readLine();
            }
            for(int j = 0; j < field[i].length; j++) {
                if(
                        (i == 0 || i == field.length    - 1 ||
                                j == 0 || j == field[i].length - 1)
                ) {
                    field[i][j] = ".";
                }else {
                    field[i][j] = brStr.substring(j - 1,j);
                }
            }
        }
        ArrayList<Island1> islandList = new ArrayList<>();
        ArrayList<Coordinate6> ijList = new ArrayList<>();
        int contSpace;
        for(int i = 1; i < field.length - 1; i++) {
            for(int j = 1; j < field[i].length - 1; j++) {
                if(field[i][j].equals("#")) {
                    islandList.add(new Island1());
                    ijList.add(new Coordinate6(i,j));
                    while(true) {
                        if(ijList.size() == 0) {
                            break;
                        }
                        /////////////////////////////
                        if(!ijList.get(ijList.size() - 1).isLandSeaCheck()) {
                            //陸面積
                            islandList.get(islandList.size() - 1).setLand(
                                    islandList.get(islandList.size() - 1).getLand() + 1);
                            //海面
                            if(field
                                    [ijList.get(ijList.size() - 1).getI()]
                                    [ijList.get(ijList.size() - 1).getJ() + 1].equals(".")) {
                                islandList.get(islandList.size() - 1).setSea(
                                        islandList.get(islandList.size() - 1).getSea() + 1);
                            }
                            if(field
                                    [ijList.get(ijList.size() - 1).getI() + 1]
                                    [ijList.get(ijList.size() - 1).getJ()].equals(".")) {
                                islandList.get(islandList.size() - 1).setSea(
                                        islandList.get(islandList.size() - 1).getSea() + 1);
                            }
                            if(field
                                    [ijList.get(ijList.size() - 1).getI()]
                                    [ijList.get(ijList.size() - 1).getJ() - 1].equals(".")) {
                                islandList.get(islandList.size() - 1).setSea(
                                        islandList.get(islandList.size() - 1).getSea() + 1);
                            }
                            if(field
                                    [ijList.get(ijList.size() - 1).getI() - 1]
                                    [ijList.get(ijList.size() - 1).getJ()].equals(".")) {
                                islandList.get(islandList.size() - 1).setSea(
                                        islandList.get(islandList.size() - 1).getSea() + 1);
                            }
                            //チェック済みとする
                            ijList.get(ijList.size() - 1).setLandSeaCheck(true);
                        }
                        /////////////////////////////
                        //周囲の陸を記録
                        contSpace = 0;
                        if(field
                                [ijList.get(ijList.size() - 1).getI()]
                                [ijList.get(ijList.size() - 1).getJ() + 1].equals("#"))
                        {
                            ijList.get(ijList.size() - 1).setSpaceLeft(true);
                            contSpace++;
                        } else {
                            ijList.get(ijList.size() - 1).setSpaceLeft(false);
                        }
                        if(field
                                [ijList.get(ijList.size() - 1).getI() + 1]
                                [ijList.get(ijList.size() - 1).getJ()].equals("#"))
                        {
                            ijList.get(ijList.size() - 1).setSpaceSita(true);
                            contSpace++;
                        } else {
                            ijList.get(ijList.size() - 1).setSpaceSita(false);
                        }
                        if(field
                                [ijList.get(ijList.size() - 1).getI()]
                                [ijList.get(ijList.size() - 1).getJ() - 1].equals("#"))
                        {
                            ijList.get(ijList.size() - 1).setSpaceRight(true);
                            contSpace++;
                        } else {
                            ijList.get(ijList.size() - 1).setSpaceRight(false);
                        }
                        if(field
                                [ijList.get(ijList.size() - 1).getI() - 1]
                                [ijList.get(ijList.size() - 1).getJ()].equals("#"))
                        {
                            ijList.get(ijList.size() - 1).setSpaceUe(true);
                            contSpace++;
                        } else {
                            ijList.get(ijList.size() - 1).setSpaceUe(false);
                        }
                        //一度踏んだら「*」
                        field
                                [ijList.get(ijList.size() - 1).getI()]
                                [ijList.get(ijList.size() - 1).getJ()] = "*";
                        //陸があれば要素追加
                        if(ijList.get(ijList.size() - 1).isSpaceLeft()) {
                            ijList.add(
                                    new Coordinate6(
                                            ijList.get(ijList.size() - 1).getI(),
                                            ijList.get(ijList.size() - 1).getJ() + 1
                                    )
                            );
                        } else if(ijList.get(ijList.size() - 1).isSpaceSita()) {
                            ijList.add(
                                    new Coordinate6(
                                            ijList.get(ijList.size() - 1).getI() + 1,
                                            ijList.get(ijList.size() - 1).getJ()
                                    )
                            );
                        } else if(ijList.get(ijList.size() - 1).isSpaceRight()) {
                            ijList.add(
                                    new Coordinate6(
                                            ijList.get(ijList.size() - 1).getI(),
                                            ijList.get(ijList.size() - 1).getJ() - 1
                                    )
                            );
                        } else if(ijList.get(ijList.size() - 1).isSpaceUe()) {
                            ijList.add(
                                    new Coordinate6(
                                            ijList.get(ijList.size() - 1).getI() - 1,
                                            ijList.get(ijList.size() - 1).getJ()
                                    )
                            );
                        }
                        if(contSpace == 1) {
                            ijList.remove(ijList.size() - 2);
                        } else if(contSpace == 0) {
                            ijList.remove(ijList.size() - 1);
                        }
                    }
                }
                for(int k = islandList.size() - 1; k > 0; k--) {
                    if(islandList.get(k).getLand() > islandList.get(k - 1).getLand()) {
                        islandList.add(k - 1, islandList.get(k));
                        islandList.remove(k + 1);
                    } else if(islandList.get(k).getLand() == islandList.get(k - 1).getLand()) {
                        while(true) {
                            if(islandList.get(k).getLand() < islandList.get(k - 1).getLand()) {
                                break;
                            }
                            if(islandList.get(k).getSea() > islandList.get(k - 1).getSea()) {
                                islandList.add(k - 1, islandList.get(k));
                                islandList.remove(k + 1);
                            } else {
                                break;
                            }
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        for(Island1 il:islandList) {
            System.out.println(il.getLand() + " " + il.getSea());
        }

    }
}
class Coordinate6 {
    private int i;
    private int j;
    private boolean spaceRight;
    private boolean spaceSita;
    private boolean spaceLeft;
    private boolean spaceUe;
    private boolean LandSeaCheck;

    Coordinate6(int i,int j){
        this.i = i;
        this.j = j;
        spaceRight = false;
        spaceUe = false;
        spaceSita = false;
        spaceLeft = false;
        LandSeaCheck = false;
    }

    public int getI() {
        return i;
    }
    public void setI(int i) {
        this.i = i;
    }
    public int getJ() {
        return j;
    }
    public void setJ(int j) {
        this.j = j;
    }

    public boolean isSpaceRight() {
        return spaceRight;
    }

    public void setSpaceRight(boolean spaceRight) {
        this.spaceRight = spaceRight;
    }

    public boolean isSpaceUe() {
        return spaceUe;
    }

    public void setSpaceUe(boolean spaceUe) {
        this.spaceUe = spaceUe;
    }

    public boolean isSpaceSita() {
        return spaceSita;
    }

    public void setSpaceSita(boolean spaceSita) {
        this.spaceSita = spaceSita;
    }

    public boolean isSpaceLeft() {
        return spaceLeft;
    }

    public void setSpaceLeft(boolean spaceLeft) {
        this.spaceLeft = spaceLeft;
    }

    public boolean isLandSeaCheck() {
        return LandSeaCheck;
    }

    public void setLandSeaCheck(boolean landSeaCheck) {
        LandSeaCheck = landSeaCheck;
    }
}
class Island1 {
    private int land;
    private int sea;

    public int getLand() {
        return land;
    }
    public void setLand(int land) {
        this.land = land;
    }
    public int getSea() {
        return sea;
    }
    public void setSea(int sea) {
        this.sea = sea;
    }
}