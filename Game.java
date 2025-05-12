public class Game
{
    private int score;
    private int level;
    private int lives;
    private String name;
    public Game(int score, int level, int lives,String name)
    {
        this.score = score;
        this.level = level;
        this.lives = lives;
        this.name = name;
    }
    public int getScore()
    {
        return score;
    }
    public int getLevel()
    {
        return level;
    }
    public int getLives()
    {
        return lives;
    }
    public String getName()
    {
        return name;
    }
    public void setScore(int score) {
        this.score = score;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public void setName(String name) {
        this.name = name;
    }

}
