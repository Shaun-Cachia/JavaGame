public class Character {
    int EXP;
    int LV;
    
    int HP;
    int AP;

    int Pwr;
    int Def;
    int Int;
    int Agl;

    String Master;

    public Character(int EXP, int LV, int HP, int AP, int Pwr, int Def, int Int, int Agl, String Master) {
        this.EXP = EXP;
        this.LV = LV;

        this.HP = HP;
        this.AP = AP;

        this.Pwr = Pwr;
        this.Def = Def;
        this.Int = Int;
        this.Agl = Agl;

        this.Master = Master;
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
    public String getMaster() {
        return Master;
    }

    public void setEXP() {
        this.EXP = EXP;
    }
    public void setLV() {
        this.LV = LV;
    }
    public void setHP() {
        this.HP = HP;
    }
    public void setAP() {
        this.AP = AP;
    }
    public void setPwr() {
        this.Pwr = Pwr;
    }
    public void setDef() {
        this.Def = Def;
    }
    public void setAgl() {
        this.Agl = Agl;
    }
    public void setMaster() {
        this.Master = Master;
    }

    public String toString() {
        return "EXP: "+EXP+"\nLV:"+LV+"\nHP: "+HP+"\nAP: "+AP+"\nPwr: "+Pwr+"\nDef: "+Def+"\nInt: "+Int+"\nAgl: "+Agl+"\nMaster: "+Master;
    }
}
