package model;


public class BookModel extends AbstractModel {

    private String title;
    private String description;
    private String content;
    private String price;
    private String background;
    private CategoryModel category;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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


    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public CategoryModel getCategory() {
        return category;
    }

    public void setCategory(CategoryModel category) {
        this.category = category;
    }

    public BookModel(String title, String description, String content, String price, String background, CategoryModel category) {
        this.title = title;
        this.description = description;
        this.content = content;
        this.price = price;
        this.background = background;
        this.category = category;
    }

    public BookModel() {
    }
}
