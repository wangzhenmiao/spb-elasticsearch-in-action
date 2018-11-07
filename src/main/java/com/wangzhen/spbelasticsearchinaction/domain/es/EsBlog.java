package com.wangzhen.spbelasticsearchinaction.domain.es;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * @ClassName EsBlog
 * @Description
 * @Author wangzhen
 * @Date 2018/11/5 下午8:15
 **/
@Document(indexName = "blog", type = "blog") // 文档
public class EsBlog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id // 主键
    private String id;
    private String title;
    private String summary;
    private String content;

    protected EsBlog() { // JPA 的规范要求无参构造函数；设为 protected 防止直接使用
    }

    public EsBlog(String title, String summary, String content) {
        this.title = title;
        this.summary = summary;
        this.content = content;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getSummary() {
        return summary;
    }
    public void setSummary(String summary) {
        this.summary = summary;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return String.format(
                "EsBlog[id='%s',title='%s',summary='%s',content='%s']",
                id, title, summary, content);
    }
}
