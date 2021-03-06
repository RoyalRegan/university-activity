// Лаба-4.cpp: определяет точку входа для консольного приложения.
//
#include "stdafx.h"
#include <iostream>
#include <string>
#include <vector>
#include <Windows.h>
using namespace std;

struct BornData
{
	int day;
	int month;
	int year;
};

struct SportsmenInfo
{
	string SecondName;
	string FisrtName;
	BornData data;
	float Weight;
	float Growth;
	string Sex;
};

void Zapln(SportsmenInfo &a); // заполнение структры
void Vivod(SportsmenInfo a); // вывод структуры
void ZaplnList(vector<SportsmenInfo> &a, SportsmenInfo b); // заполнения массива структур 
void VivodList(vector<SportsmenInfo> a); // вывод массива структур
void Sortirovka(vector<SportsmenInfo> &a); // сортировка массива структур 
bool Proverka(BornData a); // проверка на возраст 2018.12.31(Год,месяц,день относительно которого смотрим возраст)
void NewList(vector<SportsmenInfo>a, vector<SportsmenInfo>&b); //новый массив структур из тех кто проходит проверку на возраст и пол

int main()
{
	SetConsoleCP(1251);
	SetConsoleOutputCP(1251);
	SportsmenInfo Sportsmen;
	vector<SportsmenInfo> Sportsmens;
	vector<SportsmenInfo> NewSportsmensList;
	int vbr = 10;

	while (vbr != 0)
	{
		system("cls");
		cout << "Лаба-4" << endl;
		cout << "ИКБО-07-17 Ануфриев В.В" << endl;
		cout << "Меню" << endl;
		cout << "1) Добвить спортсмена" << endl;
		cout << "2) Вывести спортсмена" << endl;
		cout << "3) Добавить спортсмена в список" << endl;
		cout << "4) Вывести список спортсменов" << endl;
		cout << "5) Отсортировать список спортсменов по весу" << endl;
		cout << "6) Сформировать список спортсменов мужчин не страше 22 лет" << endl;
		cout << "0) Выход" << endl;
		cout << "Ваш выбор: ";
		cin >> vbr;
		system("cls");
		switch (vbr)
		{
		case 1:
		{
			Zapln(Sportsmen);
			system("pause");
			break;
		}
		case 2:
		{
			Vivod(Sportsmen);
			system("pause");
			break;
		}
		case 3:
		{
			ZaplnList(Sportsmens, Sportsmen);
			system("pause");
			break;
		}
		case 4:
		{
			VivodList(Sportsmens);
			system("pause");
			break;
		}
		case 5:
		{
			Sortirovka(Sportsmens);
			system("pause");
			break;
		}
		case 6:
		{
			NewList(Sportsmens, NewSportsmensList);
			VivodList(NewSportsmensList);
			NewSportsmensList.clear();
			system("pause");
			break;
		}
		default:
			break;
		}
	}
	Sportsmens.clear();
	system("pause");
	return 0;
}

 void Zapln(SportsmenInfo &a)
{
	cout << "Введите фамилию спортсмена" << endl;
	cin >> a.SecondName;
	cout << "Введите имя спортсмена" << endl;
	cin >> a.FisrtName;
	cout << "Введите дату рождения спортсмена(день,месяц,год)" << endl;
	cin >> a.data.day;
	while (a.data.day > 31 || a.data.day < 1)
	{
		cout << "Введите корректный день" << endl;
		cin >> a.data.day;
	}
	cin >> a.data.month;
	while (a.data.month > 12 || a.data.month < 1)
	{
		cout << "Введите корректный месяц" << endl;
		cin >> a.data.month;
	}
	cin >> a.data.year;
	while (a.data.year > 2018 || a.data.year < 0)
	{
		cout << "Введите корректный месяц" << endl;
		cin >> a.data.year;
	}
	cout << "Введите вес спортсмена(кг)" << endl;
	cin >> a.Weight;
	cout << "Введите рост спортсмена(м)" << endl;
	cin >> a.Growth;
	cout << "Введите пол спортсмена" << endl;
	cin >> a.Sex;
	while (a.Sex != "M" && a.Sex != "W" && a.Sex != "М" && a.Sex != "Ж")
	{
		cout << "Введите корректный пол" << endl;
		cin >> a.Sex;
	}
}

void Vivod(SportsmenInfo a)
{
	cout << "Анкета спортсмена" << endl << endl;
	if (a.SecondName != "")
	{
		cout << "Фамилия: " << a.SecondName << endl;
		cout << "Имя: " << a.FisrtName << endl;
		cout << "Дата рождения: " << a.data.day << "." << a.data.month << "." << a.data.year << endl;
		cout << "Вес: " << a.Weight << " кг" << endl;
		cout << "Рост:" << a.Growth << " м" << endl;
		cout << "Пол: " << a.Sex << endl;
	}
	else
	{
		cout << "Добавьте спортсмена" << endl;
	}
}

void ZaplnList(vector<SportsmenInfo> &a,SportsmenInfo b)
{
	if (b.SecondName != "")
	{
		a.push_back(b);
	}
	else
	{
		cout << "Добавьте спортсмена" << endl;
	}
}

void VivodList(vector<SportsmenInfo> a)
{
	cout << "Анкеты спортсменов" << endl << endl;
	if (a.size() > 0)
	{
		for (unsigned int i = 0; i < a.size(); i++)
		{
			cout << "Фамилия: " << a[i].SecondName << endl;
			cout << "Имя: " << a[i].FisrtName << endl;
			cout << "Дата рождения: " << a[i].data.day << "." << a[i].data.month << "." << a[i].data.year << endl;
			cout << "Вес: " << a[i].Weight << endl;
			cout << "Рост:" << a[i].Growth << endl;
			cout << "Пол: " << a[i].Sex << endl;
			cout << endl << endl;
		}
	}
	else
	{
		cout << "Анкет нет" << endl;
	}
}

void Sortirovka(vector<SportsmenInfo> &a)
{
	if (a.size() > 1)
	{
		for (unsigned int i = 0; i < a.size() - 1; i++)
		{
			for (unsigned int j = 0; j<a.size() - i - 1; j++)
			{
				if (a[j].Weight < a[j + 1].Weight)
				{
					swap(a[j], a[j + 1]);
				}
			}
		}
	}
	else
	{
		cout << "Добавьте больше анкет" << endl;
	}
}

bool Proverka(BornData a)
{
	if ((a.year >= 1997 && a.month <= 12 && a.day <= 30) || (a.year>1997))
	{
		return true;
	}
	return false;
}

void NewList(vector<SportsmenInfo>a, vector<SportsmenInfo>&b)
{
	for (unsigned int i = 0; i < a.size(); i++)
	{
		if ((a[i].Sex == "M" || a[i].Sex == "М") && (Proverka(a[i].data)))
		{
			b.push_back(a[i]);
		}
	}
}
