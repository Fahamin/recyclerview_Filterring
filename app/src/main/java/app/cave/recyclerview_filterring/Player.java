package app.cave.recyclerview_filterring;

public class Player {

    String name;
    String pos;
    int img;

    public Player(String name, String pos, int img) {
        this.name = name;
        this.pos = pos;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
