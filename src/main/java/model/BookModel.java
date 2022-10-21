package model;

import mapper.RowMapper;

public class BookModel extends RowMapper.AbstractModel {

    private String title;

    private Long categoryID;
    private String description;
    private String content;
    private String background;
    private String categoryName;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Long getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Long categoryID) {
        this.categoryID = categoryID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public BookModel(String title, Long categoryID, String description, String content, String background) {
        this.title = title;
        this.categoryID = categoryID;
        this.description = description;
        this.content = content;
        this.background = background;
    }

    public BookModel() {
    }
}
