package wechat.response;

/**
 * Created by magenta9 on 2017/3/5.
 */
public class ImageMessage extends BaseMessage {

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    private Image image;
}
