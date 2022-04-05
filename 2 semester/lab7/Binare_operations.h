#pragma once
#include <string>
using namespace std;

struct FIO
{
	string SecondName;
	string FirstName;
	string Patronymic;
};

struct Adress
{
	string City;
	string Street;
	int House;
	int Apartament;
};

struct bill
{
	int key = 1;
	int bill_number;
	FIO fio;
	Adress adress;
};

void create_bin_file(ifstream &read, ofstream &write);
void show_bin_file(ifstream &read);
void search_key(ifstream &read,int k);
void refresh(ifstream &read, ofstream &write,int k);
