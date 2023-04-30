package nowebsite.maker.terrariamod.manasystem.data;

import net.minecraft.nbt.CompoundTag;

/**A class which save and calculate player's mana.*/
public class PlayerMana {

    private int mana;
    private int manaMaxInt;

    private int starAddedManaInt;

    private boolean usesArcaneCrystal;
    private final int arcaneRegeneration = 1;
    private final int arcaneSoapUnRegEffect = 1;

    private int additionalPlayerManaRegeneration = 0;
    private final int stablePlayerManaRegenerationSpeed = 1;

    private int tickUnRegeneration = 0;

    /**When create a new player mana,belows will be initialized.*/
    public PlayerMana(){
        manaMaxInt = 20;
        starAddedManaInt = 0;
        usesArcaneCrystal = false;
        mana = manaMaxInt;
    }

    /**Use this to get player's mana regeneration speed in total.*/
    public int getTotalManaRegenerationSpeed(){
        if (usesArcaneCrystal)return arcaneRegeneration+additionalPlayerManaRegeneration+stablePlayerManaRegenerationSpeed;
        else return additionalPlayerManaRegeneration+stablePlayerManaRegenerationSpeed;
    }

    public int compute(){
        return 20+starAddedManaInt*20;
    }
    public void flush(){
        this.manaMaxInt = compute();
    }

    /**We calculate mana adding almost every tick.*/
    public int Tick_AddMana(){
        flush();
        assert tickUnRegeneration>=0;
        int addCount;

        //here for no counting and mana was not full.
        if (tickUnRegeneration==0&&mana<manaMaxInt){
            addCount = getTotalManaRegenerationSpeed();

            if (mana+addCount >= manaMaxInt) mana = manaMaxInt;
            else mana += addCount;
            return addCount;
        }
        //here is counting.
        else {
            if (usesArcaneCrystal){
                if (tickUnRegeneration>=arcaneSoapUnRegEffect+1)tickUnRegeneration-=arcaneSoapUnRegEffect+1;
                else tickUnRegeneration = 0;
            }else {
                /*now this var must >= 1 ,
                because first "if-else" to here this var!=0 ,
                and we assert that the var should always >=0 ,
                it's also a int .
                All in all , the var here must >=1 , we needn't judge more.*/
                tickUnRegeneration--;
            }
            return 0;
        }
    }
    public int packetTick(){
        Tick_AddMana();
        return 1;
    }

    /**Get player's mana*/
    public int getMana() {
        return mana;
    }
    /**<B>WARNING:U SHOULD NOT USE IT EXCEPT SPECIAL COMPLETES OR IT'LL CAUSE DANGER MANA ERRORS.</B>*/
    public void setMana(int mana) {
        this.mana = mana;
    }

    /**Add player mana. When mana+num is bigger than mana's max size let mana equals max size*/
    public void addMana(int mana) {
        assert mana >= 0;
        assert this.mana >= 0;
        flush();
        if (this.mana + mana < manaMaxInt) this.mana += mana;
        else mana = this.manaMaxInt;
    }

    /**@return True when player still have enough mana to cost and do cost.
     * False when player don't have enough to cost.*/
    public final boolean costMana(int mana){
        if (this.mana >=mana) this.mana -=mana;
        else return false;
        this.tickUnRegeneration = 20;
        return true;
    }

    /*--------For mana max number settings---------*/
    /**Get player's mana limit.*/
    public int getManaMaxInt(){
        flush();
        return manaMaxInt;
    }
    /**Set player's mana limit.<B>>DO NOT PUT NEGATIVE NUMBER IN.</B>*/
    public void setManaMaxInt(int manaMaxInt){
        assert this.manaMaxInt >=0;
        assert manaMaxInt>=0;
        this.manaMaxInt = manaMaxInt;
    }

    public int getStarAddedManaInt() {
        return starAddedManaInt;
    }

    /**Add player's mana limit by magic star.
     * @return True when player can still use it.
     * False when player has already used 9 stars.*/
    public boolean addManaMaxIntByMagicStar(){
        assert starAddedManaInt >= 0;
        if (starAddedManaInt <9){
            starAddedManaInt++;
            flush();
        }
        else return false;
        return true;
    }


    /**@return True if player has already used the arcane crystal.
     * False if player still not use it.*/
    public boolean isUsesArcaneCrystal() {
        return usesArcaneCrystal;
    }

    /**@return True when player still not use arcane crystal and turn it to true.
     * False when player has already used it*/
    public boolean UseArcaneCrystal() {
        if(!usesArcaneCrystal) usesArcaneCrystal = true;
        else return false;
        return true;
    }

    /**Set additional player mana regeneration speed*/
    public void setPlayerAdditionalManaRegenerationSpeed(int speed){
        additionalPlayerManaRegeneration=speed;
    }


    public void copyFrom(PlayerMana source) {
        this.manaMaxInt = source.manaMaxInt;
        this.starAddedManaInt = source.starAddedManaInt;
        this.usesArcaneCrystal = source.usesArcaneCrystal;
        this.mana = source.mana;
        this.additionalPlayerManaRegeneration = source.additionalPlayerManaRegeneration;
        this.tickUnRegeneration = source.tickUnRegeneration;
    }


    public void saveNBTData(CompoundTag compound) {
        compound.putInt("starAddedManaInt", starAddedManaInt);
        compound.putBoolean("usesArcaneCrystal", usesArcaneCrystal);
    }

    public void loadNBTData(CompoundTag compound) {
        starAddedManaInt = compound.getInt("starAddedManaInt");
        flush();
        usesArcaneCrystal = compound.getBoolean("usesArcaneCrystal");
    }
}
