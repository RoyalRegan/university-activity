#pragma once

#include <iostream>
#include <string>
#include <vector>
#include "Unit_Def.h"

using namespace std;

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

void ZaplnList(vector<SportsmenInfo> &a, SportsmenInfo b)
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