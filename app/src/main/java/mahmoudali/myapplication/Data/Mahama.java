package mahmoudali.myapplication.Data;

/**
 * فىه تصف مهمه بادارت المهمات
 */
public class Mahama
{
    /**
     * رقم مميز يتم النتاجه من قبل الخادم
     */
    private String Key;
    /**
     * الرقم المميز للمستخدم
     */
    private String title;
    private String Subject;
    private int important;
    private String owner;

    public Mahama()
    {

    }
    public String getKey() {
        return Key;
    }

    public int getImportant() {
        return important;
    }

    public String getOwner() {
        return owner;
    }

    public String getSubject() {
        return Subject;
    }

    public String getTitle() {
        return title;
    }

    public void setKey(String key) {
        Key = key;
    }

    public void setImportant(int important) {
        this.important = important;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public String toString() {
        return "Mahama{" +
                "Key='" + Key + '\'' +
                ", title='" + title + '\'' +
                ", Subject='" + Subject + '\'' +
                ", important=" + important +
                ", owner='" + owner + '\'' +
                '}';
    }
}
