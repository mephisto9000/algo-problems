

import java.util.LinkedList;
import java.util.List;


/**
 *
 * @author mephisto9000
 */


public class SpaceMarine {
    
    private static int MAX_HEALTH = 1000;
        
    private String name;

   
    private String chapter;
    private int kills;
    private SMRank rank;
    private SMStatus status;
    private SMLoyalty loyalty;
    
    private int health;
    private int damage;
    
    
    
    
    
    public SpaceMarine(String name, String chapter, int kills, SMRank rank, SMLoyalty loyalty, int damage)
    {
        super();
        this.name = name;
        this.chapter = chapter;
        this.kills = kills;
        this.rank = rank;
        this.loyalty = loyalty;
        
        this.status = SMStatus.Healthy;
        this.health = MAX_HEALTH;
        this.damage = damage;
        
        
        
    }
    
     public String getName() {
        return name;
    }

    public String getChapter() {
        return chapter;
    }

    public int getKills() {
        return kills;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }
    
    
    public SMStatus getStatus()
    {
        return this.status;
    }
    
    public SMLoyalty getLoyalty()
    {
        return loyalty;
    }
    
    public SMRank getRank()
    {
        return rank;
    }               
    
    public void addKill()
    {
        kills++;
    }
    
    public void addKills(int deltaKills)
    {
        kills += deltaKills;
    }
    
    public void acceptDamage(int deltaDamage)
    {
        health -= deltaDamage;
        
        if (health > 0)
            this.status = SMStatus.Injured;
        else
            this.status = SMStatus.Deceased;
    }
    
    public int doDamage()
    {
        return damage;
    }
    
    
    
    
    
    
    
}
