#include"stdafx.h"
#include"Text_operations.h"
#include <iostream>
#include <fstream>
#include <ctime>

void create_file(string file_name, ofstream &write)
{
	srand(time(NULL));
	int n = rand() % 30;
	write.open(file_name, ios::out);
	for (int i = 0; i < n; i++)
	{
		write << to_string(rand() % 100) << endl;
	}
	write.close();
}

void show_file(string file_name, ifstream &read)
{
	string line;
	read.open(file_name, ios::out);
	if (read.is_open())
	{
		while (getline(read, line))
		{
			cout << line << endl;
		}
		read.close();
	}
}

void add_entry(string file_name,ofstream &write)
{
	string entry;
	write.open(file_name, ios::app);
	cout << "Добавить запись" << endl; cin >> entry;
	write << entry;
	write.close();
}

string copy_in_file(string file_name, ifstream &read, ofstream &write)
{
	string line;
	read.open(file_name, ios::out);
	write.open("Copy.txt", ios::out);
	if (read.is_open())
	{
		while (getline(read, line))
		{
			int n = atoi(line.c_str());
			if (n % 7 == 0 && n != 0)
			{
				write << to_string(n) << endl;
			}
		}
		read.close();
		write.close();
	}
	return "Copy.txt";
}