// Лаба-7.cpp: определяет точку входа для консольного приложения.
//

#include "stdafx.h"
#include<iostream>
#include"Text_operations.h"
#include "Binare_operations.h"
#include <fstream>
#include <Windows.h>

int main()
{
	SetConsoleCP(1251);
	SetConsoleOutputCP(1251);
	ifstream read;
	ofstream write;
	cout << "Техтовый файл" << endl; create_file("Text.txt",write);
	cout << "Вывод файла" << endl; show_file("Text.txt",read);
	add_entry("Text.txt",write);
	cout << "Скопировать числа исходного файла, которые кратны 7, в новый файл" << endl; show_file(copy_in_file("Text.txt",read,write),read);
	cout << "Бинарный файл" << endl; create_bin_file(read, write);
	cout << "Вывод файла" << endl; 
	show_bin_file(read);
	int k;
	cout << "Введите ключ" << endl; 
	cin >> k;
	search_key(read, k);
	cout << "Введите ключ структуры у которой хотите изменить поле" << endl; 
	cin >> k;
	refresh(read,write, k);
	cout << "Измененная записа" << endl;
	show_bin_file(read);
	system("pause");
    return 0;
}

