package ru.mirea;

public class Book
{
    private String author;
    private String name;
    private int number;
    private int year;
    private String publisher;
    private int number_of_lists;
    private int number_of_last_reader;
    boolean empty;
    Book ()
    {
        this.author="";
        this.name="";
        this.number=0;
        this.year=0;
        this.publisher="";
        this.number_of_lists=0;
        this.number_of_last_reader=0;
        empty=true;
    }
    Book(String author,String name,int number,int year,String publisher,int number_of_lists,int number_of_last_reader,boolean empty)
    {
        this.author=author;
        this.name=name;
        this.number=number;
        this.year=year;
        this.publisher=publisher;
        this.number_of_lists=number_of_lists;
        this.number_of_last_reader=number_of_last_reader;
        this.empty=empty;
    }

    public String getAuthor() {
        return author;
    }

    public int getNumber() {
        return number;
    }

    public int getNumber_of_last_reader() {
        return number_of_last_reader;
    }

    public int getNumber_of_lists() {
        return number_of_lists;
    }

    public int getYear() {
        return year;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setNumber_of_last_reader(int number_of_last_reader) {
        this.number_of_last_reader = number_of_last_reader;
    }

    public void setNumber_of_lists(int number_of_lists) {
        this.number_of_lists = number_of_lists;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public void setName(String name) {
        this.name = name;
    }

    public boolean isEmpty() {
        return empty;
    }


    @Override
    public String toString() {
        return "Автор: "+author+"\n"+"Название: "+name+"\n"+"Регистрационный номер: "+number+"\n"+"Год издания: "+year+"\n"+"Публикатор: "+publisher+"\n"+"Количсетво листов: "+number_of_lists+"\n"+"Номер последнего читателя: "+number_of_last_reader+"\n"+"Доступна ли книга: "+empty;
    }
}
