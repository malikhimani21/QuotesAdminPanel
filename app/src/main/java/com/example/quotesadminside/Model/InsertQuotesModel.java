package com.example.quotesadminside.Model;

public class InsertQuotesModel {

    String id, q_id, q_cat_id, q_cat, q_quotes, q_author, q_desc;

    public InsertQuotesModel() {
    }

    public InsertQuotesModel(String id, String q_id, String q_cat_id, String q_cat, String q_quotes, String q_author, String q_desc) {
        this.id = id;
        this.q_id = q_id;
        this.q_cat_id = q_cat_id;
        this.q_cat = q_cat;
        this.q_quotes = q_quotes;
        this.q_author = q_author;
        this.q_desc = q_desc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQ_id() {
        return q_id;
    }

    public void setQ_id(String q_id) {
        this.q_id = q_id;
    }

    public String getQ_cat_id() {
        return q_cat_id;
    }

    public void setQ_cat_id(String q_cat_id) {
        this.q_cat_id = q_cat_id;
    }

    public String getQ_cat() {
        return q_cat;
    }

    public void setQ_cat(String q_cat) {
        this.q_cat = q_cat;
    }

    public String getQ_quotes() {
        return q_quotes;
    }

    public void setQ_quotes(String q_quotes) {
        this.q_quotes = q_quotes;
    }

    public String getQ_author() {
        return q_author;
    }

    public void setQ_author(String q_author) {
        this.q_author = q_author;
    }

    public String getQ_desc() {
        return q_desc;
    }

    public void setQ_desc(String q_desc) {
        this.q_desc = q_desc;
    }
}
