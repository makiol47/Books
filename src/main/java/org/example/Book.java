package org.example;

public class Book {
    private String title;
    private int pageCount;
    private String publicationDate;

    public Book() {
    }

    public Book(String title, int pageCount, String publicationDate) {
        this.title = title;
        this.pageCount = pageCount;
        this.publicationDate = publicationDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String pageCount() {
        return pageCount;
    }


    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public void setPageCount(int pageCount) {
    }


}
