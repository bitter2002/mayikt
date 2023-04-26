package com.mayikt.entity;

public class BookEntity {
    private String bookName;
    private Double bookPrice;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        System.out.println("bookName:"+bookName+",底层基于java的反射机制,调用set方法赋值");
        this.bookName = bookName;
    }

    public Double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public BookEntity() {
    }

    public BookEntity(String bookName, Double bookPrice) {
        this.bookName = bookName;
        this.bookPrice = bookPrice;
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "bookName='" + bookName + '\'' +
                ", bookPrice=" + bookPrice +
                '}';
    }

    public static void main(String[] args) {
//        BookEntity bookEntity = new BookEntity();
//        bookEntity.setBookName("老人与海");
//        bookEntity.setBookPrice(99.99);
//        System.out.println(bookEntity);


    }
}
