package ru.mirea;

import javax.annotation.processing.SupportedOptions;

public class Main {

    public static void main(String[] args)
    {
        Library library=new Library();
        //Добавление элементов в библиотеку
        library.add_book("Ануфриев","Java учебник",5132,2000,"МИРЭА",61,5213421,true);
        library.add_book("Леньтяев","Лень - искусство",5172,2001,"МИРЭА",61,521315,true);
        library.add_book("Ануфриев","Java учебник 2-ое издание",5123,2005,"МИРЭА",61,521321,false);
        System.out.println("Поиск по Автору");
        library.find_by_author("Ануфриев");
        System.out.println(library.toString());
        library.after_year();
        library.at_hand();
    }
}
