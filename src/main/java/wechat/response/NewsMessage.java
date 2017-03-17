package wechat.response;

import java.util.List;

/**
 * Created by magenta9 on 2017/3/5.
 */
public class NewsMessage extends BaseMessage {
    private int ArticleCount;   //图文消息个数，限制10个以内
    private List<Article> Articles;

    public int getArticleCount() {
        return ArticleCount;
    }

    public void setArticleCount(int articleCount) {
        ArticleCount = articleCount;
    }

    public List<Article> getArticles() {
        return Articles;
    }

    public void setArticles(List<Article> articles) {
        this.Articles = articles;
    }
}
