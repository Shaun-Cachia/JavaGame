package JavaGame;
public class Character { //All Status of Characters
    String Name;
    int EXP;
    int LV;

    int HP;
    int AP;

    int Pwr;
    int Def;
    int Int;
    int Agl;


    int gold;
    String item;

    String status;

    String Master;

    public Character(String Name, int EXP, int LV, int HP, int AP, int Pwr, int Def, int Int, int Agl, String status, String Master, int gold, String item ) {
        this.Name = Name;
        this.EXP = EXP;
        this.LV = LV;

        this.HP = HP;
        this.AP = AP;

        this.Pwr = Pwr;
        this.Def = Def;
        this.Int = Int;
        this.Agl = Agl;

        this.gold = gold;
        this.item = item;

        this.status = status;

        this.Master = Master;
    }

    public String getName() {
        return Name;
    }
    public int getEXP() {
        return EXP;
    }
    public int getLV() {
        return LV;
    }
    public int getHP() {
        return HP;
    }
    public int getAP() {
        return AP;
    }
    public int getPwr() {
        return Pwr;
    }
    public int getDef() {
        return Def;
    }
    public int getInt() {
        return Int;
    }
    public int getAgl() {
        return Agl;
    }
    public int getGold() {
        return gold;
    }
    public String getItem() {
        return item;
    }
    public String getStatus() {
        return status;
    }
    public String getMaster() {
        return Master;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    public void setEXP(int EXP) {
        this.EXP = EXP;
    }
    public void setLV(int LV) {
        this.LV = LV;
    }
    public void setHP(int HP) {
        this.HP = HP;
    }
    public void setAP(int AP) {
        this.AP = AP;
    }
    public void setPwr(int Pwr) {
        this.Pwr = Pwr;
    }
    public void setDef(int Def) {
        this.Def = Def;
    }
    public void setAgl(int Agl) {
        this.Agl = Agl;
    }
    public void setGold(int gold) {
        this.gold = gold;
    }
    public void setItem(String item) {
        this.item = item;
    }
    public void setStatus(String status) {
        this.status = status;
}
    public void setMaster(String Master) {
        this.Master = Master;
    }

    public String toString() {
        return "Name: "+Name+"\nEXP: "+EXP+"\nLV:"+LV+"\nHP: "+HP+"\nAP: "+AP+"\nPwr: "+Pwr+"\nDef: "+Def+"\nInt: "+Int+"\nAgl: "+Agl+"\nGold: "+gold+"\nItems: "+item+"\nStatus: "+status+"\nMaster: "+Master;
    }
}