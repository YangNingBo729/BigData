package com.haku.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

@Document(indexName = "poetries", type = "poetry")
public class PoetryES {
    @Id
    private String poet_id;
    private String poetry_id;
    private String name;
    private String title;
    private String content;
    private Date created;

    public PoetryES() {
    }

    public PoetryES(String poet_id, String poetry_id, String name, String title, String content, Date created) {
        this.poet_id = poet_id;
        this.poetry_id = poetry_id;
        this.name = name;
        this.title = title;
        this.content = content;
        this.created = created;
    }

    public String getPoet_id() {
        return poet_id;
    }

    public void setPoet_id(String poet_id) {
        this.poet_id = poet_id;
    }

    public String getPoetry_id() {
        return poetry_id;
    }

    public void setPoetry_id(String poetry_id) {
        this.poetry_id = poetry_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "PoetryES{" +
                "poet_id='" + poet_id + '\'' +
                ", poetry_id='" + poetry_id + '\'' +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", created=" + created +
                '}';
    }
}
