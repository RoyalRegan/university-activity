package ru.mirea;

import java.util.ArrayList;
import java.util.Scanner;

public class Library
{
    private ArrayList<Book > library;
    Library()
    {
        library=new ArrayList<>();
    }
    Library(ArrayList<Book> library)
    {
        this.library=library;
    }
    public void add_book(Book book)
    {
        this.library.add(book);
    }
    public void add_book(String author,String name,int number,int year,String publisher,int number_of_lists,int number_of_last_reader,boolean empty)
    {
        this.library.add(new Book(author,name,number,year,publisher,number_of_lists,number_of_last_reader,empty));
    }
    public void find_by_author(String author)
    {
        System.out.println("Книги автора: "+author);
        for(Book book:library)
        {
            if(book.getAuthor()==author)
            {
                System.out.println(book.getName());
            }
        }
    }

    public void after_year()
    {
        Scanner scan=new Scanner(System.in);
        System.out.printf("Введите год: ");
        int year=scan.nextInt();
        System.out.println("Список книг с фамилией автора по алфавиту после "+year+" года :");
        ArrayList<Book>new_library=new ArrayList<>();
        for (Book book:library)
        {
            if(book.getYear()>year)
            {
                new_library.add(book);
            }
        }
        for(int i=0;i<new_library.size()-1;i++)
        {
            if (new_library.get(i).getAuthor().charAt(0)>new_library.get(i+1).getAuthor().charAt(0))
            {
                Book swap=new_library.get(i);
                new_library.set(i,new_library.get(i+1));
                new_library.set(i+1,swap);
                i--;
            }
        }
        for (Book book: new_library)
        {
            System.out.println("Название: "+book.getName()+"\n"+"Фамилия автора: "+book.getAuthor());
        }
    }
    public void at_hand()
    {
        System.out.println("\n"+"Список книг которые у читателя: ");
        for (Book book:library)
        {
            if(book.isEmpty()==false)
            {
                System.out.println("Название книги: "+book.getName()+"\n"+"Код читателя:"+book.getNumber_of_last_reader());
            }
        }
    }

    @Override
    public String toString()
    {
        String info="\n"+"Все книги:"+"\n";
        for (Book book:library)
        {
            info+=book.toString()+"\n"+"\n";
        }
        return  info;
    }
}
