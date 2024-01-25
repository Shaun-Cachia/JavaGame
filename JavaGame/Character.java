package JavaGame;

import java.util.ArrayList;

public class Character { //All Status of Characters
    private ArrayList<Ability> abilities = new ArrayList<>();

    String Name;
    int EXP;
    int LV;

    int HP;
    int AP;

    int Pwr;
    int Def;
    int Int;
    int Agl;

    String status;

    String Master;

    public Character(String Name, int EXP, int LV, int HP, int AP, int Pwr, int Def, int Int, int Agl, String status, String Master) {
        this.Name = Name;
        this.EXP = EXP;
        this.LV = LV;

        this.HP = HP;
        this.AP = AP;

        this.Pwr = Pwr;
        this.Def = Def;
        this.Int = Int;
        this.Agl = Agl;

        this.status = status;

        this.Master = Master;

    }
    public ArrayList<Ability> getAbilities() {
        return abilities;
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


    public String getStatus() {
        return status;
    }
    public String getMaster() {
        return Master;
    }
    //Logic
    public boolean isAlive() {
        return HP > 0;
    }
    public int getAttackDamage() {
        // You can add more complex logic based on your game design
        return Pwr * 2; // Example: Damage is twice the power stat
    }
    public void heal(int amount) {
        // Add logic to ensure healing doesn't exceed maximum HP
        HP = Math.min(HP + amount, getMaxHP());
    }
    public void takeDamage(int damage) {
        // Ensure damage doesn't go below 0
        HP = Math.max(0, HP - damage);
    }
    public void decreaseAP(int amount) {
        // Ensure AP doesn't go below 0
        AP = Math.max(0, AP - amount);
    }
    public int getMaxHP() {
        // You can add more complex logic based on your game design
        return LV * 7; // Example: Maximum HP is 7 times the character's level
    }
        

    public void addAbility(Ability ability) {
        abilities.add(ability);
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


    public void setStatus(String status) {
        this.status = status;
}
    public void setMaster(String Master) {
        this.Master = Master;
    }


    public String toString() {
        return "Name: "+Name+"\nEXP: "+EXP+"\nLV:"+LV+"\nHP: "+HP+"\nAP: "+AP+"\nPwr: "+Pwr+"\nDef: "+Def+"\nInt: "+Int+"\nAgl: "+Agl+"\nStatus: "+status+"\nMaster: "+Master;
    }
}